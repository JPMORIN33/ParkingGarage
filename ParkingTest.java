import javax.swing.*;
import java.util.*;
import java.net.URL;
/**
 * Tester class that takes input from user and utilizes methods of ParkingSpot class to reserve, modify, or extend reservation.
 *
 */
public class ParkingTest {

	public static void main(String[]args) throws Exception {

		Scanner in = new Scanner (System.in);

		URL imageLocation = new URL(
				"https://i.imgur.com/oGOClh8.png");
		URL errorMessage = new URL("http://images.clipartpanda.com/error-clipart-1194985626525719339tasto_11_architetto_fran_01.svg.med.png");

		ParkingSpots ps = new ParkingSpots();//creates ParkingSpot Object
		String decision = "";
		/**
		 * Parking Garage Menu
		 */
		JOptionPane.showMessageDialog(null,"Welcome to Park-a-Lot", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
		JOptionPane.showMessageDialog(null, "To make a reservation enter (r), to extend a reservation enter (e), to modify a reservation enter (m), and to cancel enter (c).", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
		JOptionPane.showMessageDialog(null,"This is the current status of all parking spots: \n" +ps.toString(), "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation) );

		while(!decision.equals("c"))
		{
			decision = JOptionPane.showInputDialog("What would you like to do?");

			if(decision.equals("r"))
			{
				String time = JOptionPane.showInputDialog("What time would you like to reserve for? [1-24] ");
				int time1 = Integer.parseInt(time);

				String spot = JOptionPane.showInputDialog("What row is your desired parking spot in? [1-20] ");
				int spot1 = Integer.parseInt(spot);

				if(ps.errorCheck(spot1, time1) == true)
				{
					ps.ReserveSpot(spot1, time1);
					JOptionPane.showMessageDialog(null, ps.toString(), "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You have entered an incorrect spot or time. Please try again.", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
				}
			}

			else if(decision.equals("m"))
			{

				String currentTime = JOptionPane.showInputDialog("What time is it now? ");
				int currentTime1 = Integer.parseInt(currentTime);

				String reservedTime = JOptionPane.showInputDialog("What time was your reservation? ");
				int reservedTime1 = Integer.parseInt(reservedTime);

				if(currentTime1 < reservedTime1)
				{
					String spot = JOptionPane.showInputDialog("Please enter your parking spot number: ");
					int spot1 = Integer.parseInt(spot);

					String newTime = JOptionPane.showInputDialog("What time would you like to change it to? ");
					int newTime1 = Integer.parseInt(newTime);

					ps.modifyReservation(spot1, reservedTime1, newTime1);
					JOptionPane.showMessageDialog(null, ps.toString(), "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sorry you cannot modify your reservation to this spot and time.", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
				}
			}

			else if(decision.equals("e"))
			{
				String currentTime = JOptionPane.showInputDialog("What time is it now? ");
				int currentTime1 = Integer.parseInt(currentTime);

				String reservedTime = JOptionPane.showInputDialog("What time was your reservation? ");
				int reservedTime1 = Integer.parseInt(reservedTime);

				if(currentTime1 < reservedTime1)
				{
					String spot = JOptionPane.showInputDialog("Please enter your parking spot number: ");
					int spot1 = Integer.parseInt(spot);

					ps.extendReservation(spot1, reservedTime1);
					JOptionPane.showMessageDialog(null, ps.toString(), "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
				}

				else
				{
					JOptionPane.showMessageDialog(null, "Sorry you have passed the time limit for extending reservations.", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
				}
			}

			else if(decision.equals("c"))
			{
				JOptionPane.showMessageDialog(null, "Goodbye! Please come again!", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
				System.exit(0);
			}

			else
			{
				JOptionPane.showMessageDialog(null, "You have entered in a wrong decision. Please choose from the options listed", "Park-a-Lot", JOptionPane.PLAIN_MESSAGE, new ImageIcon(errorMessage));
			}
		}	

		System.exit(0);
	}
}
