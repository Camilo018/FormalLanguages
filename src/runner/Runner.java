package runner;


import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import view.MainJPanel;


import view.MainView;

public class Runner {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( new FlatGradiantoMidnightBlueIJTheme() );
			new MainView();
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}
	}
}
