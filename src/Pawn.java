public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "P";
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
    public boolean movement(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column == toColumn) {
            int[][] positions = new int[][]{
                    {line + 2, column}, {line + 1, column},
                    {line - 2, column}, {line - 1, column}};

            if (positions[0][0] == toLine && getColor().equals("White") && line == 1) {
                return true;
            }

            if (positions[2][0] == toLine && getColor().equals("Black") && line == 6) {
                return true;
            }

            if ((positions[1][0] == toLine && getColor().equals("White")) ||
                    (positions[3][0] == toLine && getColor().equals("Black"))) {
                return true;
            }
        } else if(checkErrorStep(line, column, toLine, toColumn)){
            int[][] positions = new int[][]{
                    {line + 1, column + 1}, {line + 1, column - 1},
                    {line - 1, column + 1}, {line - 1, column - 1}};
            for (int i = 0; i < positions.length; i++) {
                if (positions[i][0] == toLine && positions[i][1] == toColumn) {
                    if (chessBoard.board[line][column] != null
                            && chessBoard.board[line][column].getColor() != chessBoard.board[toLine][toColumn].getColor()) {
                        return true;
                    }
                }
            }
        } return false;
    }
}
