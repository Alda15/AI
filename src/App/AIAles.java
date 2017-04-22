
/*
 * Postup akce
 * 1) Vytvori pole pro ulozeni hodnoty nalezeneho policka
 * 1) Vyhleda '-'
 * 2) 
 * 
 * 
 * 
 */
package App;
 

import java.util.ArrayList;

public class AIAles {
    
        private static Tile move;
        private static int c, r;
        private static int col, row;
        private static int moveNumber;
        private static char enemySign;
        
        private static Tile[] bestShelobsOffsprings;
    	private static int ShelobsOffspringNumber = 1, webSize, spiderSize, preyRotation, preyPosition, spiderlings, bestShelobsOffspringsSpiderlings = 0;
    	private static Tile[][] web;
        
    public static Tile getMove(Tile[][] board, char mySign){
            //DEJ SOUPEROVI ZNACKU    
            switch(mySign){
                case 'x': 
                          enemySign = 'o';
                          break;
                case 'o': 
                          enemySign = 'x';
                          break;
            }
            //Pole tahu
            bestShelobsOffsprings = new Tile[webSize * webSize + 2];
    		Tile bestShelobsOffspring = board[webSize / 2][webSize / 2];
    		bestShelobsOffsprings[0] = bestShelobsOffspring;
             
            //KONTROLA HRACIHO POLE
            for(row = 0; row < board.length; row++){
                for(col = 0; col < board.length; col++){
                	
                    if(board[row][col].getContent() == '-'){
                        //System.out.println(board[col][row].getContent() + " " + col + " " + row);
                        signOfEnemyCheck(board, board[row][col]);
                        //threatHigh(board[row][col]);
                        //break;                 
                    }else {
      
                    }
                    
                }
            }
     
        //KONECNE RESENI
        //board[4][2].getContent() [radek][sloupec]
        move = board[2][8+moveNumber];
        moveNumber++;
        System.out.println("Move: #"+moveNumber);
        return move;   
    }
//KONTROLA SMERU    
    private static void signOfEnemyCheck(Tile[][] board, Tile tile){
       
        int threat = 0;
        int enemySignChain = 0;
        
        System.out.println("cislo sloupce: " + col);
        
        Check:
        for(int cisSloupce = -5; cisSloupce <= 5; cisSloupce++){ 
            for(;col + cisSloupce >= 0 && col + cisSloupce < board.length;){
            	
                if(board[row][col + cisSloupce].getContent() == enemySign){
                   threat += 10;
                   threatHigh(board[row][col], threat);

                } else {
                  threat = enemySignChain * 10;
                  enemySignChain = 0;
                  threatHigh(board[row][col], threat);
                    }
                //}
            //System.out.println(radek);
            System.out.println(board[row][col + cisSloupce].getContent() + " R " + row + " C " + (col+cisSloupce) + " S " + cisSloupce + " Threat: " + threat + " Chain: " + enemySignChain);
            continue Check;
            }
        } 
    }
    
    private static void threatHigh(Tile tile, int threat) {
        //System.out.println("R:" + tile.getRow() + " C:" + tile.getCol() + " threatHighsracka "+threat);
    }
    
    //private static void 
}