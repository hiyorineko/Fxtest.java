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
		Label l2 = new Label("�N");
		tf1 = new TextField();
		ObservableList<String> data = FXCollections.observableArrayList(
                "����","����","���a","�吳"
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
		case "����":
			if(wareki>1988 && wareki<2017){
				if(wareki ==1989){
					return "�������N ���a64�N";
				}
				int heisei = wareki-1988;
				return "����"+heisei+"�N";
			}else if(wareki>1925 && wareki<1989){
				if(wareki == 1926){
					return "���a���N �吳15�N";
				}
				int showa = wareki - 1925;
				return "���a"+showa+"�N";
			}else if(wareki>1911 && wareki<1927){
				if(wareki == 1912){
					return "�吳���N";
				}
				int taisho = wareki - 1911;
				return "�吳"+taisho+"�N";
			}else{
				return "�吳�`�����̊Ԃœ��͂��Ă��������B";
			}
		case "����":
			if(wareki<28){
				seireki = wareki + 1988;
			}else{
				return "�Ԉ���������ł�";
			}
			break;
		case "���a":
			if(wareki<65){
				seireki = wareki + 1925;
			}else{
				return "�Ԉ���������ł�";
			}
			break;
		case "�吳":
			if(wareki<16){
				seireki = wareki + 1911;
			}else{
				return "�Ԉ���������ł�";
			}
			break;
		}
		return "����"+String.valueOf(seireki)+"�N";
	}
}