package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreateAccountController implements Initializable{

	@FXML private Label addtional;
	@FXML private Button Back;
	@FXML private Button addItem;
	@FXML private Button Submit;
	@FXML private Button Delete;
	@FXML private Button Add;
	@FXML private Button Addname;
	@FXML private Button Item;
	@FXML private TableView<Party> table;
	@FXML private TableColumn<Party, String> Titlename;
	@FXML private TableColumn<Party, String> firstname;
	@FXML private TableColumn<Party, String> lastname;
	@FXML private TextField Gfirst ;
	@FXML private TextField  Gmiddle;
	@FXML private TextField  Glast;
	@FXML private TextField  Bfirst;
	@FXML private TextField  Bmiddle;
	@FXML private TextField  Blast;
	@FXML private TextField  Cnumber;
	@FXML private TextField  CAnumber;
	@FXML private TextField  Email;
	@FXML private TextField  Ceremony;
	@FXML private TextField  Cfirst;
	@FXML private TextField  Clast;
	@FXML private TextField  Cstart;
	@FXML private TextField  Cend;
	@FXML private TextField  Caddress1;
	@FXML private TextField  Caddress2;
	@FXML private TextField  Ccity;
	@FXML private TextField  Cstate;
	@FXML private TextField  Czip;
	@FXML private TextField  CCnumber;
	@FXML private TextField  Reception;
	@FXML private TextField  Rfirst;
	@FXML private TextField  Rlast;
	@FXML private TextField  Rstart;
	@FXML private TextField  Rend;
	@FXML private TextField  Raddress1;
	@FXML private TextField  Raddress2;
	@FXML private TextField  Rcity;
	@FXML private TextField  Rstate;
	@FXML private TextField  Rzip;
	@FXML private TextField  RCnumber;
	@FXML private TextField  BFflower;
	@FXML private TextField GFflower ;
	@FXML private TextField  Wflower;
	@FXML private TextField  NumberHonor;
	@FXML private TextField  NumberBestmen;
	@FXML private TextField  NumberMaids;
	@FXML private TextField  NumberGrooms;
	@FXML private TextField  NumberGuest;
	@FXML private TextField  Tsize;
	@FXML private TextField  NumberGtable;
	@FXML private TextField ptitle;
	@FXML private TextField Pfirst;
	@FXML private TextField Plast;
	@FXML private TextField itemChairCover;
	@FXML private TextField itemSashe;
	@FXML private TextField itemCover_Sashe;
	@FXML private TextField itemTableRun;
	@FXML private TextField itemTableLin;
	@FXML private TextField itemTallCenter;
	@FXML private TextField itemSmallVase;
	@FXML private TextField itemRoseRunner;
	@FXML private TextField itemRoseSkirt;
	@FXML private TextField itemLaceCloth;
	@FXML private TextField itemTableSkirt;
	@FXML private TextField itemPillars;
	@FXML private TextField itemGlassVase;
	@FXML private TextField itemGuest;
	@FXML private TextArea special;
	@FXML private DatePicker weddingDate;
	@FXML private CheckBox yes;
	@FXML private CheckBox Romantic;
	@FXML private CheckBox Soft;
	@FXML private CheckBox Simple;
	@FXML private CheckBox Casual;
	@FXML private CheckBox Formal;
	@FXML private CheckBox Extravagant;
	@FXML private CheckBox Traditional;
	@FXML private CheckBox item1;
	@FXML private CheckBox item2;
	@FXML private CheckBox item3;
	@FXML private CheckBox item4;
	@FXML private CheckBox item5;
	@FXML private CheckBox item6;
	@FXML private CheckBox item7;
	@FXML private CheckBox item8;
	@FXML private CheckBox item9;
	@FXML private CheckBox item10;
	@FXML private CheckBox item11;
	@FXML private CheckBox item12;
	@FXML private CheckBox item13;
	@FXML private ColorPicker color1;
	@FXML private ColorPicker color2;
	@FXML private ColorPicker AccentColor;
	@FXML private ChoiceBox<String> weddingPackages;
	@FXML private ChoiceBox<?> title;
	
	
	//create table data
	@FXML
	 final ObservableList<Party> data = FXCollections.observableArrayList(
			new Party("BestMan","John","Jackson")
	);
	
	// create List for choice box packages
	@FXML
	 final ObservableList<String> weddingPackageList = FXCollections.observableArrayList
	 		("Package 1","Package 2","Package 3","Package 4");
	
	// index for delete item
	@FXML
	private IntegerProperty index = new SimpleIntegerProperty();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		index.set(-1); //updates the table after deleting selecting row
		
		Titlename.setCellValueFactory(new PropertyValueFactory<Party, String>("Title"));
		firstname.setCellValueFactory(new PropertyValueFactory<Party, String>("firstname"));
		lastname.setCellValueFactory(new PropertyValueFactory<Party, String>("lastname"));
		
		//adds names to arraylist data
		table.setItems(data);
		
		// listens for changes in table
		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>(){
		
		//updates the data arraylist
		public void changed(ObservableValue<?>obserable,Object oldValue, Object newValue){
				index.set(data.indexOf(newValue));
			}});
		
		// adds packages to select package choicebox
		weddingPackages.setItems(weddingPackageList);
		weddingPackages.setValue(" ");
		
		}
	
	//
	@FXML
	public void onAddItem(ActionEvent event){
		
		//updates the table when data is added
		Party entry = new Party(ptitle.getText(),Pfirst.getText(),Plast.getText());
		
		//add data to table
		data.add(entry);
		
		// clear the textfields
		clearForm();
	}
	
	// removes selected row with the delete button
	@FXML
	public void onDeleteItem(ActionEvent event)throws IOException{
		
		int i = index.get();
		if(i > -1){
			data.remove(i);
			table.getSelectionModel().clearSelection();
		}
		
	}
	
	// clears the text fields after data is added to table
	public void clearForm()
	{
		ptitle.clear();
		Pfirst.clear();
		Plast.clear();
	}
	
	// adds ceremony information to reception fields
	@FXML
	public void samePlace(ActionEvent event) throws IOException
	{
		//if yes check box in selected adds information to reception fields
		if (yes.isSelected())
		{
			// gets ceremony text fields text and set them to reception text fields
			String make = Ceremony.getText();
			Reception.setPromptText(make);
		}
	}
	
	// selecting additional items
	@FXML
	public void selectItems(ActionEvent event) throws IOException
	{
		// Array List for Items to be added
		ArrayList<Double> ItemList = new ArrayList<>();
		
		Double sum = null;
		String grandtotal;
		
	// if Chair covers $2.50 is selected
	if(item1.isSelected())
	{
		double total;
		String text = itemChairCover.getText(); // gets input from text field
	    double qty = Double.parseDouble(text); // changes string to double
	
	    total = qty * 2.5;
	 		
	    ItemList.add(total); // adds total to Item List
	}
	
	// if Sashes  $1.50 is selected 
	if(item2.isSelected())
	{
		double total2;
	
		String text2 = itemSashe.getText();
		double qty2 = Double.parseDouble(text2);
	
		total2 = qty2 * 1.5;
	 		
		ItemList.add(total2);
	}
	
	// if Chair covers and sashes $ 3.50 is selected
	if(item3.isSelected())
	{
		double total3;
	
		String text3 = itemCover_Sashe.getText();
		double qty3 = Double.parseDouble(text3);
	
		total3 = qty3 * 3.5;
	 		
		ItemList.add(total3);
	}
	
	// if Table runners $ 3.50 is selected
	if(item4.isSelected())
	{
		double total4;
	
		String text4 = itemTableRun.getText();
		double qty4 = Double.parseDouble(text4);
	
		total4 = qty4 * 3.5;
	 		
		ItemList.add(total4);
	}
	
	// if Table linen $10.00 is selected
	if(item5.isSelected())
	{
		double total5;
	
		String text5 = itemTableLin.getText();
		double qty5 = Double.parseDouble(text5);
	
		total5 = qty5 * 10;
	 		
		ItemList.add(total5);
	}
	
	// if 24� Tall centerpieces $ 5.00 is selected
	if(item6.isSelected()) 
	{
		double total6;
	
		String text6 = itemTallCenter.getText();
		double qty6 = Double.parseDouble(text6);
	
		total6 = qty6 * 5;
	 		
		ItemList.add(total6);
	}
	
	// if Small vases $ 3.00 is selected
	if(item7.isSelected())
	{
		double total7;
	
		String text7 = itemSmallVase.getText();
		double qty7 = Double.parseDouble(text7);
	
		total7 = qty7 * 3;
	 		
		ItemList.add(total7);
	}
	
	// if Rosette table runners $ 8.00 is selected
	if(item8.isSelected())
	{
		double total8;
		
		String text8 = itemRoseRunner.getText();
		double qty8 = Double.parseDouble(text8);
	
		total8 = qty8 * 8;
	 		
		ItemList.add(total8);
	}
	
	// if Rosette table skirts $20.00 is selected
	if(item9.isSelected())
	{
		double total9;
	
		String text9 = itemRoseSkirt.getText();
		double qty9 = Double.parseDouble(text9);
	
		total9 = qty9 * 20;
	 		
		ItemList.add(total9);
	}
	
	// if Lace table clothes for the bride $25.00 is selected
	if(item10.isSelected())
	{
		double total10;
	
		String text10 = itemLaceCloth.getText();
		double qty10 = Double.parseDouble(text10);
	
		total10 = qty10 * 25;
	 		
		ItemList.add(total10);
	}
	
	// if Table skirts $ 7.50 is selected
	if(item11.isSelected())
	{
		double total11;
	
		String text11 = itemTableSkirt.getText();
		double qty11 = Double.parseDouble(text11);
	
		total11 = qty11 * 7.5;
	 		
		ItemList.add(total11);
	}
	
	// if Pillars $ 10.00 is selected
	if(item12.isSelected())
	{
		double total12;
	
		String text12 = itemPillars.getText();
		double qty12 = Double.parseDouble(text12);
	
		total12 = qty12 * 10;
	 		
		ItemList.add(total12);
	}
	
	// if Glass Vase $12.00 is selected
	if(item13.isSelected())
	{
		double total13;
	
		String text13 = itemGlassVase.getText();
		double qty13 = Double.parseDouble(text13);
	
		total13 = qty13 * 12;
	 		
		ItemList.add(total13);
	}
	
	// adds all items in the item list
	for (int i = 0; i < ItemList.size();i++)
	{
		sum = sum +ItemList.get(i);
	}
   grandtotal = Double.toString(sum); // changes items in ItemList to strings

   //ItemList.setText(grandtotal); // displays the total

	}
	
	// goes to the main menu on button click
	@FXML
	private void goHome() throws IOException{
		
		Main.showMenu();
	}
	
	// goes to item select on button click
	@FXML
	private void showItems() throws IOException{
		
		
		Main.showAdd();
		
	}
}