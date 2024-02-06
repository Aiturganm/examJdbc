package peaksoft;
import peaksoft.models.User;
import peaksoft.services.UserService;
import peaksoft.services.impl.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.createUser());
//        System.out.println(userService.saveUser(new User("Aiturgan", "0307aiturgan", "Admin")));
//        System.out.println(userService.updateUser(1L, new User("Aliya", "trend124", "Admin")));
//        System.out.println(userService.getUserById(1L));
    }
}
