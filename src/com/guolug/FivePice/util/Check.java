package com.guolug.FivePice.util;

import com.guolug.FivePice.Init.ChessPieces;

public class Check {
    /**
     * 水平扫描
     *
     * @param chessPieces 一个棋子对象
     * @return 是否连着5个棋子
     */
    public static int level(ChessPieces[][] chessPieces) {
        int countBlack;
        int countWhite;
        for (int i = 0; i < chessPieces.length; i++) {
            countWhite = 0;
            countBlack = 0;
            for (int j = 0; j < chessPieces[0].length; j++) {
                if (chessPieces[i][j].getIsCamp() == 1) {
                    //黑方
                    countBlack++;
                    countWhite = 0;
                    if (countBlack == 5) {
                        return 1;
                    }
                } else if (chessPieces[i][j].getIsCamp() == 2) {
                    //黑方
                    countBlack = 0;
                    countWhite++;
                    if (countWhite == 5) {
                        return 2;
                    }
                } else {
                    countWhite = 0;
                    countBlack = 0;
                }
            }
        }
        return 0;
    }

    public static int vertical(ChessPieces[][] chessPieces) {
        int countBlack;
        int countWhite;
        for (int j = 0; j < chessPieces[0].length; j++) {
            countWhite = 0;
            countBlack = 0;
            for (int i = 0; i < chessPieces.length; i++) {
                if (chessPieces[i][j].getIsCamp() == 1) {
                    // 黑方
                    countBlack++;
                    countWhite = 0;
                    if (countBlack == 5) {
                        return 1;
                    }
                } else if (chessPieces[i][j].getIsCamp() == 2) {
                    // 白方
                    countBlack = 0;
                    countWhite++;
                    if (countWhite == 5) {
                        return 2;
                    }
                } else {
                    countWhite = 0;
                    countBlack = 0;
                }
            }
        }
        return 0;
    }

    public static int  leadingDiagonal(ChessPieces[][] chessPieces) {
        int boardSize = Math.min(chessPieces.length, chessPieces[0].length);
        for (int k = 0; k < boardSize - 4; k++) {
            for (int offset = 0; offset < boardSize - k; offset++) {
                int countBlack = 0;
                int countWhite = 0;
                int row = k + offset;
                int col = offset;
                while (row < chessPieces.length && col < chessPieces[0].length) {
                    if (chessPieces[row][col].getIsCamp() == 1) {
                        // 黑方
                        countBlack++;
                        countWhite = 0;
                        if (countBlack == 5) {
                            return 1;
                        }
                    } else if (chessPieces[row][col].getIsCamp() == 2) {
                        // 白方
                        countBlack = 0;
                        countWhite++;
                        if (countWhite == 5) {
                           return 2;
                        }
                    } else {
                        countWhite = 0;
                        countBlack = 0;
                    }
                    row++;
                    col++;
                }
            }
        }
        return 0;
    }
    public static int counterDiagonal(ChessPieces[][] chessPieces) {
        int boardSize = Math.min(chessPieces.length, chessPieces[0].length);
        for (int k = 0; k < boardSize - 4; k++) {
            for (int offset = 0; offset < boardSize - k; offset++) {
                int countBlack = 0;
                int countWhite = 0;
                int row = k + offset;
                int col = chessPieces[0].length - 1 - offset;
                while (row < chessPieces.length && col >= 0) {
                    if (chessPieces[row][col].getIsCamp() == 1) {
                        // 黑方
                        countBlack++;
                        countWhite = 0;
                        if (countBlack == 5) {
                           return 1;
                        }
                    } else if (chessPieces[row][col].getIsCamp() == 2) {
                        // 白方
                        countBlack = 0;
                        countWhite++;
                        if (countWhite == 5) {
                           return 2;
                        }
                    } else {
                        countWhite = 0;
                        countBlack = 0;
                    }
                    row++;
                    col--;
                }
            }
        }
        return 0;
    }

}
