package mn.edu.must.sqat;

public class GradeCalculator {
    
    // 90+ -> A, 80-89 -> B, 70-79 -> C, 60-69 -> D, <60 -> F
    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Оноо 0-100 хязгаараас гарсан байна.");
        }
        if (score > 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    // Ирц(10), лаб+бие даалт(40), сорил1(10), сорил2(10), шалгалт(30)
    public double totalScore(double att, double lab, double quiz1, double quiz2, double exam) {
        if (att < 0 || att > 10) throw new IllegalArgumentException("Ирцийн оноо буруу байна.");
        if (lab < 0 || lab > 40) throw new IllegalArgumentException("Лаб/бие даалтын оноо буруу байна.");
        if (quiz1 < 0 || quiz1 > 10) throw new IllegalArgumentException("Сорил 1 оноо буруу байна.");
        if (quiz2 < 0 || quiz2 > 10) throw new IllegalArgumentException("Сорил 2 оноо буруу байна.");
        if (exam < 0 || exam > 30) throw new IllegalArgumentException("Шалгалтын оноо буруу байна.");
        double total = att + lab + quiz1 + quiz2 + exam;
        if (total < 0 || total > 100) throw new IllegalArgumentException("Нийт оноо буруу байна.");

        return total;
    }
}