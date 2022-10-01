package com.infoshareacademy.repository;

import com.infoshareacademy.dto.FindGameDto;
import com.infoshareacademy.entity.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Game> findGamesByCriteriaBuilder(FindGameDto findGameDto) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Game> cr = cb.createQuery(Game.class);
        Root<Game> root = cr.from(Game.class);

        CriteriaQuery<Game> gameCriteriaQuery = cr.where(getPredicates(cb, findGameDto, root));
        TypedQuery<Game> query = entityManager.createQuery(gameCriteriaQuery);

        List<Game> results = query.getResultList();

        return results;

    }

    Predicate getPredicates(CriteriaBuilder cb, FindGameDto findGameDto, Root root) {

        List<Predicate> predicates = new ArrayList<>();

        if (findGameDto.getName() != null) {
            predicates.add(isNameEqual(findGameDto.getName(), root, cb));
        }

        if (findGameDto.getTown() != null) {
            predicates.add(isTownEqual(findGameDto.getTown(), root, cb));
        }

        if (findGameDto.getType() != null) {
            predicates.add(isTypeEqual(findGameDto.getType(), root, cb));
        }

        if (findGameDto.getDateOfGame() != null) {
            predicates.add(isDateOfGameEqual(findGameDto.getDateOfGame(), root, cb));
        }

        return cb.and(predicates.get(0), predicates.get(1), predicates.get(2), predicates.get(3));

    }

    Predicate isNameEqual(String name, Root root, CriteriaBuilder cb) {
        return cb.equal(root.get("name"), name);
    }

    Predicate isTownEqual(String town, Root root, CriteriaBuilder cb) {
        return cb.equal(root.get("gameLocation").get("town"), town);
    }

    Predicate isTypeEqual(String gameType, Root root, CriteriaBuilder cb) {
        return cb.equal(root.get("type").get("value"), gameType);
    }

    Predicate isDateOfGameEqual(LocalDate date, Root root, CriteriaBuilder cb) {
        return cb.equal(root.<LocalDate> get("dateOfGame"), date);
    }
}