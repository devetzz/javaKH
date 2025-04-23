package theater;

public class Movie {

	private int movieNum;
	private String movieName;
	private String movieDate;
	private int reservationNum;
	
	public Movie() {
		this(0,null,null);
	}

	public Movie(int movieNum, String movieName, String movieDate) {
		super();
		this.movieNum = movieNum;
		this.movieName = movieName;
		this.movieDate = movieDate;
	}

	public Movie(int movieNum, String movieName, String movieDate, int reservationNum) {
		super();
		this.movieNum = movieNum;
		this.movieName = movieName;
		this.movieDate = movieDate;
		this.reservationNum = reservationNum;
	}

	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public int getReservationNum() {
		return reservationNum;
	}

	public void setReservationNum(int reservationNum) {
		this.reservationNum = reservationNum;
	}

	@Override
	public String toString() {
		return "Movie [" + movieNum + ", " + movieName + ", " + movieDate + "]";
	}
	
}
