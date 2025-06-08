package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.MovieVO;
import model.ReservationVO;
import model.ReviewVO;

public class FuncImplementation extends Thread implements ReservationFuncInterface{
    public static final String adminID = "admin";
	public static final String adminPW = "1q2w3e4r";
    @Override
    public String PatternInspection(Scanner s, String string, String regex) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int adminLogon(int no, Scanner s) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void movieAdd(ArrayList<MovieVO> mvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void movieFileSave(ArrayList<MovieVO> mvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void movieFileUpload(ArrayList<MovieVO> mvList) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void movieList(ArrayList<MovieVO> mvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void movieModify(ArrayList<MovieVO> mvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void movieRemove(ArrayList<MovieVO> mvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void movieReservationCountUpdate(ArrayList<ReservationVO> rsvList, ArrayList<MovieVO> mvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationAdd(ArrayList<ReservationVO> rsvList, ArrayList<MovieVO> mvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationAsc(ArrayList<MovieVO> rsvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationCancle(ArrayList<ReservationVO> rsvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationCheck(ArrayList<ReservationVO> rsvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationDesc(ArrayList<MovieVO> rsvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationFileSave(ArrayList<ReservationVO> rsvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationFileUpload(ArrayList<ReservationVO> rsvList) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationMax(ArrayList<MovieVO> rsvList) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationMin(ArrayList<MovieVO> rsvList) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reservationModify(ArrayList<ReservationVO> rsvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reviewFileSave(ArrayList<ReviewVO> rvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reviewFileUpload(ArrayList<ReviewVO> rvList) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reviewPrint(ArrayList<ReviewVO> rvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void reviewWrite(ArrayList<ReviewVO> rvList, ArrayList<MovieVO> mvList, Scanner s) {
        // TODO Auto-generated method stub
        
    }

    

}
