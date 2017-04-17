import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class JumblePanel extends JPanel {
	private JPanel checkBoxPanel;
	LanguageMap map;
	private int nWords, curWord;
	private ArrayList<String> letters;
	private ArrayList<String> finalLetters = new ArrayList<String>();
	private ArrayList<JTextField> boxes = new ArrayList<JTextField>();
	private ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
	public JumblePanel(LanguageMap map) {
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.map = map;
		this.setBackground(new Color(135,206,250));// just to make sure we can change...
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
		else if(curWord == nWords) {
			System.out.println("finding words");
			ArrayList<String> myWords = findWords();
			decipherWords(myWords);
		}
	}
	private void decipherWords(ArrayList<String> myWords) {
		for(String word: myWords) {
			String key = map.alph(word);
			System.out.println("Word " + word + " Key " + key);
			HashSet<String> answers = map.findPossilities(key);
			displayAnswers(answers);
		}
		JButton doneButton = new JButton("done");
		doneButton.setBackground(new Color(135,206,250));
		doneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				finalWords();
				
			}
			
		});
		this.add(doneButton);
		this.validate();
		this.repaint();
	}

	private void finalWords() {
		clear();
		this.setLayout(new BorderLayout());
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
				solveFinal(numberList.getSelectedIndex() + 1);
			}

		});
		this.add(numberList);
		this.validate();
		this.repaint();
	}

	protected void solveFinal(int num) {
		
	}

	private void displayAnswers(HashSet<String> answers) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel answerPanel = new JPanel();
		if(answers.isEmpty()) {
			System.out.println("empty");
			return;
		}
		for(String ans: answers) {
			JTextField ansBox = new JTextField(ans);
			ansBox.setEditable(false);
			ansBox.setBackground(new Color(135,206,250));
			answerPanel.add(ansBox);
		}
		answerPanel.setBackground(new Color(135,206,250));
		this.add(answerPanel);
		this.validate();
		this.repaint();
	}

	private void makeLetters() {
		int amt = promptAmtOfLetters();
		makeBoxes(amt);
	}
	private void makeBoxes(int amt) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel letterPanel = new JPanel();
		JPanel checkPanel = new JPanel();
		
		for(int i = 0; i < amt; i++) {
			JCheckBox check = new JCheckBox();
			check.setSelected(false);
			checkBoxes.add(check);
			checkPanel.add(check);
		}
		
		for(int i = 0; i < amt; i++) {
			JTextField curr = new JTextField("Letters");
			boxes.add(curr);
			letterPanel.add(curr);
		}
		
		letterPanel.setBackground(new Color(135,206,250));
		checkPanel.setBackground(new Color(135,206,250));
		this.add(letterPanel);
		this.add(checkPanel);

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
		for(JCheckBox check: checkBoxes) {
			if(check.isSelected()) {
				finalLetters.add(boxes.get(checkBoxes.indexOf(check)).getText());
			}
		}
		boxes.clear();
		checkBoxes.clear();
		letters.add("");
		curWord++;
		clear();
		nextWord();
	}

	private int promptAmtOfLetters() {
		JOptionPane prompt = new JOptionPane();
		int myWordCount = curWord + 1;
		int number = Integer.parseInt(prompt.showInputDialog("Enter the amount of letters in " + "word " + myWordCount));
		return number;
	}

	private ArrayList<String> findWords() {
		ArrayList<String> words = new ArrayList<String>();
		//if(letters.get(letters.size() - 1).equals("")) {
		//	letters.remove(letters.size() - 1);
		//}
		String thisWord = "";
		for(String let: letters) {
			if(!let.equals("")) {
				thisWord += let;
			}
			else {
				words.add(thisWord);
				thisWord = "";
			}
		}
		return words;
	}

}
