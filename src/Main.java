import com.jdbc.dao.UserDao;
import com.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();



        List <User> users = userDao.getAll();
        for ( User uu :
             users) {
            System.out.println(uu.getId());
            System.out.println(uu.getFirstName());
            System.out.println(uu.getLastName());
            System.out.println(uu.getEmail());
            System.out.println(uu.getPassword());
            System.out.println(uu.getRoleId());

        }
    }
}
