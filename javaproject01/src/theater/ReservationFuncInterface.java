package theater;

import java.util.ArrayList;

public interface ReservationFuncInterface {
	public void movieFileUpload(ArrayList<Movie> mvList);
	public void movieFileSave(ArrayList<Movie> mvList);
	public void reservationFileUpload(ArrayList<Reservation> rsvList);
	public void reservationFileSave(ArrayList<Reservation> rsvList);
	public void reviewFileUpload(ArrayList<Review> rvList);
	public void reviewFileSave(ArrayList<Review> rvList);
	
	public void adminLogon();
	
	public void movieAdd();
	public void movieModify();
	public void movieRemove();
	
	public void movieList();
	
	public void reservationAsc();
	public void reservationDesc();
	public void reservationMax();
	public void reservationMin();

	public void reservationAdd();
	public void reservationCancle();
	public void reservationCheck();
	public void reservationModify();

	public void reviewWrite();
	public void reviewPrint();

}
