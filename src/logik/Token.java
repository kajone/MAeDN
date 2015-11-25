package logik;

public class Token {

	private int position;
	private int id;
	
	public Token(int id){
		this.id = id;
		position = -1;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosistion(int newPosition){
		this.position = newPosition;
	}

}
