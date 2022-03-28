
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
        if (toLine >= 0 && toColumn >= 0 && toLine <= 7 && toColumn <= 7 &&
                line >= 0 && column >= 0 && line <= 7 && column <= 7) {
            if (line != toLine && column != toColumn) {
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
            }
        } else return false;
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
