package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;

public class CartScreenController {
	private Cart cart;
	private boolean filterByID = true;
	private boolean sortByTitle = true;
	private FilteredList<Media> filteredCart; 
	
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, String> colMediaCost;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;
	
	@FXML
	private TextField tfFilter;
	
	@FXML
	private Label costLabel;
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
	
	@FXML
	public void initialize() {
		filteredCart = new FilteredList<Media>(this.cart.getItemsOrdered(), s -> true);
		
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));
		tblMedia.setItems(filteredCart);
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		costLabel.setText(String.valueOf(this.cart.totalCost()));
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {

					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}
					}	
				});
		
		tfFilter.textProperty().addListener(new ChangeListener<String> () {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
		
	}
	
	private void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}
	
	private void showFilteredMedia(String filter) {
		if (filter == null || filter.length() == 0) {
			filteredCart.setPredicate(s -> true);
		} else {
			if (filterByID) {
				try {
					filteredCart.setPredicate(s -> s.getID() == Integer.parseInt(filter));
				} catch (NumberFormatException e) {}
			} else {
				filteredCart.setPredicate(s -> s.getTitle().toLowerCase().contains(filter));
			}
		}
	}
	
	@FXML
	private void removeButtonPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		this.cart.removeMedia(media);
		costLabel.setText(String.valueOf(this.cart.totalCost()));
	}
	
	@FXML
	private void playButtonPressed(ActionEvent event) {
		Media media = this.tblMedia.getSelectionModel().getSelectedItem();
		try {
			((Playable)media).play();
		} catch (PlayerException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Media Player");
			alert.setHeaderText("ERROR: Media length is non-positive.");
			alert.setContentText("Media cannot be played.");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void placeOrderPressed(ActionEvent event) {	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		if (this.cart.getSize() > 0) {
			alert.setHeaderText("Your order has been placed.");
			this.cart.empty();
			costLabel.setText(String.valueOf(this.cart.totalCost()));
		} else {
			alert.setHeaderText("ERROR: Failed to place order.");
			alert.setContentText("Your cart is empty");
		}
		alert.showAndWait();
	}
	
	@FXML
	private void setFilterByID() {
		this.filterByID = true;
	}
	
	@FXML 
	private void setFilterByTitle() {
		this.filterByID = false;
	}
	
	@FXML
	private void sortBtnPressed() {
		if (sortByTitle) {
			this.cart.sortByTitle();
		} else {
			this.cart.sortByCost();
		}
	}
	
	@FXML
	private void setSortByTitle() {
		this.sortByTitle = true;
	}
	
	@FXML
	private void setSortByCost() {
		this.sortByTitle = false;
	}
}
