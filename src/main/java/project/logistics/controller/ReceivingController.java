package project.logistics.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import project.logistics.dto.ApiResponseDto;
import project.logistics.dto.ItemDto;
import project.logistics.constant.StatusMessagesEnum;
import project.logistics.service.ReceivingService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReceivingController {

    private final ReceivingService receivingService;

    // 입고 데이터 등록
    @PostMapping("/receivingReg")
    public ApiResponseDto receivingReg(@RequestParam("time") String time, @RequestParam("carNo") String carNo, @RequestParam("receiving_code") String receiving_code) {
        try{
            receivingService.saveReceiving(time, carNo, receiving_code);
            return new ApiResponseDto(StatusMessagesEnum.STATUS_SUCCESS.name(),StatusMessagesEnum.STATUS_SUCCESS.msg(),null);
        } catch(Exception e){
            return new ApiResponseDto(StatusMessagesEnum.STATUS_FAILED.name(),e.getMessage(),null);
        }


    }

    @PostMapping("/receivingItems")
    public ApiResponseDto receivingItems(@RequestBody List<ItemDto> items, @RequestParam Long receivingId){
        try{
            receivingService.saveItems(items, receivingId);
            return new ApiResponseDto(StatusMessagesEnum.STATUS_SUCCESS.name(),StatusMessagesEnum.STATUS_SUCCESS.msg(),null);
        } catch(Exception e){
            return new ApiResponseDto(StatusMessagesEnum.STATUS_FAILED.name(),e.getMessage(),null);
        }
    }


}
