package hust.soict.dsai.aims.screen;

import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class PlayScreen {
  public static void play(Media media) {
	  JDialog dialog = new JDialog();
		
		JLabel label;
			if(media instanceof CompactDisc) {
			  CompactDisc cd = (CompactDisc) media;
			  label = new JLabel(cd.play());
			}
			else {
			  DigitalVideoDisc dvd = (DigitalVideoDisc) media;
			  label = new JLabel(dvd.play());
			}
			 
			dialog.add(label);
			
			dialog.setSize(200, 200);
			dialog.setVisible(true);
  }
  
  public static void addMedia(int tmp, String str) {
	  JDialog dialog = new JDialog();
		JLabel label = new JLabel(" ");
		
		switch(tmp) {
		case 0:  //Thông báo thêm vào giỏ hàng thành công  //In ra số lượng media trong giỏ hàng
		  label = new JLabel("The media has been added");  
		  break;
		case -1:
		  label = new JLabel("Add to "+str+" failed");
		  break;
		case -2:
		  label = new JLabel("The "+str+" is almost full");
		  break;
		case -3:
		  label = new JLabel("The media is already on the "+str);
		  break;
		}
		
		dialog.add(label);
		dialog.setSize(200, 200);
		dialog.setVisible(true);
  }
}
