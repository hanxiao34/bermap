package com.ber.map;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
/**
 * ��������ͼ��Ҫ�ڴ��������
 * @author hx
 *
 */
public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1L;
/**
 * ���߷�����װ���Ա����point����
 * @param g
 * @param p
 */
	private void lineTo(GeneralPath g, Point p) {
		g.lineTo(p.getX(), p.getY());
	}
/**
 * ��дpaintComponent������ʵ�ֻ�ͼ
 */
	public void paintComponent(Graphics comp) {
		Graphics2D comp2D = (Graphics2D) comp;
		comp2D.setColor(Color.lightGray);
		comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Rectangle2D.Float background = new Rectangle2D.Float(0F, 0F, (float) getSize().width, (float) getSize().height);
		comp2D.fill(background);
		comp2D.setColor(Color.gray);
		BasicStroke pen = new BasicStroke(2F, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
		comp2D.setStroke(pen);
		//����ͼ 20����һ�� ÿ������ֱ��20����
		for (int ax = 0; ax < 1920; ax += 20) {
			for (int ay = 0; ay < 1080; ay += 20) {
				Arc2D.Float wave = new Arc2D.Float(ax, ay, 20, 20, 0, -180, Arc2D.OPEN);
				comp2D.draw(wave);
			}
		}
		GradientPaint gp = new GradientPaint(0F, 0F, Color.gray, 1920F, 1080f, Color.orange, true);
		comp2D.setPaint(gp);
		GeneralPath f1 = new GeneralPath();
		Point origin = Data.point.get(0);
		//�����Ƶ���һ�� ��
		f1.moveTo(origin.getX(), origin.getY());
		//��˳����
		for (Point p : Data.point) {
			lineTo(f1, p);
		}
		//�γɱջ����������һ���㻭�ߵ���ʼ��
		f1.closePath();
		//���������������״����ͼ�����ˣ�
		comp2D.fill(f1);
		//̨���ͼ ͬ��
		origin = Data.point_tw.get(0);
		f1.moveTo(origin.getX(), origin.getY());
		for (Point p : Data.point_tw) {
			lineTo(f1, p);
		}
		f1.closePath();
		comp2D.fill(f1);
		comp2D.setColor(Color.red);
		BasicStroke pen2 = new BasicStroke();
		comp2D.setStroke(pen2);
		String[] berCovers = Data.cover.split(";");
		comp2D.setFont(comp2D.getFont().deriveFont(23f));
		//�ڵ�ͼ�ϱ�ע���ǳ���
		for (String c : berCovers) {
			String[] city = c.split(",");
			Ellipse2D.Float e1 = new Ellipse2D.Float(Integer.parseInt(city[0]), Integer.parseInt(city[1]), 10, 10);
			comp2D.setColor(Color.BLUE);
			comp2D.drawString(city[2], new Double(e1.getCenterX()).intValue(), new Double(e1.getCenterY()).intValue());
			comp2D.setColor(Color.red);
			comp2D.fill(e1);
		}
	}
}