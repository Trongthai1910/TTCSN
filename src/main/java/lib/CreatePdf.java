package lib;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.bouncycastle.asn1.cms.TimeStampAndCRL;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

public class CreatePdf {
    public static void PDFGen(entity.PhieuMuonSach pms) {
    	String pdfPath = "D:\\phieu" +pms.getMaPhieuMuon()+ ".pdf";
        String fontPath = "src\\main\\resources\\Roboto-Regular.ttf"; 

        try {
            PdfWriter writer = new PdfWriter(pdfPath);

            PdfDocument pdfDoc = new PdfDocument(writer);

            Document document = new Document(pdfDoc);

            //font
            FontProgram fontProgram = FontProgramFactory.createFont(fontPath);
            PdfFont font = PdfFontFactory.createFont(fontProgram, "Identity-H");

            //header
            Table tbl_header = new Table(2);
            tbl_header.setWidth(UnitValue.createPercentValue(100));
            
            Cell c_left = new Cell();
            c_left.add(new Paragraph("Hệ thống thư viện ABC").setFont(font).setBold());
            Paragraph p_intro = new Paragraph("Địa chỉ: Nhổn, Bắc Từ Liêm, Hà Nội\n"
            		+ "Số điện thoại: 0123456789\n"
            		+ "Email: thuvienabc@gmail.com")
                    .setFont(font);
            c_left.add(p_intro);
            
            Cell c_right = new Cell();
            String maPhieu = "Mã phiếu: " + pms.getMaPhieuMuon();
            Paragraph p_maPhieu = new Paragraph(maPhieu).setFont(font).setBold();
            c_right.add(p_maPhieu);
            
            String time = "Thời gian: " + Func.PrintDateTime(pms.getThoiGianMuon());
            Paragraph p_time = new Paragraph(time).setFont(font);
            c_right.add(p_time);
            
            tbl_header.addCell(c_left.setBorder(Border.NO_BORDER));
            tbl_header.addCell(c_right.setBorder(Border.NO_BORDER));
            
            document.add(tbl_header);
            
            //body
            Paragraph title = new Paragraph("PHIẾU MƯỢN SÁCH")
                .setFont(font)
                .setBold()
                .setFontSize(20)
                .setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            String username = "Độc giả: " + pms.getHoTen();
            String sdt = "Số điện thoại: " + pms.getSoDienThoai();
            String email = "Email: " + pms.getEmail();
            
            Paragraph user_infor = new Paragraph(username+"\n"
            		+ sdt + "\n"
            		+ email)
                    .setFont(font);
            document.add(user_infor);
            
            
            Table tbl = new Table(4);
            tbl.setWidth(UnitValue.createPercentValue(100));
            
            Table sub_tbl = new Table(2);
            sub_tbl.setWidth(UnitValue.createPercentValue(100));
            sub_tbl.addCell(new Cell().add(new Paragraph("Từ").setFont(font).setTextAlignment(TextAlignment.CENTER)).setBorder(Border.NO_BORDER));
            sub_tbl.addCell(new Cell().add(new Paragraph("Đến").setFont(font).setTextAlignment(TextAlignment.CENTER)).setBorder(Border.NO_BORDER));
            sub_tbl.addCell(new Cell().add(new Paragraph( Func.PrintTime(pms.getThoiGianMuon())).setTextAlignment(TextAlignment.CENTER)).setBorder(Border.NO_BORDER));          
            LocalDate tuNgay = pms.getThoiGianMuon().toLocalDateTime().toLocalDate();
            LocalDate denNgay = tuNgay.plus(7,ChronoUnit.DAYS);  
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
            sub_tbl.addCell(new Cell().add(new Paragraph(denNgay.format(formatter)+"").setTextAlignment(TextAlignment.CENTER)).setBorder(Border.NO_BORDER));
            
            tbl.addCell(new Cell().add(new Paragraph("Mã sách").setFont(font).setTextAlignment(TextAlignment.CENTER)));
            tbl.addCell(new Cell().add(new Paragraph("Tên sách").setFont(font).setTextAlignment(TextAlignment.CENTER)));
            tbl.addCell(new Cell().add(new Paragraph("Thời hạn").setFont(font).setTextAlignment(TextAlignment.CENTER)));
            tbl.addCell(new Cell().add(new Paragraph("Giá tiền thế chấp (VND)").setFont(font).setTextAlignment(TextAlignment.CENTER)));
            
            tbl.addCell(new Cell().add(new Paragraph(pms.getSach().getMaSach()+"").setFont(font)));
            tbl.addCell(new Cell().add(new Paragraph(pms.getSach().getTenSach()).setFont(font)));
            tbl.addCell(new Cell().add(sub_tbl));
            tbl.addCell(new Cell().add(new Paragraph(pms.getSoTienTheChap()+"")));
            
            document.add(tbl);
            
            
            Paragraph p_thank = new Paragraph("\n\nCảm ơn quý khách đã sử dụng dịch vụ của chúng tôi."
            		+ " Vui lòng kiểm tra thông tin trên phiếu và kiểm tra sản phẩm trước khi ra khỏi thư viện.")
            		.setFont(font)
            		.setFontSize(10)
            		.setBold()
            		.setTextAlignment(TextAlignment.CENTER);
            document.add(p_thank);
            //close
            document.close();

            System.out.println("Tệp PDF đã được tạo thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

