package com.weatherweb.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class HistoryController {
    UserRepository userRepository;
    HistoryRepository historyRepository;
    public HistoryController(UserRepository userRepository, HistoryRepository historyRepository) {
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }

    @GetMapping("")
    public List<History> getHistory() {
        return historyRepository.findAll();
    }
    @GetMapping("/{id}")
    public History getHistory(@PathVariable long id) {
        return this.historyRepository.findById(id);
    }
    @DeleteMapping("DeleteAll")
    public void deleteAll() {
        historyRepository.deleteAll();
    }
    @DeleteMapping("")
    public void deleteHistory(@RequestBody History history) {
        historyRepository.delete(history);
    }
    @PutMapping("")
    public History updateHistory(@RequestBody History history) {
        return this.historyRepository.save(history);
    }
    @PostMapping("")
    public History addHistory(@RequestBody History history) {
        return this.historyRepository.save(history);
    }
}
