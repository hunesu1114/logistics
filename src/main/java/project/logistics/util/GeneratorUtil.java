package project.logistics.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.logistics.entity.Item;
import project.logistics.entity.Receiving;
import project.logistics.repository.ItemRepository;
import project.logistics.repository.ReceivingRepository;
import project.logistics.service.ReceivingService;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Component
@RequiredArgsConstructor
public class GeneratorUtil {

    private final List<String> Hanguel = Arrays.asList(new String[]{"가", "나", "다", "라", "마", "바", "사", "아", "자", "차", "카", "타", "파", "하"});
    private final ReceivingRepository receivingRepository;
    private final ItemRepository itemRepository;

    public void generateReceiving() {
        // car_no 랜덤, time=now, receiving_code 랜덤
        // barcode 랜덤 숫자
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String formattedDate = formatter.format(now);

        Random random = new Random();
        String randomCarNo = random.nextInt(999) + Hanguel.get(random.nextInt(14)) + random.nextInt(9999);
        String randomReceivingCode= UUID.randomUUID().toString().replace("-", "").substring(0, 12);

        Receiving receiving=Receiving.builder()
                .carNo(randomCarNo)
                .receivingCode(randomReceivingCode)
                .time(formattedDate)
                .build();

        Receiving savedReceiving = receivingRepository.saveAndFlush(receiving);

        int itemCnt= random.nextInt(500);
        for (int i = 0; i < itemCnt; i++) {
            Item item = Item.builder()
                    .barcode(generateEAN13())
                    .receiving(savedReceiving)
                    .cnt(random.nextInt(40))
                    .isDisplayed('N')
                    .build();
            itemRepository.save(item);
        }
    }

    // EAN13 형식으로 바코드 랜덤 생성
    private String generateEAN13() {
        Random random = new Random();
        int[] digits = new int[12];

        // 12자리 랜덤 숫자 생성
        for (int i = 0; i < 12; i++) {
            digits[i] = random.nextInt(10);
        }

        // 체크섬 계산
        int checksum = calculateChecksum(digits);

        // 바코드 형식으로 반환 (12자리 + 체크섬)
        StringBuilder barcode = new StringBuilder();
        for (int digit : digits) {
            barcode.append(digit);
        }
        barcode.append(checksum);

        return barcode.toString();
    }

    // EAN-13 체크섬 계산 함수
    private int calculateChecksum(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += (i % 2 == 0) ? digits[i] : digits[i] * 3;
        }
        int checksum = (10 - (sum % 10)) % 10;
        return checksum;
    }
}
