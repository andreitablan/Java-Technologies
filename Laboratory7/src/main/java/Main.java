import com.example.laboratory7.entity.Users;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(  "default");
        EntityManager entityManager = entityManagerFactory.createEntityManager ();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Users user = new Users();
            user.setUsername("admin2");
            user.setPassword("admin2");
            user.setRole("admin");
            entityManager.persist(user);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
    }
}
}
