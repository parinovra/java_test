public class User {

    private int id;
    private String name;
    private int age; //replaced int to String for createUser method

    public int getId() {
        return id;
    }

    //replace setId to withId for fluent-style use
    //replace void to User (as object)
    //add return this; (return object in method)
    public User withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() { //replaced int to String for createUser method
        return age;
    }

    public User withAge(int age) { //replaced int to String for createUser method
        this.age = age;
        return this;
    }
}
