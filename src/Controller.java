import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.scene.control.ButtonType;
public class Controller implements EventHandler<ActionEvent>{


	
	
	
	public void handle(ActionEvent event) { //this will fire when the create button is clicked on the U.I.

		if (!Rigid.URL.getText().equals("")){ //check if the url field is not empty
		if (!Rigid.Name.getText().equals("")){ //check if the name field is not empty
		if (!Rigid.DirecLoc.getText().equals("")){ //check if the specified directory field is not empty
		try(PrintWriter pw = new PrintWriter(new FileWriter(Rigid.DirecLoc.getText()+"/"+Rigid.Name.getText()+ ".bat"));) //try with resource will close once done this opens up a new batch file to write to
		{
			
			//below the python file is written (if still using this make sure file extension is .py not .bat
			/*pw.write(
					"from subprocess import call\n\n"
					
					+ "def main(): \n "	
					+ 		"\t call([\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe  \" , \" --new-window --app="+Rigid.URL.getText()+"\" ])\n\n"
					
					+ "if __name__ == '__main__':\n"
					+ 		"\t main()");*/
			pw.write("@ECHO OFF\ncd C:\\Program Files (x86)\\Google\\Chrome\\Application\\\n chrome --new-window --app=" + Rigid.URL.getText());
			pw.close();
			
			
			
			Alert alert = new Alert(AlertType.INFORMATION, "Successfully created application!"); //Let the user know that it worked
			alert.showAndWait().ifPresent(response -> {
			     if (response == ButtonType.OK) {
			    	 //clear the fields
			    	 Rigid.URL.setText("");
			    	 Rigid.Name.setText("");
			        alert.close();
			     }
			 });
			
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR, "There was an error in creating the application!"); //if any error occurred aware user
			alert.showAndWait().ifPresent(response -> {
			     if (response == ButtonType.OK) {
			        alert.close();
			     }});
			
		}
		
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR, "A directory must be specified!"); //alert user that they didn't specify directory
			alert.showAndWait().ifPresent(response -> {
			     if (response == ButtonType.OK) {
			        alert.close();
			     }});
		}
	}
	
	else
	{
		Alert alert = new Alert(AlertType.ERROR, "A name must be specified!"); ///alert user that they didn't specify name of app
		alert.showAndWait().ifPresent(response -> {
		     if (response == ButtonType.OK) {
		        alert.close();
		     }});
	}

	}
		else
		{
			Alert alert = new Alert(AlertType.ERROR, "A URL must be specified!");  //alert user that they didn't specify url 
			alert.showAndWait().ifPresent(response -> {
			     if (response == ButtonType.OK) {
			        alert.close();
			     }});
		}
	}
}
