package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by SELPHA on 22/2/2018.
 */
public interface DaoI {
    boolean insert(Object o);
    boolean update(Object o);
    boolean delete(Object o);
    boolean find(Object o);
    boolean findById(Object o);
    ResultSet findAll(Object o);
    int countAll(Object o);
}
