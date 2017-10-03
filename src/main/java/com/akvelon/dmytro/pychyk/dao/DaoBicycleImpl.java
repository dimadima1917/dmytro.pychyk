package com.akvelon.dmytro.pychyk.dao;

import com.akvelon.dmytro.pychyk.domain.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.*;
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
        return this.jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Bicycle>(Bicycle.class));
    }

    @Override
    public long add(Bicycle bicycle) {
        try {
            UUID uuid = UUID.randomUUID();
            this.jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement preparedStatement = null;

                    preparedStatement = connection.prepareStatement(ADD, new String[]{"productId"});
                    preparedStatement.setString(1, bicycle.getName());
                    preparedStatement.setString(2, bicycle.getProductNumber());
                    preparedStatement.setString(3, bicycle.getColor());
                    preparedStatement.setDouble(4, bicycle.getStandardCost());
                    preparedStatement.setString(5, bicycle.getSize());
                    preparedStatement.setString(6, bicycle.getStyle());
                    preparedStatement.setString(7, uuid.toString());
                    return preparedStatement;
                }
            }, keyHolder);
            return (long) keyHolder.getKey();
        } catch (Exception exception) {
            return -1;
        }
    }

    @Override
    public void delete(long productId) {
        String Sql = DELETE_BY_ID;
        String Sql1 = Sql.replace("?", Long.toString(productId));
        jdbcTemplate.batchUpdate(Sql1.split(";"));
    }

    @Override
    public Bicycle searchById(long id) {
        Bicycle bicycle;
        try {
            bicycle = this.jdbcTemplate.queryForObject(FIND_BY_ID, new BeanPropertyRowMapper<>(Bicycle.class), id);
        } catch (IncorrectResultSizeDataAccessException exception) {
            bicycle = null;
        }
        return bicycle;
    }

    @Override
    public Bicycle searchByName(String name) {
        Bicycle bicycle;
        try {
            bicycle = this.jdbcTemplate.queryForObject(FIND_BY_NAME, new BeanPropertyRowMapper<>(Bicycle.class), name);
        } catch (IncorrectResultSizeDataAccessException exception) {
            bicycle = null;
        }
        return bicycle;
    }
}
