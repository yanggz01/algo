package com.ifeng.yanggz.day4.string;

/**
 * 朴素字符串匹配算法
 * @Author yanggz
 * @Date 2020-06-18
 */
public class BF {

    public static int bfMatch(String mainStr, String modeStr) {

        char[] mainArr = mainStr.toCharArray();
        char[] modeArr = modeStr.toCharArray();

        int index=0;
        int j = 0;
        int i = index;
        do {
            if(mainArr[i] != modeArr[j]) {
                index++;// 主串起始匹配地址+1
                j = 0;// 模式串开始匹配地址+1
                i = index; // 主串相等地址回调
            } else {
                if(j == modeArr.length -1) {
                    return index;
                }
                i++;
                j++;
            }
        }while (index < mainArr.length - modeArr.length + 1);


        return -1;
    }

    public static int bf(String mainStr, String modeStr) {
        char[] mainArr = mainStr.toCharArray();
        char[] modeArr = modeStr.toCharArray();
        int n = mainArr.length;
        int m = modeArr.length;
        int k;
        for(int i=0; i<=n-m; i++) {
            k = 0;
            for(int j=0; j<m; j++) {
                if(mainArr[j+i] == modeArr[j]) {
                    k++;
                } else {
                    break;
                }
            }
            if(k == m) {
                return i;
            }
        }
        return -1;
    }
}
