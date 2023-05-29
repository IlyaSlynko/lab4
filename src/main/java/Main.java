import org.dstu.dao.BirdDao;
import org.dstu.dao.GenusDao;
import org.dstu.dao.MammalDao;
import org.dstu.domain.Bird;
import org.dstu.domain.Genus;
import org.dstu.domain.Mammal;
import org.dstu.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();

        GenusDao genusDao = new GenusDao();

        Genus bear = new Genus();
        bear.setName("Медведи");
        int savedIdBear = genusDao.save(bear);
        System.out.println(savedIdBear);


        MammalDao mammalDao = new MammalDao();

        Mammal mammal = new Mammal();
        mammal.setName("Миша");
        mammal.setAge(2);
        mammal.setMale(true);
        mammal.setUpRight(false);
        mammal.setSeasonHibernation(true);
        mammal.setGenus(bear);

        mammalDao.save(mammal);


        Genus sparrow = new Genus();
        sparrow.setName("Воробьи");
        int savedIdSparrow = genusDao.save(sparrow);
        System.out.println(savedIdSparrow);

        BirdDao birdDao = new BirdDao();

        Bird bird = new Bird();
        bird.setName("Чик-чирик");
        bird.setAge(1);
        bird.setMale(true);
        bird.setFlying(true);
        bird.setMigrating(true);
        bird.setGenus(sparrow);
        birdDao.save(bird);


        Bird bird1 = new Bird();
        bird1.setName("Пыжик");
        bird1.setAge(2);
        bird1.setMale(false);
        bird1.setFlying(true);
        bird1.setMigrating(true);
        bird1.setGenus(sparrow);
        birdDao.save(bird1);

        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}