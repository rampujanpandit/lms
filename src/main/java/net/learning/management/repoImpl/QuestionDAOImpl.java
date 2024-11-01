package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Question;
import net.learning.management.repo.QuestionDAO;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Question question) {
        String sql = "INSERT INTO question (quiz_id, question_text, question_type) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, question.getQuizId(), question.getQuestionText(), question.getQuestionType());
    }

    @Override
    public List<Question> findByQuizId(Long quizId) {
        String sql = "SELECT * FROM question WHERE quiz_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Question.class), quizId);
    }
}

