package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
  private Media media;
  private Cart cart = new Cart();
  
  public MediaStore(Media media, Cart cart) {
	this.media = media;
	this.cart = cart;
	
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  
	JLabel title = new JLabel(media.getTitle());
	title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
	title.setAlignmentX(CENTER_ALIGNMENT);
	
	JLabel cost = new JLabel(""+media.getCost()+" $");
	cost.setAlignmentX(CENTER_ALIGNMENT);
	
	JPanel container = new JPanel();
	container.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	JButton btnAddCart = new JButton("Add to cart");
	btnAddCart.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnAddCartListener();
		}
	});
	container.add(btnAddCart);
	
	if(media instanceof Playable) {
	  JButton btnPlay = new JButton("Play");
	  btnPlay.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnPlayListener();
		} 
	  });
	  container.add(btnPlay);
	}
	
	this.add(Box.createVerticalGlue());
	this.add(title);
	this.add(cost);
	this.add(Box.createVerticalGlue());
	this.add(container);
	
	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  }
  
  private void btnPlayListener() {
	PlayScreen.play(media);
  }
  
  private void btnAddCartListener() {
	PlayScreen.addMedia(cart.addMedia(media), "cart");
  }
}
