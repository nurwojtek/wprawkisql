package pl.com.nur.wprawkisql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

//    @Bean
//    public DataSource getDataSource(){  // definiujemy połącznie do bazy zamiast w
//        // application.properties robimy to np gdy mamy więcej baz danych niż jedna
//        DataSourceBuilder dataSourceBuilder =
//                DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://mysql-232160.vipserv.org:3306/nur_akademia"); // jdbc: baza / aders  do bazy : port / nazwa bazy
//        dataSourceBuilder.username("nur_akademia");
//        dataSourceBuilder.password("7uVxKqes6A7fndwRy9oniggSM0OGK0sS");
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");  // klasa która odpowiada za połączenia
//                       // adademia S07E03  min 7,30
//
//        return dataSourceBuilder.build(); // zwracam jako zbudowany element
//    }

    private DataSource getDataSource;

    @Autowired
    public DbConfig(DataSource getDataSource) {
        this.getDataSource = getDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource);
    }


//    @EventListener(ApplicationEvent.class)
//    public void init(){
//        String sql = "CREATE TABLE videos(video_id int, title varchar(255), url varchar(255), PRIMARY KEY (video_id))";
//        getJdbcTemplate().update(sql);
//    }

    
}
