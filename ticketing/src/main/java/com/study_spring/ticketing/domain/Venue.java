package com.study_spring.ticketing.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Venue")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok을 사용하여 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 포함하는 생성자 추가
public class Venue {
    @Id
    @Column(nullable = false, length = 20)
    private String venue_id;
    @Column(nullable = false, length = 100)
    private String venue_name;
    @Column(nullable = false, length = 4)
    private Integer seat_scale;
    @Column(nullable = false, length = 4)
    private Integer disabled_scale;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
