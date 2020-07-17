package org.mabchour.cities.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {
    @Id
    private String id;
    private String name;
    private String country;
    private String subcountry;
    private String geonameid;
}
