package zw.co.afrosoft.junittest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private String decription;
}
