package proj.concert.service.domain;
// assertEquals(1L, booking.getConcertId());
//        assertEquals(LocalDateTime.of(2020, 2, 15, 20, 0, 0), booking.getDate());
//        assertEquals(2, booking.getSeats().size());
//        booking.getSeats().sort(Comparator.comparing(SeatDTO::getLabel));
//        assertEquals("C5", booking.getSeats().get(0).getLabel());
//        assertEquals("C6", booking.getSeats().get(1).getLabel());
//

import proj.concert.common.dto.SeatDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    private long concertId;
    private LocalDateTime date;

    @ManyToOne
    private User user;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.REMOVE})
    private Set<Seat> seats = new HashSet<>(); //set? no duplicates?

    public Booking() {
    }

    public Booking(long concertId, LocalDateTime date, Set<Seat> seats, User user) {
        this.concertId = concertId;
        this.date = date;
        this.seats = seats;
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public long getConcertId() {
        return concertId;
    }

    public void setConcertId(long concertId) {
        this.concertId = concertId;
    }

    public long getId() { return this.bookingId; }

    public User getUser() { return this.user; }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public long getBookingId() {
        return this.bookingId;
    }

}
