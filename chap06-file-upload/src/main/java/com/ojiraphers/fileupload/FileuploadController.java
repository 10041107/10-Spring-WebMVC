package com.ojiraphers.fileupload;

import jakarta.annotation.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileuploadController {

    @Resource
    private ResourceLoader rescourceLoader;

    @RequestMapping(value = {"/", "/main"})
    public String index() {
        return "main";
    }

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singlefile, String singleFileDescription, Model model) throws IOException {
        System.out.println("single file : " + singlefile);
        System.out.println("원본 파일 이름 : " + singlefile.getOriginalFilename());
        System.out.println("파일 이름 : " + singlefile.getName());
//        System.out.println("원본 파일 객체 : " + singlefile.getBytes());
        System.out.println("원본 파일 사이즈 : " + singlefile.getSize());

        //파일을 저장할 경로 설정
//        String root = "c:/upload-files";
//        String filePath = root + "/single";

        String filePath = rescourceLoader.getResource("classpath:static/img").getFile().getAbsolutePath();

        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());

        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 파일 경로가 존재하지 않으면 만들겠다

        String originFileName = singlefile.getOriginalFilename();

        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
        // = 파일 확장자 떼고 관리하겠다
        try {

            System.out.println("filePath================= " + filePath);
            singlefile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 성공");
            model.addAttribute("img","static/img/"+savedName);

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패");
        }

        return "result";
    }


    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multipartFiles,
                                  String multiFileDescription, Model model) {
        System.out.println("multiFiles : " + multipartFiles);
        System.out.println("multiFileDescription : " + multiFileDescription);

        String root = "c:/upload-files";
        String filePath = root + "/multi";
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs(); // 여기까지 :파일 업로드할건데 폴더 없으면 폴더도 만들어라
//            dir.mkdir(); : 상위 폴더가 존재하는 경우
        }

        List<FileDTO> files = new ArrayList<>();


        try {
            for (MultipartFile file : multipartFiles) {
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
                files.add(new FileDTO(originFileName, savedName, filePath, multiFileDescription));
                file.transferTo(new File(filePath, "/" + savedName));
            }
            model.addAttribute("message", "다중 파일 업로드 성공");

        } catch (IOException e) {
            e.printStackTrace();

            for (FileDTO file : files) {
                new File(filePath + "/" + file.getSavedName()).delete();
            }
            model.addAttribute("message", "다중 파일 업로드 실패");
        }

        return "result";
    }




}
