package ch.zli.m223.service;

import ch.zli.m223.model.ContactRequestModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ContactRequestService {

    @Inject
    EntityManager em;

    public List<ContactRequestModel> getAll() {
        return ContactRequestModel.listAll();
    }

    @Transactional
    public ContactRequestModel create(ContactRequestModel request) {
        em.persist(request);
        return request;
    }
}
