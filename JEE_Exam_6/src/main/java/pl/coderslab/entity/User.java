package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "tweeter_user")
public class User {

    /*id - klucz główny
firstName - pole wymagane
lastName - pole wymagane
email - walidacja adresu email, pole nie wymagane*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 100)
    private String firstName;

    private String lastName;

    private String email;


}
