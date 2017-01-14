import javafx.application.Application;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;

public class Rigid extends Application{
int height = 260;
int width = 515;
static Controller creationControl;
static TextField URL = new TextField();
static TextField Name = new TextField();
static TextField DirecLoc = new TextField();
	public static void main(String[] args) {
	Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		creationControl = new Controller(stage);
		pane.getChildren().addAll(createHeader(),createContrast(),createInformation(),createFields(),createButton());
		Scene scene = new Scene(pane,width,height,Color.DARKGRAY);
		stage.setScene(scene);
		stage.setTitle("Rigid");
		stage.show();
	}
	private VBox createFields()
	{
		FileInputStream input = null;
		try {
			input = new FileInputStream("Icons/folder.png");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Image folderIcon = new Image(input);
		ImageView folderIconView = new ImageView(folderIcon);
		VBox container = new VBox(20);
		
		
		URL.setMinSize(300,20);
		Name.setMinSize(300,20);
		DirecLoc.setMinSize(300, 20);
		
		
		Button btnDirec = new Button("",folderIconView);
		btnDirec.setStyle("-fx-background-color: #007aff;");
		HBox DirecBox = new HBox(5);
		btnDirec.setOnAction(creationControl);
		DirecBox.getChildren().addAll(DirecLoc,btnDirec);
		container.getChildren().addAll(URL,Name,DirecBox);
	
		container.setLayoutX(135);
		container.setLayoutY(80);
		return container;
	}
	private VBox createInformation()
	{
		VBox container = new VBox(30);
		Label lblurl = new Label("URL:");
		lblurl.setTextFill(Color.BLACK);
		Label lblname = new Label("Name:");
		lblname.setTextFill(Color.BLACK);
		Label lbldirec = new Label("Directory:");
		lbldirec.setTextFill(Color.BLACK);
		container.setAlignment(Pos.CENTER_RIGHT);
		container.setLayoutY(85);
		container.setLayoutX(55);
		container.getChildren().addAll(lblurl,lblname,lbldirec);
		return container;
		
	}
	private Button createButton()
	{
		Button btnCreate= new Button("Create");
		btnCreate.setStyle("-fx-background-color: #007aff;");
		btnCreate.setTextFill(Color.WHITE);
		btnCreate.setLayoutX(415);
		btnCreate.setLayoutY(210);
		return btnCreate;
		
	}
	private Rectangle createContrast()
	{
		Rectangle lightBG = new Rectangle();
		lightBG.setFill(Color.LIGHTGREY);
		lightBG.setStroke(Color.TRANSPARENT);
		lightBG.setX(30);
		lightBG.setY(50);
		lightBG.setWidth(7*width/8+20);
		lightBG.setHeight(3*height/4+5);
		lightBG.setArcWidth(20);
		lightBG.setArcHeight(20);
		
		return lightBG;
	}
	private Label createHeader()
	{
		Label head = new Label("Create a Rigid app");
		head.setTextFill(Color.BLACK);
		head.setLayoutX(30);
		head.setTranslateY(20);
		return head;
	}
	
	

}
