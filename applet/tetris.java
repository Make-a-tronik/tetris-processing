import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class tetris extends PApplet {

public int[] colors={
  color(255,0,0),
  color(0,0,255),
  color(155,39,240),
  color(247,255,44),
  color(20,230,247),
  color(255,179,57),
  color(0,255,0),
  color(120)
  };

  PFont font;

pieza piece;
tablero board;
marcador score;
juego game;
int t1;

public void setup(){

  font=loadFont("font.vlw");
  piece = new pieza(PApplet.parseInt(random(0,7 )),17,10,30,colors);
  board = new tablero(17,10,30,colors);
  score = new marcador(font);
  game = new juego(piece,board,score);

  noCursor();
  frameRate(30);
  size(480,510);
  background(128);
  board.draw();

  t1=millis();
};

public void draw(){
  background(128);
 game.draw();

  if(!game.getStatus()){

    //Para bajar la pieza rapidamente
    if (keyPressed){
      if (key==CODED){
        if (keyCode==DOWN){
          if (millis()-t1>=20){
            t1=millis();
            if (game.validMove("DOWN")){
              piece.move("DOWN");
            }
            else{
              game.saveBoard();
              score.linesUp(board.checkLines());
              piece.restart(PApplet.parseInt(random(0,7 )));
            }
          }
        }
      }
    }

    //Baja automaticamente la pieza
    if (millis()-t1>=score.vel){
      t1=millis();
      if (game.validMove("DOWN")){
        piece.move("DOWN");
      }
      else{
        game.saveBoard();
        score.linesUp(board.checkLines());
        piece.restart(PApplet.parseInt(random(0,7 )));
      }
    }
  }
  else{
    fill(255,0,0);
    textSize(70);
    text("Game Over",50,250);
    textSize(30);
    text("Presione R para reiniciar",50,320);
  }


};

public void keyPressed() {

  if(!game.getStatus()){
    if ((key=='z' || key=='Z')) { 
      piece.restart(PApplet.parseInt(random(0,6)));
    }

    if (key==CODED){
      if (keyCode==LEFT){
        if (game.validMove("LEFT")){
          piece.move("LEFT");
        }
      }
      if (keyCode==RIGHT){
        if (game.validMove("RIGHT")){
          piece.move("RIGHT");
        }
      }
      if (keyCode==UP){
        if (game.validMove("ROTATE")){
          piece.rotate();
        }
      }
    }
  }
  else{
    if ((key=='r' || key=='R')) { 
      game.restart();
    }
  }
}










class juego{

  pieza piece;
  tablero board;
  marcador score;

  int rot;
  private boolean gameOver=false;

  juego(pieza p, tablero b, marcador s){
    piece=p;
    board=b;
    score=s;
  }

  public void draw(){
    board.draw();
    piece.draw();
    score.draw();
  }

  public boolean validMove(String w){
    if (w=="DOWN"){
      //Llego a tope en el borde inferior
      if(piece.pivot[1]+2+piece.offset[piece.type][piece.rot][3]+1>=board.sizeY()+1) return false;

      for (int x=0;x<=4;x++){
        for (int y=0;y<=4;y++){
          if(piece.form[piece.type][piece.rot][y][x]!=0){
            if(x+piece.pivot[0]-3>=0 && y+piece.pivot[1]-3>=0 ){
              if(board.checkBlock(x+piece.pivot[0]-3,y+piece.pivot[1]-2)==false) return false;
            }
          }
        }
      }

    }

    if(w=="RIGHT"){
      //Que no salga del borde derecho
      if(piece.pivot[0]+2+piece.offset[piece.type][piece.rot][2]+1>=board.sizeX()+1) return false;

      for (int x=0;x<=4;x++){
        for (int y=0;y<=4;y++){
          if(piece.form[piece.type][piece.rot][y][x]!=0){
            if(x+piece.pivot[0]-3>=0 && y+piece.pivot[1]-3>=0 ){
              if(board.checkBlock(x+piece.pivot[0]-2,y+piece.pivot[1]-3)==false) return false;
            }
          }
        }
      }

    }

    if(w=="LEFT"){
      //Que no salga del borde izquierdo
      if(piece.pivot[0]-2-piece.offset[piece.type][piece.rot][0]-1<=0) return false;

      for (int x=0;x<=4;x++){
        for (int y=0;y<=4;y++){
          if(piece.form[piece.type][piece.rot][y][x]!=0){
            if(x+piece.pivot[0]-3>=0 && y+piece.pivot[1]-3>=0 ){
              if(board.checkBlock(x+piece.pivot[0]-4,y+piece.pivot[1]-3)==false) return false;
            }
          }
        }
      }

    }

    if(w=="ROTATE"){

      rot=piece.rot+1;
      if (rot>3){
        rot=0;
      }


      //Si sale de bordes
      if(piece.pivot[0]+2+piece.offset[piece.type][rot][2]>=board.sizeX()+1) return false;
      if(piece.pivot[0]-2-piece.offset[piece.type][rot][0]<=0) return false;



      //Si se encima
      for (int x=0;x<=4;x++){
        for (int y=0;y<=4;y++){
          if(piece.form[piece.type][rot][y][x]!=0){
            if(x+piece.pivot[0]-3>=0 && y+piece.pivot[1]-3>=0 ){
              if(board.checkBlock(x+piece.pivot[0]-3,y+piece.pivot[1]-3)==false) return false;
            }
          }
        }
      }
    }

    return true; 
  }

  public void saveBoard(){
    for (int x=0;x<=4;x++){
      for (int y=0;y<=4;y++){
        if(piece.form[piece.type][piece.rot][y][x]!=0){
          if(!board.saveBlock(x+piece.pivot[0]-3,y+piece.pivot[1]-3,piece.type)) gameOver();
        }
      }
    }
  }

  public void gameOver(){
    gameOver=true;
  }

  public boolean getStatus(){
    return gameOver;
  }

  public void restart(){
    piece.restart(PApplet.parseInt(random(0,6)));
    score.restart();
    board.restart();
    gameOver=false;
  }

}




class marcador{

  private PFont font;
  private int lines,linesAux=0,score=0,level=1,vel=500;

  marcador(PFont f){
    font=f;
  }

  public void draw(){
    textSize(30);
    fill(255);
    text("Tetris :e",340,20);
    text("Puntos",340,80);
    text(score,340,140);
    text("Lineas",340,200);
    text(lines,340,260);
    text("Nivel",340,320);
    text(level,340,380);
  }

  private void scoreUp(int l){
    score+=level*10*l;
  }

  public void linesUp(int l){
    lines+=l;
    scoreUp(l);
    linesAux+=l;
    if(linesAux>=30){
      linesAux-=30;
      levelUp();
    }
  }

  private void levelUp(){
    level++;
    vel-=50;
  }

  public void restart(){
lines=0;
linesAux=0;
score=0;
level=1;
  }

}



class pieza{
  final private int[][][][] form = {
    //----------------------------I-----------------------------------------------------------
    {
      {
        {
          0,0,0,0,0                                                     }
        ,
        {
          0,0,0,0,0                                                              }
        ,
        {
          0,1,2,1,1                                                               }
        ,
        {
          0,0,0,0,0                                                         }
        ,
        {
          0,0,0,0,0                                                         }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                        }
        ,
        {
          0,0,2,0,0                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                        }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                        }
        ,
        {
          1,1,2,1,0                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                        }
      }
      ,
      {
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                       }
        ,
        {
          0,0,2,0,0                                                                                                                                       }
        ,
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
    }
    ,
    //----------------------------Cuadrado-----------------------------------------------------------
    {
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,2,1,0                                                                                                                                        }
        ,
        {
          0,0,1,1,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                       }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,0,1,1,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                       }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,0,1,1,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                       }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,0,1,1,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
    }
    ,
    //----------------------------L-----------------------------------------------------------
    {
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,2,1,1                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                       }
        ,
        {
          0,1,2,0,0                                                                                                                                       }
        ,
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                       }
        ,
        {
          1,1,2,0,0                                                                                                                                       }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                       }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
    }
    ,
    //----------------------------L espejo-----------------------------------------------------------
    {
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,2,1,1                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                       }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                       }
        ,
        {
          1,1,2,0,0                                                                                                                                       }
        ,
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                       }
        ,
        {
          0,1,2,0,0                                                                                                                                       }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
    }
    ,
    //----------------------------Z-----------------------------------------------------------
    {
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,1,1,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,1,0,0,0                                                                                                                                       }
        ,
        {
          0,1,2,0,0                                                                                                                                       }
        ,
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,1,1,0                                                                                                                                       }
        ,
        {
          0,1,2,0,0                                                                                                                                       }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                       }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,0,0,1,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
    }
    ,
    //----------------------------Z espejo-----------------------------------------------------------
    {
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,1,2,0,0                                                                                                                                        }
        ,
        {
          0,0,1,1,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                                                                       }
        ,
        {
          0,1,2,0,0                                                                                                                                       }
        ,
        {
          0,1,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,1,1,0,0                                                                                                                                       }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                        }
        ,
        {
          0,0,0,1,0                                                                                                                                       }
        ,
        {
          0,0,2,1,0                                                                                                                                       }
        ,
        {
          0,0,1,0,0                                                                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
      }
    }
    ,
    //----------------------------T-----------------------------------------------------------
    {
      {
        {
          0,0,0,0,0                                                                                                                                    }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
        ,
        {
          0,1,2,1,0                                                                                                                                 }
        ,
        {
          0,0,1,0,0                                                                                                                                    }
        ,
        {
          0,0,0,0,0                                                                                                                                }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                    }
        ,
        {
          0,0,1,0,0                                                                                                                                   }
        ,
        {
          0,1,2,0,0                                                                                                                                   }
        ,
        {
          0,0,1,0,0                                                                                                                                    }
        ,
        {
          0,0,0,0,0                                                                                                                                }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                    }
        ,
        {
          0,0,1,0,0                                                                                                                                   }
        ,
        {
          0,1,2,1,0                                                                                                                                   }
        ,
        {
          0,0,0,0,0                                                                                                                                    }
        ,
        {
          0,0,0,0,0                                                                                                                                }
      }
      ,
      {
        {
          0,0,0,0,0                                                                                                                                    }
        ,
        {
          0,0,1,0,0                                                                                        }
        ,
        {
          0,0,2,1,0                                                                                        }
        ,
        {
          0,0,1,0,0                                                                                        }
        ,
        {
          0,0,0,0,0                                                                                        }
      }
    }
  };

  final private int[][][] offset={
    {
      {
        -1,-2,0,-2                                                                  }
      ,{
        -2,-1,-2,0                                                                  }
      ,{
        0,-2,-1,-2                                                                  }
      ,{
        -2,0,-2,-1                                                                  }
    }
    ,
    {
      {
        -2,-2,-1,-1                                                                  }
      ,{
        -2,-2,-1,-1                                                                  }
      ,{
        -2,-2,-1,-1                                                                  }
      ,{
        -2,-2,-1,-1                                                                  }
    }
    ,
    {
      {
        -2,-2,0,-1                                                                  }
      ,{
        -1,-2,-2,0                                                                  }
      ,{
        0,-1,-2,-2                                                                  }
      ,{
        -2,0,-1,-2                                                                  }
    }
    ,
    {
      {
        -2,-1,0,-2                                                                  }
      ,{
        -2,-2,-1,0                                                                  }
      ,{
        0,-2,-2,-1                                                                  }
      ,{
        -1,0,-2,-2                                                                  }
    }
    ,
    {
      {
        -1,-2,-1,-1                                                                  }
      ,{
        -1,-1,-2,-1                                                                  }
      ,{
        -1,-1,-1,-2                                                                  }
      ,{
        -2,-1,-1,-1                                                                  }
    }
    ,
    {
      {
        -1,-2,-1,-1                                                                  }
      ,{
        -1,-1,-2,-1                                                                  }
      ,{
        -1,-1,-1,-2                                                                  }
      ,{
        -2,-1,-1,-1                                                                  }
    }
    ,
    {
      {
        -1,-2,-1,-1                                                                  }
      ,{
        -1,-1,-2,-1                                                                  }
      ,{
        -1,-1,-1,-2                                                                  }
      ,{
        -2,-1,-1,-1                                                                  }
    }
    ,
  };

  public int[] pivot= new int[2];//[x][y]
  private int rot,pX,pY;
  int type;
  final private int block;

  pieza(int ptype,int h,int w,int b, int[] col){
    int[] colors=col;
    type=ptype;
    rot=0;
    block=b;
    pX=block*offset[type][rot][0]+4*block;
    pY=-5*block-block*offset[type][rot][3];
    pivot[0]=(3+offset[type][rot][0])+4;
    pivot[1]=-2-offset[type][rot][3];
  }

  public void draw(){
    stroke(255);
    fill(colors[type]);
    for (int x=0;x<=4;x++){
      for (int y=0;y<=4;y++){
        if(form[type][rot][y][x]!=0){
          stroke(255);
          fill(colors[type]);
          rect(pX+block*x,pY+block*y,block,block);
        }
//        else{
//          stroke(255);
//          fill(0);
//          rect(pX+block*x,pY+block*y,block,block);
//        }
      }
    }
  }

  public void move(String w){
    if (w=="DOWN"){    
      pY+=block;
      pivot[1]+=1;
    }
    else if(w=="RIGHT"){
      pX+=block;
      pivot[0]+=1;
    }
    else if(w=="LEFT"){
      pX-=block;
      pivot[0]-=1;
    }
  }


  public void rotate(){
    rot+=1;
    if (rot>3){
      rot=0;
    }
  }

  public void restart(int ptype){
    type=ptype;
    rot=0;
    pX=block*offset[type][rot][0]+4*block;
    pY=-150-block*offset[type][rot][3];
    pivot[0]=(3+offset[type][rot][0])+4;
    pivot[1]=-2-offset[type][rot][3];
  }
}
class tablero{
  final private int gridHeight, gridWidth, block;
  public int[][] grid;

