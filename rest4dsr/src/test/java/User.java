public class User {

    private int id;
    private String name;
    private String age; //replaced int to String for createUser method

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

    public String getAge() { //replaced int to String for createUser method
        return age;
    }

    public User withAge(String age) { //replaced int to String for createUser method
        this.age = age;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return age != null ? age.equals(user.age) : user.age == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
