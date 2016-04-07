//@AUTHOR: John Russell
//@DATE: 1 April 2016
//@NAME: ConverterProgram.java
//@PURPOSE: methods for the conversion process between temperatures

import javax.swing.*;
import java.util.Enumeration;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
//import java.util.Random;

public class ConverterProgram 
{
	private JPanel content;
	private JButton button;
	private JLabel label;
	private JTextField text;
	private JMenuBar menuBar;
	private JMenu menu;
	
	private ButtonGroup butGroup;
	private JRadioButtonMenuItem menuItem;


	public ConverterProgram()
	{
		content = new JPanel(new GridLayout(0,1)); //Create with a grid layout of a single column
		button = new JButton("submit"); //make the button
		label = new JLabel("Awaiting input"); //make the label for writing text to
		//Set up the Action Listener
		button.addActionListener( submitAction() );//this instance will handle the actions
		
		text = new JTextField(3);//3 columns, not 20 chars
		
		//make the menu bar
		menuBar = new JMenuBar();
		//make a menu
		menu = new JMenu("Conversion type");
		//add menu to menu bar
		menuBar.add(menu);
		
		//menuItem=new JMenuItem("C to K");
		
		//Radio menu options
		butGroup = new ButtonGroup();
		menuItem = new JRadioButtonMenuItem("C to K");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		menuItem = new JRadioButtonMenuItem("F to K");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		menuItem = new JRadioButtonMenuItem("K to C");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		menuItem = new JRadioButtonMenuItem("K to F");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		menuItem = new JRadioButtonMenuItem("C to F");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		menuItem = new JRadioButtonMenuItem("F to C");
		butGroup.add(menuItem);
		menu.add(menuItem);
		
		//frame.setJMenuBar(menuBar);

		
		content.add(label);	
		content.add(text);
		content.add(menuBar);
		content.add(button);
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
				//Modify this one to change temperatures
				//string _ = new Double(num).toString();
				double temperature;
				String inputTemp = text.getText();
				
				try
				{
					temperature=Double.parseDouble(inputTemp);
				}
				catch(Exception err)
				{
					label.setText("Invalid input");
					return;
				}
				
				if(getSelectedButtonText(butGroup)=="C to K")
				{
					double result= temperature + 273;
					label.setText("Result: " + Double.toString(result));
				}
				else if(getSelectedButtonText(butGroup)=="K to C")
				{
					double result= temperature - 273;
					label.setText("Result: " + Double.toString(result));
				}
				else if(getSelectedButtonText(butGroup)=="K to F")
				{
					double result= 1.8*(temperature -273) + 32;
					label.setText("Result: " + Double.toString(result));
				}
				else if(getSelectedButtonText(butGroup)=="F to K")
				{
					double result= (.555555) * (temperature - 32) + 273;
					label.setText("Result: " + Double.toString(result));
				}
				else if(getSelectedButtonText(butGroup)=="C to F")
				{
					double result= 1.8*temperature + 32;
					label.setText("Result: " + Double.toString(result));
				}
				else if(getSelectedButtonText(butGroup)=="F to C")
				{
					//not working for some unknown reason
					double result= ((.555555) * (temperature - 32));
					label.setText("Result: " + Double.toString(result));
				}
				else if(getSelectedButtonText(butGroup)==null)
				{
					label.setText("Select a conversion");
					return;
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
