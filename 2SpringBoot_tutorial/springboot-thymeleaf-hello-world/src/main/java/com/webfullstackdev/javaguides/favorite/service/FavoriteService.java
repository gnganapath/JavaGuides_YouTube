package com.webfullstackdev.javaguides.favorite.service;

import com.webfullstackdev.javaguides.favorite.dao.FavoriteDao;
import com.webfullstackdev.javaguides.favorite.model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    FavoriteDao favoriteDao;

    public List<Favorite> getAllFavService(){
        return favoriteDao.findAll();
    }

    public Favorite postFavoriteService(Favorite favorite){
        return favoriteDao.save(favorite);
    }
}
