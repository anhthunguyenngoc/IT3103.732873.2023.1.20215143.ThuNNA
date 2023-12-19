package hust.soict.dsai.aims.screen;
import java.awt.*;
import javax.swing.*;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
  private JTextField tfDirectory = new JTextField();
  private JTextField tfArtist = new JTextField();
	
  public AddCompactDiscToStoreScreen() {  
    super();
    GridBagConstraints c = new GridBagConstraints();
    title.setText("Add CD");
   
	  c.gridwidth = 1;
	  c.weightx = 0.3; c.weighty = 1;
	  c.insets = new Insets(0, 20, 0, 20);
	  
	  c.gridx = 0;
	  c.anchor = GridBagConstraints.LINE_END;
	  
	  c.gridy = 4;
	  panel.add(new JLabel("Directory"), c);
	  
	  c.gridy = 5;
	  panel.add(new JLabel("Artist"), c);
	  
	  c.insets = new Insets(0, 20, 0, 80);
	  c.weightx = 1;
	  c.weighty = 1;
	  c.gridx = 1;
	  c.gridwidth = 2;
	  c.anchor = GridBagConstraints.LINE_START;
	  c.fill = GridBagConstraints.HORIZONTAL;

	  c.gridy = 4;
	  panel.add(tfDirectory, c);
	  
	  c.gridy = 5;
	  panel.add(tfArtist, c);
	  
	  c.insets = new Insets(0, 20, 0, 20);
		c.gridx = 0;
		++c.gridy;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
	
		btnAdd.setText("Add CD");
		panel.add(btnAdd, c);
	
  }
  
  public int addMedia() {
	return Aims.store.addMedia(new CompactDisc(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()), tfDirectory.getText(), tfArtist.getText()));
  }
}
