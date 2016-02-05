
public class Animate implements Runnable {
	BlokPaneli p;
	Animate(BlokPaneli bp)
	{
		p=bp;		
	}
	@Override
	public void run() {
		
		while(true)
		{
			
				p.update();
			
			try
			{
			Thread.sleep(10);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
	}
	

	}
}
