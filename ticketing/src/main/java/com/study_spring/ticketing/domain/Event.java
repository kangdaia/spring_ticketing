package com.study_spring.ticketing.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Events")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok을 사용하여 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 포함하는 생성자 추가
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID event_id;

    @Column(nullable = false, length = 100)
    private String event_name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false, length = 100)
    private String category;
    @Column(nullable = false, length = 100)
    private String event_state;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EventSession> eventSession;
}
