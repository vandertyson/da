package com.concretepage.utils;

import com.concretepage.entity.SalesQuotation;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class PdfFromXmlFile {

    public static String exportQuotation(SalesQuotation quot) throws JRException, IOException {
        JasperReport jasperReport = JasperCompileManager
                .compileReport("D:\\ĐỒ ÁN TỐT NGHIỆP\\jasper\\Invoice.jrxml");

        // Tham số truyền vào báo cáo.
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportTitle", quot.getCode());
        System.out.println(parameters.get("ReportTitle"));
        // DataSource
        // Đây là báo cáo đơn giản, không kết nối vào DB
        // vì vậy không cần nguồn dữ liệu.
        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters, dataSource);

        // Chạy báo cáo và export ra file PDF.
        String ouputPath = "D:\\ĐỒ ÁN TỐT NGHIỆP\\jasper_out\\quotation_" + System.currentTimeMillis() + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, ouputPath
        );
        return ouputPath;
    }
}
