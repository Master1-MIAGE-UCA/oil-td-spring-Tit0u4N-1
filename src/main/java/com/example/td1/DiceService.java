package com.example.td1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {
    @Autowired
    private Dice dice;
    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    List<Integer> roll(int nbRolls) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nbRolls; i++) {
            results.add(dice.roll());
        }

        DiceRollLog diceRollLog = new DiceRollLog(results);
        diceRollLogRepository.save(diceRollLog);

        return results;
    }

    List<DiceRollLog> getLog() {
        return diceRollLogRepository.findAll();
    }
}
