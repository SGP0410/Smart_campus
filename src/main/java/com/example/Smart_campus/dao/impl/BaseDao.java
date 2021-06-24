package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 15:10 星期一
 */

public class BaseDao {
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     *update()方法用来执行update、insert、delete语句
     * @param sql
     * @param args
     * @return 返回-1执行失败，返回其他代表影响的行数
     */
    public int update(String sql , Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection , sql , args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 返回一个JavaBean的SQL语句
     * @param type 返回的对象类型
     * @param sql  执行的SQL语句
     * @param args  SQL对应的参数值
     * @param <T> 返回类型的泛型
     * @return
     */

    public <T> T queryForOne(Class<T> type , String sql , Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection , sql , new BeanHandler<T>(type) , args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 返回多个JavaBean的SQL语句
     * @param type 返回的对象类型
     * @param sql  执行的SQL语句
     * @param args  SQL对应的参数值
     * @param <T> 返回类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type , String sql , Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection , sql , new BeanListHandler<T>(type) , args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 执行返回一行一列的SQL语句
     * @param sql  执行SQL语句
     * @param args SQL参数
     * @return
     */
    public Object queryForSingleValue(String sql , Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection , sql , new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}
