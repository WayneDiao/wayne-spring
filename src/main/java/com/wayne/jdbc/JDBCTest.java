package com.wayne.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wayne
 * @Date: 2018/9/6
 * @Description:
 */
public class JDBCTest {

    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    {
        context = new ClassPathXmlApplicationContext("classpath:jdbc/application-jdbc.xml");
        jdbcTemplate = context.getBean(JdbcTemplate.class);
        namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
    }

    /*
    * 使用具名参数时，可以使用public int update(String sql, SqlParameterSource paramSource)
    * 1、SQL 语句的参数名要求和类的属性名一致
    * 2、使用SqlParameterSource的BeanPropertySqlParameterSource实现类作为参数
    */
    @Test
    public void testNamedParameterJdbcTemplate2() {
        String sql = "insert into  user values(:name,:number,:age,:gender)";
        User user = new User();
        user.setAge(16);
        user.setGender("男");
        user.setName("老掉");
        user.setNumber("八号");
        SqlParameterSource source = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql,source);
    }

    /*
    * 使用具名的参数的jdbc template
    * 好处：可以直接使用对应参数映射相应数据，参数过多时，不需要仔细核对位置
    * 坏处：稍显复杂
    */
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "insert into  user values(:name,:number,:age,:gender)";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","刁凡");
        map.put("number","今晚");
        map.put("age",24);
        map.put("gender","男");
        namedParameterJdbcTemplate.update(sql,map);
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
