package za.ac.tut;
	
import javafx.application.Application;
import za.ac.tut.pizzashopwindows.PizzaShopWindows;

public class Main{
	
	public static void main(String[] args) {
		try{
			Application.launch(PizzaShopWindows.class, args);
		}
		catch (Exception e){
			// display message showing that an the program failed
			e.printStackTrace();
		}
	}
}
