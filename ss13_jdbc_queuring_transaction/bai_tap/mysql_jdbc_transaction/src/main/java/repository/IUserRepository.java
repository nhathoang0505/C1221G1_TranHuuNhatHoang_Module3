package repository;

import model.User;

import java.util.List;

public interface IUserRepository extends ICrudRepository<User> {
    void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    void deleteUser(int id);

    void updateUser(User user);

    List<User> getSearchList(String search_input);

    List<User> sortByName(boolean isDESC);

    void addUserTransaction(User user, int[] permisions);

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction();


}