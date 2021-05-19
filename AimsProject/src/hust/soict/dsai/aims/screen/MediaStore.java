package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new AddToCartListener());
		container.add(addToCartButton);
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new PlayButtonListener());
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class PlayButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel j1 = new JLabel();
			JLabel j2 = new JLabel();
			try {
				j1.setText("Playing " + media.getTitle());
				j2.setText("Length: " + ((Disc)media).getLength());
				((Disc)media).play();
			} catch (PlayerException ex) {
				j1.setText(media.getTitle() + " cannot be played");
				j2.setText("Media length is non-positive");
			} finally {
				p.add(j1);
				p.add(j2);
				d.add(p);
				d.setSize(200,100);
				d.setVisible(true);
			}
		}
	}
	
	private class AddToCartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			cart.addMedia(media);
		}
		
	}
}
