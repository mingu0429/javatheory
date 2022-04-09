package oopCh9;

import java.awt.*;

public class DrawObject {
	public static final int  NIL = 0;
	public static final int  RECT = 2;
	private static int  m_ID_available = 0;

	void initId(int val) { m_ID_available = val; }
	protected static  int assignId() {    ++ m_ID_available; return m_ID_available;    }

	int  id, type;
	int w, h;
	Point p0, p1;
	boolean  select, fill;
	Color color;

	DrawObject() {
		id = assignId();
	}
	void setPoint(Point p) { p1 = p; w = p1.x - p0.x; h = p1.y - p0.y; }
	void addPoint(Point p) {}
	boolean getSelect() { return select; }
	void  setSelect(boolean val) { select = val; }
	void paint(Graphics g) {}
	void  drawMarker(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(p0.x-5, p0.y-5, 5, 5);
		g.fillRect(p0.x+w+1, p0.y-5, 5, 5);
		g.fillRect(p0.x-5, p0.y+h+1, 5, 5);
		g.fillRect(p0.x+w+1, p0.y+h+1, 5, 5);
	}
}
class Rect extends DrawObject {
	Rect() { super(); type = DrawObject.RECT; }
	Rect(Point p0, Point p1) { this(); this.p0 = p0; setPoint(p1); }
//	Rect(int type) { super(); this.type = type /*Drawbject.NIL*/; }
	void paint(Graphics g) {
		g.drawRect(p0.x, p0.y, w, h);
		if (select) drawMarker(g);
	}

}
