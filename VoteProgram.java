/*
 * 	@AUTHOR: John Russell, j362r647@ku.edu
 * 	
 */

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;


//aaaaa
//Includes and stuff taken from javase tutorials on docs.oracle.com
import static java.nio.file.StandardOpenOption.*;

import java.nio.charset.Charset;
import java.nio.file.*;
//import java.io.BufferedOutputStream;
import java.io.*;

public class VoteProgram {

	private JPanel content;
	private JButton button;
	private JLabel label1;
	private JLabel label2;
	private JLabel alerting;
	private JTextField firstName;
	private JTextField lastName;
	private JMenuBar menuBar;
	private JMenu menu;
	
	private ButtonGroup butGroup;
	private JRadioButtonMenuItem menuItem;


	public VoteProgram()
	{
		content = new JPanel(new GridLayout(0,1)); //Create with a grid layout of a single column
		button = new JButton("submit"); //make the button
		label1 = new JLabel("First name"); //make the label for writing text to
		label2 = new JLabel("Last name");
		alerting = new JLabel("");
		//Set up the Action Listener
		button.addActionListener( submitAction() );//this instance will handle the actions
		
		firstName = new JTextField(20);//if their name is longer than 20 characters, I don't care.
		lastName = new JTextField(20); 
		
		//make the menu bar
		menuBar = new JMenuBar();
		//make a menu
		menu = new JMenu("Favored Candidate");
		//add menu to menu bar
		menuBar.add(menu);
		
		//menuItem=new JMenuItem("C to K");
		
		//Radio menu options
		butGroup = new ButtonGroup();
		menuItem = new JRadioButtonMenuItem("Bernie Sanders");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		menuItem = new JRadioButtonMenuItem("Hillary Clinton");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		menuItem = new JRadioButtonMenuItem("Donald Trump");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		menuItem = new JRadioButtonMenuItem("Ted Cruz");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		
		
		content.add(label1);	
		content.add(firstName);
		content.add(label2);
		content.add(lastName);
		content.add(menuBar);
		content.add(button);
		content.add(alerting);
	}
	
	//important for driver file
	public Component getContent()
	{
		return(content);
	}

	
	private ActionListener submitAction()
	{
		ActionListener action = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				String first = firstName.getText();
				String last = lastName.getText();
				String candidate = "If this is recorded in the file, it's a bug.";
				if(first=="")
				{
					alerting.setText("Please give your first name");
					return;
				}
				if(last=="")
				{
					alerting.setText("Please give last name");
					return;
				}
				String fileName = last + "_" + first + "_ballot.txt";
				
				
				if(getSelectedButtonText(butGroup)=="Bernie Sanders")
				{
					candidate = "Bernie Sanders";
					//alerting.setText("Feel burn");
				}
				else if(getSelectedButtonText(butGroup)=="Hillary Clinton")
				{
					candidate = "Hillary Clinton";
					//alerting.setText("Lizard skin");
				}
				else if(getSelectedButtonText(butGroup)=="Donald Trump")
				{
					candidate = "Donald Trump";
					//alerting.setText("Make Donald Drumpf Again");
				}
				else if(getSelectedButtonText(butGroup)=="Ted Cruz")
				{
					candidate = "Ted Cruz";
					//alerting.setText("The zodiac killer");
				}
				
				else if(getSelectedButtonText(butGroup)==null)
				{
					alerting.setText("Select a candidate");
					return;
				}
				
				byte data[] = candidate.getBytes();
				//System.out.println(data);
				//System.out.println(candidate.getBytes());
				Path p = Paths.get("./" + fileName);
				
				try 
				{
					
					//createFile throws error if file already exists
					Files.createFile(p);
					Files.write(p, data);
					//out.write(data, 0, data.length);
					
				}
				catch(Exception err)
				{
					alerting.setText("You've already voted");
				}
			}
		};
		return(action);
	}
	
	//A handy-dandy little method for checking which radio button is checked
	//courtesy of StackOverflow user "Rendicahya"
	//Method takes in a radiogroup and returns the text of the selected button.
	//If none are selected, it will instead return null
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return (button.getText());
            }
        }

        return null;
    }
	
}
