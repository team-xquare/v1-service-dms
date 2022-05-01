package app.xquare.dms.domain.stay.domain;

import app.xquare.dms.domain.stay.exception.InvalidStayStatusException;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StayStatus {

    private final String id;

    private final String name;

    private final String num;

    private String stay;

    public void setStay(String stay) {
        if(stay.equals("금요귀가") || stay.equals("토요귀가") || stay.equals("토요귀사") || stay.equals("잔류")) {
            this.stay = stay;
        }
        else {
            throw InvalidStayStatusException.EXCEPTION;
        }
    }
}
