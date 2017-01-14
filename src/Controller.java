import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
public class Controller implements EventHandler<ActionEvent>{
Stage stage;
File directory;
String directoryPath = "";
	public Controller(Stage inStage)
	{
		stage = inStage;
	}

	@Override
	public void handle(ActionEvent event) {
		try
		{
		DirectoryChooser Direc = new DirectoryChooser();
		Direc.setTitle("Choose where to store application");
		directory = Direc.showDialog(stage);
		directoryPath = directory.toString();
		Rigid.DirecLoc.setText(directoryPath);
		}
		catch (Exception e)
		{
			System.out.println("No directory chosen!");
		}
	}
	


}
