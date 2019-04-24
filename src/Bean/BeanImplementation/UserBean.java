package Bean.BeanImplementation;

import Bean.BeanInterface.UserBeanI;
import Dao.DaoInterface.DaoI;
import Dao.DaoInterface.DaoIAnnotation;
import Entities.User;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;


import static Dao.DaoInterface.DaoIAnnotation.User.USER;

/**
 * Created by SELPHA on 19/2/2018.
 */

//creates a managed bean called "userbean"
@Stateless
public class UserBean implements UserBeanI {
    @Inject
    @DaoIAnnotation(choice = USER)

    DaoI daoI;
    User u=null;

    public UserBean() {
        u=new User();
    }

   @PostConstruct
    public void register(){
   }

    public boolean register(User u) {
        return daoI.insert(u);
    }

    //@LoginInterceptorB
    public void login(User u) {
         daoI.find(u);
    }

    public boolean edit(User u) {
        return daoI.update(u);
    }
    public boolean logout(User u) {
        return daoI.find(u);
    }

    @PreDestroy
    public void logout(){
    }
}
