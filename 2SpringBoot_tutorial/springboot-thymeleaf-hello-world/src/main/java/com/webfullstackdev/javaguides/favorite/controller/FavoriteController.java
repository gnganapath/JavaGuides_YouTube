package com.webfullstackdev.javaguides.favorite.controller;

import com.webfullstackdev.javaguides.favorite.model.Favorite;
import com.webfullstackdev.javaguides.favorite.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @GetMapping("/favorites")
    public List<Favorite> getAllFavorite(){
        return favoriteService.getAllFavService();
    }

    @PostMapping("/favorites")
    public Favorite postFavorite(@RequestBody Favorite fav){
        return favoriteService.postFavoriteService(fav);
    }
}
