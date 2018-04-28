package net.kprod.productivity.wekanhook.service;

/**
 * Created by kemkem on 4/26/18.
 */
public interface WekanLoginService {
    /**
     * Login to wekan
     * Maintain token validity
     * @return current token
     */
    String login();
}
