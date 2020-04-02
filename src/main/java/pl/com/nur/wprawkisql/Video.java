package pl.com.nur.wprawkisql;


public class Video {

  /// generowanie automatycznie pliku E07S04 - 1.3min

  private long videoId;
  private String title;
  private String url;

  public Video() {
  }

  public Video(long videoId, String title, String url) {
    this.videoId = videoId;
    this.title = title;
    this.url = url;
  }

  public long getVideoId() {
    return videoId;
  }

  public void setVideoId(long videoId) {
    this.videoId = videoId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Video{" +
            "videoId=" + videoId +
            ", title='" + title + '\'' +
            ", url='" + url + '\'' +
            '}';
  }
}
