package com.ifeng.yanggz.day8;

public class Cal8Queens {

    public static void main(String[] args) {
        Cal8Queens cal8Queens = new Cal8Queens();
        int[] a = new int[4];
        cal8Queens.cal8Queens(a, 0);
    }

    public void cal8Queens(int[] a, int row) {
        if(row == a.length) {
            print(a);
            return;
        }
        for(int j=0; j<a.length; j++) {
            if(isOk(a, row, j)) {
                a[row] = j;
                cal8Queens(a, row+1);
            }
        }
    }

    public boolean isOk(int[] a, int row, int column) {
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

    public void print(int[] a) {
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a.length; j++) {
                if(a[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
