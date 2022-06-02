package app.xquare.dms.domain.student.domain;

import app.xquare.dms.domain.point.domain.Point;
import app.xquare.dms.domain.student.exception.InvalidPointException;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Student {

    private final String id;

    private final String name;

    private final String num;

    private Integer goodPoint;

    private Integer badPoint;

    private Integer penaltyLevel;

    private Boolean isPenaltyRequired;

    private String stayApply;

    private String mealApply;

    public void addPoint(Point point) {
        if(point.isGoodPoint()) setGoodPoint(point.getPoint());
        else setBadPoint(point.getPoint());
    }

    public void completeTraining() {
        setGoodPoint(-5);
        isPenaltyRequired = false;
        setBadPoint(-5);
    }

    private void setGoodPoint(Integer point) {
        goodPoint += point;
        if(goodPoint < 0) {
            goodPoint -= point;
            throw InvalidPointException.EXCEPTION;
        }
    }

    private void setBadPoint(Integer point) {
        badPoint += point;

        if(!isPenaltyRequired && isOverBound(penaltyLevel+1, badPoint)) {
            penaltyLevel++;
            isPenaltyRequired = true;
        }
    }

    private boolean isOverBound(Integer level, Integer point) {
        return point >= PenaltyLevel.BOUNDS[level];
    }
}
