package com.example.separation.controller;


import com.example.separation.entity.completions.Completion;
import com.example.separation.entity.completions.CompletionResponse;
import com.example.separation.entity.edits.Edit;
import com.example.separation.entity.edits.EditResponse;
import com.example.separation.entity.models.Model;
import com.example.separation.entity.models.images.ImageResponse;
import com.example.separation.entity.models.images.Item;
import com.example.separation.entity.req.OpenRequest;
import com.example.separation.utils.OpenAiClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/open")
@Slf4j
@Api(value = "chatGPT接口", tags = "chatGPT接口")
public class OperAiController {


    @ApiOperation(value = "文本问答")
    @PostMapping("/text")
    public CompletionResponse getByUserName(@RequestBody OpenRequest req) {
        log.info("请求参数是：test {}：", req.getText());
        OpenAiClient v2 = new OpenAiClient("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");
        Completion q = Completion.builder()
                .prompt(req.getText())
                .model("text-davinci-003")
                .build();
        CompletionResponse completions = v2.completions(q);
        if (Objects.nonNull(completions)) {
            return completions;
        }
        return null;
    }

    @ApiOperation(value = "根据描述生成图片")
    @PostMapping("/image")
    public ImageResponse getimage(@RequestBody OpenRequest text) {
        log.info("请求参数是：test {}：", text.getText());
        OpenAiClient v2 = new OpenAiClient("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");
        Completion q = Completion.builder()
                .prompt(text.getText())
                .model("text-davinci-003")
                .build();
        ImageResponse imageResponse = v2.genImages(text.getText());
        if (Objects.nonNull(imageResponse)) {
            return imageResponse;
        }
        return null;
    }


    @ApiOperation(value = "openAi模型列表")
    @GetMapping("/model")
    public List<Model> models() {
        OpenAiClient v2 = new OpenAiClient("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");
        List<Model> models = v2.models();
        return models;
    }




    @ApiOperation(value = "列表1")
    @PostMapping("/model1111")
    public String modelsTest() {

        return "测试接口";
    }


    @ApiOperation(value = "文本修改")
    @PostMapping("/updateText")
    public EditResponse editText(@RequestBody OpenRequest text) {
        //文本修改
//        Edit edit = Edit.builder().input("我爱你麻麻").instruction("帮我修改错别字").model(Edit.Model.TEXT_DAVINCI_EDIT_001.getName()).build();
        //代码修改 NB....
        OpenAiClient v2 = new OpenAiClient("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");
        Edit edit = Edit.builder().input(text.getText()).instruction(text.getQuestion()).model(Edit.Model.CODE_DAVINCI_EDIT_001.getName()).build();
        EditResponse editResponse = v2.edit(edit);

        return editResponse;
    }

    @ApiOperation(value = "图片修改")
    @GetMapping("/updateImage")
    public List<Item> editImageV3(@RequestParam("text") String text, @RequestParam("file") MultipartFile file) {
        OpenAiClient v2 = new OpenAiClient("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");
        File file1 = MultipartFileToFile(file);
        List<Item> itemList = v2.editImages(file1, "去除图片中的文字");
        return itemList;

    }


    /**
     * MultipartFile 转 File
     *
     * @param multipartFile
     * @throws Exception
     */
    public File MultipartFileToFile(MultipartFile multipartFile) {

        File file = null;
        //判断是否为null
        if (multipartFile.equals("") || multipartFile.getSize() <= 0) {
            return file;
        }
        //MultipartFile转换为File
        InputStream ins = null;
        OutputStream os = null;
        try {
            ins = multipartFile.getInputStream();
            file = new File(multipartFile.getOriginalFilename());
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }


}
