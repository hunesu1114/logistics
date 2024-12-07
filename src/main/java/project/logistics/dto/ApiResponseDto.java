package project.logistics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDto {
    private String status;
    private String msg;
    private ApiResponseData data;

}
