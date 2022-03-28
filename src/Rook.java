public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column) && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (line == toLine || column == toColumn) {
                if (line == toLine && column != toColumn){
                    return true;
                } else if (line != toLine && column == toColumn){
                    return true;
                }
            } else return false;
        } else return false;
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
