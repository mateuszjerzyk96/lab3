package com.example.lab3.data;

import com.example.lab3.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "admin:admin",
            "user:password"
    };

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(username)) {
                    // Account exists, return true if the password matches.
                    if (pieces[1].equals(password)){
                    LoggedInUser fakeUser =
                            new LoggedInUser(
                                    java.util.UUID.randomUUID().toString(),
                                    username );
                    return new Result.Success<>(fakeUser);
                    }

                }
            }

            return new Result.Error(new IOException("Próba utworzenia konta:"+username));


        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
