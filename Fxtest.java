import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Fxtest extends Application{
	
	Label l1;
	Label l2;
	TextField tf1;
	Button b1;
	ComboBox<String> cb1;
	FlowPane fp;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage)throws Exception{
		
		Label l1 = new Label("This is JavaFX!");
		Label l2 = new Label("îN");
		tf1 = new TextField();
		ObservableList<String> data = FXCollections.observableArrayList(
                "ïΩê¨","è∫òa","ëÂê≥"
        );
		cb1 = new ComboBox<String>(data);
		b1 = new Button("Click!");
		b1.setOnAction((ActionEvent)->{
			String msg = waseiTrans(tf1.getText());
			l1.setText(msg);
		});
		
		FlowPane fp = new FlowPane();
		fp.getChildren().add(cb1);
		fp.getChildren().add(tf1);
		fp.getChildren().add(l2);
		BorderPane pane = new BorderPane();
		pane.setTop(l1);
		pane.setCenter(fp);
		pane.setBottom(b1);
		Scene scene = new Scene(pane,320,120);
		stage.setScene(scene);
		stage.show();
	}
	
	public String waseiTrans(String input){
		int wareki = Integer.parseInt(input);
		int seireki = 0;
		switch(cb1.getValue()){
		case "ïΩê¨":
			if(wareki<28){
				seireki = wareki + 1988;
			}else{
				return "ä‘à·Ç¡ÇΩêîéöÇ≈Ç∑";
			}
			break;
		case "è∫òa":
			if(wareki<65){
				seireki = wareki + 1925;
			}else{
				return "ä‘à·Ç¡ÇΩêîéöÇ≈Ç∑";
			}
			break;
		case "ëÂê≥":
			if(wareki<16){
				seireki = wareki + 1911;
			}else{
				return "ä‘à·Ç¡ÇΩì¸óÕÇ≈Ç∑";
			}
			break;
		}
		return "êºóÔ"+String.valueOf(seireki)+"îN";
	}
}