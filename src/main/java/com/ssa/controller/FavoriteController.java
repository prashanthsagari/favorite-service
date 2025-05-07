package com.ssa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssa.entity.Favorite;
import com.ssa.service.FavoriteService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoriteController {

	private final FavoriteService favoriteService;

	@PostMapping
	public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
		return ResponseEntity.ok(favoriteService.addFavorite(favorite));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Favorite>> getFavorites(@PathVariable Long userId) {
		return ResponseEntity.ok(favoriteService.getFavoritesByUserId(userId));
	}

	@DeleteMapping("/{userId}/{flatId}")
	public ResponseEntity<Void> deleteFavorite(@PathVariable Long userId, @PathVariable Long flatId) {
		favoriteService.removeFavorite(userId, flatId);
		return ResponseEntity.noContent().build();
	}
}
