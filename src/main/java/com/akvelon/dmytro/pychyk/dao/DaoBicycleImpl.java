package com.akvelon.dmytro.pychyk.dao;

import com.akvelon.dmytro.pychyk.domain.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static com.akvelon.dmytro.pychyk.dao.SQLs.*;

@Repository
public class DaoBicycleImpl implements Dao<Bicycle> {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    KeyHolder keyHolder = new GeneratedKeyHolder();

    @Override
    public List<Bicycle> selectMostPopular() {
       return this.jdbcTemplate.query(SELECT_MOST_POPULAR, new BeanPropertyRowMapper<Bicycle>(Bicycle.class));
    }

    @Override
    public List<Bicycle> selectAll() {
        return this.jdbcTemplate.query(SELECT_ALL,new BeanPropertyRowMapper<Bicycle>(Bicycle.class));
    }

    @Override
    public long add(Bicycle bicycle) {
        UUID uuid = UUID.randomUUID();
        this.jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(ADD,new String[] {"productId"});
                preparedStatement.setString(1, bicycle.getName());
                preparedStatement.setString(2, bicycle.getProductNumber());
                preparedStatement.setString(3, bicycle.getColor());
                preparedStatement.setDouble(4, bicycle.getStandartCost());
                preparedStatement.setString(5, bicycle.getSize());
                preparedStatement.setString(6, bicycle.getStyle());
                preparedStatement.setString(7, uuid.toString());
                return preparedStatement;
            }
        },keyHolder);
        return (long) keyHolder.getKey();
    }

    @Override
    public void delete(int productId) {
        this.jdbcTemplate.update(DELETE_BY_ID);
    }

    @Override
    public List<Bicycle> search() {
        return null;
    }
}
