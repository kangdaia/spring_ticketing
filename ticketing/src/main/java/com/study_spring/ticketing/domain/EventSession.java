package com.study_spring.ticketing.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="EventSession")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok을 사용하여 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 포함하는 생성자 추가
public class EventSession {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID session_id;

    @Column(nullable = false)
    private Date session_start;

    @Column(nullable = false)
    private Integer session_end;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
