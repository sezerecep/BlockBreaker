import javax.swing.JFrame;

public class Main {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("BlokKýrýcý");
		BlokPaneli panel = new BlokPaneli();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(520, 520);
	}

}
