package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import code.Board;
import code.Driver;
import code.MovePawnHandler;
import code.RotateExtraTileHandler;
import code.Tile;
import gui.Console.DeleteConsole;


public class MultiLayers extends JFrame {
	protected Board _board;
	protected int size =1;
	protected int ButtonSize = 60;
	protected int FontSize = 20;
	protected int windowSizeX = 900;
	protected int windowSizeY = 750;
	protected String[] p;
	protected Play play;
	JLayeredPane lp;
	JPanel a = new JPanel();
	
	Driver driver;
	Tile tile;
	
	//constructor
  public MultiLayers(String[] players, Tile t) {
    super("Dragon's Labryinth");
    
    driver = new Driver(tile);
    tile = t;
    
    _board = new Board();
    p = players;
    play = new Play(p);
    setSize((int) windowSizeX, windowSizeY);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    //size 1
    if(width<1450){
    	setSize(1);
    }	
    //size 2
    else if(width>=1450 && width<2000){
    	setSize(2);
    }
    //size 3
    else if(width>=2000){
    	setSize(3);
    }
  }
 
  /*
   * This method makes the main gaming GUI
   * it uses classes ScoreTable, GameBoard, Extra, PawnLayer, and TokenLayer.
   */
  public void initualize(){
	  setSize((int) windowSizeX, windowSizeY);
	  lp = getLayeredPane();
	  lp.removeAll();
	  
	  //score table 1
	  initualizeScoreBoard();
	  
	  //turnTable 2
	  initualizeTurnTable();
	
	  //Console 3
	  updateConsole("");
	  
	  //create board 0
	  for(int i=0;i<=6;i++){
		  for(int j=0;j<=6;j++){
			  GameBoard gb = new GameBoard(_board, size, ButtonSize,i, j);
			  int[] pos = {i,j};
			  MovePawnHandler mph = new MovePawnHandler(_board, pos.clone(), play, this);
			  gb.getButton().addActionListener(mph);
			  lp.add(gb.getButton(), new Integer(0));
		  }
	  }
	  //create triangles 4
	  Triangle tri = new Triangle(_board, ButtonSize, size, play, this);
	  for(int i=0; i<12; i++){
		  lp.add(tri.getTri()[i], new Integer(4));
	  }
		  
	  //create extra 5
	  Extra ex = new Extra( _board, ButtonSize , size);
	  RotateExtraTileHandler reth = new RotateExtraTileHandler(_board.get_ExtraTile(), this);
	  ex.getButton().addActionListener(reth);
	  lp.add(ex.getButton(), new Integer(5));
	  
	  //create size Button 6
	  SizeButton sizeb = new SizeButton(ButtonSize, FontSize, size, this);
	  lp.add(sizeb.getButton(), new Integer(6));
	  
	  //create skip button 7
	  SkipButton sb = new SkipButton(ButtonSize, FontSize, play, this);
	  lp.add(sb.getButton(), new Integer(7));

	  //create tokens 8
	  initualizeToken();
	  
	  //creating pawns 9
	  for(int i=0; i<p.length; i++){
		  PawnLayer pl = new PawnLayer(i+1, _board, size, ButtonSize);
		  lp.add(pl.getLabel(), new Integer(9));
	  }
	  
	  //create use magic wand button 10
	  MagicWandButton mw = new MagicWandButton(ButtonSize, FontSize, play, this, _board);
	  lp.add(mw.getButton(), new Integer(10) );
	  
	  //create formula Table 11
	  initualizeFormula();
	  repaint();
	  
	  // create save button 12
	  SaveGame sg = new SaveGame(ButtonSize, FontSize, play, this, driver, _board, tile);
	  lp.add(sg.getButton(), new Integer(12));
  }
  public void initualizeFormula(){
	  lp = getLayeredPane();
	  removeLayer(lp, 11);
	  
	  for(int i=0; i<p.length; i++){
		  FormulaTable ft = new FormulaTable(p[i], _board, i+1, ButtonSize, FontSize);
		  lp.add(ft.getLabel(), new Integer(11));
	  }

  }
  
  public void initualizeScoreBoard(){
	  lp = getLayeredPane();
	  removeLayer(lp, 1);
	  
	  for(int i=0; i<p.length; i++){
		  ScoreTable st = new ScoreTable(p[i], _board, i+1, ButtonSize, FontSize);
		  lp.add(st.getLabel(), new Integer(1));
	  }

  }

  public void initualizeToken(){
	  lp = getLayeredPane();
	  removeLayer(lp, 8);
	  
	  for(int i=0; i<21; i++){
		  TokenLayer tl = new TokenLayer(i+1, _board, ButtonSize, size);
		  lp.add(tl.getLabel(), new Integer(8));
	  }
	  repaint();

  }
  
  public void initualizePawn(){

	  lp = getLayeredPane();
	  removeLayer(lp, 9);
	  
	  for(int i=0; i<p.length; i++){
		  PawnLayer pl = new PawnLayer(i+1, _board, size, ButtonSize);
		  lp.add(pl.getLabel(), new Integer(9));
	  }
	  System.out.println(lp.getComponentCountInLayer(2));

  }
  
  public void initualizeTurnTable(){
	  lp = getLayeredPane();
	  removeLayer(lp, 2);
	  
	  TurnTable tt = new TurnTable(p, ButtonSize, FontSize, play);
	  lp.add(tt.getLabel(), new Integer(2));
	  
  }
  
   public static int removeLayer(JLayeredPane pane, int layer) {
	  Component[] comps = pane.getComponentsInLayer(layer);
	  for(int i = 0; i < comps.length; i++) {
		  pane.remove(pane.getIndexOf(comps[i]));    
	  }
	  return comps.length;
  } 
  public void updateConsole(String message){
	  Console console = new Console(message, ButtonSize, FontSize);
	  lp.add(console.getLabel(), new Integer(3));

	  if(message!=""){
		  DeleteConsole dc = console.new DeleteConsole(this);
		  Timer timer = new Timer(5000, dc);
		  timer.setRepeats(false);
		  timer.start();
	  }
  }
  
  public void setSize(int s){
	  if(s == 1){
		  ButtonSize = 60;
		  FontSize = 14;
		  windowSizeX = 900;
		  windowSizeY = 750;
		  size = 1;
		  initualize();
	  }

	  else if(s == 2){
		  ButtonSize = 100;
		  FontSize = 20;
		  windowSizeX = 1500;
		  windowSizeY = 1200;
		  size = 2;
		  initualize();	
	  }

	  else if(s == 3){
		  ButtonSize = 170;
		  FontSize = 40;
		  windowSizeX = 2500;
		  windowSizeY = 2000;
		  size = 3;
		  initualize();
	  }

  }
  
  public int gameSize(){
	  return size;
  }
  
}


