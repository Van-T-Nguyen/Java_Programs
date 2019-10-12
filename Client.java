import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.concurrent.Task;
import javafx.scene.control.Label;


public class Client extends Application{

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String myServer;
	private Socket client;
	private String message = "";
	
	private TextField enterField;
	private Label displayArea;

	public static void main( String[] args ){
		launch( args );
	}
	
	public void start( Stage primaryStage ){
		
		enterField = new TextField( "Enter an Item ID here: " );
		displayArea = new Label();
		
		enterField.setOnAction(
			new EventHandler< ActionEvent >(){
				public void handle( ActionEvent ae ){
					Task t = new Task< Void >(){
						public Void call(){
							System.out.println( "Task top" );
							sendData( enterField.getText() );
							enterField.setText( "" );
							try{
								displayArea.setText( (String)input.readObject() + "\n" );
							}catch( IOException e ){
								e.printStackTrace();
							}catch( ClassNotFoundException e ){
								e.printStackTrace();
							}
							System.out.println( "Task bottom" );
							return null;
						}
					};
					new Thread( t ).start();
				}
			}
		);
		
		VBox root = new VBox();
		root.setPadding( new Insets( 10, 10, 10, 10 ) );
		root.getChildren().addAll( enterField, displayArea );
		primaryStage.setScene( new Scene( root, 220, 300 ) );
		primaryStage.show();
		
		myServer = "127.0.0.1";
		try{
			connectToServer();
			getStreams();
		}catch( EOFException e ){
			System.out.println( "Terminated connection" );
		}catch( IOException e ){
			e.printStackTrace();
		}
		
	}
	
	private void connectToServer() throws IOException{
		System.out.print( "Attempting to connect to server" );
		client = new Socket( InetAddress.getByName( myServer ), 12345 );
		System.out.println( "Connected to " + client.getInetAddress().getHostName() );
	}
	
	private void getStreams() throws IOException{
		input = new ObjectInputStream( client.getInputStream() );
		output = new ObjectOutputStream( client.getOutputStream() );
		output.flush();
		System.out.println( "Got IO Streams" );
	}
	
	private void closeConnection(){
		System.out.println( "Closing Connection" );
		try{
			input.close();
			output.close();
			client.close();
		}catch( IOException e ){
			e.printStackTrace();
		}
	}
	
	private void sendData( String message ){
		try{
			output.writeObject( message );
			output.flush();
		}catch( IOException e ){
			e.printStackTrace();
		}
	}
	
}


















