package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;

import javax.naming.LimitExceededException;
import javax.swing.*;
import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.MediaException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
//Nguyễn Ngọc Anh Thư - 20215143
public class MediaStore extends JPanel{
  private Media media;
  private Cart cart = Aims.cart;
  
  public MediaStore(Media media) {
	this.media = media;
	
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  
	JLabel title = new JLabel(media.getTitle());
	title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
	title.setAlignmentX(CENTER_ALIGNMENT);
	
	JLabel cost = new JLabel(""+media.getCost()+" $");
	cost.setAlignmentX(CENTER_ALIGNMENT);
	
	JPanel container = new JPanel();
	container.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	JButton btnAddCart = new JButton("Add to cart");
	btnAddCart.addActionListener(new btnAddCartListener());
	container.add(btnAddCart);
	
	if(media instanceof Playable) {
	  JButton btnPlay = new JButton("Play");
	  btnPlay.addActionListener(new btnPlayListener());
	  container.add(btnPlay);
	}
	
	this.add(Box.createVerticalGlue());
	this.add(title);
	this.add(cost);
	this.add(Box.createVerticalGlue());
	this.add(container);
	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  }
  
//Nguyễn Ngọc Anh Thư - 20215143
  //ActionListener khi click vào Add to cart
  private class btnAddCartListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
	  boolean check = false;
	  try {
		check = cart.addMedia(media);
	  } catch (NullPointerException e1) {	//Nếu title rỗng
		JOptionPane.showMessageDialog(null, e1.getMessage(), "Add media failed", 0);
	  } catch(LimitExceededException e2) {	//Nếu số lượng media trong cart max
		JOptionPane.showMessageDialog(null, e2.getMessage(), "Add media failed", 0);
	  }catch(MediaException e3) {			//Nếu trong giỏ hàng đã có media
		JOptionPane.showMessageDialog(null, e3.getMessage(), "Add media failed", 0);
	  }catch (Exception e4) {				
	    JOptionPane.showMessageDialog(null, e4.getMessage(), "Add media failed", 0);
	  }
	  if(check) {
		JOptionPane.showMessageDialog(null, "The media has been added", "Add media successful", 1);
	  }
	}
  }  
  //ActionListener khi click vào Play
  private class btnPlayListener implements ActionListener {	
	@Override
	public void actionPerformed(ActionEvent e) {
	  try {
	    PlayScreenAndOptionsMenu.play(media);
	  } catch (PlayerException e1) {
			// TODO Auto-generated catch block
	    JOptionPane.showMessageDialog(null, e1.getMessage(), "Play media failed", 0);
	  }		
	}
  }
}
