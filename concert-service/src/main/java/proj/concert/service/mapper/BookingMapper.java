package proj.concert.service.mapper;

import proj.concert.common.dto.BookingDTO;
import proj.concert.common.dto.SeatDTO;
import proj.concert.service.domain.Booking;
import proj.concert.service.domain.Seat;

import java.util.ArrayList;
import java.util.List;

public class BookingMapper {
    //make these methods static since we will be calling them
    public static BookingDTO toDTO(Booking booking){
        //need to complete dto seats first since we need to add the seats into our booking mapper
        List<SeatDTO> dtoS = new ArrayList<>();
        List<Seat> seats = booking.getSeats();
        for (Seat s : seats){
            dtoS.add(SeatMapper.toDTO(s));
        }

        BookingDTO DTOto = new BookingDTO(booking.getConcertId(), booking.getDate(), dtoS);
        return DTOto;

    }


}
