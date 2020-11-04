import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kyg
 * @version 1.0
 * @description
 * @since 2020/11/4 16:39
 */
public class Test {
    public static void main(String[] args) {

        ApplicationContext applicationContext = null;
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.getUser();

    }
}
