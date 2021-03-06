package view.box.util;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class ButtonFactory {

	private Pane parent;
	private double buttonWidth;
	
	public ButtonFactory(Pane parent, double buttonWidth) {
		
		this.parent = parent;
		this.buttonWidth = buttonWidth;
		
	}
	
	public Button createAndAddButtonWithText(String text) {
		
		Button returnButton = new Button(text);

		setWidthOnButton(buttonWidth, returnButton);
		
		returnButton.setFont(new Font(20));
		
		return returnButton;
		
	}
	
	// Modify Button Width
	public void setButtonWidth(double buttonWidth) {
		
		this.buttonWidth = buttonWidth;
		
		// Account for existing buttons
		for (Node n : this.parent.getChildren()) {
			
			if (n instanceof Button) {
				
				Button b = (Button)n;
				setWidthOnButton(buttonWidth, b);
				
			}
			
		}
		
	}
	
	private void setWidthOnButton(double width, Button button) {
		
		button.setMinWidth(width);
		button.setMaxWidth(width);
		
	}
	
}
