package Bean.BeanImplementation;

import Bean.BeanInterface.BeanI;
import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Pojo.User;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


import static Dao.DaoInterface.DaoIAnnotation.User.USER;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "userbean"
@Stateful
public class UserBean implements BeanI {
    @Inject
    @DaoIAnnotation(choice = USER)

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
