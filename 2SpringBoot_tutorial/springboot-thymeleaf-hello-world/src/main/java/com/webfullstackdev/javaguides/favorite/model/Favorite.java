package com.webfullstackdev.javaguides.favorite.model;

import javax.persistence.*;

@Entity
@Table( name="Favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favoriteId;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="PATH")
    private String path;

    @Column(name="LINK_NAME")
    private String linkName;

    public Favorite() {
    }

    public Favorite(String userId, String path, String linkName) {
        this.userId = userId;
        this.path = path;
        this.linkName = linkName;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
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

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
