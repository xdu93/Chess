
public class Horse extends ChessPiece {
    public Horse(String color) {
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
                    if (movement(chessBoard, line, column, toLine, toColumn)){
                        return crossing(chessBoard, line, column, toLine, toColumn);
                    }
                }
            } else return false;
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean movement(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        int[][] positions = new int[][]{
                {line - 2, column - 1}, {line - 2, column + 1},
                {line + 2, column - 1}, {line + 2, column + 1},
                {line - 1, column - 2}, {line - 1, column + 2},
                {line + 1, column - 2}, {line + 1, column + 2}};

        for (int i = 0; i < positions.length; i++) {
            if (positions[i][0] == toLine && positions[i][1] == toColumn) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean crossing(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return true;
    }
}
