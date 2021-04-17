package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
