package entity;

public class Movies
{
    private Long movieId;
    private String title;
    private int duration;
    private String genre;
    private int year;
    private Double rating;

    private Long userId;

    public Movies(Long movieId, String title, int duration, String genre, int year, Double rating, Long userId) {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public Double getRating() {
        return rating;
    }

    public Long getUserId()
    {
        return userId;
    }


    @Override
    public String toString() {
        return title + " (" + year + ") | " + genre + " | " + rating;
    }
}
