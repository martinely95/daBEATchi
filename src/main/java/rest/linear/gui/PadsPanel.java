package rest.linear.gui;

import javax.swing.*;
import java.awt.*;

public class PadsPanel extends JPanel {
	private static final boolean NOT_SELECTED = false;
	private static final String NO_LABEL = "";
	private static final int COLUMNS = 70;
	private static final int ROWS = 30;
	private static final int VERTICAL_GAP = 1;
	private static final int HORIZONTAL_GAP = 0;
	private static JToggleButton[][] buttons;

	public PadsPanel() {
		buttons = new JToggleButton[ROWS][COLUMNS];
		setLayout(new GridLayout(ROWS, COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP));
		JToggleButton button = null;
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				button = new JToggleButton(NO_LABEL, NOT_SELECTED);
				buttons[row][col] = button;
				add(button);
			}
		}
	}

	public static JToggleButton[][] getButtons() {
		return buttons;
	}
}
