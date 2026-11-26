package com.javaexercise.datecheck;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 日付入力の検証機能を提供するクラス
 */
public class DateValidator {
    
    // 定数定義
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final LocalDate START_DATE = LocalDate.of(1990, 1, 2);
    private static final LocalDate END_DATE = LocalDate.of(2023, 12, 30);
    
    /**
     * 入力文字列が yyyy/MM/dd 形式かどうか検証
     * 
     * @param dateStr 検証する日付文字列
     * @return 有効な形式の場合true、無効な場合false
     */
    public boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * 入力日付が範囲内かどうか検証
     * 
     * @param dateStr 検証する日付文字列
     * @return 範囲内の場合true、範囲外の場合false
     */
    public boolean isInRange(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, FORMATTER);
        return !(date.isBefore(START_DATE) || date.isAfter(END_DATE));
    }
}