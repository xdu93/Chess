public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPitchPoint(chessBoard, line, column, toLine, toColumn)) {
            if (attack(chessBoard, line, column, toLine, toColumn)) {
                if (checkErrorStep(line, column, toLine, toColumn)) {
                    if (movement(chessBoard, line, column, toLine, toColumn)) {
                        return crossing(chessBoard, line, column, toLine, toColumn);
                    }
                }
            } else return false;
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean movement(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            return true;
        }
        return false;
    }

}
