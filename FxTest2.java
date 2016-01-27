import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Screen;


import javafx.scene.layout.BorderPane;

public class FxTest2 extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage)throws Exception{
		
		List<String> output = new ArrayList<String>();
		Rectangle2D primaryScreenBounds = null;
		File f = null;
		String str = null;
		
		FileChooser fc = new FileChooser();
		fc.setTitle("ファイル選択ダイアログ");
		fc.getExtensionFilters().addAll(
			new ExtensionFilter("All Files","*.*"),
			new ExtensionFilter("Text Files","*.txt"),
			new ExtensionFilter( "Image Files", "*.png", "*.jpg", "*.gif" ),
			new ExtensionFilter( "Audio Files", "*.wav", "*.mp3", "*.aac" )
		);
		f = fc.showOpenDialog(stage);
		
		DirectoryChooser dc = new DirectoryChooser();
		dc.setTitle("ディレクトリ選択ダイアログ");
		f = dc.showDialog(stage);
		str = (f == null)? "選択なし" : f.toURI().toString();
		output.add("選択したディレクトリ" + str);
		
		primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		output.add("ディスプレイサイズ："+primaryScreenBounds.getWidth() +"x" +primaryScreenBounds.getHeight() + "(px)" );
		output.add( "ディスプレイ解像度：" + Screen.getPrimary().getDpi() + "dpi" );
		// シーングラフを作成
        Group root      = new Group();
        root.getChildren().add( new Label( String.join( "\n" , output ) ) );
         
        // シーンを作成
        Scene scene     = new Scene( root,
                                     primaryScreenBounds.getWidth(),
                                     primaryScreenBounds.getHeight(),
                                     Color.WHITE );
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
	}
}