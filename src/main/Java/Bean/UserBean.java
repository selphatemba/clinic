package Bean;

import Dao.DaoI;
import Dao.UserDao;
import Dao.UserDaoI;
import Pojo.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "userbean"
@RequestScoped
@UserBeanI
public class UserBean implements BeanI {
    @Inject
    @UserDaoI

    DaoI daoI;
    User u=null;

    public UserBean() {
        u=new User();
    }

    public boolean register(Object o) {
        u= (User) o;
        return daoI.insert(u);
    }

    public boolean login(Object o) {
        u= (User) o;
        return daoI.find(u);
    }

    public boolean edit(Object o) {
        u= (User) o;
        return daoI.update(u);
    }

    public boolean logout(Object o) {
        u= (User) o;
        return daoI.find(u);
    }
}
