package app.xquare.dms.domain.student.application.port.inbound;

public interface DeletePointHistoryUseCase {

    void deletePointHistory(String studentId, String historyId);
}
