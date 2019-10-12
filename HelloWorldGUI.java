import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.text.Font;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;

import java.util.Optional;

public class HelloWorldGUI extends Application{

	public static void main( String[] args ){
		launch( args );
	}
	
	String default_msg = "Hello World!";
	String message = default_msg;
		
	public void start( Stage primaryStage ){
		
		primaryStage.setTitle( "Hello World!" );
		Label lbl = new Label( default_msg );
		lbl.setMinWidth( 400 );
		lbl.setMinHeight( 200 );
		lbl.setAlignment( Pos.CENTER );
		
		lbl.setFont( Font.font( "Arial", 24 ) );
		
		Button upperCase = new Button( "Uppercase" );
		upperCase.setPrefWidth( 200 );
		upperCase.setPrefHeight( 100 );
		Button lowerCase = new Button( "Lowercase" );
		lowerCase.setPrefWidth( 200 );
		lowerCase.setPrefHeight( 100 );
		Button newBtn = new Button( "New Phrase" );
		newBtn.setPrefWidth( 200 );
		newBtn.setPrefHeight( 100 );
		Button resetBtn = new Button( "Reset" );
		resetBtn.setPrefWidth( 200 );
		resetBtn.setPrefHeight( 100 );

		upperCase.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent e ){
					lbl.setText( message.toUpperCase() );
				}
			}
		);

		lowerCase.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent e ){
					lbl.setText( message.toLowerCase() );
				}
			}
		);
		
		newBtn.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent e ){
					TextInputDialog t = new TextInputDialog( message );
					t.setTitle( "New Phrase" );
					t.setHeaderText( "Enter a new phrase to be displayed" );
					t.setContentText( "Please enter your phrase here" );
					Optional< String > response = t.showAndWait();
					message = response.get();
					lbl.setText( message );
				}
			}
		);

		resetBtn.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent e ){
					lbl.setText( default_msg );
				}
			}
		);
			
		GridPane root = new GridPane();
		root.setGridLinesVisible( false );
		root.setHgap( 10 );
		root.setVgap( 10 );
		root.setPadding( new Insets( 10, 20, 30, 40 ) );
	
		root.add( lbl, 0, 0, 2, 1 );
		root.add( upperCase, 0, 1 );
		root.add( lowerCase, 1, 1 );
		root.add( newBtn, 0, 2 );
		root.add( resetBtn, 1, 2 );
		
		Scene primaryScene = new Scene( root, 500, 400 );
		primaryStage.setScene( primaryScene );
		primaryStage.show();
		
	}
	
}


