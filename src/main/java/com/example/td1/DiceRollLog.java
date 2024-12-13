package com.example.td1;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @Builder @ToString
public class DiceRollLog {
    @Id
    @GeneratedValue()
    private int id;
    @ElementCollection
    private List<Integer> results;
    private int diceCount;
    @CurrentTimestamp
    private Timestamp timestamp;

    public DiceRollLog() {
    }

    public DiceRollLog(List<Integer> results) {
        this.results = results;
        this.diceCount = results.size();
    }
}
