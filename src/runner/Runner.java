package runner;


import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import controller.Controller;

import javax.swing.*;

public class Runner {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( new FlatGradiantoMidnightBlueIJTheme() );
		new Controller();
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}
	}
}
