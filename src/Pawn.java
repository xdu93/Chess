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
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column) && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (line != toLine && column == toColumn) {
                int[][] positions = new int[][]{
                        {line + 2, column}, {line + 1, column},
                        {line - 2, column}, {line - 1, column}};;

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
            }
        }
        return false;
    }


}
