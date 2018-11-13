import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Panel extends JPanel{
	
	Cell aCells[][];

	public Panel(int width, int height) {
		// TODO Auto-generated constructor stub
		
		//System.out.println(width + " " + height);
		
		aCells = new Cell[width / (Cell.WIDTH+1)][height / (Cell.HEIGHT+1)];
		
		for(int i = 0; i < aCells.length; i++){
			for(int j = 0; j < aCells[0].length; j++){
				//System.out.println(i + " " + j);
				aCells[i][j] = new Cell(i,j);
			}
		}
		
		/*
		aCells[10][10].setNextAlive(true);  //
		aCells[10][11].setNextAlive(true);	//  BLINKER
		aCells[10][12].setNextAlive(true);	//
		*/
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		for(int i = 0; i < aCells.length; i++){
			for(int j = 0; j < aCells[0].length; j++){
				//System.out.println(i + " " + j);
				//System.out.println(aCells[i][j].isAlive());
				
				aCells[i][j].setAlive();
				
				if(aCells[i][j].isAlive()){
					g.setColor(Color.GREEN);
				}else{
					g.setColor(Color.GRAY);	
				}	
				g.fillRect(aCells[i][j].getX()+1, aCells[i][j].getY()+1, Cell.WIDTH, Cell.HEIGHT);
			}
		}
	}
	
	public void updateCells(){
		int iCnt;
		for(int i = 0; i < aCells.length; i++){
			for(int j = 0; j < aCells[0].length; j++){
				iCnt = 0;
				
				if( (i-1) >= 0 ){
					if(aCells[i-1][j].isAlive()) iCnt++;
					if( (j-1) >= 0 ) if(aCells[i-1][j-1].isAlive()) iCnt++;
					if( (j+1) < aCells[0].length ) if(aCells[i-1][j+1].isAlive()) iCnt++;
				}
					
				if( (j-1) >= 0 ) if(aCells[i][j-1].isAlive()) iCnt++;
				if( (j+1) < aCells[0].length ) if(aCells[i][j+1].isAlive()) iCnt++;
				
				if( (i+1) < aCells.length ){
					if(aCells[i+1][j].isAlive()) iCnt++;
					if( (j-1) >= 0 ) if(aCells[i+1][j-1].isAlive()) iCnt++;
					if( (j+1) < aCells[0].length ) if(aCells[i+1][j+1].isAlive()) iCnt++;
				}
				
				
				if(iCnt == 2){
					//
				}else if(iCnt == 3){
					aCells[i][j].setNextAlive(true);
				}else{
					aCells[i][j].setNextAlive(false);
				}

			}
		}
	}
}
