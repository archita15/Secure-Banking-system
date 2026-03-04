#Secure Banking System
<h1 align="center">🔐 Secure Banking System</h1>

<p align="center">
A secure online banking web application designed for customers, merchants, and bank employees.
</p>

<p align="center">
<img src="https://img.shields.io/badge/Java-Backend-blue">
<img src="https://img.shields.io/badge/Spring-Framework-green">
<img src="https://img.shields.io/badge/MySQL-Database-orange">
<img src="https://img.shields.io/badge/Security-Enabled-red">
</p>

<hr>

<h2>🚀 Overview</h2>
<p>
Secure Banking System provides a web platform where users can perform banking operations such as
fund transfers, payments, and account management securely.
The system focuses on strong authentication, secure transactions, and role-based access control.
</p>

<hr>

<h2>👥 User Roles</h2>

<h3>🧑 Customers</h3>
<ul>
<li>View account information</li>
<li>Transfer funds</li>
<li>Make payments to merchants</li>
<li>View transaction history</li>
</ul>

<h3>🏪 Merchants</h3>
<ul>
<li>Receive payments from customers</li>
<li>Manage business transactions</li>
</ul>

<h3>🏦 Bank Employees</h3>
<ul>
<li>Approve or decline transaction requests</li>
<li>Handle customer service requests</li>
</ul>

<h3>🧑‍💼 System Managers</h3>
<ul>
<li>Authorize high-value transactions</li>
</ul>

<h3>⚙️ System Administrators</h3>
<ul>
<li>Manage internal accounts</li>
<li>Assign roles and permissions</li>
</ul>

<hr>

<h2>💳 Core Features</h2>
<ul>
<li>Secure fund transfers between accounts</li>
<li>Customer payments to merchants</li>
<li>Transaction approval workflow</li>
<li>Account statements and transaction history</li>
<li>Role-based system access</li>
</ul>

<hr>

<h2>🔒 Security Features</h2>
<ul>
<li>Two-Factor Authentication (OTP)</li>
<li>Password hashing using Spring Security</li>
<li>HTTPS / SSL encryption</li>
<li>Session timeout for inactivity</li>
<li>XSS protection through input validation</li>
<li>CSRF protection using tokens</li>
<li>Google reCAPTCHA for bot protection</li>
<li>PKI authentication for critical transactions</li>
</ul>

<hr>

<h2>🏗 System Architecture</h2>

<pre>
Client (Browser)
      │
      ▼
Frontend (HTML / Bootstrap / JavaScript)
      │
      ▼
Spring MVC Application
      │
      ▼
Hibernate ORM
      │
      ▼
MySQL Database
</pre>

<hr>

<h2>🛠 Tech Stack</h2>

<table>
<tr>
<th>Layer</th>
<th>Technology</th>
</tr>

<tr>
<td>Backend</td>
<td>Java</td>
</tr>

<tr>
<td>Framework</td>
<td>Spring Framework</td>
</tr>

<tr>
<td>ORM</td>
<td>Hibernate</td>
</tr>

<tr>
<td>Frontend</td>
<td>HTML, JavaScript, Bootstrap</td>
</tr>

<tr>
<td>Database</td>
<td>MySQL</td>
</tr>

<tr>
<td>Server</td>
<td>Apache Tomcat</td>
</tr>

<tr>
<td>Security</td>
<td>SSL/TLS, OTP, PKI</td>
</tr>

</table>

<hr>

<h2>🧪 Security Testing</h2>
<ul>
<li>Postman</li>
<li>Chrome Developer Tools</li>
<li>XSS Me</li>
</ul>

<p>Security practices referenced from <b>OWASP guidelines</b>.</p>

<hr>

<h2>🎯 Project Goal</h2>
<p>
The goal of this project is to build a secure banking web application while demonstrating
best practices in web security, authentication, and secure software development.
</p>

</p>
<p align="center" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<font face="Times New Roman, serif"><font size="2" style="font-size: 10pt">REFERENCES</font></font></p>
<p align="center" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<br/>

</p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<font face="Times New Roman, serif"><font size="2" style="font-size: 10pt">[1]
Open Web Application Security Project. (n.d.). Retrieved December 1,
2015, from https://www.owasp.org/index.php/Main_Page</font></font></p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<font face="Times New Roman, serif"><font size="2" style="font-size: 10pt">[2]
XSS-Me | Security Compass. (n.d.). Retrieved December 1, 2015, from
http://labs.securitycompass.com/exploit-me/xss-me/</font></font></p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<font face="Times New Roman, serif"><font size="2" style="font-size: 10pt">[3]
Spring.io. (n.d.). Retrieved December 1, 2015, from
https://spring.io/</font></font></p>
<p align="left" style="margin-bottom: 0in; line-height: 100%"><font face="Times New Roman, serif"><font size="2" style="font-size: 10pt"><span style="font-weight: normal">[4]
</span></font></font><font face="Times New Roman, serif"><font size="2" style="font-size: 10pt"><span style="font-weight: normal">Modern
software is built on APIs. (n.d.). Retrieved December 1, 2015, from
https://www.getpostman.com/	</span></font></font></p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<font face="Times New Roman, serif"><font size="2" style="font-size: 10pt">[5]
RFC 2818 - HTTP Over TLS. (n.d.). Retrieved May 24, 2015, from
https://tools.ietf.org/html/rfc2818</font></font></p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<font face="Times New Roman, serif"><font size="2" style="font-size: 10pt">[6]
Secure Banking System source code. (n.d.). Retrieved December 1,
2015, from https://github.com/anirudhgali/ Secure-Banking-System</font></font></p>
<p align="left" style="margin-bottom: 0in; line-height: 100%"><font face="Times New Roman, serif"><font size="2" style="font-size: 10pt"><span style="font-weight: normal">[</span></font></font><font face="Times New Roman, serif"><font size="2" style="font-size: 10pt"><span style="font-weight: normal">7]
ReCAPTCHA. (n.d.). Retrieved December 1, 2015, from
https://www.google.com/recaptcha/intro/index.html</span></font></font></p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<font face="Times New Roman, serif"><font size="2" style="font-size: 10pt">[8]
 Hibernate ORM. (n.d.). Retrieved December 1, 2015, from
http://hibernate.org/orm/</font></font></p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<font face="Times New Roman, serif"><font size="2" style="font-size: 10pt">[9]
Chrome DevTools. (n.d.). Retrieved December 1, 2015, from
https://developer.chrome.com/devtools</font></font></p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<br/>

</p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<br/>

</p>
<p align="left" style="margin-bottom: 0in; font-weight: normal; line-height: 100%">
<br/>

</p>
</body>
</html>
