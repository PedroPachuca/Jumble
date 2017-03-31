

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JumbleFrame extends JFrame {
	String lang=null;// start off without a language
	
	// all the languages that have been loaded up.  Maybe only need
	// one LanguageMap at a time, but can change that later
	Set<LanguageMap> languageMaps = new HashSet<LanguageMap>();
	
	
	
	public JumbleFrame() {
		super("Let's solve the Jumble!");// title the bar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ALWAYS DO THIS
		addMenuBar();// just wanted to show you how to make a menu bar
		addSplashPanel();// start screen you can add your trademark images
		pack();// make sure the frame is just big enough to show all components
	}

	private void addSplashPanel() {
		// Things are typically added to the content pane
		// Opening Screen could include animations, etc.  
		// it is a type of JPanel
		this.getContentPane().add(new OpeningScreen());
	}

	private void addMenuBar() {
		// built-in Object that behaves like typical menu bar.  This behavior
		// could change based on the OS of the machine it is running on.
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		// this File menu is just like most applications have 
		JMenu fileMenu = new JMenu("File");
		jmb.add(fileMenu);
		// Menu Items are added to Menus which are on the MenuBar
		// You can add menu items to menu items...
		JMenuItem newPuzzle = new JMenuItem("New Jumble");
		// when the user selects the newPuzzle Menu Item, it tells 
		// everyone in its ActionListenerList to do their actionPerformed event
		// We know they all have actionPerformed, because they implement ActionListener
		// We know they implement ActionListener because they couldn't have been added to
		// the list unless they did...
		newPuzzle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// when someone clicks on the newPuzzle MenuItem this method is called
				if(lang==null) {// check to see if they have already loaded up a language
					JOptionPane.showMessageDialog(null, 
							"Select a language first!");
					return;
				}
				// here might be a good time to change the device
				// keyboard to match the language :)
				loadJumblePanel();
				
			}
			
		});
		fileMenu.add(newPuzzle);// adds to the File Menu
		
		// a menu for choosing the language of the puzzle
		JMenu languageMenu = new JMenu("Language");
		jmb.add(languageMenu);
		
		// menu for English
		JMenu englishMenu = new JMenu("English");
		
		// this adds a menu to a menu. Only do this if you want submenus
		languageMenu.add(englishMenu); 
		
		// now I'll make a menu item for a type of English
		JMenuItem kingsEnglishMenuItem = new JMenuItem("King's English");
		kingsEnglishMenuItem.addActionListener(new ActionListener() {
			// When user selects this menu Item (or any...) languageSelected is called
			@Override
			public void actionPerformed(ActionEvent arg0) {
				languageSelected("English");
			}
			
		});
		englishMenu.add(kingsEnglishMenuItem);
		
		// Made one for kings english, lets make one for Aussie
		JMenuItem aussieMenuItem = new JMenuItem("Australian!");
		aussieMenuItem.addActionListener(new ActionListener() {
			// When user selects this menu Item (or any...) languageSelected is called
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Crikey mate!  Haven't finished that yet... \nToo many shrimp on the barbie!"+
									"\nTry again next version!");
			}
			
		});
		englishMenu.add(aussieMenuItem);
		
		// Obviously, you can add many languages this way.  Because these
		// JMenuItems have no ActionListeners associated with them, nothing
		// happens when you select them
		languageMenu.add(new JMenuItem("Spanish"));
		languageMenu.add(new JMenuItem("Farsi"));
	}

	protected void loadJumblePanel() {
		// Here is where you would load up the JumblePanel/JumbleView
		Dimension d=this.getContentPane().getComponent(0).getPreferredSize();
		this.getContentPane().removeAll();
		
		LanguageMap map = getCurrentLanguage();
		JumblePanel jp = new JumblePanel(map);
		jp.setPreferredSize(d);
		this.getContentPane().add(jp);
		pack();
		validate();
		repaint();
	}

	private LanguageMap getCurrentLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void languageSelected(String string) {
		this.lang=string;
		// check to see if any LanguageMaps have this language
		for(LanguageMap lm:this.languageMaps) {
			if(lm.getLanguage().equals(string))
				return;// this language has already been loaded
		}
		// new language, so construct a new LanguageMap and add it 
		// to the languageMaps ...  This involves reading from a file,
		// so you don't want to repeat this and you don't want to load
		// up languages that may not be needed
		
		
	}
}
