package com.group9.bankofaz.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.group9.bankofaz.model.ExternalUser;

@Service
public class UserOperationsServiceImpl implements UserOperationsService {

    // I will use SecureRandom for security-related random values.
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    // I will restrict uploads to a safe temp folder (prevents arbitrary file overwrite).
    private static final Path BASE_UPLOAD_DIR =
            Paths.get(System.getProperty("java.io.tmpdir"), "boa-uploads");

    static {
        // I will register BouncyCastle once.
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
        try {
            Files.createDirectories(BASE_UPLOAD_DIR);
        } catch (IOException e) {
            // If we cannot create the directory, the service should fail fast.
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public String getUploadFileLocation() {
        try {
            // I will create a safe temp file under our controlled directory.
            Path tempFile = Files.createTempFile(BASE_UPLOAD_DIR, "upload_", ".tmp");
            return tempFile.toAbsolutePath().toString();
        } catch (IOException e) {
            // I will avoid returning empty string silently; caller can detect failure with "".
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public boolean uploadFile(String location, MultipartFile file) {
        if (location == null || location.trim().isEmpty() || file == null || file.isEmpty()) {
            return false;
        }

        try {
            Path target = Paths.get(location).toAbsolutePath().normalize();

            // I will ensure the file write stays inside BASE_UPLOAD_DIR.
            if (!target.startsWith(BASE_UPLOAD_DIR.toAbsolutePath().normalize())) {
                return false;
            }

            // I will stream-copy safely and overwrite only the expected temp file.
            try (InputStream in = file.getInputStream()) {
                Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean compareKeys(ExternalUser user, String privateKeyFileLocation) {
        try {
            if (user == null || user.getPublickey() == null || privateKeyFileLocation == null) {
                return false;
            }

            // I will use an explicit RSA transformation. OAEP is preferred.
            // Note: If your stored keys/clients expect PKCS1 padding, switch to:
            // Cipher.getInstance("RSA/ECB/PKCS1Padding");
            Cipher rsa = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");

            // I will generate a random plaintext challenge.
            String plaintext = Long.toString(SECURE_RANDOM.nextLong());

            // I will read the user's public key bytes from DB (assumed DER X.509 encoded).
            byte[] pubKeyBytes = user.getPublickey().getBytes(1, (int) user.getPublickey().length());
            PublicKey publicKey = KeyFactory.getInstance("RSA")
                    .generatePublic(new X509EncodedKeySpec(pubKeyBytes));

            // I will read the private key file bytes (assumed DER PKCS#8 encoded).
            byte[] pvtKeyBytes = Files.readAllBytes(Paths.get(privateKeyFileLocation));
            PrivateKey privateKey = KeyFactory.getInstance("RSA")
                    .generatePrivate(new PKCS8EncodedKeySpec(pvtKeyBytes));

            // I will encrypt with public key.
            rsa.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] cipherText = rsa.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

            // I will decrypt with private key.
            rsa.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] plainBytes = rsa.doFinal(cipherText);
            String decrypted = new String(plainBytes, StandardCharsets.UTF_8);

            return plaintext.equals(decrypted);
        } catch (Exception e) {
            // I will return false when verification fails.
            return false;
        }
    }
}