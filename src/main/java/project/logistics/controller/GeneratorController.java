package project.logistics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.logistics.dto.ApiResponseDto;
import project.logistics.constant.StatusMessagesEnum;
import project.logistics.util.GeneratorUtil;

@RestController
@RequiredArgsConstructor
public class GeneratorController {

    private final GeneratorUtil generatorUtil;

    @PostMapping("/gen/receiving")
    public ApiResponseDto genReceiving() {
        try {
            generatorUtil.generateReceiving();
            return new ApiResponseDto(StatusMessagesEnum.STATUS_SUCCESS.name(), StatusMessagesEnum.STATUS_SUCCESS.msg(), null);
        } catch (Exception e) {
            return new ApiResponseDto(StatusMessagesEnum.STATUS_FAILED.name(), e.getMessage(), null);
        }
    }


}
