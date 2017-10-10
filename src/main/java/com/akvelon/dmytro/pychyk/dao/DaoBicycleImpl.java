package com.akvelon.dmytro.pychyk.dao;

import com.akvelon.dmytro.pychyk.domain.Bicycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static com.akvelon.dmytro.pychyk.dao.SQLs.*;

@Repository
public class DaoBicycleImpl implements Dao<Bicycle> {

    public static final Logger logger = LoggerFactory.getLogger(DaoBicycleImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    KeyHolder keyHolder = new GeneratedKeyHolder();

    private RowMapper<Bicycle> bicycleRowMapper = new RowMapper<Bicycle>() {
        @Override
        public Bicycle mapRow(ResultSet resultSet, int i) throws SQLException {
            Bicycle bicycle = new Bicycle();
            bicycle.setProductId(resultSet.getInt("ProductID"));
            bicycle.setName(resultSet.getString("Name"));
            bicycle.setProductNumber(resultSet.getString("ProductNumber"));
            bicycle.setColor(resultSet.getString("Color"));
            bicycle.setStandardCost(resultSet.getDouble("StandardCost"));
            bicycle.setSize(resultSet.getString("Size"));
            bicycle.setStyle("Style");
            return bicycle;
        }
    };

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
            logger.info(String.valueOf(exception));
            return -1;
        }
    }

    @Override
    public boolean delete(long productId) {
        String DELETE_BY_ID_SQL = DELETE_BY_ID.replace("?", Long.toString(productId));
        try {
            this.jdbcTemplate.batchUpdate(DELETE_BY_ID_SQL.split(";"));
        } catch (Exception exception) {
            logger.info(String.valueOf(exception));
            return false;
        }
        return true;
    }

    @Override
    public Bicycle searchById(long id) {
        List<Bicycle> bicycleList = this.jdbcTemplate.query(FIND_BY_ID, bicycleRowMapper, id);
        return bicycleList.size() > 0 ? bicycleList.get(0) : null;
    }

    @Override
    public List<Bicycle> searchByString(String substring) {
        String args = ("%" + substring + "%").trim();
        List<Bicycle> bicycleList = this.jdbcTemplate.query(FIND_BY_STRUNG, bicycleRowMapper, args);
        return bicycleList;
    }

    @Override
    public boolean update(Bicycle bicycle) {
        try {
            this.jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement preparedStatement = null;
                    preparedStatement = connection.prepareStatement(UPDATE, new String[]{"productId"});
                    preparedStatement.setString(1, bicycle.getName());
                    preparedStatement.setString(2, bicycle.getProductNumber());
                    preparedStatement.setString(3, bicycle.getColor());
                    preparedStatement.setDouble(4, bicycle.getStandardCost());
                    preparedStatement.setString(5, bicycle.getSize());
                    preparedStatement.setString(6, bicycle.getStyle());
                    preparedStatement.setInt(7, bicycle.getProductId());
                    return preparedStatement;
                }
            });
            return true;
        } catch (Exception exception) {
            logger.info(String.valueOf(exception));
            return false;
        }
    }
}
