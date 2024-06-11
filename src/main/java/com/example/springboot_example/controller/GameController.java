package com.example.springboot_example.controller;

import com.example.springboot_example.model.Game;
import com.example.springboot_example.model.Player;
import com.example.springboot_example.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// Base endpoint
@RequestMapping("/games")
public class GameController {

    private final GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game savedGame = gameRepository.save(game);
        return ResponseEntity.ok(savedGame);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{gameId}/player/{playerId}/cards")
    public ResponseEntity<List<String>> getPlayerCards(@PathVariable Long gameId, @PathVariable Long playerId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            for (Player player : game.getPlayers()) {
                if (player.getId().equals(playerId)) {
                    return ResponseEntity.ok(player.getCards());
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{gameId}/player/{playerId}/cards")
    public ResponseEntity<Player> updatePlayerCards(@PathVariable Long gameId, @PathVariable Long playerId,
            @RequestBody List<String> newCards) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            for (Player player : game.getPlayers()) {
                if (player.getId().equals(playerId)) {
                    player.setCards(newCards);
                    gameRepository.save(game);
                    return ResponseEntity.ok(player);
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

}
