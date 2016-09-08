public color[] colors={
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

void setup(){

  font=loadFont("font.vlw");
  piece = new pieza(int(random(0,7 )),17,10,30,colors);
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

void draw(){
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
              piece.restart(int(random(0,7 )));
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
        piece.restart(int(random(0,7 )));
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

void keyPressed() {

  if(!game.getStatus()){
    if ((key=='z' || key=='Z')) { 
      piece.restart(int(random(0,6)));
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










