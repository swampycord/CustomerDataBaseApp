package app.service.entities;

import app.currentdata.CurrentUser;
import app.service.dummydata.Users;

import java.util.List;

public class UserService {
    private static final List<UserEntity> users = Users.getHardCodedList();
    private static final List<UserEntity> customUsers = Users.getCustomList();

    public void getUserWithUsername(String username) {
        UserEntity user = users//
                .stream()//
                .filter(e -> e.getUsername().equals(username.toLowerCase().trim()))//
                .findFirst()//
                .orElse(null);

        if (user == null) {
            user = customUsers
                    .stream()
                    .filter(e -> e.getUsername().equals(username.toLowerCase().trim()))
                    .findFirst()
                    .orElse(null);
        }

        CurrentUser.setCurrentUser(user);
    }

    public void verifyUserWithPassword(String password) {
        UserEntity user = CurrentUser.getCurrentUser();
        if (user != null) {
            CurrentUser.setCredentialsValidation(user.getPassword().equals(password.trim()));
        }
    }

    public void addUser(String username, String password) {
        UserEntity user = new UserEntity(username.toLowerCase().trim(), password.trim());
        customUsers.add(user);
    }
}
