package app.xquare.dms.domain.stay.adaptor.inbound.web;

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
@RequestMapping("/excel/stay")
public class StayExcelController {

    private final StayStatusExcel stayStatusExcel;

    @GetMapping
    public void stay(HttpServletResponse response) throws IOException {

        Workbook workbook = stayStatusExcel.createWorkHook();

        String filename = "잔류신청명단.xlsx";

        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("KSC5601"), "8859_1"));

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
