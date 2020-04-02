package pl.com.nur.wprawkisql;

import org.springframework.stereotype.Component;

@Component
public class Start {

    private VideoDao videoDao;

    public Start(VideoDao videoDao) {
        this.videoDao = videoDao;
//        videoDao.saveVideo(1L, "Terminator1", "www.terminator1.pl");
//        videoDao.saveVideo(2L, "Terminator2", "www.terminator2.pl");
//        videoDao.saveVideo(3L, "Terminator3", "www.terminator3.pl");
//
//          videoDao.findAll().forEach(System.out::println);
//          videoDao.updateVideo(new Video(1L, "Terminator jeden", "nur.com.pl/terminator1"));
//          videoDao.deleteVideo(2L);
          videoDao.findAll().forEach(System.out::println);

         System.out.println(" szukany element = " + videoDao.getOne(1L));

    }
}
