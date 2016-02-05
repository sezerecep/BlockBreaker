import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bloklar extends Rectangle
{

	Image pic;
	int dx=2;
	int dy=-2;
	boolean destroyed=false;
	
	Bloklar (int x ,int y ,int h, int w, String s)
	{
	this.setBounds(x, y, w, h);
	pic=Toolkit.getDefaultToolkit().getImage(s);
	}
	public void draw (Graphics g, Component c){
		if(!destroyed)
		{
			g.drawImage(pic,x,y,width,height,c)	;
		}
		
	}
	
}