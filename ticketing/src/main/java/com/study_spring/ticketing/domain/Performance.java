package com.study_spring.ticketing.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Performance")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok을 사용하여 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 포함하는 생성자 추가
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID prf_id;
    @Column(nullable = false, length = 100)
    private String prf_name;
    @Column(nullable = false, length = 100)
    private String prf_cast;
    @Column(nullable = false, length = 100)
    private String prf_crew;
    @Column(nullable = false, length = 100)
    private String genre_name;
    @Column(nullable = false)
    private Date prf_start;
    @Column(nullable = false)
    private Date prf_end;
    @Column(nullable = false, length = 100)
    private String entrps_name;
    @Column(nullable = true, length = 100)
    @ColumnDefault("")
    private String entrps_name_p;
    @Column(nullable = true, length = 100)
    @ColumnDefault("")
    private String entrps_name_a;
    @Column(nullable = true, length = 100)
    @ColumnDefault("")
    private String entrps_name_h;
    @Column(nullable = true, length = 100)
    @ColumnDefault("")
    private String entrps_name_s;
    @Column(nullable = true, length = 200)
    @ColumnDefault("")
    private String poster_url;
    @Column(nullable = true, length = 100)
    @ColumnDefault("")
    private String prf_age;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    @OneToMany(mappedBy = "prf", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PRFSession> prfSession;

    @OneToMany(mappedBy = "prf", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PRFPrice> prfPrice;
}
