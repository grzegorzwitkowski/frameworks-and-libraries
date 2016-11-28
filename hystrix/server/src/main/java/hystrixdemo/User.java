package hystrixdemo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final int age;

    public User(@JsonProperty("id") String id,
                @JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName,
                @JsonProperty("age") int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
