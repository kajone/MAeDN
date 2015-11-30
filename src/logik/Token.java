package logik;

public class Token {

	private int position;
	private int moveCounter;
	private int id;
	private String color;
	
	public Token(int id, String color){
		this.id = id;
		this.color = color;
		position = -1;
		
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosistion(int newPosition){
		this.position = newPosition;
	}
	
	public int getId(){
		return id;
	}
	
	public String getColor(){
		return color;
	}
	
	
	public void move(int rollResult){
		
	}

	
}
