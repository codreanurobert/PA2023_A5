package Test;

import Test.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private List<Player> players = new ArrayList<>();

    @GetMapping
    public List<Player> getAllPlayers() {
        players.add(new Player(1, "A"));
        players.add(new Player(2, "B"));
        players.add(new Player(3, "C"));
        return players;
    }
}