import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class BlokPaneli extends JPanel implements KeyListener {
	
	ArrayList <Bloklar> blocks = new ArrayList<Bloklar>();
	Bloklar paddle = new Bloklar(186,400,15,128,"img/paddle.png");
	Bloklar gameover = new Bloklar(100,200,300,300,"img/GameOver.png");
	boolean flag=false;
	ArrayList <Bloklar> ball= new ArrayList <Bloklar>();
	
	Thread thread;
	Animate animate;
	BlokPaneli()
	{
		addKeyListener(this);
		setFocusable(true);
		ball.add(new Bloklar(242,380,16,16,"img/ball.png"));
		for(int i=0;i<10;i++)
		{
			blocks.add(new Bloklar(i*50,0,50,50,"img/BlockB.png"));
			blocks.add(new Bloklar(i*50,50,50,50,"img/BlockR.png"));
			blocks.add(new Bloklar(i*50,100,50,50,"img/BlockP.png"));

		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Bloklar bl:blocks)
		{
			bl.draw(g, this);
		}
		paddle.draw(g, this);
		for(Bloklar bl:ball)
		{
			bl.draw(g,this);
		}
		if(flag)
		{
			gameover.draw(g, this);
		}
		
	}
	
	public void update()
	{
		for(Bloklar ba:ball)
		{
			ba.x+=ba.dx;
			if(ba.x>(getWidth()-32)&&ba.dx>0||ba.x<0)
			ba.dx*=-1;
			if(ba.y<0||ba.intersects(paddle))
				ba.dy*=-1;
			if(ba.y>paddle.y){
				ba.destroyed=true;
				paddle.destroyed=true;
				flag=true;				
				
			}
				
			ba.y+=ba.dy;
			
			for(Bloklar b : blocks)
			{
				if(b.intersects(ba)&&(!b.destroyed))
				{
					b.destroyed=true;
					ba.dy*=-1;
				}
			}
		}
		repaint();
		
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()== KeyEvent.VK_ENTER)
		{
			animate=new Animate(this);
			thread = new Thread(animate);
			thread.start();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT && paddle.x>0)
			paddle.x-=20;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && paddle.x<getWidth()-paddle.width)
			paddle.x+=20;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
