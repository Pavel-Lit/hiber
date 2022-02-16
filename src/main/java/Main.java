import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        Session session = null;

        session = factory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, 3);
       Category category = session.get(Category.class, 3);
        System.out.println("Games");
        System.out.println(product);
        System.out.println("Platform games");
        System.out.println(category);
        factory.close();
        session.close();
    }

}
