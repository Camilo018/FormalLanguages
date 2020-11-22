package runner;


import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;


import javax.swing.*;

public class Runner {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( new FlatGradiantoMidnightBlueIJTheme() );

		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}
	}
}
