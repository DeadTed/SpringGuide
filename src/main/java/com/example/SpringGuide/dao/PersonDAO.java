package com.example.SpringGuide.dao;

import com.example.SpringGuide.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Yauheni Minchanka
 * 9/19/22
 */
@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //выполняем запрос в бд
    //в данном случае через BeanPropertyRowMapper, он автоматически совмещает поля таблицы с моделью, но можно сделать и через PersonMapper(пример в show())
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * from person where id=?",
                new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES(1,?,?,?)",
                person.getName(),
                person.getAge(),
                person.getEmail());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET name=?,age=?,email=? where id=?",
                updatedPerson.getName(),
                updatedPerson.getAge(),
                updatedPerson.getEmail(),
                updatedPerson.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE from person where id=?", id);
    }
}
