package app.xquare.dms.domain.excel.adaptor.inbound.web;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/excel")
public class ExcelController {

    private final StudentPointExcel studentPointExcel;

    @GetMapping("/point")
    public void point(HttpServletResponse response) throws IOException {

        Workbook workbook = studentPointExcel.createWorkHook();

        String filename = LocalDate.now().getYear() + "년 우정관 상벌점 현황.xlsx";

        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("KSC5601"), "8859_1"));

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
