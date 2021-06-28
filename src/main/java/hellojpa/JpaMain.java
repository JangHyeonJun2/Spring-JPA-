package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("hello");
            member1.setTeam(team);

            em.persist(member1);
            
            em.flush();
            em.clear();
            Member m = em.find(Member.class, member1.getId());
            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass()); //프록시로 가져온다.

            System.out.println("==============");
            m.getTeam().getName(); // 실제 team을 사용하는 시점에 프록시를 초기화하고 실제 값을 가져온다.
            System.out.println("==============");

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

//        **데이터 등록**
//        try{
//
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Person person = new Person();
//            person.setName("person1");
//            person.changeTeam(team);
//            em.persist(person);
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//
//            List<Person> persons = findTeam.getPersons();
//
//            for (Person person1 : persons) {
//                System.out.println("person1.getName() = " + person1.getName());
//            }
//
//
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        ////        **데이터 수정**
//        try {
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("========수정 전========");
//            System.out.println("findMemberId = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//
//            findMember.setName("HelloB");
////            여기서 persist를 안해도된다!!
//            tx.commit();
//
//            System.out.println("========수정 후========");
//            System.out.println("findMemberId = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }


//        **데이터 삭제**
//        try {
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
//            tx.commit();
//
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }

//      JPQL로 모든 멤버 가져오기
//        try{
//            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : findMembers) {
//                System.out.println("member.getName() = " + member.getName());
//            }
//            tx.commit();
//        }catch (Exception e) {
//            tx.rollback();
//        }finally {
//            em.close();
//        }
//
//        emf.close();
    }
}
