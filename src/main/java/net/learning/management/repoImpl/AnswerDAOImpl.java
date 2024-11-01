package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Answer;
import net.learning.management.repo.AnswerDAO;

import java.util.List;

@Repository
public class AnswerDAOImpl implements AnswerDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnswerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Answer answer) {
        String sql = "INSERT INTO answer (question_id, user_id, answer_text, is_correct) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, answer.getQuestionId(), answer.getUserId(), answer.getAnswerText(), answer.isCorrect());
    }

    @Override
    public List<Answer> findByUserIdAndQuizId(Long userId, Long quizId) {
        String sql = "SELECT a.* FROM answer a JOIN question q ON a.question_id = q.id WHERE a.user_id = ? AND q.quiz_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Answer.class), userId, quizId);
    }
}

