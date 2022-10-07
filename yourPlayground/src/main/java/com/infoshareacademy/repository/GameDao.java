package com.infoshareacademy.repository;

import com.infoshareacademy.dto.FindGameDto;
import com.infoshareacademy.entity.Game;
import com.infoshareacademy.utils.GameType;
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

        if (findGameDto.getName() != "") {
            predicates.add(isNameEqual(findGameDto.getName(), root, cb));
        }

        if (findGameDto.getTown() != "") {
            predicates.add(isTownEqual(findGameDto.getTown(), root, cb));
        }

        if (findGameDto.getType() != "") {
            predicates.add(isTypeEqual(findGameDto.getType(), root, cb));
        }

        if (findGameDto.getDateOfGame() != null) {
            predicates.add(isDateOfGameEqual(findGameDto.getDateOfGame(), root, cb));
        }

        return cb.and(predicates.toArray(Predicate[]::new));

    }

    Predicate isNameEqual(String name, Root root, CriteriaBuilder cb) {
        return cb.equal(root.get("name"), name);
    }

    Predicate isTownEqual(String town, Root root, CriteriaBuilder cb) {
        return cb.equal(root.get("gameLocation").<String> get("town"), town);
    }

    Predicate isTypeEqual(String gameType, Root root, CriteriaBuilder cb) {
        return cb.equal(root.get("type"), GameType.valueOf(gameType));
    }

    Predicate isDateOfGameEqual(LocalDate date, Root root, CriteriaBuilder cb) {
        return cb.between(root.get("dateOfGame"), date.atStartOfDay(), date.plusDays(1).atStartOfDay());
    }
}