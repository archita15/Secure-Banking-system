
package com.group9.bankofaz.service;
import java.util.List;

import com.group9.bankofaz.exception.AuthorizationException;
import com.group9.bankofaz.model.InternalUser;
import com.group9.bankofaz.model.Logs;
import com.group9.bankofaz.model.Task;
import com.group9.bankofaz.model.Users;

/**
 * @author Archita Palkar
 *
 */
public interface SystemAdministratorService {

    void addInternalUserAccount(InternalUser internalUser) throws AuthorizationException;

    void updateInternalUserAccount(InternalUser internalUser) throws AuthorizationException;

    void deleteInternalUserAccount(long internalUserId) throws AuthorizationException;

    List<Logs> viewSystemLogs() throws AuthorizationException;

    List<Task> getTasks() throws AuthorizationException;

    void completeTask(int taskId) throws AuthorizationException;

    void refreshTasks() throws AuthorizationException;

    void updateInternalUserInfo(InternalUser user) throws AuthorizationException;

    void updatePassword(Users user) throws AuthorizationException;
}
