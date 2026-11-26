package com.javaexercise.datecheck;

import java.util.Scanner;

/**
 * 日付入力チェックアプリケーションのメインクラス
 */
public class Main {
    
    /**
     * アプリケーションのエントリーポイント
     * 
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateValidator validator = new DateValidator();

        while (true) {
            System.out.print("日付を入力してください（yyyy/MM/dd）: ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("アプリケーションを終了します。");
                break;
            }

            try {
                if (validator.isValidDate(input)) {
                    if (validator.isInRange(input)) {
                        System.out.println("結果：範囲内");
                    } else {
                        System.out.println("結果：範囲外");
                    }
                } else {
                    System.out.println("入力形式エラーです。yyyy/MM/dd 形式で入力してください。");
                }
            } catch (Exception e) {
                System.out.println("入力形式エラーです。yyyy/MM/dd 形式で入力してください。");
            }
        }
        scanner.close();
    }
}