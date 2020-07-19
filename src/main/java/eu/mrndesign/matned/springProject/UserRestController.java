package eu.mrndesign.matned.springProject;

import eu.mrndesign.matned.springProject.model.UserModel;
import eu.mrndesign.matned.springProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    UserRepository repository;

    @GetMapping("/userlist")
    public List<UserModel> showAllUsers(){
        return repository.getUsers();
    }

    @PostMapping("/addUser")
    public UserModel addUser(@RequestBody UserModel user){
        repository.save(user);
        return user;
    }

    @PostMapping("/addUsers")
    public List<UserModel> addUsers(@RequestBody List<UserModel> users){
        for (UserModel user: users) {
            repository.save(user);
        }
        return users;
    }

    @PostMapping("/deleteUser/{userId}")
    public void deleteUsers(@PathVariable int userId){
            repository.delete(userId);

    }





}
