package sound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class FileFreq {

	private ArrayList<float[]> list;
	private int n;

	public FileFreq(int n) {
		this.n = n;
		list = new ArrayList<float[]>();
	}

	public void maj(float[] f) {
		list.add(0, f);
		if (list.size() > n) {
			list.remove(list.size() - 1);
		}
	}

	public float[] getIndex(int i) {
		return list.get(i);
	}

	public int getsize() {
		return list.size();
	}

}