package Dao.DaoInterface;

import Entities.User;
import java.util.List;

/**
 * Created by SELPHA on 22/2/2018.
 */
public interface DaoI {
    boolean insert(Object o);
    boolean update(Object o);
    boolean delete(Object o);
    boolean find(Object o);
    boolean findById(Object o);
    List<Object> findAll(Object o);
    int countAll(Object o);
}
