package com.ifeng.yanggz.day7;

import java.util.Arrays;

/**
 * 计算8皇后问题
 *
 * 回溯算法
 */
public class Cal8queens {

    public int[] result = new int[8];

    private void cal8queens(int row) {
        if(row == 8) {
            print(result);
            return;
        }
        for(int column=0; column<8; column++) {
            if(isOK(row, column)) {
                result[row] = column;
                cal8queens(row+1);
            }
        }
    }

    public boolean isOK(int row, int column) {
        int leftUp = column-1;
        int rightUp = column+1;
        for(int i=row-1; i>=0; i--) {
            if(result[i] == column) {
                return false;
            }
            if(leftUp >= 0) {
                if(result[i] == leftUp) {
                    return false;
                }
            }
            if(rightUp < 8) {
                if(result[i] == rightUp) {
                    return false;
                }
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    public void print(int[] result) {
        for(int row=0; row<8; row++) {
            for(int column=0; column<8; column++) {
                if(result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        Cal8queens cal8queens = new Cal8queens();
        cal8queens.cal8queens(0);
    }

}
