package app.currentdata;

import app.service.entities.UserEntity;

public class CurrentUser {

    private static UserEntity currentUser = new UserEntity();
    private static boolean validCredentials = false;

    public static void setCurrentUser(UserEntity currentUser) {
        CurrentUser.currentUser = currentUser;
    }
    public static UserEntity getCurrentUser() {
        return currentUser;
    }

    public static void setCredentialsValidation(boolean validation) {
        CurrentUser.validCredentials = validation;
    }

    public static boolean credentialsValidated() {
        return CurrentUser.validCredentials;
    }

}
