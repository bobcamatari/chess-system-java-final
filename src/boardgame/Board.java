package boardgame;

public class Board {
	
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if(rows <1 || columns <1) {
			throw new BoardException("Error creating board: precisa ter pelo menos uma Row e uma Column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExist(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces [row][column];
	}
	
	public Piece piece (Position position) {
		if(!posistionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma pe�a nessa posi��o "+position);
		}
		pieces[position.getRow()][position.getColumn()]= piece;
		piece.position = position;
	}
	
	public boolean posistionExists (Position position) {
		return positionExist(position.getRow(), position.getColumn());
		
	}
	
	private boolean positionExist (int row, int column) {
		return row >= 0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!posistionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}

}
