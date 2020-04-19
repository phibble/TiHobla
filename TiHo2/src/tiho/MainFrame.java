package tiho;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private ChoosePanel choosePanel;
	private JPanel framePanel;
	private JButton confirmButton;
	private String fileAbsolutePath = "";
	private boolean allParameters = true;

	public MainFrame()
	{
		setProgramLookAndFeel();
		
		choosePanel = new ChoosePanel();
		framePanel = new JPanel();
		confirmButton = new JButton("OK");
		
		setFrameSettings();
		setComponentLayout();
		
		confirmButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fileAbsolutePath = choosePanel.getFileAbsolutePath();
				allParameters = choosePanel.isAllParameters();
			}
		});
	}
	
	private void setProgramLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void setFrameSettings()
	{
		setTitle("Dateiauswahl");
		
		setSize(360, 145);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border innerBorder = BorderFactory.createEtchedBorder();
		Border outerBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);
		framePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setPreferredSize(new Dimension(305, 195));
	}
	
	private void setComponentLayout()
	{
		setLayout(new BorderLayout());
		framePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;

		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.gridy = 0;
		framePanel.add(choosePanel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		framePanel.add(confirmButton, gc);
		add(framePanel, BorderLayout.CENTER);
	}
	
	public String getFileAbsolutePath()
	{
		return fileAbsolutePath;
	}
}