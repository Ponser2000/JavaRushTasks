package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        this.modelData.setDisplayDeletedUserList(false);
        //this.modelData.setUsers(userService.getUsersBetweenLevels(1,100));
        this.modelData.setUsers(getAllUsers());
    }

    public void loadDeletedUsers() {
        this.modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        this.modelData.setUsers(users);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        this.modelData.setActiveUser(user);
    }

    public void deleteUserById(long id){

        User user = this.userService.deleteUser(id);
        modelData.setUsers(getAllUsers());

    }

    @Override
    public void changeUserData(String name, long id, int level) {

        userService.createOrUpdateUser(name,id,level);
        modelData.setUsers(getAllUsers());
    }

    private List<User> getAllUsers(){
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }

}
