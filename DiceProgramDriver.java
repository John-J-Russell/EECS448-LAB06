//@AUTHOR: John Russell j362r647@ku.edu
//@NAME: DiceProgram.java
//@DATE: 31 March 2016
//@PURPOSE: Allow user to make and roll a die, does the things.

import javax.swing.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;

public class DiceProgramDriver 
{
	
	
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Roller Die");
		DiceProgram die = new DiceProgram();
		
		frame.getContentPane().add( die.getContent() /*This will become something?*/ );
		
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
	
}
