import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.text.Font;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.event.*;
import javafx.geometry.*;

import java.util.Optional;
import java.util.Random;
import java.util.ArrayList;

public class PasswordRandomizer extends Application{

	public static void main( String[] args ){
		launch( args );
	}
	//Instantiates Labels, Radio Buttons, Check Boxes, and Textfield
	int length;
		
	private RadioButton eight; 
	private RadioButton sixteen; 
	private RadioButton thirtyTwo; 
	
	private CheckBox caps; 
	private CheckBox special_chars; 
	private CheckBox num; 
	
	private TextField tf; 
	
	ToggleGroup tg = new ToggleGroup();
	
	//Defines the parameters that the Checkboxes control
	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = "abcdefghijklmnopqrstuzwxyz";
    public static final String digits = "0123456789";
    public static final String special = "!@#$%&";
	
	String parameters = lower;

	public void start( Stage primaryStage ){
		
		//Sets up the stage and all its parts
		primaryStage.setTitle( "Password Randomizer" );
		Label lbl = new Label( "This program creates a random password based set parameters." );
		lbl.setMinWidth( 400 );
		lbl.setMinHeight( 200 );
		lbl.setAlignment( Pos.CENTER );
				
		tf = new TextField();
		tf.setMinWidth( 200 );
		tf.setMinHeight( 100 );
		tf.setAlignment( Pos.CENTER );

		tf.setPromptText( "Gives you a random password" );
		tf.setPrefColumnCount( 15 );
				
		eight = new RadioButton( "8 characters" );
		sixteen = new RadioButton( "16 characters" );
		thirtyTwo = new RadioButton( "32 characters" );
		
		caps = new CheckBox( "Use Caps" );
		special_chars = new CheckBox( "Use Special Characters" );
		num = new CheckBox( "Use Numbers" );
		
		Button generate = new Button( "Generate" );
		generate.setMinWidth( 200 );
		generate.setMinHeight( 50 );
		generate.setAlignment( Pos.CENTER );

		eight.setToggleGroup( tg );
		sixteen.setToggleGroup( tg );
		thirtyTwo.setToggleGroup( tg );
		
		eight.setSelected( true );
		sixteen.setSelected( false );
		thirtyTwo.setSelected( false );
		
		caps.setSelected( false );
		special_chars.setSelected( false );
		num.setSelected( false );
		
		Random r = new Random( length );

		
		eight.setOnAction( new EventHandler< ActionEvent >(){
			public void handle( ActionEvent ae ){
				if( eight.isSelected() ){
					length = 8;
				}else{
				}
			}
			
		});
		
		sixteen.setOnAction( new EventHandler< ActionEvent >(){
			public void handle( ActionEvent ae ){
				if( sixteen.isSelected() ){
					length = 16;
				}else{
				}
			}
			
		});
		
		thirtyTwo.setOnAction( new EventHandler< ActionEvent >(){
			public void handle( ActionEvent ae ){
				if( thirtyTwo.isSelected() ){
					length = 32;
				}else{
				}
			}
			
		});
		
		caps.setOnAction( new EventHandler< ActionEvent >(){
			public void handle( ActionEvent ae ){
				if( caps.isSelected() ){
					parameters = parameters + upper;
				}else{
				}
			}
			
		});
		
		special_chars.setOnAction( new EventHandler< ActionEvent >(){
			public void handle( ActionEvent ae ){
				if( special_chars.isSelected() ){
					parameters = parameters + special;
				}else{
				}
			}
			
		});
		
		num.setOnAction( new EventHandler< ActionEvent >(){
			public void handle( ActionEvent ae ){
				if( num.isSelected() ){
					parameters = parameters + num;
				}else{
				}
			}
			
		});

		generate.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent e ){
					char[] password = new char[ length ];
 
					for ( int i = 0; i < length; i++ ){
						password[i] =
						parameters.charAt(r.nextInt(parameters.length())); 
		}
					tf.setText( "Password is: " + password );
				}
			}
		);
		
		//Controls the layout
		GridPane root = new GridPane();
		root.setGridLinesVisible( false );
		root.setHgap( 10 );
		root.setVgap( 10 );
		root.setPadding( new Insets( 10, 20, 30, 40 ) );
	
		root.add( lbl, 0, 0, 2, 1 );
		root.add( generate, 0, 1, 2, 1 );
		root.add( eight, 0, 2 );
		root.add( sixteen, 1, 2);
		root.add( thirtyTwo, 0, 3 );
		root.add( caps, 1, 3 );
		root.add( num, 0, 4 );
		root.add( special_chars, 1, 4 );
		root.add( tf, 0, 5, 2, 1 );

		Scene primaryScene = new Scene( root, 500, 500 );
		primaryStage.setScene( primaryScene );
		primaryStage.show();
		
	}
	
}



