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
            Address address = new Address("city", "street", "10000");

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(address);
            em.persist(member);

            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setHomeAddress(member.getHomeAddress());
            em.persist(member2);

            member.getHomeAddress().setCity("newCity");



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
