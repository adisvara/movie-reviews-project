package com.adisvara.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Getter
@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    // Explicit getters to ensure they're available
    @Id
    //@JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String body;

    public Review(String body) {
        this.body = body;
    }

}
