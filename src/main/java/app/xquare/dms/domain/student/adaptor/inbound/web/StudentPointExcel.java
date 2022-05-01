package app.xquare.dms.domain.student.adaptor.inbound.web;

import app.xquare.dms.domain.student.application.port.inbound.GetPointBreakDownUseCase;
import app.xquare.dms.domain.student.application.port.inbound.GetStudentListUseCase;
import app.xquare.dms.domain.student.domain.PointHistory;
import app.xquare.dms.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StudentPointExcel {

    private final GetPointBreakDownUseCase getPointBreakDownUseCase;
    private final GetStudentListUseCase getStudentListUseCase;

    public Workbook createWorkHook() {
        Workbook workbook = new XSSFWorkbook();

        createPointStatusSheet(workbook);
        createPointHistorySheet(workbook, 1);
        createPointHistorySheet(workbook, 2);
        createPointHistorySheet(workbook, 3);

        return workbook;
    }

    private void createPointStatusSheet(Workbook workbook) {
        int rowNo = 0;
        Sheet sheet = workbook.createSheet("상벌점 현황");

        Row headerRow = sheet.createRow(rowNo++);

        headerRow.createCell(0).setCellValue("학번");
        headerRow.createCell(1).setCellValue("이름");
        headerRow.createCell(2).setCellValue("상점");
        headerRow.createCell(3).setCellValue("벌점");
        headerRow.createCell(4).setCellValue("교육단계");

        List<Student> students = getStudentListUseCase.getStudentList().getStudents();

        for(Student student : students) {
            Row row = sheet.createRow(rowNo++);

            row.createCell(0).setCellValue(student.getNum());
            row.createCell(1).setCellValue(student.getName());
            row.createCell(2).setCellValue(student.getGoodPoint());
            row.createCell(3).setCellValue(student.getBadPoint());
            row.createCell(4).setCellValue(student.getPenaltyLevel());
        }
    }

    private void createPointHistorySheet(Workbook workbook, Integer grade) {
        int rowNo = 0;
        Sheet sheet = workbook.createSheet(String.format("상벌점 내역 - %d학년", grade));

        Row headerRow = sheet.createRow(rowNo++);

        headerRow.createCell(0).setCellValue("날짜");
        headerRow.createCell(1).setCellValue("학번");
        headerRow.createCell(2).setCellValue("이름");
        headerRow.createCell(3).setCellValue("구분");
        headerRow.createCell(4).setCellValue("점수");
        headerRow.createCell(5).setCellValue("사유");
        headerRow.createCell(6).setCellValue("비고");

        List<PointHistory> pointHistories = getPointBreakDownUseCase.getPointBreakDown(grade);

        for(PointHistory pointHistory : pointHistories) {
            Row row = sheet.createRow(rowNo++);

            row.createCell(0).setCellValue(pointHistory.getDate().toString());
            row.createCell(1).setCellValue(pointHistory.getNum());
            row.createCell(2).setCellValue(pointHistory.getName());
            row.createCell(3).setCellValue(pointHistory.getPointType() ? "상점" : "벌점");
            row.createCell(4).setCellValue(pointHistory.getPoint());
            row.createCell(5).setCellValue(pointHistory.getReason());
        }
    }
}