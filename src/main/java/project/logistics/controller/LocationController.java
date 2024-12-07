package project.logistics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.logistics.constant.StatusMessagesEnum;
import project.logistics.dto.ApiResponseDto;
import project.logistics.service.LocationService;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/location/create")
    public ApiResponseDto createLocation(@RequestParam String code, @RequestParam String description) {
        try {
            locationService.createLocation(code, description);
            return new ApiResponseDto(StatusMessagesEnum.STATUS_SUCCESS.name(), StatusMessagesEnum.STATUS_SUCCESS.msg(), null);
        } catch (Exception e) {
            return new ApiResponseDto(StatusMessagesEnum.STATUS_FAILED.name(), e.getMessage(), null);
        }
    }
}
