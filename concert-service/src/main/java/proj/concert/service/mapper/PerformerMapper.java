package proj.concert.service.mapper;

import proj.concert.common.dto.PerformerDTO;
import proj.concert.service.domain.Performer;

public class PerformerMapper {

    public static PerformerDTO toPerformerDTO(Performer p) {
        PerformerDTO pDTO = new PerformerDTO(p.getId(), p.getName(), p.getImageName(), p.getGenre(), p.getBlurb());

        return pDTO;
    }

}
