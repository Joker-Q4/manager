package com.sau.controller;

import com.sau.entity.FileBinding;
import com.sau.global.JsonTools;
import com.sau.service.FileService;
import com.sau.utils.CommonUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    FileService fileService;

    @PostMapping("/upload")
    public Map<String, Object> addThesis(MultipartFile file) {
        FileBinding fileBinding = CommonController.getFile(file);
        if(fileBinding == null || !fileService.addFile(fileBinding)){
            return JsonTools.toResult(1, "文件保存失败", 0, null);
        }
        return JsonTools.toResult(0, "保存成功", 1, fileBinding);
    }

    @GetMapping("/download/{id}")
    public String downLoad(@PathVariable Integer id,
                           HttpServletResponse response)
            throws UnsupportedEncodingException {
        FileBinding fileBinding = fileService.getFile(id);
        File file = new File(CommonUtil.PATH + fileBinding.getPath());
        if (file.exists()) { //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(fileBinding.getName(), "UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis; //文件输入流
            BufferedInputStream bis;
            OutputStream os; //输出流

            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
                System.out.println("----------file download---" + fileBinding.getName());
                bis.close();
                fis.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
