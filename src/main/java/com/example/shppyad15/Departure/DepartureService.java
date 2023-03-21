package com.example.shppyad15.Departure;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureService {
    private final SessionFactory sessionFactory;

    @Autowired
    public DepartureService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Departure> getAllDepartures() {
        Session session = sessionFactory.getCurrentSession();
        Query<Departure> query = session.createQuery("SELECT d FROM Departure d", Departure.class);
        return query.getResultList();
    }

    public Departure getDepartureById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Departure.class, id);
    }

    public Departure createDeparture(Departure departure) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(departure);
        tx.commit();
        return departure;
    }

    public void deleteDepartureById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Departure departure = session.get(Departure.class, id);
        if (departure != null) {
            session.remove(departure);
        }
        tx.commit();
    }

}