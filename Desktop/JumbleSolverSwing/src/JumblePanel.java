import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

<<<<<<< HEAD
import javax.swing.JButton;
=======
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
>>>>>>> a437445542127cafbfc3f5744b3772c52505016a
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


public class JumblePanel extends JPanel {

	LanguageMap map;
	private int nWords, curWord;
	private ArrayList<String> letters;
<<<<<<< HEAD
	private ArrayList<Integer> amtLetters;
	private ArrayList<JTextField> boxArr = new ArrayList<JTextField>();
=======
	private ArrayList<JTextField> boxes = new ArrayList<JTextField>();
>>>>>>> a437445542127cafbfc3f5744b3772c52505016a
	public JumblePanel(LanguageMap map) {
		this.map = map;
		this.setBackground(new Color(255, 128, 255));// just to make sure we can change...
		letters = new ArrayList<String>();
		createGUI();

	}
	
	private void createGUI() {
		JTextField myField = new JTextField();
		myField.setText("Pick number of words");
		myField.setEditable(false);
		this.add(myField);
		final JComboBox<Integer> numberList = new JComboBox<Integer>();
		for(int i = 1; i < 11; i++) {
			numberList.addItem(i);
		}
		numberList.setSelectedIndex(0);
		numberList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nWords = numberList.getSelectedIndex() + 1;
				clear();
				makeLetters();
				curWord = 0;
			}

		});
		this.add(numberList);

	}
	
	private void clear() {
		this.removeAll();
		this.repaint();
	}
	private void nextWord() {
		if(curWord < nWords) {
			makeLetters();
		}
	}
	private void makeLetters() {
			int amt = promptAmtOfLetters();
			makeBoxes(amt);
	}
	private void makeBoxes(int amt) {
		for(int i = 0; i < amt; i++) {
			JTextField curr = new JTextField("Letter");
			boxes.add(curr);
		}
		
		for(JTextField field: boxes) {
			this.add(field);
		}
		
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gatherLetters();
			}
		});
		this.add(doneButton);
		this.validate();
		this.repaint();
	}
	
	private void gatherLetters() {
		for(JTextField field: boxes) {
			letters.add(field.getText());
		}
		boxes.clear();
		curWord++;
		clear();
		nextWord();
	}
/*	private void inputLetters() {
		for(int i = 0; i < nWords; i++) {
			int amt = promptAmtOfLetters();
			makeLetters(amt);
		}
	}
	
	private void makeLetters(int amt) {
		
		for(int i = 0; i < amt; i++) {
			JTextField field = new JTextField(i);
			boxArr.add(field);
		}
		
		for(JTextField cur: boxArr) {
			this.add(cur);
		}
		
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveLetters();
			}
		
		});
	}
	private void saveLetters() {
		
	}
	private void inputTheLetters() {
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
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i < amt; i++) {
			JCheckBox myBox = new JCheckBox("Letter " + amt);
			myBox.setVisible(true);
			bg.add(myBox);
			this.add(myBox);
			System.out.println("show pls");
		}
		
	}*/

	private int promptAmtOfLetters() {
		JOptionPane prompt = new JOptionPane();
		int myWordCount = curWord + 1;
		int number = Integer.parseInt(prompt.showInputDialog("Enter the amount of letters in " + myWordCount + " word"));
		return number;
	}

}
