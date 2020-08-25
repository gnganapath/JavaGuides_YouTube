package com.webfullstackdev.javaguides.favorite.controller;

import com.webfullstackdev.javaguides.favorite.model.Favorite;
import com.webfullstackdev.javaguides.favorite.service.FavoriteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@ApiOperation(value = "/api/favorites", tags = "Employee Profile Controller", notes = "favorites  API")
@RestController
@RequestMapping("/api")
public class FavoriteController {

    FavoriteService favoriteService;
    @Autowired
    public void setFavoriteService(FavoriteService favoriteService){
        this.favoriteService = favoriteService;
    }

    @ApiOperation(value = "Get favorites list from swagger", response = Favorite.class)
    @GetMapping("/favorites")
    public List<Favorite> getAllFavorite(){
        return favoriteService.getAllFavService();
    }

    @ApiOperation(value = "post favorites list from swagger", response = Favorite.class)
    @PostMapping("/favorites")
    public Favorite postFavorite(@RequestBody Favorite fav){
        return favoriteService.postFavoriteService(fav);
    }

    @ApiOperation(value = "Get specific favorites list from swagger", response = Favorite.class)
    @GetMapping("/favorites/{id}")
    public ResponseEntity<Favorite> viewFavorite(@PathVariable Long id){
        return favoriteService.viewFavoriteService(id);
    }

    @ApiOperation(value = "Updte favorites list from swagger", response = Favorite.class)
    @PutMapping("/favorites/{id}")
    public ResponseEntity<Favorite> updateFavorite(@PathVariable Long id,@RequestBody Favorite favorite ){
        return favoriteService.updateFavoriteService(id,favorite);
    }

    @ApiOperation(value = "Delete favorites list from swagger", response = Favorite.class)
    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<Map< String, Boolean >> deleteFavorite(@PathVariable Long id){
        return favoriteService.deleteFavService(id);
    }
}
