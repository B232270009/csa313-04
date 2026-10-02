# Лаборатори №4: Нэгжийн тестийн эхлэл — JUnit 5

**Оюутны нэр:** Н. Төгөлдөр
**Оюутны код:** B232270009

## Ажлын орчин (Versions)

mvn -version
Apache Maven 3.9.9
Maven home: /usr/share/maven
Java version: 21.0.12.1, vendor: Debian, runtime: /usr/lib/jvm/java-21-openjdk-amd64
Default locale: en_HK, platform encoding: UTF-8
OS name: "linux", version: "6.12.107+deb13-amd64", arch: "amd64", family: "unix"

java -version
openjdk version "21.0.12.1" 2026-08-18
OpenJDK Runtime Environment (build 21.0.12.1+1-1-deb13u1-Debian)
OpenJDK 64-Bit Server VM (build 21.0.12.1+1-1-deb13u1-Debian, mixed mode, sharing)


Тестийн үр дүн ба Мутацийн шинжилгээ
Тестийн методын тоо: 9 метод (Энгийн болон Exception шалгасан 7 метод, Parameterized 2 метод)

results/mvn-test.txt файлын Tests run тоо: 24

Мутацийн үр дүн:
GradeCalculator классын score >= 90 нөхцөлийг score > 90 болгож мутаци оруулан mvn test командыг ажиллуулахад нийт 24 тестээс дараах 2 тест унасан байна:

GradeCalculatorTest.ninetyIsExactlyA

GradeCalculatorTest.letterGradeBoundaries(double, String)

Дүгнэлт:
Энэхүү лабораторийн ажлаар GradeCalculator классыг хэрэгжүүлж, JUnit 5 хүрээгээр Arrange-Act-Assert бүтцийн дагуу нэгжийн тестүүд бичиж сурлаа. Олон давтагдсан тестийн логикийг @ParameterizedTest болон @CsvSource ашиглан нэгтгэснээр кодын давхардлыг бууруулж, нийт 24 бие даасан шалгалтыг амжилттай ажиллуулсан. Кодын бат бөх байдлыг шалгах зорилгоор letterGrade функц дэх score >= 90 нөхцөлийг score > 90 болгон санаатайгаар мутаци оруулахад ninetyIsExactlyA метод болон parameterized тестийн 90 онооны шалгалт шууд унаж (Failures: 2), BUILD FAILURE заасан. Энэхүү мутацийн үр дүн нь программ хангамжийн туршилтад хязгаарын утгуудыг (boundary values) заавал оруулж шалгах нь алдааг хэрхэн эрт илрүүлж чаддаг болохыг харуулсан маш сонирхолтой бөгөөд чухал алхам байлаа. Мутацийн туршилтын дараа кодыг буцаан хэвэнд нь оруулж, бүх тест алдаагүй (ногоон) ажиллаж байгааг баталгаажуулав.