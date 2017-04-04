import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


public class JumblePanel extends JPanel {

	LanguageMap map;
	private int nWords;
	private ArrayList<String> letters;
	private ArrayList<Integer> amtLetters;
	public JumblePanel(LanguageMap map) {
		this.map = map;
		this.setBackground(new Color(255, 128, 255));// just to make sure we can change...
		letters = new ArrayList<String>();
		amtLetters = new ArrayList<Integer>(0);
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
		numberList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nWords = numberList.getSelectedIndex() + 1;
				System.out.println(nWords);
				clear();
				inputLetters();
			}
		
		});
		this.add(numberList);

	}
	private void clear() {
		this.removeAll();
		this.repaint();
	}
	private void inputLetters() {
		for(int i = 0; i < nWords; i++) {
			int amtOfLetters = promptAmtOfLetters();
			amtLetters.add(amtOfLetters);
			promptLetters(amtOfLetters);
		}
	}
	private void promptLetters(int amt) {
		ArrayList<Object> qs = new ArrayList<Object>();
		for(int i = 0; i < amt; i++) {
			//qs.add(i + 1 + " letter");
			qs.add(new JTextField(i + 1 + " letter"));
		}
		Object[] qsArr = qs.toArray();
		JOptionPane myLetters = new JOptionPane();
		myLetters.showConfirmDialog(null, qsArr, "Enter Letters", JOptionPane.OK_CANCEL_OPTION);
		for(Object tf: qs) {
			String thisLetter = ((JTextComponent) tf).getText();
			letters.add(thisLetter);
		}
	}
	private int promptAmtOfLetters() {
		JOptionPane prompt = new JOptionPane();
		int number = Integer.parseInt(prompt.showInputDialog("Enter the amount of letters in this word"));
		return number;
	}

}
