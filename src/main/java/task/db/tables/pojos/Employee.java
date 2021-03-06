/*
 * This file is generated by jOOQ.
*/
package task.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Employee implements Serializable {

    private static final long serialVersionUID = 1782371712;

    private String username;
    private String email;
    private String name;

    public Employee() {}

    public Employee(Employee value) {
        this.username = value.username;
        this.email = value.email;
        this.name = value.name;
    }

    public Employee(
        String username,
        String email,
        String name
    ) {
        this.username = username;
        this.email = email;
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Employee (");

        sb.append(username);
        sb.append(", ").append(email);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }
}
