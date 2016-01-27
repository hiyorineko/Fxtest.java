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
		fc.setTitle("�t�@�C���I���_�C�A���O");
		fc.getExtensionFilters().addAll(
			new ExtensionFilter("All Files","*.*"),
			new ExtensionFilter("Text Files","*.txt"),
			new ExtensionFilter( "Image Files", "*.png", "*.jpg", "*.gif" ),
			new ExtensionFilter( "Audio Files", "*.wav", "*.mp3", "*.aac" )
		);
		f = fc.showOpenDialog(stage);
		
		DirectoryChooser dc = new DirectoryChooser();
		dc.setTitle("�f�B���N�g���I���_�C�A���O");
		f = dc.showDialog(stage);
		str = (f == null)? "�I���Ȃ�" : f.toURI().toString();
		output.add("�I�������f�B���N�g��" + str);
		
		primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		output.add("�f�B�X�v���C�T�C�Y�F"+primaryScreenBounds.getWidth() +"x" +primaryScreenBounds.getHeight() + "(px)" );
		output.add( "�f�B�X�v���C�𑜓x�F" + Screen.getPrimary().getDpi() + "dpi" );
		// �V�[���O���t���쐬
        Group root      = new Group();
        root.getChildren().add( new Label( String.join( "\n" , output ) ) );
         
        // �V�[�����쐬
        Scene scene     = new Scene( root,
                                     primaryScreenBounds.getWidth(),
                                     primaryScreenBounds.getHeight(),
                                     Color.WHITE );
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
	}
}