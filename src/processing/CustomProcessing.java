package processing;

import java.awt.Container;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.CustomDesign;
import model.ListShapes;
import sound.AudioHandler;
import sound.Fourier;
import view.ControlCustomFormWindow;

/**
 * 
 * @author Mehdi Raddadi
 * 
 */
public class CustomProcessing extends AbstractProcessing {

	CustomDesign currentShape = new CustomDesign(this);

	private ListShapes allShapes = new ListShapes(currentShape);

	private CustomDesign s = new CustomDesign(this);

	public CustomProcessing(Container parent) {
		super(parent);

	}

	public void setup() {
		size(this.parent.getWidth(), this.parent.getHeight(), P2D);

		audio = new AudioHandler(this);

		fourier = new Fourier(audio);
		fourier.maj();

		size(900, 900, P2D);
	}

	public void draw() {

		this.noFill();
		this.stroke(255);
		this.background(0);

		if (allShapes != null) {
			for (int i = 0; i < allShapes.size(); i++) {
				allShapes.get(i).display();
			}
		}
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		for (int i = 0; i < allShapes.size(); i++) {
			ArrayList<Point> list = allShapes.get(i).getPoints();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).distance(e.getPoint()) < 10) {
					list.get(j).move(e.getX(), e.getY());
				}
			}
		}
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (currentShape.getPoints().size() != 0
					&& currentShape.detect(e.getPoint(), 10)) {
				currentShape.add(e.getX(), e.getY());
				this.currentShape = new CustomDesign(this);
				allShapes.add(currentShape);
			} else {
				currentShape.add(e.getX(), e.getY());
			}
		}
		if (SwingUtilities.isRightMouseButton(e)) {

			for (int i = 0; i < allShapes.size(); i++) {
				ArrayList<Point> list = allShapes.get(i).getPoints();
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).distance(e.getPoint()) < 10) {
						CustomDesign p = allShapes.get(i);

						ControlCustomFormWindow c = new ControlCustomFormWindow(
								p);
						c.setVisible(true);

					}
				}
			}
		}

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {

	}

	@Override
	public void majForme(String s, String path) {
		// TODO Auto-generated method stub

	}

}
