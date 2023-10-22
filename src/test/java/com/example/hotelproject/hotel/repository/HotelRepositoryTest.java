package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelOption;
import com.example.hotelproject.owner.entity.Owner;
import com.example.hotelproject.owner.repository.OwnerRepository;
import com.example.hotelproject.review.controller.request.PageRequest;
import com.example.hotelproject.utils.IntegrationTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class HotelRepositoryTest extends IntegrationTestSupport {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private HotelOptionRepository hotelOptionRepository;

    private static Owner OWNER;
    private static HotelOption BREAKFAST;
    private static HotelOption SMOKE;

    @BeforeEach
    void setUp() {
        cleanUp();

        OWNER = ownerRepository.save(createOwner());
        BREAKFAST = hotelOptionRepository.save(createHotelOption("BREAKFAST"));
        SMOKE = hotelOptionRepository.save(createHotelOption("SMOKE"));
    }

    @DisplayName("호텔 정보 저장")
    @Test
    void save() {
        // given
        List<HotelOption> hotelOptions = List.of(BREAKFAST, SMOKE);
        Hotel hotel = createHotel(1L, hotelOptions);

        // when
        Hotel savedHotel = hotelRepository.save(hotel);

        // then
        List<String> savedHotelOptionCodes = savedHotel.getOptions().stream()
                .map(HotelOption::getCode)
                .collect(Collectors.toList());


        assertThat(savedHotel.getHotelNo()).isEqualTo(1L);
        assertThat(savedHotelOptionCodes).isEqualTo(List.of("BREAKFAST", "SMOKE"));
    }

    @DisplayName("호텔 조회")
    @Test
    void searchHotels() {
        // given
        List<String> hotelOptionCodes = List.of("BREAKFAST", "SMOKE");
        List<Hotel> hotels = List.of(
                createHotel(1L, "A호텔", "호텔", "서울", 5,  List.of(BREAKFAST, SMOKE)),
                createHotel(2L, "B호텔", "호텔", "서울", 5,  List.of(BREAKFAST, SMOKE)),
                createHotel(3L, "A호텔", "민박", "서울", 5,  List.of(BREAKFAST, SMOKE)),
                createHotel(4L, "A호텔", "호텔", "대전", 5,  List.of(BREAKFAST, SMOKE)),
                createHotel(5L, "A호텔", "호텔", "서울", 4,  List.of(BREAKFAST, SMOKE))
        );

        hotelRepository.saveAll(hotels);

        PageRequest pageRequest = new PageRequest();

        Hotel hotelFilter = createHotelFilter("A호텔", "호텔", "서울", 5);

        // when
        PageImpl<Hotel> result = hotelRepository.searchHotels(pageRequest.of(), hotelFilter);

        // then
        assertThat(result.getContent()).hasSize(1);
        assertThat(result.getContent().get(0).getHotelNo()).isEqualTo(1L);
    }

    private Hotel createHotelFilter(String hotelName, String hotelType, String location, int grade) {
        return Hotel.builder()
                .hotelName(hotelName)
                .hotelType(hotelType)
                .location(location)
                .grade(grade)
                .build();
    }

    private Hotel createHotel(Long hotelNo, List<HotelOption> hotelOptions) {
        return createHotel(hotelNo, "hotelName", "type", "location", 5,  hotelOptions);
    }

    private Hotel createHotel(Long hotelNo, String hotelName, String hotelType, String location, int grade, List<HotelOption> hotelOptions) {
        return Hotel.builder()
                .hotelNo(hotelNo)
                .hotelName(hotelName)
                .hotelType(hotelType)
                .location(location)
                .grade(grade)
                .checkin("checkin")
                .checkout("checkout")
                .owner(OWNER)
                .options(hotelOptions)
                .starRateAverage(5.0f)
                .build();
    }

    private HotelOption createHotelOption(String code) {
        return HotelOption.builder()
                .code(code)
                .description("description")
                .build();
    }

    private Owner createOwner() {
        return Owner.builder()
                .ownerId("ownerId")
                .name("name")
                .password("password")
                .email("email")
                .address("address")
                .mobile("mobile")
                .enabled(true)
                .build();
    }
}