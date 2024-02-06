package peaksoft.dao.impl;
import peaksoft.config.JdbcConfig;
import peaksoft.dao.UserDao;
import peaksoft.models.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    Connection connection = JdbcConfig.getConnectioin();

    @Override
    public String createUser() {
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate("""
                    create table if not exists users(
                id serial primary key,
                user_name varchar,
                password varchar,
                role varchar
                );
                    """);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "Successfully created table";
    }

    @Override
    public String saveUser(User user) {
        String query = """
                insert into users(user_name, password, role)
                values(?, ?, ?);
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return "Successfully saved user!!!";
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        try(PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                throw new RuntimeException("Student with id: " + id + " not found!");
            }
            user.setId(resultSet.getInt(1));
            user.setUserName(resultSet.getString("user_name"));
            user.setPassword((resultSet.getString("password")));
            user.setRole(resultSet.getString("role"));
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public String updateUser(Long id, User user) {
        String query = """
                update users
                set user_name = ?,
                password = ?,
                role = ?
                where id = ?;
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
            return "Updated!";
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }

    void changeRoleByUserNameAndPassword(String userName, String password){

    }

    String getUserRole(){
        return getUserRole();
    }
}
