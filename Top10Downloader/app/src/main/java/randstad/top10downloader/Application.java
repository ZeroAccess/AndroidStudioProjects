package randstad.top10downloader;

/**
 * Created by robertsg on 2/18/2015.
 */
public class Application {
    
    private String name;
    private String artist;
    private String releaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String toString() {
        return "Name: " + this.name + "\n" +
                "Artist: " + this.artist + "\n" +
                "Release Date: " + this.releaseDate + "\n";
    }
}
