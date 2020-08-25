package com.webfullstackdev.javaguides.favorite.service;

import com.webfullstackdev.javaguides.favorite.dao.FavoriteDao;
import com.webfullstackdev.javaguides.favorite.model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FavoriteService {

    FavoriteDao favoriteDao;
    @Autowired
    public void setFavoriteDao(FavoriteDao favoriteDao ){
        this.favoriteDao = favoriteDao;
    }

    public List<Favorite> getAllFavService(){
        return favoriteDao.findAll();
    }

    public Favorite postFavoriteService(Favorite favorite){
        return favoriteDao.save(favorite);
    }

    public ResponseEntity<Favorite> viewFavoriteService(Long favoriteId){
        Favorite favorite;
        favorite = favoriteDao.findById(favoriteId).orElseThrow();
        return ResponseEntity.ok(favorite);
    }

    public ResponseEntity<Favorite> updateFavoriteService( Long id, Favorite favoriteUpdate){
        Favorite  favorite;
        favorite = favoriteDao.findById(id).orElseThrow();

        favorite.setUserId(favoriteUpdate.getUserId());
        favorite.setLinkName(favoriteUpdate.getLinkName());
        favorite.setPath(favoriteUpdate.getPath());

        Favorite favoriteClone = favoriteDao.save(favorite);
        return ResponseEntity.ok(favoriteClone);
    }

    public ResponseEntity<Map< String, Boolean>> deleteFavService(Long favid){
        Favorite  favorite;
        favorite = favoriteDao.findById(favid).orElseThrow();

        favoriteDao.delete(favorite);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
