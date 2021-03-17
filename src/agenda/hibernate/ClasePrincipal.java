package agenda.hibernate;

import java.util.List;

import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class ClasePrincipal {

	public static void main(String[] args) {
		StandardServiceRegistry s=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		
		
		
		Contacto c=new Contacto("manolo", "garcia", "manolo@gmail.com");
		//sesion.save(p);		
		sesion.save(c);
		
		
		t.commit();
		
		Query q=sesion.createNamedQuery("consulta_por_nombre").setString("nombre", "manolo");
		List<Contacto> lista=q.getResultList();
		System.out.println(lista);
	}

}
