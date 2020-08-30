package com.webfullstackdev.javaguides.favorite.model;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="FAVORITE")
public class Favorite implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator( name ="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name ="FAVORITE_ID")
     private String favoriteId;

    @Column(name ="USER_ID")
     private String userId;

    @Column(name ="PATH")
     private String path;

    @Column( name ="LINK")
    private String link;

    public Favorite() {
    }

    public Favorite(String userId, String path, String link) {
        super();
        this.userId = userId;
        this.path = path;
        this.link = link;
    }

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
