package com.study_spring.ticketing.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Location")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok을 사용하여 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 포함하는 생성자 추가
public class Location {
    @Id
    @Column(nullable = false, length = 20)
    private String location_id;
    @Column(nullable = false, length = 100)
    private String loc_name;
    @Column(nullable = false, length = 4)
    private String areacode;
    @Column(nullable = false, length = 4)
    private String sigungucodesub;
    @Column(nullable = false)
    private Integer capacity;
    @Column(nullable = false, length = 100)
    private String address;
}
