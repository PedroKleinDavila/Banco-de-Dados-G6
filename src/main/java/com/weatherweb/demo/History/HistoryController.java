package com.weatherweb.demo.History;

import com.weatherweb.demo.User.User;
import com.weatherweb.demo.User.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
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
    public History addHistory(@RequestBody HistoryDTO history) {
        User user = this.userRepository.findById(history.getId());
        History history1=new History();
        history1.setUser(user);
        history1.setDay(history.getDay());
        history1.setHumidity(history.getHumidity());
        history1.setTemperature(history.getTemperature());
        history1.setTime(history.getTime());
        history1.setWeather(history.getWeather());
        history1.setWind(history.getWind());
        return this.historyRepository.save(history1);
    }
}
