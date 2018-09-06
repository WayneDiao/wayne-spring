package com.wayne.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wayne
 * @Date: 2018/9/6
 * @Description:
 */
public class JDBCTest {

    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate;


    {
        context = new ClassPathXmlApplicationContext("classpath:jdbc/application-jdbc.xml");
        jdbcTemplate = context.getBean(JdbcTemplate.class);
    }

    /**
     * 执行 INSERT UPDATE DELETE
     */
    @Test
    public void testUpdate() {
        String sql = "update user set name = ? where name = ?";
        jdbcTemplate.update(sql,"wayne","hai");
    }

    /**
     * 获取一条记录
     * 不是调用 queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     * 而是queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     * 1、RowMapper指定如何去映射结果集的行，常用实现类为BeanPropertyRowMapper
     * 2、使用SQL中列的别名完成列名和类属性名的映射
     * 3、不支持级联属性，
     */
    @Test
    public void testQueryObject() {
        String sql = "select * from user limit 1";
        RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql,mapper);
        assert user != null;
        System.out.println(user.toString());
    }

    /**
     * 获取单个值，或做统计查询
     */
    @Test
    public void testQueryForObject() {
        String sql = "select count(*) from user";
        long count = jdbcTemplate.queryForObject(sql,long.class);
        System.out.println(count);
    }

    /**
     * 查询实体类集合
     */
    @Test
    public void testQueryForList() {
        String sql = "select * from user limit 10";
        RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = jdbcTemplate.query(sql,mapper);
        System.out.println(list);
    }


    /**
     * 批量更新:INSERT UPDATE DELETE
     */
    @Test
    public void testBatchUpdate() {
        String sql = "insert into user values(?,?,?,?)";

        List<Object[]> objects = new ArrayList<Object[]>();
        for (int i = 0; i < 10;i++) {
            Object[] objects1 = new Object[]{"jack" + i,"user_" + i,18 + i,i % 2 == 0 ? "男" : "女"};
            objects.add(objects1);
        }

        jdbcTemplate.batchUpdate(sql,objects);

    }


    @Test
    public void test() {
        DataSource dataSource = context.getBean(DataSource.class);
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
