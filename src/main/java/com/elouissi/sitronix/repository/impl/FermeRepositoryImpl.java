package com.elouissi.sitronix.repository.impl;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.FermeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FermeRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public Page<Ferme> searchFermes(String nom, Double minSuperficie, Double maxSuperficie,
                                    String localisation, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ferme> query = cb.createQuery(Ferme.class);
        Root<Ferme> ferme = query.from(Ferme.class);

        List<Predicate> predicates = createPredicates(cb, ferme, nom, minSuperficie,
                maxSuperficie, localisation);

        query.where(cb.and(predicates.toArray(new Predicate[0])));
        query.orderBy(cb.asc(ferme.get("id")));

        List<Ferme> resultList = entityManager.createQuery(query)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long totalRecords = countFermesWithCriteria(nom, minSuperficie, maxSuperficie, localisation);
        return new PageImpl<>(resultList, pageable, totalRecords);
    }

    private long countFermesWithCriteria(String nom, Double minSuperficie,
                                         Double maxSuperficie, String localisation) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Ferme> fermeRoot = countQuery.from(Ferme.class);

        List<Predicate> predicates = createPredicates(cb, fermeRoot, nom, minSuperficie,
                maxSuperficie, localisation);

        countQuery.select(cb.count(fermeRoot))
                .where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private List<Predicate> createPredicates(CriteriaBuilder cb, Root<Ferme> root,
                                             String nom, Double minSuperficie,
                                             Double maxSuperficie, String localisation) {
        List<Predicate> predicates = new ArrayList<>();

        if (nom != null && !nom.isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("nom")),
                    "%" + nom.toLowerCase() + "%"));
        }

        if (minSuperficie != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("superficie"),
                    minSuperficie));
        }

        if (maxSuperficie != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("superficie"),
                    maxSuperficie));
        }

        if (localisation != null && !localisation.isEmpty()) {
            predicates.add(cb.equal(root.get("localisation"), localisation));
        }

        return predicates;
    }


}
