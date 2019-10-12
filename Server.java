import java.io.*;
import java.net.*;
import java.util.*;

public class Server{

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket theServer;
	private Socket connection;
	
	public static void main( String[] args ){
		Server s = new Server();
		s.runServer();
		
		try(
			FileReader fr = new FileReader( "item.csv" );
			BufferedReader br = new BufferedReader( fr );			
		){
			
		}catch( IOException e ){
			e.printStackTrace();
		}
		
	}

	public void runServer(){
		try{
			theServer = new ServerSocket( 12345, 100 );
			while( true ){
				try{
					waitForConnection();
					getStream();
					processConnection();
				}catch( EOFException eof ){
					System.out.println( "Server terminiated connection" );
				}finally{
					closeConnection();
				}
			}
		}catch( IOException e ){
			e.printStackTrace();
		}
	}
	
	private void waitForConnection() throws IOException{
		System.out.println( "Waiting for connection" );
		connection = theServer.accept();
		System.out.println( "Connection received from " + connection.getInetAddress().getHostName() );
	}
	
	private void getStream() throws IOException{
		output = new ObjectOutputStream( connection.getOutputStream() );
		output.flush();
		input = new ObjectInputStream( connection.getInputStream() );
		System.out.println( "Got input stream" );
	}
	
	private void processConnection() throws IOException{
		String message = "";
		System.out.println( "Connection Successful" );
		do{
			try{
				message = (String)input.readObject();
				System.out.println( "Client sent: " + message + "\n" );
				sendData( message );
			}catch( ClassNotFoundException e ){
				e.printStackTrace();
			}
		}while( !message.trim().equals( "quit" ) );
	}
	
	private void sendData( String message ){
		//Takes Client data and returns Quantity depending on input
		if( message.startsWith( "ab" ) ){
			message = Item.getQuantity( Apple );
		}else if( message.startsWith( "or" ) ){
			message = Item.getQuantity( Orange );
		}else if( message.startsWith( "kw" ) ){
			message = Item.getQuantity( Kiwi );
		}else if( message.startsWith( "bn" ) ){
			message = Item.getQuantity( Banana );
		}else if( message.startsWith( "ph" ) ){
			message = Item.getQuantity( Peach );
		}else if( message.startsWith( "sb" ) ){
			message = Item.getQuantity( Strawberry );
		}else if( message.startsWith( "ch" ) ){
			message = Item.getQuantity( Cherry );
		}else if( message.startsWith( "bb" ) ){
			message = Item.getQuantity( Blueberry );
		}else if( message.startsWith( "gp" ) ){
			message = Item.getQuantity( Grape );
		}else if( message.startsWith( "wm" ) ){
			message = Item.getQuantity( Watermelon );
		}else{
			//Handles invalid inputs
			System.out.println( "Please enter a valid ID" );
		}
		System.out.println( "Server is about to send: " + message );
		try{
			output.writeObject( message );
			output.flush();
		}catch( IOException e ){
			System.out.println( "Error writing string" );
		}
	}
	
	public void closeConnection(){
		System.out.println( "Stopping connection" );
		try{
			output.close();
			input.close();
			connection.close();
		}catch( IOException e ){
			e.printStackTrace();
		}
	}
	
	private void readClient() throws IOException{
	
	}
}

	













