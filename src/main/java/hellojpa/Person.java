package hellojpa;

import javax.persistence.*;

@Entity
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getPersons().add(this); //여기서 this는 나 자신(Person)
    }
}
