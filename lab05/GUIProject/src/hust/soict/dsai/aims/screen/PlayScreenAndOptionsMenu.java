package hust.soict.dsai.aims.screen;
import java.awt.FlowLayout;
import javax.swing.*;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
//Nguyễn Ngọc Anh Thư - 20215143
public class PlayScreenAndOptionsMenu {
  //Hiển thị dialog thông tin play media
  public static void play(Media media) throws PlayerException {
	JDialog dialog = new JDialog();
	dialog.setTitle("Play Media");
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

  //Tạo menu option dùng chung cho các screen
  public static JMenuBar createMenuBar(JFrame jframe) {
		JMenu menu = new JMenu("Options");	
		JMenu smUpdateStore = new JMenu("Update Store");	
		OptionsListener optionsListener = new OptionsListener(jframe);
		
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(optionsListener);
		smUpdateStore.add(addBook);
		
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(optionsListener);
		smUpdateStore.add(addCD);
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(optionsListener);
		smUpdateStore.add(addDVD);
		
		JMenuItem removeMedia = new JMenuItem("Remove Media");
		removeMedia.addActionListener(optionsListener);
		smUpdateStore.add(removeMedia);
		
		menu.add(smUpdateStore);    //Nguyễn Ngọc Anh Thư - 20215143

		JMenuItem viewStore = new JMenuItem("View store");
		viewStore.addActionListener(optionsListener);
		menu.add(viewStore);
		
		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(optionsListener);
		menu.add(viewCart);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	  }
}