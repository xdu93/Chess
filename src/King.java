public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPitchPoint(chessBoard, line, column, toLine, toColumn)) {
            if (checkErrorStep(line, column, toLine, toColumn)) {
                if (movement(chessBoard, line, column, toLine, toColumn)) {
                    return crossing(chessBoard, line, column, toLine, toColumn);
                }
            }
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) &&
                                chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }

    @Override
    public boolean movement(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1){
            return false;
        }

        if (isUnderAttack(chessBoard, toLine, toColumn)){
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null) {
            return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }

        return true;
    }
}
