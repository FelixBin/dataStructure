package Array;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s, score:%d)", name, score);
    }

    public static void main(String[] args) {
        GenericArray<Student> studentArray = new GenericArray<Student>();
        studentArray.addLast(new Student("test01", 66));
        studentArray.addLast(new Student("test02", 77));
        studentArray.addLast(new Student("test03", 88));
        System.out.println(studentArray);
    }
}
