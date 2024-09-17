package com.weatherweb.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    private UserRepository userRepository;
    private FavoriteRepository favoriteRepository;

    public FavoriteController(UserRepository userRepository, FavoriteRepository favoriteRepository) {
        this.userRepository = userRepository;
        this.favoriteRepository = favoriteRepository;
    }

    @GetMapping("")
    public List<Favorite> getFavorites() {
        return favoriteRepository.findAll();
    }
    @GetMapping("/{id}")
    public Favorite getFavorite(@PathVariable() long id){
        return this.favoriteRepository.findById(id);
    }
    @DeleteMapping("DeleteAll")
    public void deleteAllFavorites() {
        favoriteRepository.deleteAll();
    }
    @DeleteMapping("")
    public void deleteFavorite(@RequestBody Favorite favorite) {
        this.favoriteRepository.delete(favorite);
    }
    @PutMapping
    public Favorite updateFavorite(@RequestBody Favorite favorite) {
        return this.favoriteRepository.save(favorite);
    }
    @PostMapping
    public Favorite addFavorite(@RequestBody FavoriteDTO favorite) {
        User user = this.userRepository.findById(favorite.getId());
        Favorite favorite1=new Favorite();
        favorite1.setUser(user);
        favorite1.setCity(favorite.getCity());
        return this.favoriteRepository.save(favorite1);
    }
}
