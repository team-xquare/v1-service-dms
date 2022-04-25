package app.xquare.dms.domain.student.application.port.inbound;

public interface CompleteTrainingUseCase {

    void completeTraining(String studentId, Integer penaltyLevel);
}
