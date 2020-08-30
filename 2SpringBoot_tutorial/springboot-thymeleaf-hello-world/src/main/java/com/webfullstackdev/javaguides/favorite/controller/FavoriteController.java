package com.webfullstackdev.javaguides.favorite.controller;

import com.webfullstackdev.javaguides.favorite.model.Favorite;
import com.webfullstackdev.javaguides.favorite.service.FavoriteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.templateparser.markup.decoupled.IDecoupledTemplateLogicResolver;

import java.util.List;
import java.util.Map;
@ApiOperation(value = "/api/favorites", tags = "USer profile Controller", notes = "favorites  API")
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
    public ResponseEntity<Favorite> viewFavorite(@PathVariable String id){
        return favoriteService.viewFavoriteService(id);
    }

    @ApiOperation(value = "Updte favorites list from swagger", response = Favorite.class)
    @PutMapping("/favorites/{id}")
    public ResponseEntity<Favorite> updateFavorite(@PathVariable String id,@RequestBody Favorite favorite ){
        return favoriteService.updateFavoriteService(id,favorite);
    }

    @ApiOperation(value = "Delete favorites list from swagger", response = Favorite.class)
    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<Map< String, Boolean >> deleteFavorite(@PathVariable String id){
        return favoriteService.deleteFavService(id);
    }

    // profile message from applicaiton
    @Value("${spring.profilemessage}")
    private String message;

    @ApiOperation(value = "profile variable e.g", response = Iterable.class)
    @GetMapping("/profile")
    public String HelloProfile(){
        return message;
    }
}
