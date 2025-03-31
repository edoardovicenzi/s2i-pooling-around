package solutions.vdesign.database;

import java.util.*;
import solutions.vdesign.datatransfer.*;
import solutions.vdesign.util.*;

public class UserRepository {
    // Needed since we wont implement an update only a save functionality (our
    // database is a file)
    private ArrayList<User> users = CsvParser.getUsers();

    // Needed since we are dealing with static csv
    private int lastId = 0;

    UserRepository() {
        lastId = users.get(users.size() - 1).getId();
    }

    // CRUD operations
    public boolean add(User newUser) {
        newUser.setId(lastId + 1);
        this.lastId = lastId + 1;
        return users.add(newUser);
    }

    public void deleteById(int id) {
        Optional<User> userInDatabase = getById(id);
        if (userInDatabase.isPresent()) {
            users.remove(userInDatabase.get().getId());
        }
    }

    public ArrayList<User> getAll() {
        return users;
    }

    public Optional<User> getById(int id) {
        return users
            .stream()
            .filter((user) -> user.getId() == id)
            .findFirst();
    }

    public void update(User newUser) {
        for (User user : users) {
            if (user.getId() == newUser.getId()){
                user = newUser;
                return;
            }
        }
        // no match found = add resource
        add(newUser);
    }

}
