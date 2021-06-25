package application;

import java.io.IOException;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import application.Total;

public class PaymentController extends Total{
	
	@FXML
    private CheckBox chkCash;

    @FXML
    private CheckBox chkCard;

    @FXML
    private TextField txtCash;
    

    @FXML
    private TextField txtCardNo;

    @FXML
    private TextField txtCVV;

    @FXML
    private TextField txtDate;

    @FXML
    private TextArea areaPaymentDetail;
    
    @FXML
    private TextField txtAmountOfCard;
    
    @FXML
    private Button btnPayent;
    
    @FXML
    private TextArea areaPayableAmount;
    
    @FXML
    private Button btnGoBack;
    
    
   // @Override
//    public double getTotal(){
    	//double totalPrice;
		
		//totalPrice =  subTotal() * getnumber()+ serviceFee();
		
		//return totalPrice;
//    }
   // SampleController sc = new SampleController("");
    
    public void displayareaPayableAmount() {
    	areaPayableAmount.setText("Amount to be paid: R"+getTotal());
    }
    public double getTotal() {
    	double totalPrice;
		
		totalPrice =  subTotal() * getnumber()+ serviceFee();
		
		return totalPrice;
    }
    
    protected void areaPayableAmount() {
    	DecimalFormat df =new DecimalFormat("0.00");
    			
    	areaPayableAmount.setText("R"+df.format(getTotal()));
	}
    
	public String typeOfPayment() {
    	String info = "";
    	
    	if(chkCash.isSelected() && chkCard.isSelected()) {
    		info =info +  chkCash.getText()+"\n\t\t\t\t\t\t\t";
    		info =info+ chkCard.getText()+"\n\t\t\t\t\t\t\t";
    	}else {
	    	if(chkCash.isSelected()) {
	    		info =info +  chkCash.getText()+"\n\t\t\t\t\t\t\t";
	    	}
	    	if(chkCard.isSelected()) {
	    		info =info+ chkCard.getText()+"\n\t\t\t\t\t\t\t";
	    	}
	    }
		return info;
    }
    
    public String amountPaid() {
    	String info = "";
    	
    	if(chkCash.isSelected() && chkCard.isSelected()) {
    		info =info + "R"+  txtCash.getText()+"\n\t\t\t\t\t\t\t";
    		info =info+ "R"+ txtAmountOfCard.getText()+"\n\t\t\t\t\t\t\t";
    	}else if(chkCash.isSelected()) {
	    	info =info + "R"+ txtCash.getText()+"\n\t\t\t\t\t\t\t";
	    }else {
	    	info =info+"R"+  txtAmountOfCard.getText()+"\n\t\t\t\t\t\t\t";
	    }
		return info;
    }
    
    public void makePayment() {
    	
    	if(chkCash.isSelected()) {
    		txtCash.getText();
    	}
    	if(chkCard.isSelected()) {
    		txtAmountOfCard.getText();
    	}
    }
    
    public double addAmount() {
    	double paidAmount;
    	
    	return paidAmount = Double.parseDouble(txtCash.getText()) + Double.parseDouble(txtAmountOfCard.getText());
    }
    
    public void submitPayment(ActionEvent event) {
    	DecimalFormat df =new DecimalFormat("0.00");
    	
    	areaPaymentDetail.setText("Payment method made: \t\t\t" +typeOfPayment() +"\nAmount: \t\t\t\t\t\t" +amountPaid() +"\nTotal amount:\t\t\t\t\tR"+df.format(addAmount())+"\n"+ serviceFee() );
    }
	@Override
	protected int serviceFee() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	protected int subTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	protected int getnumber() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void goBack(ActionEvent event) throws IOException {
		
		Pane root = FXMLLoader.load(getClass().getResource("za/ac/tut/buywindow/buyWindowLayout.fxml"));
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root,900,900);
		stage.setScene(scene);
		stage.setTitle("PIZZA ORDER");
		stage.show();
	}
}






























































