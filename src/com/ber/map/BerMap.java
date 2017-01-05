package com.ber.map;
import javax.swing.JFrame;

public class BerMap extends JFrame {

	private static final long serialVersionUID = 1L;

	BerMap() {
		super("BerMap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920, 1080);
		MapPanel map = new MapPanel();
		add(map);
		setVisible(true);
	}
/**
 * 入口在这里
 * @param args
 */
	public static void main(String[] args) {
		BerMap frame = new BerMap();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
