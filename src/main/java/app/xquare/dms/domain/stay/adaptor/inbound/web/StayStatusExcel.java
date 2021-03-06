package app.xquare.dms.domain.stay.adaptor.inbound.web;

import app.xquare.dms.domain.stay.application.port.inbound.GetStayApplyListUseCase;
import app.xquare.dms.domain.stay.domain.StayStatus;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StayStatusExcel {

    private final GetStayApplyListUseCase getStayApplyListUseCase;

    public Workbook createWorkHook() {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("잔류신청명단");

        Row row1 = sheet.createRow(1);
        Row row2 = sheet.createRow(24);
        Row row3 = sheet.createRow(47);

        setHeaderRow(row1);
        setHeaderRow(row2);
        setHeaderRow(row3);

        List<StayStatus> stayStatuses = getStayApplyListUseCase.getStayApplyList().getStudents();

        // row: 23n - 21 + num -1, n은 학년, num은 학번
        // column: 4n - 3 , n은 반
        for(StayStatus stayStatus : stayStatuses) {
            int grade = Integer.parseInt(String.valueOf(stayStatus.getNum().charAt(0)));
            int cls = Integer.parseInt(String.valueOf(stayStatus.getNum().charAt(1)));
            int number = Integer.parseInt(stayStatus.getNum().substring(2, 4));

            int rowNo = 23 * grade - 22 + number; // 2
            int columnNo = 4 * cls - 3; // 1

            Row row = sheet.getRow(rowNo) == null ? sheet.createRow(rowNo) : sheet.getRow(rowNo);
            row.createCell(columnNo++).setCellValue(stayStatus.getNum());
            row.createCell(columnNo++).setCellValue(stayStatus.getName());
            row.createCell(columnNo).setCellValue(stayStatus.getStay());
        }

        return workbook;
    }

    private void setHeaderRow(Row row) {
        row.createCell(1).setCellValue("학번");
        row.createCell(2).setCellValue("이름");
        row.createCell(5).setCellValue("학번");
        row.createCell(6).setCellValue("이름");
        row.createCell(9).setCellValue("학번");
        row.createCell(10).setCellValue("이름");
        row.createCell(13).setCellValue("학번");
        row.createCell(14).setCellValue("이름");
    }
}
