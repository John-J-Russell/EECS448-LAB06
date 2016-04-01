//@AUTHOR: John Russell j362r647@ku.edu
//@NAME: DiceProgram.java
//@DATE: 31 March 2016
//@PURPOSE: Allow user to make and roll a die.

import javax.swing.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;

//For making random numbers
import java.util.Random;

public class DiceProgram implements ActionListener
{
	//Get user number input
	//Roll between 1 and that number
	//display result
	
	//private int counter = 0;
	private JPanel content;
	private JButton button;
	private JLabel label;
	private JTextField text;
	
	public DiceProgram()
	{
		content = new JPanel(new GridLayout(0,1)); //Create with a grid layout of a single column
		button = new JButton("submit"); //make the button
		label = new JLabel("Awaiting input"); //make the label for writing text to
		
		//Set up the Action Listener
		button.addActionListener(this);//this instance will handle the actions
		
		text = new JTextField(3);//3 cols, not 20 chars
		
		content.add(button);
		content.add(label);	
		content.add(text);
	}
	
	//important for driver file
	public Component getContent()
	{
		return(content);
	}
	/*
	private String counterMessage(int num)
	{
		//Create a message based on current counter number
		return (new String("Counter:  " + num + " "));
	}
	*/
	public void actionPerformed(ActionEvent e) 
	{
		/*
                //When the button is pressed...
		String msg  = counterMessage(counter) ; 
		counter++;
		label.setText(msg);	//update label
		System.out.println(msg); //update 
		*/
		
		int sides;
		String input = text.getText();
		try
		{
			sides=Integer.parseInt(input);
		}
		catch(Exception err)
		{
			label.setText("Invalid input");
			return;
		}
		if(sides>1)
		{
			Random placeholder= new Random(System.currentTimeMillis()) ;
			
			int result= placeholder.nextInt((sides - 1) +1) +1;
			//stuff
			label.setText("Result: " + Integer.toString(result));
		}
		else
		{
			label.setText("Invalid input");
			return;
		}
	}
	
	

}
