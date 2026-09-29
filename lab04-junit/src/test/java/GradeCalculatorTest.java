package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;




public class GradeCalculatorTest {


    @ParameterizedTest
    @DisplayName("letterGrade: Хязгаарын болон ердийн утгуудыг шалгах")
    @CsvSource({
        "100.0, A",
        "95.0, A",
        "90.0, A",
        "89.99, B",
        "80.0, B",
        "79.99, C",
        "70.0, C",
        "69.99, D",
        "60.0, D",
        "59.99, F",
        "0.0, F"
    })
    void letterGradeBoundaries(double score, String expected) {
        GradeCalculator calc = new GradeCalculator();
        assertEquals(expected, calc.letterGrade(score));
    }

    @ParameterizedTest
    @DisplayName("totalScore: Төрөл бүрийн зөв оролтуудад нийлбэрийг шалгах")
    @CsvSource({
        "10.0, 40.0, 10.0, 10.0, 30.0, 100.0",
        "5.0, 20.0, 5.0, 5.0, 15.0, 50.0",
        "0.0, 0.0, 0.0, 0.0, 0.0, 0.0",
        "10.0, 39.5, 9.5, 9.0, 29.0, 97.0"
    })
    void totalScoreCalculations(double att, double lab, double quiz1, double quiz2, double exam, double expected) {
        GradeCalculator calc = new GradeCalculator();
        assertEquals(expected, calc.totalScore(att, lab, quiz1, quiz2, exam));
    }

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        String grade = calc.letterGrade(90.0);             // Act
        assertEquals("A", grade);                          // Assert
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой (хязгаарын тохиолдол)")
    void justBelowNinetyIsB() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        String grade = calc.letterGrade(89.99);            // Act
        assertEquals("B", grade);                          // Assert
    }

    @Test
    @DisplayName("60 оноо D дүн байх ёстой (хязгаарын тохиолдол)")
    void sixtyIsExactlyD() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        String grade = calc.letterGrade(60.0);             // Act
        assertEquals("D", grade);                          // Assert
    }

    @Test
    @DisplayName("100 оноо өгөхөд A дүн гарах ёстой (дээд хязгаар)")
    void hundredIsA() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        String grade = calc.letterGrade(100.0);            // Act
        assertEquals("A", grade);                          // Assert
    }

    @Test
    @DisplayName("0 оноо өгөхөд F дүн гарах ёстой (доод хязгаар)")
    void zeroIsF() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        String grade = calc.letterGrade(0.0);              // Act
        assertEquals("F", grade);                          // Assert
    }

    @Test
    @DisplayName("Оноо 100-аас хэтэрсэн үед Exception шидэх ёстой")
    void overHundredThrowsException() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calc.letterGrade(101.0);
        });
    }

    @Test
    @DisplayName("totalScore: Бүх оноо хязгаар дотор байхад зөв нийлбэр гарах ёстой")
    void totalScoreCorrectCalculation() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        double total = calc.totalScore(10.0, 40.0, 10.0, 10.0, 30.0); // Act
        assertEquals(100.0, total);                        // Assert
    }

    @Test
    @DisplayName("totalScore: Лаб оноо хязгаараас (40) хэтэрсэн үед Exception шидэх ёстой")
    void totalScoreExceedsMaxThrowsException() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calc.totalScore(10.0, 41.0, 10.0, 10.0, 30.0);
        });
    }

    @Test
    @DisplayName("totalScore: Ирцийн оноо сөрөг байхад Exception шидэх ёстой")
    void totalScoreNegativeInputThrowsException() {
        GradeCalculator calc = new GradeCalculator();      // Arrange
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calc.totalScore(-5.0, 40.0, 10.0, 10.0, 30.0);
        });
    }
}