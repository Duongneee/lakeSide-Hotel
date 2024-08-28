package com.example.lakeSide_Hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @Column(name = "check_In") // ánh xạ sang cơ sở dữ liệu
    private LocalDate checkInDate;
    @Column(name = "check_Out") // ánh xạ sang cơ sở dữ liệu
    private LocalDate checkOutDate;
    @Column(name = "guest_FullName")
    private String guestFullName;
    @Column(name = "guest_Email")
    private String guestEmail;
    @Column(name = "adults")
    private int NumOfAdults;
    @Column(name = "children")
    private int NumOfChildren;
    @Column(name = "total_guest")
    private int TotalOfGuest;
    @Column(name = "confirmation_Code")
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY) // 1 phong co nhieu lich dat phong
    @JoinColumn(name = "room_id") // joincolunm là khóa ngoại của bảng, tham chiếu tới bảng khác
    private Room room;


    public void calculateTotalOfGuest() {
        this.TotalOfGuest = this.NumOfChildren + this.NumOfAdults;
    }

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalOfGuest();
    }



    public void setNumOfChildren(int numOfChildren) {
        NumOfChildren = numOfChildren;
        calculateTotalOfGuest(); // tính toán lại khi khách điền vào
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

}
