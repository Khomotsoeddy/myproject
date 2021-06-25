package za.ac.tut.buywindow;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class buyWindowController implements Initializable{

    @FXML
    private ComboBox<String> cboBox;

    @FXML
    private Label txtSize;

    @FXML
    private RadioButton rdoSmall;

    @FXML
    private RadioButton rdoMedium;

    @FXML
    private RadioButton rdoLarge;

    @FXML
    private Label Label_1;

    @FXML
    private CheckBox chkExtraCheese;

    @FXML
    private CheckBox chkExtraMeat;

    @FXML
    private CheckBox chkMushroom;

    @FXML
    private CheckBox chkBlackOlives;

    @FXML
    private CheckBox chkOnions;

    @FXML
    private CheckBox chkSausage;

    @FXML
    private CheckBox chkPeriperi;

    @FXML
    private CheckBox ckhBBQ;

    @FXML
    private RadioButton rdoDineIn;

    @FXML
    private RadioButton rdoTakeOut;

    @FXML
    private RadioButton rdoDelivery;

    @FXML
    private Button btnDecrement;

    @FXML
    private Button btnIncrement;

    @FXML
    private Button btnBillOut;

    @FXML
    private Button btnOrderAgain;
    
    
    @FXML
    private Button btnPayment;
    
    @FXML
    private Text txtSmall;

    @FXML
    private Text txtMedium;

    @FXML
    private Text txtLarge;
    
    @FXML
    private TextArea txtArea;
    
    @FXML
    private Label txtQuantity;
    
    private double addMore = 0.00;
    private int qty = 1; 
	
    private ObservableList<String> list = FXCollections.observableArrayList("Pepperoni",
																	 "BBQ Chicken",
																	 "Meat",
																	 "Vegetarian",
																	 "Bacon and Cheese",
																	 "Hawaiian");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cboBox.setItems(list);
	}
	
	public void getPrice(ActionEvent event) {
		if(cboBox.getSelectionModel().isSelected(0)) {
			txtSmall.setText("100.00");
			txtMedium.setText("120.00");
			txtLarge.setText("140.00");
		}else if(cboBox.getSelectionModel().isSelected(1)) {
			txtSmall.setText("130.00");
			txtMedium.setText("150.00");
			txtLarge.setText("170.00");
		}else if(cboBox.getSelectionModel().isSelected(2)) {
			txtSmall.setText("90.00");
			txtMedium.setText("110.00");
			txtLarge.setText("140.00");
		}else if(cboBox.getSelectionModel().isSelected(3)) {
			txtSmall.setText("110.00");
			txtMedium.setText("130.00");
			txtLarge.setText("150.00");
		}else if(cboBox.getSelectionModel().isSelected(4)) {
			txtSmall.setText("120.00");
			txtMedium.setText("140.00");
			txtLarge.setText("160.00");
		}else if(cboBox.getSelectionModel().isSelected(5)) {
			txtSmall.setText("80.00");
			txtMedium.setText("90.00");
			txtLarge.setText("100.00");
		}else{
			txtSmall.setText("0.00");
			txtMedium.setText("0.00");
			txtLarge.setText("0.00");
		}
	}
	
	public double addMorePrice() {
		
		if(chkExtraCheese.isSelected()) {
			
			addMore += 10.00;
		}
		if(chkExtraMeat.isSelected()) {
			addMore += 15.00;
		}
		if(chkMushroom.isSelected()) {
			addMore += 5.00;
		}
		if(chkBlackOlives.isSelected()) {
			addMore += 8.00;
		}
		if(chkOnions.isSelected()) {
			addMore += 7.00;
		}
		if(chkSausage.isSelected()) {
			addMore += 5.00;
		}
		if(ckhBBQ.isSelected()) {
			addMore += 10.00;
		}
		if(chkPeriperi.isSelected()) {
			addMore += 11.00;
		}
		
		return addMore ;
	}
	
	public String addOnsInfo() {
		String info = "";
	
		if(chkExtraCheese.isSelected()) {
			info = info + "\n\t" + chkExtraCheese.getText() + "\t\t" + "R10.00";
		}
		if(chkExtraMeat.isSelected()){
			info = info + "\n\t" + chkExtraMeat.getText() + "\t\t" + "R15.00";
		}
		if(chkMushroom.isSelected()) {
			info = info + "\n\t" + chkMushroom.getText() + "\t\t" + "R5.00";
		}
		if(chkBlackOlives.isSelected()) {
			info = info + "\n\t" + chkBlackOlives.getText() + "\t\t" + "R8.00";
		}
		if(chkOnions.isSelected()) {
			info = info + "\n\t" + chkOnions.getText() + "\t\t\t" + "R7.00";
		}
		if(chkSausage.isSelected()) {
			info = info + "\n\t" + chkSausage.getText() + "\t\t\t" + "R5.00";
		}
		if(ckhBBQ.isSelected()) {
			info = info + "\n\t" + ckhBBQ.getText() + "\t\t" + "R10.00";
		}
		if(chkPeriperi.isSelected()) {
			info = info + "\n\t" + chkPeriperi.getText() + "\t\t" + "R11.00";
		}
		
		return info;
	}
	
	public String getSizeOfPizza() {
		String size = "";
		
		if(rdoSmall.isSelected()) {
			size = rdoSmall.getText();
		}else if(rdoMedium.isSelected()) {
			size = rdoMedium.getText();
		}else {
			size = rdoLarge.getText();
		}
		
		return size;
	}
	
	public double getPriceOfPizza() {
		double pizzaPrice = 0.00;
		
		if(rdoSmall.isSelected()) {
			pizzaPrice = Double.parseDouble(txtSmall.getText());
		}else if(rdoMedium.isSelected()) {
			pizzaPrice = Double.parseDouble(txtMedium.getText());
		}else {
			pizzaPrice = Double.parseDouble(txtLarge.getText());
		}
		
		return pizzaPrice;
	}
	
	public String serviceMethod() {
		String service = "" ;
		
		if(rdoDineIn.isSelected()) {
			service = rdoDineIn.getText();
		}else if(rdoTakeOut.isSelected()) {
			service = rdoTakeOut.getText();
		}else {
			service = rdoDelivery.getText()+"\t R50,00";
		}
		//txtArea.setText("\nFLAVOR: " + cboBox.getValue() +"\nSIZE \t"+getSizeOfPizza() + "\nPRICE \t" + getPriceOfPizza());
		return service;
	}
	
	public double serviceFee() {
		double serviceFee = 0.00;
		
		if(rdoDineIn.isSelected()) {
			serviceFee =0.00;
		}else if(rdoTakeOut.isSelected()) {
			serviceFee= 0.00;
		}else {
			serviceFee = 50.00;
		}
		return serviceFee;
	}
	
	public double subTotal() {
		double subTotal=0;
		
		subTotal = addMorePrice() + getPriceOfPizza() ;
		
		return subTotal;
	}
	
	public void incrementButton(ActionEvent event) {
		qty++;
			
		txtQuantity.setText(String.valueOf(qty));
	}
	
	public void decrementButton(ActionEvent event) {
		qty--;
			
		txtQuantity.setText(String.valueOf(qty));
	}
	
	public void orderAgain(ActionEvent event) {
		txtArea.setText(null);
	}
	
	public void makePayment(ActionEvent event) throws IOException {
		
		Pane root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root,900,900);
		stage.setScene(scene);
		stage.setTitle("PIZZA ORDER");
		stage.show();
	}
	public int getnumber() {
		int quantity= Integer.parseInt(txtQuantity.getText());
		
		return quantity;
	}
	public double getTotal() {
		double totalPrice;
		
		totalPrice =  subTotal() * getnumber()+ serviceFee();
		
		return totalPrice;
	}
	public void showOrderDetail(ActionEvent event) {
		DecimalFormat df = new DecimalFormat("0.00");
		
		txtArea.setText("\n" +
						"\t\t\t\t CUSTOMER ORDER" + "\n" +
						"**************************************************************\n" +
						"Flavour\t\t\t\t" + cboBox.getValue() + "\n" +
						"Size \t\t\t\t" + getSizeOfPizza() + "\n" +
						"Price \t\t\t\tR" +df.format( getPriceOfPizza()) + "\n" +
						"Extras\t" + addOnsInfo() + "\n" +
						"Service \t\t\t\t" + serviceMethod() + "\n" +
						"Quantity \t\t\t\t" + getnumber() + "\n" +
						"*************************************************************\n\n" +
						"Total price:\t\t\tR" + df.format(getTotal()));
	}

}