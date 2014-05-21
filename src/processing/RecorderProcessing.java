package processing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import processing.core.PGraphics;

/**
 * 
 * @author mehdi & guillaume
 * 
 *         Class which record the current image in the full Window, and display
 *         it on a second screen '/!\ Not yet functional
 * 
 */
public class RecorderProcessing extends AbstractProcessing {

	PGraphics p;
	/**
	 * ProcessingSketch Recorded
	 */
	AbstractProcessing model;

	public RecorderProcessing(Container parent) {
		super(parent);
		System.out.println("Recorder : " + parent.getWidth());
	}

	public void majForme(String s, String path) {

	}

	@Override
	public void setup() {
		System.out.println("Setup : " + parent.getWidth());
		p = new PGraphics();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		p = createGraphics((int) screenSize.getWidth(),
				(int) screenSize.getHeight());
	}

	@Override
	public void draw() {
		p.beginDraw();
		p.endDraw();
	}

	public void setModel(AbstractProcessing model) {
		if (!(model instanceof RecorderProcessing)) {
			this.model = model;
			p = model.recorder;
		}
	}
}
