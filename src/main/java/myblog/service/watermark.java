package myblog.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.awt.*;
import java.io.File;


public interface watermark {

    public static final String MARK_TEXT = "哈哈哈";

    public static final int FONT_STYLE = Font.BOLD;
    public static final String FONT_NAME = "微软雅黑";
    public static final int FONT_SIZE = 120;
    public static final Color FONT_COLOR = Color.BLACK;

    public static final int X = 10;
    public static final int Y = 10;

    public static float ALPHA = 0.3F;
    public static final String LOGO = "logo.jpg";

    /**
     * 文本水印
     * @param file
     * @param filename
     * @param uploadPath
     * @param realUploadPath
     * @return
     */
    public String watermark(File file, String filename, String uploadPath, String realUploadPath);

    /**
     * 图片水印
     * @param file
     * @param filename
     * @param uploadPath
     * @param realUploadPath
     * @return
     */
    public String imagemark(File file, String filename, String uploadPath, String realUploadPath);

    /**
     * 多个文本水印
     * @param file
     * @param filename
     * @param uploadPath
     * @param realUploadPath
     * @return
     */
    public String morewatermark(File file, String filename, String uploadPath, String realUploadPath);

    /**
     * 多个图片水印
     * @param file
     * @param filename
     * @param uploadPath
     * @param realUploadPath
     * @return
     */
    public String moreimgmark(File file, String filename, String uploadPath, String realUploadPath);
}
