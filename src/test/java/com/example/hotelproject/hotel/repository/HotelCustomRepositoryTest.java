package com.example.hotelproject.hotel.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelFilter;
import com.example.hotelproject.hotel.entity.HotelOption;
import com.example.hotelproject.hotel.entity.HotelOptions;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import com.example.hotelproject.utils.IntegrationTestSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
class HotelCustomRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelOptionRepository hotelOptionRepository;

    @Autowired
    private HotelOptionsRepository hotelOptionsRepository;

    @BeforeEach
    void setUp() {
        cleanUp();

        //hotel option 공통코드 세팅
        setHotelOptionList();

        //set , logic 작성 하면 됨!!!!!!!!
    }

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
                    .build());
        }
        for (int i = 15; i < 20; i++) {
            hotelRepository.save(Hotel.builder()
                    .hotelName(hotelName + i)
                    .grade(3)
                    .build());
        }
        //when
        HotelFilter filter = HotelFilter.builder()
                .grade(4)
                .build();

        int limit = 10;
        List<Hotel> result = hotelRepository.searchHotelsBasic(
                null, limit, filter);
        //then
        assertThat(result).hasSize(10);
//        assertThat(result.getContent().get(0).getGrade()).isEqualTo(4);
    }

    @Test
    @DisplayName("hotel option 쿼리 테스트")
    void findByHotelOptions() {
        //given
        List<String> optioncode = List.of("BREAKFAST", "FITNESS");
        //when
        List<Hotel> result = hotelRepository.findAllByOptions(optioncode);
        //then
        assertThat(result).hasSize(1);

    }

    @Test
    @DisplayName("호텔 검색 기능 테스트")
    void searchHotelsBasic() {
        //given
        //샘플 options
        List<String> optioncodes1 = new ArrayList<>(
                Arrays.asList("BREAKFAST", "FITNESS", "SWIMMINGPOOL"));
        List<String> optioncodes2 = new ArrayList<>(Arrays.asList("BREAKFAST", "FITNESS"));
        List<String> optioncodes3 = new ArrayList<>(Arrays.asList("PARKING"));

        //호텔 데이터, hotel <-> option 테이블 데이터
        createHotelOptions(createHotel(1L).getHotelNo(), optioncodes1);
        createHotelOptions(createHotel(2L).getHotelNo(), optioncodes1);
        createHotelOptions(createHotel(3L).getHotelNo(), optioncodes2);
        createHotelOptions(createHotel(4L).getHotelNo(), optioncodes3);
        createHotelOptions(createHotel(5L).getHotelNo(), optioncodes3);

        HotelFilter filter = createHotelFilter(null, "HOTEL", "location"
                , 5, List.of("BREAKFAST", "FITNESS"));

        //when
        List<Hotel> result = hotelRepository.searchHotelsBasic(null, 10, filter);

        //then
        assertThat(result).hasSize(3);
    }

    private HotelOption createHotelOptions(String code, String description) {
        return HotelOption.builder()
                .code(code)
                .description(description)
                .build();
    }

    //hotel option 공통 코드
    private void setHotelOptionList() {
        List<String> optioncode = new ArrayList<>(
                Arrays.asList("BREAKFAST", "FITNESS", "SWIMMINGPOOL"));
        for (String option : optioncode) {
            hotelOptionRepository.save(createHotelOptions(option, option));
        }
    }

    private Hotel createHotel(Long hotelNo) {
        return hotelRepository.save(Hotel.builder()
                .hotelNo(hotelNo)
                .hotelName("hotel" + hotelNo)
                .hotelType(HotelTypeEnum.HOTEL)
                .location("location")
                .grade(5)
                .checkin("15:00")
                .checkout("12:00")
                .build());
    }

    // hotel <-> option 관계 테이블
    private void createHotelOptions(Long hotelNo, List<String> optionCodes) {
        Hotel hotel = hotelRepository.findByHotelNo(hotelNo)
                .orElseThrow(() -> new EntityNotFoundException("no hotel : " + hotelNo));

        for (String option : optionCodes) {
            HotelOption hotelOption = hotelOptionRepository.findByCode(option);

            hotelOptionsRepository.save(HotelOptions.builder()
                    .hotel(hotel)
                    .hotelOption(hotelOption)
                    .build());
        }
    }

    private HotelFilter createHotelFilter(String hotelName, String hotelType, String location,
            int grade, List<String> optionCodes) {
        return HotelFilter.builder()
                .hotelName(hotelName)
                .hotelType(hotelType)
                .location(location)
                .grade(grade)
                .starRateAverage(0.0)
                .optionCode(optionCodes)
                .build();
    }

//    @Test
//    void connectionTest() {
//        hotelRepository.findAll();
//        System.out.println(hotelRepository.findAll());
//    }

}