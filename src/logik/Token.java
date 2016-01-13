package logik;

public class Token {

	private int position;
//	private int moveCounter;
	private int id;
	private String color;
	
	private int possibleNewPosition = 0;
	
	public int getPossibleNewPosition() {
		return possibleNewPosition;
	}

	public void setPossibleNewPosition(int possibleNewPosition) {
		this.possibleNewPosition = possibleNewPosition;
	}

	public Token(int id, String color){
		this.id = id;
		this.color = color;
		position = -1;
//		moveCounter = 0;
		
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosistion(int newPosition){
		if(newPosition > getHouseEnd()) throw new RuntimeException("wrong bitch");
		this.position = newPosition;
	}
	
	public int getId(){
		return id;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getPlayerId(){
		return getId()/10-1;
	}
	public int houseStart(){
		return 40 + 4 * getPlayerId();
	}
	public int getHouseEnd(){
		return houseStart()+3;
	}
	public boolean inHouse(){
		return position >= houseStart() && position <= getHouseEnd();
	}
	public int getStart(){
		return 10 * getPlayerId(); 
	}
	
}
