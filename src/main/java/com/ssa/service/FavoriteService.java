package com.ssa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ssa.entity.Favorite;
import com.ssa.repository.FavoriteRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

	private final FavoriteRepository favoriteRepository;

	public Favorite addFavorite(Favorite favorite) {
		return favoriteRepository.save(favorite);
	}

	public List<Favorite> getFavoritesByUserId(Long userId) {
		return favoriteRepository.findByUserId(userId);
	}

	@Transactional
	public void removeFavorite(Long userId, Long flatId) {
		favoriteRepository.deleteByUserIdAndFlatId(userId, flatId);
	}
}
