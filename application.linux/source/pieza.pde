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

  pieza(int ptype,int h,int w,int b, color[] col){
    color[] colors=col;
    type=ptype;
    rot=0;
    block=b;
    pX=block*offset[type][rot][0]+4*block;
    pY=-5*block-block*offset[type][rot][3];
    pivot[0]=(3+offset[type][rot][0])+4;
    pivot[1]=-2-offset[type][rot][3];
  }

  void draw(){
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

  void move(String w){
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


  void rotate(){
    rot+=1;
    if (rot>3){
      rot=0;
    }
  }

  void restart(int ptype){
    type=ptype;
    rot=0;
    pX=block*offset[type][rot][0]+4*block;
    pY=-150-block*offset[type][rot][3];
    pivot[0]=(3+offset[type][rot][0])+4;
    pivot[1]=-2-offset[type][rot][3];
  }
}
