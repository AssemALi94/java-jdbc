import com.jdbc.dao.BookDao;
import com.jdbc.dao.LendingDao;
import com.jdbc.dao.RoleDao;
import com.jdbc.dao.UserDao;
import com.jdbc.model.Book;
import com.jdbc.model.Lending;
import com.jdbc.model.Role;
//import com.jdbc.model.RoleBuilder;
import com.jdbc.model.User;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Testing get RoleDao
//        RoleDao roleDao = RoleDao.builder().build();
//        System.out.println(roleDao.get(2));
//        *****************************************
//        Testing getAll RoleDao
//        RoleDao roleDao = RoleDao.builder().build();
//        List<Role> roles = roleDao.getAll();
//        for (int i = 0; i < roles.size(); i++) {
//            System.out.println(roles.get(i));
//        }
//        **********************************************
//        Testing save RoleDao
//        Role role = Role.builder().role("cleaner").build();
//        RoleDao roleDao = RoleDao.builder().build();
//        roleDao.save(role);
//        ***********************************************
//        Testing delete in RoleDao
//        RoleDao roleDao = RoleDao.builder().build();
//        roleDao.delete(4);
//        ****************************************************
//        Testing update in RoleDao
//        Role role = Role.builder().role("client").build();
//        RoleDao roleDao = RoleDao.builder().build();
//        roleDao.update(role,3);
//          *****************************************************
//////////////////////////////////////////////////////////////////////

//        --Testing get method for UserDao
//        UserDao userDao = UserDao.builder().build();
//        System.out.println(userDao.get(5));
//        ******************************************************
//        --Testing save method for UserDao
//        User user = User.builder().firstName("Ahmed").lastName("Ghareb").email("ahmed.ghareb@gmail.com").password("123456").roleId(2).build();
//        UserDao userDao= UserDao.builder().build();
//        userDao.save(user);
//        ******************************************************
//        --Testing getAll method for UserDao
//        UserDao userDao = UserDao.builder().build();
//        List<User> users = userDao.getAll();
//        for (int i = 0; i < users.size(); i++) {
//            System.out.println(users.get(i));
//        }
//        *******************************************************
//       --Testing delete method for UserDao
//        UserDao userDao = UserDao.builder().build();
//        userDao.delete(6);
//        **********************************************************
//       --Testing update method for UserDao
//        User user = User.builder().firstName("Assem").lastName("Gamal").email("assem.gimy@gmail.com").password("01005077").roleId(1).build();
//        UserDao userDao = UserDao.builder().build();
//        userDao.update(user,5);
//        ***************************************************************
//        Date d = java.sql.Date.valueOf("2020-08-20");
//        Lending lending = Lending.builder().bookId(1).borrowerId(7).staffId(5).lendDate(d.getTime()).returnDate(d).bookStatus(false).build();
//        LendingDao lendingDao= LendingDao.builder().build();
//        lendingDao.save(lending);
//
//       **************************************************************
//       --Testing book save method
//        Book book = Book.builder().title("Python").author("Assem").build();
//        BookDao bookDao= BookDao.builder().build();
//        bookDao.save(book);
//        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        --Testing update method for BookDao
//        Book book = Book.builder().title("Python").id(2).author("Ghareb").build();
//        BookDao bookDao = BookDao.builder().build();
//        bookDao.update(book);
//        ******************************************
//        --Testing getAll method for BookDao
//        BookDao bookDao = BookDao.builder().build();
//        List<Book> books = bookDao.getAll();
//        for (int i = 0; i < books.size(); i++) {
//            System.out.println(books.get(i));
//        }
//          *************************************************
//        --Testing get method for BookDao
        BookDao bookDao = BookDao.builder().build();
        System.out.println(bookDao.get(2));


    }
}