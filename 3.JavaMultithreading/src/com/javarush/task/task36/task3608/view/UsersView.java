package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.Formatter;
import java.util.List;

public class UsersView implements View {
    private Controller controller;



    @Override
    public void refresh(ModelData modelData) {
        String s_out;
        s_out = modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:";
        System.out.println(s_out);
        List<User> users = modelData.getUsers();
        for(User user : users) {
            //User{name='A', id=1, level=1}
            String format = String.format("\tUser{name='%s', id=%d, level=%d}",user.getName(),user.getId(),user.getLevel());
            System.out.println(format);
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }



}
