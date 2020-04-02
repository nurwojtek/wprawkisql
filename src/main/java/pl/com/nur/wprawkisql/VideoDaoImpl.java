package pl.com.nur.wprawkisql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VideoDaoImpl implements VideoDao{
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public VideoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveVideo(long id, String title, String url) {
        Video video = new Video(id, title, url);
        String sql = "INSERT INTO videos VALUES (?,?,?)";
        jdbcTemplate.update(sql, video.getVideoId(), video.getTitle(), video.getUrl());
    }

    @Override
    public List<Video> findAll() {
        String sql=  "SELECT * FROM videos";
        List<Video> videoList = new ArrayList<>();
        // E07S06
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach((element -> videoList.add(new Video(
                Long.parseLong(String.valueOf(element.get("video_id"))),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("url"))
                ))));

        return videoList;
    }

    @Override
    public void updateVideo(Video newVideo) {
        String sql = "UPDATE videos SET videos.title=?,videos.url=? where videos.video_id=?";
        jdbcTemplate.update(sql, newVideo.getTitle(), newVideo.getUrl(), newVideo.getVideoId());
    }

    @Override
    public void deleteVideo(long id) {
        String sql = "DELETE FROM videos  WHERE videos.video_id=?";
        jdbcTemplate.update(sql, id);
    }


    @Override
    //E07S09
    public Video getOne(long id) {
        String sql = "SELECT * FROM videos WHERE video_id = ?";
        // kolumny numerujemy od 1 lub po nazwach
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Video(rs.getLong(1),
                rs.getString("title"), rs.getString("url")), id);
    }

}
