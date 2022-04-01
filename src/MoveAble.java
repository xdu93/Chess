public interface MoveAble {

    default boolean checkErrorStep(int line, int column, int toLine, int toColumn) {
        return (line != toLine && column != toColumn) ? true : false;
    }

    default boolean attack(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null ||
                chessBoard.board[line][column].getColor() != chessBoard.board[toLine][toColumn].getColor()) {
            return true;
        }
        return false;
    }

    default boolean checkPitchPoint(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return (chessBoard.checkPos(line) && chessBoard.checkPos(column)
                && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) ? true : false;
    }

    boolean movement(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);


    default String direction(int line, int column, int toLine, int toColumn) {
        //Движение по прямой
        //Слева-направо
        if (line == toLine && column != toColumn && column == Math.min(column, toColumn)) return "lTOr";

        //Справа-налево
        if (line == toLine && column != toColumn && column == Math.max(column, toColumn)) return "rTOl";

        //Снизу-вверх
        if (line != toLine && column == toColumn && line == Math.min(line, toLine)) return "dTOu";

        //Сверху-вниз
        if (line != toLine && column == toColumn && line == Math.max(line, toLine)) return "uTOd";

        //Движение по диагонали
        //Слева-направо снизу-вверх
        if (line != toLine && column != toColumn &&
                line == Math.min(line, toLine) && column == Math.min(column, toColumn)) {
            return "D-lTOr-dTOu";
        }

        //Слева-направо сверху-вниз
        if (line != toLine && column != toColumn &&
                line == Math.max(line, toLine) && column == Math.min(column, toColumn)){
            return "D-lTOr-uTOd";
        }

        //Справа-налево снизу-вверх
        if (line != toLine && column != toColumn &&
                line == Math.min(line, toLine) && column == Math.max(column, toColumn)) {
            return "D-rTOl-dTOu";
        }

        //Справа-налево сверху-вниз
        if (line != toLine && column != toColumn &&
                line == Math.max(line, toLine) && column == Math.max(column, toColumn)) {
            return "D-rTOl-uTOd";
        }

        //буквой Г
        return "Horse";
    }


    default boolean crossing(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        switch (direction(line, column, toLine, toColumn)) {
            case ("lTOr"):
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.board[line][i] != null) return false;
                }
                return true;

            case ("rTOl"):
                for (int i = column - 1; i > toColumn; i--) {
                    if (chessBoard.board[line][i] != null) return false;
                }
                return true;

            case ("dTOu"):
                for (int i = line + 1; i < toLine; i++) {
                    if (chessBoard.board[i][column] != null) return false;
                }
                return true;

            case ("uTOd"):
                for (int i = line - 1; i > toLine; i--) {
                    if (chessBoard.board[i][column] != null) return false;
                }
                return true;

            case ("D-lTOr-dTOu"):
                for (int i = line + 1; i < toLine; i++) {
                    column++;
                    if (chessBoard.board[i][column] != null) return false;
                }
                return true;

            case ("D-lTOr-uTOd"):
                System.out.println("D-lTOr-uTOd");
                for (int i = line - 1; i > toLine; i--) {
                    column++;
                    if (chessBoard.board[i][column] != null) return false;
                }
                return true;

            case ("D-rTOl-uTOd"):
                for (int i = line - 1; i > toLine; i--) {
                    column--;
                    if (chessBoard.board[i][column] != null) return false;
                }
                return true;

            case ("D-rTOl-dTOu"):
                for (int i = line + 1; i < toLine; i++) {
                    column--;
                    if (chessBoard.board[i][column] != null) return false;
                }
                return true;

            default:
                return true;
        }
    }
}
