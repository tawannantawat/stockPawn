package com.maneelak.stockpawn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.maneelak.stockpawn.entity.User;

@Entity
@Table(name = "pawn_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PawnRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pawn_number", length = 50, nullable = false, unique = true)
    private String pawnNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "created_by_user_id")
    private User createdBy; 

    @Column(name = "pawn_date", nullable = false)
    private LocalDate pawnDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "interest_rate", precision = 5, scale = 2)
    private BigDecimal interestRate;

    @Column(name = "total_evaluated", precision = 12, scale = 2)
    private BigDecimal totalEvaluated;

    @Column(name = "redeemed_date")
    private LocalDate redeemedDate;

    @Column(length = 20)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "active";
        }
    }
}