package com.webfullstackdev.javaguides.favorite.dao;

import com.webfullstackdev.javaguides.favorite.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteDao extends JpaRepository<Favorite, Long> {
}
