package eu.mrndesign.matned.springProject.repository;

import eu.mrndesign.matned.springProject.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepository {

    private final List<UserModel> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public void save(UserModel user){
        user.setAddDate(new Date());
        users.add(user);
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void delete(int id){
        users.remove(users.get(id));
    }
}
