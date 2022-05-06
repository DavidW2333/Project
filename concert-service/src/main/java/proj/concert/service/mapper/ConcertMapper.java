package proj.concert.service.mapper;

import proj.concert.common.dto.ConcertDTO;
import proj.concert.common.dto.ConcertSummaryDTO;
import proj.concert.common.dto.PerformerDTO;
import proj.concert.service.domain.Concert;
import proj.concert.service.domain.Performer;

import java.time.LocalDateTime;
import java.util.*;

public class ConcertMapper {

    public static ConcertDTO toConcertDTO(Concert c) {
        ConcertDTO concertDTO = new ConcertDTO(c.getId(), c.getTitle(), c.getImageName(), c.getBlurb());

        Set<Performer> p = c.getPerformers(); //get a set of performers
        List<PerformerDTO> pDTO = new ArrayList<>();
        for (Performer performer : p) {
            pDTO.add(PerformerMapper.toPerformerDTO(performer));
        }

        concertDTO.setPerformers(pDTO);

        Set<LocalDateTime> t = c.getDates();
        List<LocalDateTime> times = new ArrayList<>();
        for (LocalDateTime time : t) {
            times.add(time);
        }

        concertDTO.setDates(times);

        return concertDTO;
    }

    public static ConcertSummaryDTO toConcertSummaryDTO(Concert c) {
        ConcertSummaryDTO concertSummaryDTO = new ConcertSummaryDTO(c.getId(), c.getTitle(), c.getImageName());

        return concertSummaryDTO;
    }



}
