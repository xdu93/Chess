public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPitchPoint(chessBoard, line, column, toLine, toColumn)) {
            if (movement(chessBoard, line, column, toLine, toColumn)){
                return crossing(chessBoard, line, column, toLine, toColumn);
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean movement(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine || column == toColumn) {
            if (attack(chessBoard, line, column, toLine, toColumn)) {
                if (checkErrorStep(line, column, toLine, toColumn)) {
                    return true;
                } else if (line != toLine && column == toColumn) {
                    return true;
                }
            }
        }
        return false;
    }


}
