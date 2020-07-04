import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
	static int clicks = 0;
	static int autoClickLevel = 0;
	int autoClickNextLevelUpgradeCost = 100;
	static int autoClickRateMilliseconds = 0;
	String versionRing = "Alpha";
	String versionNumber = "1.2";
	JLabel clickText;
	JFrame frame;
	JPanel panel;
	JLabel autoClickCostText;
	
	public GUI() {
		frame = new JFrame();
		
		JButton button = new JButton("Click me!");
		JButton autoClickUpgradeButton = new JButton("Auto Clicker - Level " + autoClickLevel);
		button.addActionListener(this);
		button.setPreferredSize(new Dimension(10, 75));
		autoClickUpgradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clicks >= autoClickNextLevelUpgradeCost && autoClickLevel < 9) {
					autoClickLevel++;
					autoClickUpgradeButton.setText("Auto Clicker - Level " + autoClickLevel);
					clicks = clicks - autoClickNextLevelUpgradeCost;
					clickText.setText("Times Clicked: " + clicks);
					autoClickNextLevelUpgradeCost = autoClickNextLevelUpgradeCost * 10;
					autoClickCostText.setText("Auto Clicker Upgrade Cost: " + autoClickNextLevelUpgradeCost + " Clicks");
					frame.pack();
//					while(autoClickLevel > 0) {
//						if(autoClickLevel == 1) {
//							SwingUtilities.invokeLater(() -> { clicks++; })
//						}
//					}
				}
			}
		});
		
		clickText = new JLabel("Times Clicked: 0");
		autoClickCostText = new JLabel("Auto Clicker Upgrade Cost: " + autoClickNextLevelUpgradeCost + " Clicks");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 30, 100));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		panel.add(clickText);
		panel.add(autoClickUpgradeButton);
		panel.add(autoClickCostText);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Clicker Clicker - " + versionRing + " " + versionNumber);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		clicks++;
		clickText.setText("Times Clicked: " + clicks);
		frame.pack();
		clickText.setHorizontalTextPosition(JLabel.CENTER);
		clickText.setVerticalTextPosition(JLabel.CENTER);
	}
}