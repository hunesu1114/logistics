package project.logistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.logistics.entity.Location;
import project.logistics.repository.LocationRepository;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    @Transactional
    public void createLocation(String code, String description) {
        Location location=Location.builder()
                .code(code)
                .description(description)
                .build();
        locationRepository.save(location);
    }
}
