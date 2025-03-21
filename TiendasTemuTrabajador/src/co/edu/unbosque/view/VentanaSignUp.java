package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaSignUp extends JFrame{
	
	private PanelSignUp panelSignUp;
	
	public VentanaSignUp() {
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Sign Up");
		setResizable(false);
		panelSignUp = new PanelSignUp();
		
		add(panelSignUp);
	}

}
