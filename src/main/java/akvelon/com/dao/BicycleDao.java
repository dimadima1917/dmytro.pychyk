package akvelon.com.dao;

import akvelon.com.domain.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BicycleDao implements Dao<Bicycle> {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    KeyHolder keyHolder = new GeneratedKeyHolder();

    @Override
    public List<Bicycle> selectMostPopular() {
       return jdbcTemplate.query("SELECT * FROM bike", new BeanPropertyRowMapper<Bicycle>(Bicycle.class));
    }

    @Override
    public long add(Bicycle object) {
        return 111;
    }

    @Override
    public void delete() {

    }
}
