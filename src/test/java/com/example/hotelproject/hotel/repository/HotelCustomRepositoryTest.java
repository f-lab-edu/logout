package com.example.hotelproject.hotel.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.hotelproject.campaign.entity.Campaign;
import com.example.hotelproject.campaign.entity.CampaignBillingType;
import com.example.hotelproject.campaign.entity.CampaignInventory;
import com.example.hotelproject.campaign.entity.CampaignKind;
import com.example.hotelproject.campaign.repository.CampaignInventoryRepository;
import com.example.hotelproject.campaign.repository.CampaignKindRepository;
import com.example.hotelproject.campaign.repository.CampaignRepository;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelFilter;
import com.example.hotelproject.hotel.entity.HotelOption;
import com.example.hotelproject.hotel.entity.HotelOptions;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import com.example.hotelproject.utils.IntegrationTestSupport;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

@Slf4j
@SpringBootTest
class HotelCustomRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelOptionRepository hotelOptionRepository;

    @Autowired
    private HotelOptionsRepository hotelOptionsRepository;

    @Autowired
    private CampaignKindRepository campaignKindRepository;

    @Autowired
    private CampaignInventoryRepository campaignInventoryRepository;
    @Autowired
    private CampaignRepository campaignRepository;

    @BeforeEach
    void setUp() {
        cleanUp();

        //hotel option 공통코드 세팅
        setHotelOptionList();

        //campaign kind, inventory 공통코드 세팅
        setCampaignKindAndInventory();
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

        //캠페인 등록한 호텔 데이터
        List<Campaign> campaignList = List.of(
                setCampaign(1L, "SEARCH", "search_list", "2023-01-01 00:00:00",
                        "2023-12-31 00:00:00"),
                setCampaign(2L, "SEARCH", "search_list", "2023-01-01 00:00:00",
                        "2023-03-01 00:00:00"),
                setCampaign(3L, "SEARCH", "search_list", "2023-12-01 00:00:00",
                        "2023-12-31 00:00:00"),
                setCampaign(4L, "POWER_LINK", "top_search_list", "2023-12-01 00:00:00",
                        "2023-12-31 00:00:00"),
                setCampaign(5L, "POWER_LINK", "top_search_list", "2023-12-01 00:00:00",
                        "2023-12-31 00:00:00")
        );

        setCampaignList(campaignList);

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


    //campaign kind (캠페인 종류)공통코드 세팅
    private void setCampaignKindAndInventory() {
        List<CampaignKind> campaignKinds = List.of(
                createCampaignKind("SEARCH", 8000, "MONTHLY", "2023-01-01 00:00:00",
                        "2023-12-31 00:00:00"),
                createCampaignKind("POWER_LINK", 20000, "MONTHLY", "2023-01-01 00:00:00",
                        "2023-12-31 00:00:00")
        );

        campaignKindRepository.saveAll(campaignKinds);

        List<CampaignInventory> inventories = List.of(
                createCampaignInventory("search_list"),
                createCampaignInventory("top_search_list")
        );

        campaignInventoryRepository.saveAll(inventories);
    }

    // 캠페인 종류 기준정보 데이터
    private CampaignKind createCampaignKind(String key, int price, String billingType,
            String startDate, String endDate) {
        return CampaignKind.builder()
                .kindKey(key)
                .price(BigDecimal.valueOf(price))
                .billingType(CampaignBillingType.valueOf(billingType))
                .salesBeginDate(
                        LocalDateTime.parse(startDate,
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .salesEndDate(
                        LocalDateTime.parse(endDate,
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

    private CampaignInventory createCampaignInventory(String name) {
        return CampaignInventory.builder()
                .name(name)
                .build();
    }

    private void setCampaignList(List<Campaign> campaignList) {
        campaignRepository.saveAll(campaignList);
    }

    //광고 내역
    private Campaign setCampaign(Long hotelNo, String kindKey, String inventoryName,
            String beginDate, String endDate) {
        CampaignKind campaignKind = campaignKindRepository.findByKindKey(kindKey)
                .orElseThrow(() -> new EntityNotFoundException("no campaignKind : " + kindKey));
        CampaignInventory inventory = campaignInventoryRepository.findByName(inventoryName)
                .orElseThrow(() -> new EntityNotFoundException("no inventory : " + inventoryName));

        return Campaign.builder()
                .hotelNo(hotelNo)
                .campaignKind(campaignKind)
                .campaignInventory(inventory)
                .serviceBeginDate(LocalDateTime.parse(beginDate,
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .serviceEndDate(
                        LocalDateTime.parse(endDate,
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

}