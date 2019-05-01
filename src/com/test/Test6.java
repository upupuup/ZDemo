package com.test;

import java.io.*;

public class Test6 {

    public static void main(String[] args) {
        // 路径
        ReadSubdirectory(new File("/Users/qiuming/git"));
    }

    public static void ReadSubdirectory(File myDir) {
        // 判断myDir是否为文件目录
        if (myDir.isDirectory()) {
            File[] subFile = myDir.listFiles();
            for (int i = 0; i < subFile.length; i++) {

                // 如果列表下含有子目录，递归查询
                if (subFile[i].isDirectory()) {
                    ReadSubdirectory(subFile[i]);
                } else {
                    // 没有子目录，则查找文件的数字个数，字母个数，空格格式，行数
                    ReadSubFile(subFile[i]);
                }
            }
        }
    }

    // 统计当前文件中数字 字母 空格的个数 和 文件行数
    public static void ReadSubFile(File file) {
        int numCount = 0;// 数字个数
        int letterCount = 0;// 字母个数
        int spaceCount = 0;// 空格个数
        int lineCount = 0;//行数
        int uniChar = 0;
        try {
            FileInputStream input = new FileInputStream(file);
            while ((uniChar = input.read()) != -1) {

                // 判断是否是数字
                if (uniChar >= 48 && uniChar <= 57) {
                    numCount++;
                } else if ((uniChar >= 65 && uniChar <= 90) || (uniChar >= 97 && uniChar <= 122)) {
                    // 判断是否是字母
                    letterCount++;
                } else if (uniChar == 32) {
                    // 判断是否是空格
                    spaceCount++;
                }
            }

            // 读取行数
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while(buffer.readLine() != null) {
                lineCount++;
            }

            // 打印信息
            System.out.println(file.getAbsolutePath());
            System.out.println(" 数字个数 : " + numCount);
            System.out.println(" 字母个数 : " + letterCount);
            System.out.println(" 空格个数 : " + spaceCount);
            System.out.println(" 行数数 : " + lineCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
