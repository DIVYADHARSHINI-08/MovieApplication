package service;

import entity.Users;
import java.util.HashMap;

public class UsersService {

    private HashMap<String, Users> users = new HashMap<>();

    public UsersService() {
        // Manual data
        users.put("admin", new Users(1L, "admin", "123", "admin@mail.com", "9999999999", "Chennai", "ADMIN"));
        users.put("user", new Users(2L, "user", "123", "user@mail.com", "8888888888", "Chennai", "USER"));
    }

    public Users login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("User not found!");
            return null;
        }

        Users user = users.get(username);

        if (!user.getPassword().equals(password)) {
            System.out.println("Wrong password!");
            return null;
        }

        return user;
    }

    public void registerUser(Long userId, String name, String password,
                             String email, String phnNo, String city) {

        // username = name (you are using name as key)
        if (users.containsKey(name)) {
            System.out.println("Username already exists!");
            return;
        }

        Users newUser = new Users(userId, name, password, email, phnNo, city, "USER");

        users.put(name, newUser);
        System.out.println("Registration successful!");
    }

    public void showAllUsers() {
        for (Users u : users.values()) {
            System.out.println(u);
        }
    }
}