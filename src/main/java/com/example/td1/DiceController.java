package com.example.td1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Dice Controller", description = "API for dice operations")
@RequestMapping("/dice")
public class DiceController {
    @Autowired
    private DiceService diceService;

    public DiceController() {
    }

    @GetMapping("/roll")
    @Operation(summary = "Roll a single dice")
    @Parameter(description = "The result of the dice roll")
    public int roll() {
        return diceService.roll(1).get(0);
    }

    @GetMapping("/roll/{x}")
    @Operation(summary = "Roll multiple dice")
    @Parameter(description = "The number of dice to roll", required = true)
    public List<Integer> rollX(@PathVariable("x") int x) {
        return diceService.roll(x);
    }

    @GetMapping("/log")
    @Operation(summary = "Get the log of all dice rolls")
    @Parameter(description = "The log of all dice rolls")
    public List<DiceRollLog> getLog() {
        return diceService.getLog();
    }
}
