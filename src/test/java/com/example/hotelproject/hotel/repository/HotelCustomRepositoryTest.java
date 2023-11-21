package com.example.hotelproject.hotel.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelFilter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.SliceImpl;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
class HotelCustomRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @DisplayName("호텔 검색 slice 테스트")
    @Test
    @Transactional
    void searchHotelsBasicScroll() {
        String hotelName = "호텔";
        //given
        for (int i = 1; i < 15; i++) {
            hotelRepository.save(Hotel.builder()
                    .hotelName(hotelName + i)
                    .grade(4)
                    .starRateAverage(0)
                    .build());
        }
        for (int i = 15; i < 20; i++) {
            hotelRepository.save(Hotel.builder()
                    .hotelName(hotelName + i)
                    .grade(3)
                    .starRateAverage(0)
                    .build());
        }
        //when
        HotelFilter filter = HotelFilter.builder()
                .grade(4)
                .build();

        int limit = 10;
        SliceImpl<Hotel> result = (SliceImpl<Hotel>) hotelRepository.searchHotelsBasic(
                null, limit, filter);
        //then
        assertThat(result).hasSize(10);
        assertThat(result.getContent().get(0).getGrade()).isEqualTo(4);
    }

    @Test
    void findByHotelOptions() {
        //given
        List<String> optioncode = List.of("BREAKFAST", "FITNESS");
        //when
        List<Hotel> result = hotelRepository.findAllByOptions(optioncode);
        //then
        assertThat(result).hasSize(1);

    }
}