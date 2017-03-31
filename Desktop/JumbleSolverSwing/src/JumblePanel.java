import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JumblePanel extends JPanel {

	LanguageMap map;
	public JumblePanel(LanguageMap map) {
		this.map = map;
		this.setBackground(new Color(255, 128, 255));// just to make sure we can change...
		createGUI();

	}
	private void createGUI() {
		JTextField myField = new JTextField();
		myField.setText("Pick number of words");
		myField.setEditable(false);
		this.add(myField);
		JComboBox<Integer> numberList = new JComboBox<Integer>();
		for(int i = 1; i < 11; i++) {
			numberList.addItem(i);
		}
		numberList.setSelectedIndex(0);
		this.add(numberList);

	}



}
