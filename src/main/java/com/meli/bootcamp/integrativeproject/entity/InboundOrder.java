package com.meli.bootcamp.integrativeproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class InboundOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "date_order")
    private LocalDateTime dateOrder;

    @ManyToOne
    private Agent agent;

    @OneToOne
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    private Batch batch;
}