  tablero(int h, int w, int b, int[] col){
    int[] colors=col;
    gridHeight=h;
    gridWidth=w;
    block=b;
    grid =new int[gridHeight][gridWidth];

    for (int x=0;x<=gridWidth-1;x++){
      for (int y=0;y<=gridHeight-1;y++){
        grid[y][x]=7;
      } 
    }
  }

  public void draw(){
    for (int x=0;x<=gridWidth-1;x++){
      for (int y=0;y<=gridHeight-1;y++){
        if(grid[y][x]<=6){
          stroke(255);
          fill(colors[grid[y][x]]);
          rect(block*x,block*y,block,block);
        }
        else{
          stroke(0);
          fill(colors[7]);
          rect(block*x,block*y,block,block);
        }
      }
    }
  }

  public int sizeX(){
    return gridWidth;
  }

  public int sizeY(){
    return gridHeight;
  }

  public boolean saveBlock(int x, int y, int c){
    try{
      grid[y][x]=c;
      return true;
    }
    catch(Exception e){
      println("Game Over");
      return false;
    }
  }

  public boolean checkBlock(int x, int y){
    try{
      if(grid[y][x]!=7){
        return false;
      }
      else{
        return true;
      }
    }
    catch(Exception e){
      return false;
    }
  }

  private void eraseLine(int Line){
    for (int y=Line;y>=1;y--){
      for (int x=0;x<=gridWidth-1;x++){
        grid[y][x]=grid[y-1][x];
      }
    }

  }

  public int checkLines(){
    int z=0,l=0;
    println();
    for (int y=0;y<=gridHeight-1;y++){
      z=0;
      for (int x=0;x<=gridWidth-1;x++){
        if(grid[y][x]<=6) z++;
      }
      if(z==10) {
        eraseLine(y); 
        l++;
      }
    }
    return l;
  }

  public void restart(){
    for (int x=0;x<=gridWidth-1;x++){
      for (int y=0;y<=gridHeight-1;y++){
        grid[y][x]=7;
      } 
    }
  }

};






  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "tetris" });
  }
}
