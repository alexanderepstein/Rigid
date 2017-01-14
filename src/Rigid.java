import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;

public class Rigid extends Application{
int height = 260;
int width = 515;
static Controller creationControl; //object that controls the create button
static TextField URL = new TextField();
static TextField Name = new TextField();
static TextField DirecLoc = new TextField();
Stage ms; 
	
public static void main(String[] args) {
	Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane(); //pane containing app
		creationControl = new Controller();
		pane.getChildren().addAll(createHeader(),createContrast(),createInformation(),createFields(),createButton()); //add components to pane
		Scene scene = new Scene(pane,width,height,Color.DARKGRAY); //create the scene 
		stage.setScene(scene);
		stage.setTitle("Rigid");
		ms = stage; // setting stage here to be referenced later
		stage.show();
	}
	
	
	private VBox createFields() //This function sets up the textboxes and the create directory button
	{
		FileInputStream input = null; // there is a better way to set the icon for a button but this will do for now
		try {
			input = new FileInputStream("Icons/folder.png");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Image folderIcon = new Image(input);
		ImageView folderIconView = new ImageView(folderIcon);
		VBox container = new VBox(20); // create the vertical box that will be result of function
		
		
		URL.setMinSize(300,20);
		Name.setMinSize(300,20);
		DirecLoc.setMinSize(300, 20);
		
		
		Button btnDirec = new Button("",folderIconView);
		btnDirec.setStyle("-fx-background-color: #007aff;");
		HBox DirecBox = new HBox(5);
		btnDirec.setOnAction(new EventHandler<ActionEvent>() { // when the directory button is clicked lambda function will occur
		    @Override public void handle(ActionEvent e) {
		    	File directory;
		    	String directoryPath = "";
		    	try //this try lets the user choose a directory from their system
				{
				DirectoryChooser Direc = new DirectoryChooser();
				Direc.setTitle("Choose where to store application");
				directory = Direc.showDialog(ms);
				directoryPath = directory.toString();
				Rigid.DirecLoc.setText(directoryPath); 
				}
				catch (Exception e1)
				{
					System.out.println("No directory chosen!");
				}
		    }
		});
		DirecBox.getChildren().addAll(DirecLoc,btnDirec); //the directory had an hbox to keep the textbox and button aligned
		container.getChildren().addAll(URL,Name,DirecBox); //adding all the components to the container
		container.setLayoutX(135); //some hardcoded alignment
		container.setLayoutY(80); //some hardcoded alignment
		return container;
	}
	private VBox createInformation() //This function creates the labels to inform the user what each box indicates
	{
		VBox container = new VBox(30); //create resultant container
		Label lblurl = new Label("URL:");
		lblurl.setTextFill(Color.BLACK);
		Label lblname = new Label("Name:");
		lblname.setTextFill(Color.BLACK);
		Label lbldirec = new Label("Directory:");
		lbldirec.setTextFill(Color.BLACK);
		container.setAlignment(Pos.CENTER_RIGHT);
		container.setLayoutY(85); //some hardcoded alignment
		container.setLayoutX(55); //some hardcoded alignment
		container.getChildren().addAll(lblurl,lblname,lbldirec); // adding all the labels to the container
		return container;
		
	}
	private Button createButton() //This function create the button which will create the application after the user inputs the required information
	{
		Button btnCreate= new Button("Create"); 
		btnCreate.setStyle("-fx-background-color: #007aff;");
		btnCreate.setTextFill(Color.WHITE);
		btnCreate.setLayoutX(415);
		btnCreate.setLayoutY(210);
		btnCreate.setOnAction(creationControl); //connect this button to the controller
		return btnCreate;
		
	}
	private Rectangle createContrast() //This helps create an overlay onto the background (modeled after fluid's U.I.)
	{
		Rectangle lightBG = new Rectangle();
		lightBG.setFill(Color.LIGHTGREY);
		lightBG.setStroke(Color.TRANSPARENT);
		lightBG.setX(30); //some hardcoded alignment
		lightBG.setY(50); //some hardcoded alignment
		lightBG.setWidth(7*width/8+20);
		lightBG.setHeight(3*height/4+5);
		lightBG.setArcWidth(20);
		lightBG.setArcHeight(20);
		
		return lightBG;
	}
	private Label createHeader() //This creates a simple header for the application (modeled after fluid's U.I.)
	{
		Label head = new Label("Create a Rigid app");
		head.setTextFill(Color.BLACK);
		head.setLayoutX(30); //some hardcoded alignment
		head.setTranslateY(20); //some hardcoded alignment
		return head;
	}
	
	

}
