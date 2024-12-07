package project.logistics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 층-구역(4자리)-번호
    private String code;

    // 위치
    private String description;

    @OneToMany(mappedBy = "location")
    List<Item> items = new ArrayList<>();

}
