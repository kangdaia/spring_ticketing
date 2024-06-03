package com.study_spring.ticketing.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="PRFPrice")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok을 사용하여 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 포함하는 생성자 추가
public class PRFPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID prf_price_id;

    @Column(nullable = false, length = 50)
    private String ticket_type;

    @Column(nullable = false)
    private Double ticket_price;

    @ManyToOne
    @JoinColumn(name = "prf_id")
    private Performance prf;
}
