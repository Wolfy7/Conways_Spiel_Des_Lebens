import java.util.Random;


public class Cell {
	
	public static int WIDTH = 10;
	public static int HEIGHT = 10;
	private Boolean boAlive;
	private Boolean boNextAlive;
	private int x;
	private int y;
	private Random rand = new Random();
	
	
	public Cell(int x, int y){
		
		this.x = x * 10 + x;
		this.y = y * 10 + y;
		this.boAlive = rand.nextBoolean();
		this.boNextAlive = this.boAlive;
	}
	
	public Boolean isAlive(){
		return this.boAlive;
	}
	
	public void setAlive(){
		this.boAlive = this.boNextAlive;
	}
	
	public void setNextAlive(Boolean b){
		this.boNextAlive = b;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
