//@AUTHOR: John Russell
//@DATE: 1 April 2016
//@NAME: ConverterProgramDriver.java
//@PURPOSE: Handle the conversion process between temperatures

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;

public class ConverterProgramDriver {

	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Roller Die");
		ConverterProgram convert = new ConverterProgram();
		
		frame.getContentPane().add( convert.getContent() );
		
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
