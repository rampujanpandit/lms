package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Media;
import net.learning.management.repo.MediaDAO;

import java.util.List;

@Repository
public class MediaDAOImpl implements MediaDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MediaDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Media media) {
        String sql = "INSERT INTO media (file_name, media_type, url, upload_date) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, media.getFileName(), media.getMediaType(), media.getUrl(), media.getUploadDate());
    }

    @Override
    public List<Media> findAll() {
        String sql = "SELECT * FROM media";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Media.class));
    }
}

