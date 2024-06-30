import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
  private String name;
  private int score;
  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }
  @Override
  public String toString() {
    return name + ": " + score;
  }
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student("홍길동", 88));
    students.add(new Student("김철수", 75));
    students.add(new Student("이영희", 95));

    // 점수를 기준으로 오름차순 정렬하는 Comparator
    Comparator<Student> scoreComparator = new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return Integer.compare(s1.score, s2.score);
      }
    };

    Collections.sort(students, scoreComparator);
    for (Student student : students) {
      System.out.println(student);
    }

    // 이름을 기준으로 오름차순 정렬하는 Comparator
    Comparator<Student> nameComparator = new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
      }
    };

    Collections.sort(students, nameComparator);
    for (Student student : students) {
      System.out.println(student);
    }
  }
}