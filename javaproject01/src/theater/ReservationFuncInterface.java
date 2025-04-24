package theater;

import java.util.ArrayList;
import java.util.Scanner;

public interface ReservationFuncInterface {
	public void movieFileUpload(ArrayList<Movie> mvList);
	public void movieFileSave(ArrayList<Movie> mvList);
	public void reservationFileUpload(ArrayList<Reservation> rsvList);
	public void reservationFileSave(ArrayList<Reservation> rsvList);
	public void reviewFileUpload(ArrayList<Review> rvList);
	public void reviewFileSave(ArrayList<Review> rvList);
	
	public void adminLogon();
	
	public void movieAdd(ArrayList<Movie> mvList, Scanner s);
	public void movieModify(ArrayList<Movie> mvList, Scanner s);
	public void movieRemove(ArrayList<Movie> mvList, Scanner s);
	
	public void movieList(ArrayList<Movie> mvList, Scanner s);
	
	public void reservationAsc(ArrayList<Reservation> rsvList);
	public void reservationDesc(ArrayList<Reservation> rsvList);
	public void reservationMax(ArrayList<Reservation> rsvList);
	public void reservationMin(ArrayList<Reservation> rsvList);

	public void reservationAdd(ArrayList<Reservation> rsvList, Scanner s);
	public void reservationCancle(ArrayList<Reservation> rsvList, Scanner s);
	public void reservationCheck(ArrayList<Reservation> rsvList);
	public void reservationModify(ArrayList<Reservation> rsvList, Scanner s);

	public void reviewWrite(ArrayList<Review> rvList, Scanner s);
	public void reviewPrint(ArrayList<Review> rvList);
	
	public String PatternInspection(Scanner s, String string, String regex);

}
