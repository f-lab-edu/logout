package com.example.hotelproject.hotel.repository;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelOption;
import com.example.hotelproject.owner.entity.Owner;
import com.example.hotelproject.owner.repository.OwnerRepository;
import com.example.hotelproject.review.controller.request.PageRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@Sql({"classpath:sql/hotel.sql"})
@SpringBootTest
class HotelRepositoryTestWithSQL {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private HotelOptionRepository hotelOptionRepository;

    @DisplayName("호텔 정보 저장")
    @Test
    void save() {
        // given
        Owner owner = ownerRepository.save(
                Owner.builder()
                        .ownerId("ownerId")
                        .name("name")
                        .password("password")
                        .email("email")
                        .address("address")
                        .mobile("mobile")
                        .enabled(true)
                        .build()
        );

        List<HotelOption> hotelOptions = hotelOptionRepository.saveAll(
                List.of(
                        HotelOption.builder()
                                .code("BREAKFAST")
                                .description("description")
                                .build(),
                        HotelOption.builder()
                                .code("SMOKE")
                                .description("description")
                                .build()
                )
        );

        Hotel hotel = Hotel.builder()
                .hotelName("name")
                .hotelType("type")
                .location("location")
                .grade(5)
                .checkin("checkin")
                .checkout("checkout")
                .owner(owner)
                .options(hotelOptions)
                .starRateAverage(5.0f)
                .build();

        // when
        Hotel savedHotel = hotelRepository.save(hotel);

        // then
        List<String> savedHotelOptionCodes = savedHotel.getOptions().stream()
                .map(HotelOption::getCode)
                .collect(Collectors.toList());

        assertThat(savedHotel.getHotelNo()).isEqualTo(6L);
        assertThat(savedHotelOptionCodes).isEqualTo(List.of("BREAKFAST", "SMOKE"));
    }

    @DisplayName("호텔 조회")
    @Test
    void searchHotels() {
        // given
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
}