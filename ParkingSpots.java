import java.net.URL;
import java.util.*;
import javax.swing.*;
/**
 * This class is a Parking Spot object that has methods to reserve a spot, 
 * modify a reservation and and extend a reservation. It also contains a toStirng and errorCheck method.
 */
public class ParkingSpots {

	private String [][] parkinglot;
	private int rows;
	private int hours;
	/**
	 * Constructs an object with 20 empty spots each alloted with 24 hours representing a full day
	 */
	public ParkingSpots(){

		rows = 20;
		hours = 24;

		
		parkinglot = new String [20][24];
		
		for (int x = 0; x<rows; x++)
		{
			for (int y = 0; y<hours; y++)
			{
				parkinglot[x][y]= " ";
			}
		}
	}
	/**
	 * Checks to make sure there are no errors in the scheduling considering 24 hour time slot and spots allocated
	 * @param spot
	 * @param time
	 * @return
	 */
	public boolean errorCheck(int spot, int time)
	{
		if(time > 0 && time<=hours && spot >0 && spot<=rows)
		{
			return true;
		}
		else
			return false;
	}
	
	/**
	 *Initially reserves a specific spot for a specific time in the garage. Outputs error 
	 *if spot is already taken
	 * @param spot
	 * @param time
	 * @throws Exception
	 */
	public void ReserveSpot(int spot, int time) throws Exception {
		
		URL imageLocation = new URL(
				"https://i.imgur.com/oGOClh8.png");
		
		if(parkinglot[spot-1][time-1] == " ")
		{
			parkinglot[spot-1][time-1] = "R";
				
			JOptionPane.showMessageDialog(null, "Your parking spot number is: "+spot+ " at time "+time+ ":00.", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
		}
		else
			JOptionPane.showMessageDialog(null, "Sorry parking spot number "+spot+ " is reserved at this time. Please choose another spot.", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));

	}
	/**
	 * Extends reservation for user if they already have a spot. If spot is taken by a different user or 
	 * if inputed reservation does not exist then output is printed stating so.
	 * @param spot
	 * @param time
	 * @throws Exception
	 */
	public void extendReservation(int spot, int time) throws Exception {
		
		URL imageLocation = new URL(
				"https://i.imgur.com/oGOClh8.png");
		
		if(parkinglot[spot-1][time-1]== "R")
		{
			parkinglot[spot-1][time-1] = " ";
			if(parkinglot[spot-1][time] != "R")
			{
				parkinglot[spot-1][time] = "R";
				JOptionPane.showMessageDialog(null, "Your reservation has been extended for an hour for parking spot number: "+spot+"\nYour new reservation time is until: "+(time+2), "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Sorry that spot and time are already reserved. Please choose another spot.", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Your reserved spot does not exist.", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
		}
	}
	/**
	 * Modifies reservation. If spot does not exist or user tries to modify violating garage rules 
	 * then output is printed
	 * @param spot
	 * @param time
	 * @param newTime
	 * @throws Exception
	 */
	public void modifyReservation(int spot, int time, int newTime) throws Exception {
		
		URL imageLocation = new URL(
				"https://i.imgur.com/oGOClh8.png");
		
		if(errorCheck(spot, time)==true)
		{
			if(parkinglot[spot-1][time-1] == "R")
			{
				parkinglot[spot-1][time-1] = " ";
				
			
					if(parkinglot[spot-1][newTime-1] == " ")
					{
						parkinglot[spot-1][newTime-1] = "R";
						JOptionPane.showMessageDialog(null, "Your reservation has been successfully modified for spot "+spot+ "at time "+newTime, "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
					}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Your reserved spot does not exist.", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid spot [1-20] and valid time [1-24].", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
		}
		
	}
	/**
	 * Displays the complete garage
	 */
	public String toString()
	{
		String displayLot = "         1:00   2:00   3:00   4:00   5:00   6:00   7:00   8:00   9:00  10:00 11:00 12:00 13:00 14:00 15:00 16:00 17:00 18:00 19:00 20:00 21:00 22:00 23:00 24:00";
		for(int x = 0; x < 9; x++)
		{
			displayLot = displayLot + " \nR" +(x+1)+ "    ";
			for(int y = 0; y < hours; y++)
			{
				displayLot = displayLot + "[   "+parkinglot[x][y]+"   ] ";
			}
		}
		for(int x = 9; x < rows; x++)
		{
			displayLot = displayLot + " \nR" +(x+1)+ "  ";
			for(int y = 0; y < hours; y++)
			{
				displayLot = displayLot + "[   "+parkinglot[x][y]+"   ] ";
			}
		}
		return displayLot;
	}

}
