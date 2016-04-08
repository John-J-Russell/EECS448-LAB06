import javax.swing.JFrame;

/*
 * 	@AUTHOR: John Russell, j362r647@ku.edu
 * 	@NAME: VoteProgramDriver
 * 	@PURPOSE: it's the driver for the voting program
 */
public class VoteProgramDriver {

	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Cast Your Vote");
		VoteProgram convert = new VoteProgram();
		
		frame.getContentPane().add( convert.getContent() );
		
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
