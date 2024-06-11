INSERT INTO games (id) VALUES (1); -- Create game 1

INSERT INTO players (name, game_id) VALUES ('Player 1', 1); -- add player 1 to game
INSERT INTO players (name, game_id) VALUES ('Player 2', 1); -- add player 2 to game

INSERT INTO player_cards (player_id, card) VALUES -- add Cards to player 1
((SELECT id FROM players WHERE name = 'Player 1'), 'card1'), 
((SELECT id FROM players WHERE name = 'Player 1'), 'card2'),
((SELECT id FROM players WHERE name = 'Player 1'), 'card3'), 
((SELECT id FROM players WHERE name = 'Player 1'), 'card4'),
((SELECT id FROM players WHERE name = 'Player 1'), 'card5');

INSERT INTO player_cards (player_id, card) VALUES -- add Cards to player 2
((SELECT id FROM players WHERE name = 'Player 2'), 'card1'),
((SELECT id FROM players WHERE name = 'Player 2'), 'card2'), 
((SELECT id FROM players WHERE name = 'Player 2'), 'card3'),
((SELECT id FROM players WHERE name = 'Player 2'), 'card4'), 
((SELECT id FROM players WHERE name = 'Player 2'), 'card5');
