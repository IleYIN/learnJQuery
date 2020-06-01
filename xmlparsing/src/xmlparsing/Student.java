package xmlparsing;

public class Student {
	private String name;
	private String id;
	private Integer age;
	public Student(String name, String id, Integer age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public Student() {

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	//alt+shift+s tostring
	//alt+shift+s o
	//alt+shift+s r
}
