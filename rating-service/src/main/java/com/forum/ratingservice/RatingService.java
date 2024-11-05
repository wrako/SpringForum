
package com.forum.ratingservice;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RatingService{
    @Autowired
    private RatingRepository ratingRepository;


    public void setRating(Rating rating) throws RatingException {
//        try {
//            Rating existingRating = (Rating) entityManager.createNamedQuery("Rating.getRatingByUsrId")
//                    .setParameter("usrId", rating.getUsrId())
//                    .setParameter("game", rating.getGame())
//                    .getSingleResult();
//
//            if (existingRating != null) {
//                existingRating.setRating(rating.getRating());
//                existingRating.setRatedOn(rating.getRatedOn());
//                entityManager.merge(existingRating);
//            }
//        } catch (NoResultException e) {
//            entityManager.persist(rating);
////            throw new RatingException("Error setting rating: " + e.getMessage(), e);
//        }
        ratingRepository.save(rating);
    }


    public int getAverageRating(String game) throws RatingException {
//        Object object =  entityManager.createNamedQuery("Rating.getAveRating")
//                .setParameter("game", game)
//                .getSingleResult();
//        if(object == null) return 0;

        return (int) Math.round((double) 1);
    }




    public int getRating(String game, Long id) throws RatingException {
//        return entityManager.find(Rating.class, id).getRating();
        return 1;
    }


    public void reset() {
        ratingRepository.deleteAll();
    }
}
