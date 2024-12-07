package project.logistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.logistics.dto.ItemDto;
import project.logistics.entity.Item;
import project.logistics.entity.Receiving;
import project.logistics.repository.ItemRepository;
import project.logistics.repository.ReceivingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceivingService {

    private final ReceivingRepository receivingRepository;
    private final ItemRepository itemRepository;

    /**
     * Receiving 데이터 생성
     * @param time
     * @param carNo
     * @param receiving_code
     */
    @Transactional
    public void saveReceiving(String time, String carNo, String receiving_code){
        Receiving entity = Receiving.builder()
                .time(time)
                .carNo(carNo)
                .receivingCode(receiving_code)
                .build();

        receivingRepository.save(entity);
    }

    @Transactional
    public void saveItems(List<ItemDto> items, Long receivingId) {
        Receiving receivingEntity = receivingRepository.findById(receivingId).orElseThrow();
        for (ItemDto dto : items) {
            Item item=Item.builder()
                    .barcode(dto.getBarcode())
                    .receiving(receivingEntity)
                    .build();
            itemRepository.save(item);
        }
    }
}
