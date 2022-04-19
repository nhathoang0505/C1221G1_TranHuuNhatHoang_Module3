package service;

import model.User;

import java.util.List;

public interface IUserService {
    void insertUser(User user) ;

    User selectUser(int id);

    List<User> selectAllUsers();

    void deleteUser(int id) ;

    void updateUser(User user);

    List<User> getSearchList(String search_input);

    List<User> sortByName(boolean isDESC);

    void addUserTransaction(User user, int[] permision);

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction();
}