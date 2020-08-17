import com.jdbc.dao.UserDao;
import com.jdbc.model.User;
import com.jdbc.utility.Utility;

import java.util.List;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Utility.getAllAnnotations("com.jdbc.model.User");
//        Class sample =Class.forName("com.jdbc.dao.UserDao");
//
//        UserDao userDao=(UserDao)sample.newInstance();
//
//
//
//
//        List <User> users = userDao.getAll();
//        for ( User uu :
//             users) {
//            System.out.println(uu.getId());
//            System.out.println(uu.getFirstName());
//            System.out.println(uu.getLastName());
//            System.out.println(uu.getEmail());
//            System.out.println(uu.getPassword());
//            System.out.println(uu.getRoleId());
//
//        }
    }
}
