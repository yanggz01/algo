package com.ifeng.yanggz.day7;


/**
 * 计算8皇后问题
 * 8*8的棋盘，每一行放一枚棋子，放满以后要求横、竖和对角线都只有一个棋子
 *
 * 回溯算法
 */
public class Cal8queens {

    private void cal8queens(int[] a, int row) {
        if(row == a.length) {
            print(a);
            return;
        }
        for(int column=0; column<a.length; column++) {
            if(isOK(a, row, column)) {
                a[row] = column;
                cal8queens(a,row+1);
            }
        }
    }

    public boolean isOK(int[] a, int row, int column) {
        int leftUp = column-1;
        int rightUp = column+1;

        for(int i=row-1; i>=0; i--) {
            if(a[i] == column) {
                return false;
            }
            if(leftUp >= 0) {
                if(a[i] == leftUp) {
                    return false;
                }
            }
            if(rightUp < a.length) {
                if(a[i] == rightUp) {
                    return false;
                }
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    public void print(int[] result) {
        for(int row=0; row<result.length; row++) {
            for(int column=0; column<result.length; column++) {
                if(result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Cal8queens cal8queens = new Cal8queens();
        int[] a = new int[4];
        cal8queens.cal8queens(a,0);
    }

}
