package com.javaexercise.datecheck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * DateValidatorクラスのテストクラス
 */
class DateValidatorTest {

    private DateValidator validator = new DateValidator();

    /**
     * 正常系テスト：有効な日付形式
     */
    @Test
    @DisplayName("有効な日付形式でtrueが返されること")
    void testValidDate() {
        // 期待値: 有効な日付形式
        boolean expected = true;
        // 実際の値
        boolean actual = validator.isValidDate("2020/05/10");

        // 期待値と実際の値が等しいか検証
        assertEquals(expected, actual);
    }

    /**
     * 異常系テスト：無効な日付形式や存在しない日付でfalseを返すこと
     */
    @ParameterizedTest
    @ValueSource(strings = { "2020-05-10", "2019/02/31", "abc" })
    @DisplayName("無効な日付でfalseが返されること")
    void testInvalidDateReturnsFalse(String invalidDate) {
        assertFalse(validator.isValidDate(invalidDate));
    }

    /**
     * 境界値テスト：範囲内の日付（下限）
     */
    @Test
    @DisplayName("下限日付で範囲内判定されること")
    void testDateBoundaryLower() {
        // 下限日付（1990/01/02）の場合
        boolean result = validator.isInRange("1990/01/02");
        assertTrue(result);
    }

    /**
     * 境界値テスト：範囲内の日付（上限）
     */
    @Test
    @DisplayName("上限日付で範囲内判定されること")
    void testDateBoundaryUpper() {
        // 上限日付（2023/12/30）の場合
        boolean result = validator.isInRange("2023/12/30");
        assertTrue(result);
    }
}