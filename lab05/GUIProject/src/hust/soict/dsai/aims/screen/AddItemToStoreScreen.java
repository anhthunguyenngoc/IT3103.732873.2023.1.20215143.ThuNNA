package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame{
	  protected JTextField tfTitle = new JTextField();
	  protected JTextField tfCategory = new JTextField();
	  protected JTextField tfCost = new JTextField();
	  protected JPanel panel = new JPanel();
	  protected JLabel title = new JLabel();
	  protected JButton btnAdd = new JButton();
	  protected Store store = new Store();
	  
  public AddItemToStoreScreen() {   
	  panel.setLayout(new GridBagLayout());
	  GridBagConstraints c = new GridBagConstraints();
	  
	  //Hàng 0 (1 cột)
	  c.gridx = 0; c.gridy = 0;
	  c.gridwidth = 2;
	  c.weightx = 0.3; c.weighty = 1;
	  c.anchor = GridBagConstraints.CENTER;
	  
	  title.setFont(new Font(title.getFont().getName(), Font.BOLD, 24));
	  title.setForeground(new Color(0, 0 , 128));  
	  
	  panel.add(title, c);
	  
	  //Hàng 1 (3 cột)
	  c.gridwidth = 1;
	  c.weightx = 0.3; c.weighty = 1;
	  c.insets = new Insets(0, 20, 0, 20);
	  
	  c.gridx = 0;
	  c.anchor = GridBagConstraints.LINE_END;
	  
	  c.gridy = 1;
	  panel.add(new JLabel("Title"), c);
	  
	  c.gridy = 2;
	  panel.add(new JLabel("Category"), c);
	  
	  c.gridy = 3;
	  panel.add(new JLabel("Cost"), c);  
	  	  
	  c.insets = new Insets(0, 20, 0, 80);
	  c.weightx = 1; c.weighty = 1;
	  c.gridx = 1;
	  c.anchor = GridBagConstraints.LINE_START;
	  c.fill = GridBagConstraints.HORIZONTAL;
	  
	  c.gridy = 1;
	  panel.add(tfTitle, c); 
	  
	  c.gridy = 2;
	  panel.add(tfCategory, c);	
	  
	  c.gridy = 3;
	  panel.add(tfCost, c);
	   
	  btnAdd.setSize(25, 50);
	  btnAdd.addActionListener(new btnAddPressed());
	  	  
	  this.add(panel);
	  this.setTitle("Add book");
	  this.setVisible(true);
	  this.setSize(400, 200);
  }
  
  private class btnAddPressed implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				int tmp = addMedia();
				PlayScreen.addMedia(tmp, "store");
				  
				  if(tmp==0) {
					close();
				  }
			}
			
		  }
  
  public abstract int addMedia();
  
  private void close() {
	  this.dispose();
  }
}
