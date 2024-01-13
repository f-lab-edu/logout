package com.example.hotelproject.campaign.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.hotelproject.campaign.entity.Campaign;
import com.example.hotelproject.campaign.entity.CampaignBillingType;
import com.example.hotelproject.campaign.entity.CampaignInventory;
import com.example.hotelproject.campaign.entity.CampaignKind;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.entity.HotelTypeEnum;
import com.example.hotelproject.hotel.repository.HotelRepository;
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
class CampaignRepositoryImplTest extends IntegrationTestSupport {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private CampaignKindRepository campaignKindRepository;
    @Autowired
    private CampaignInventoryRepository campaignInventoryRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        cleanUp();
        setCampaignKindAndInventory();

        //호텔데이터
        setHotel();

    }

    private void setHotel() {
        List<Hotel> hotels = List.of(
                createHotel(1L),
                createHotel(2L),
                createHotel(3L),
                createHotel(4L),
                createHotel(5L)
        );

        hotelRepository.saveAll(hotels);
    }

    //campaign kind (캠페인 종류)공통코드 세팅
    private void setCampaignKindAndInventory() {
        List<CampaignKind> campaignKinds = List.of(
                createCampaignKind("SEARCH", 8000, "MONTHLY", "2023-01-01 00:00:00",
                        "2023-12-31 00:00:00"),
                createCampaignKind("POWER_LINK", 20000, "MONTHLY", "2023-01-01 00:00:00",
                        "2023-12-31 00:00:00"),
                createCampaignKind("FREE_SEARCH", 0, "MONTHLY", "2023-01-01 00:00:00",
                        "2023-12-31 00:00:00")
        );

        campaignKindRepository.saveAll(campaignKinds);

        List<CampaignInventory> inventories = List.of(
                createCampaignInventory("search_list"),
                createCampaignInventory("top_search_list")
        );

        campaignInventoryRepository.saveAll(inventories);
    }

    private CampaignInventory createCampaignInventory(String name) {
        return CampaignInventory.builder()
                .name(name)
                .build();
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

    @Test
    @DisplayName("광고+호텔 검색 기능 테스트")
    void searchCampaign() {
        //given

        //캠페인 등록한 호텔 데이터
        List<Campaign> campaignList = List.of(
                setCampaign(1L, "SEARCH", "search_list", "2023-01-01 00:00:00",
                        "2023-12-31 00:00:00"),
                setCampaign(2L, "SEARCH", "search_list", "2023-01-01 00:00:00",
                        "2023-03-01 00:00:00"),
                setCampaign(3L, "FREE_SEARCH", "search_list", "2023-12-01 00:00:00",
                        "2023-12-31 00:00:00"),
                setCampaign(4L, "POWER_LINK", "top_search_list", "2023-12-01 00:00:00",
                        "2023-12-31 00:00:00"),
                setCampaign(5L, "POWER_LINK", "top_search_list", "2023-12-01 00:00:00",
                        "2023-12-31 00:00:00")
        );
        setCampaignList(campaignList);
        List<String> kinds = new ArrayList<>(Arrays.asList("SEARCH", "FREE_SEARCH"));

        //when
        List<Campaign> campaignLHotelist = campaignRepository.findSearchCampaign(1L, kinds);

        //then
//        System.out.println(campaignLHotelist);
        assertThat(campaignLHotelist).hasSize(2);
        assertThat(campaignLHotelist.get(0).getHotel().getHotelNo()).isEqualTo(1L);
    }

    private void setCampaignList(List<Campaign> campaignList) {
        campaignRepository.saveAll(campaignList);
    }

    private Campaign setCampaign(Long hotelNo, String kindKey, String inventoryName,
            String beginDate, String endDate) {
        CampaignKind campaignKind = campaignKindRepository.findByKindKey(kindKey)
                .orElseThrow(() -> new EntityNotFoundException("no campaignKind : " + kindKey));
        CampaignInventory inventory = campaignInventoryRepository.findByName(inventoryName)
                .orElseThrow(() -> new EntityNotFoundException("no inventory : " + inventoryName));

        Hotel hotel = hotelRepository.findByHotelNo(hotelNo)
                .orElseThrow(() -> new EntityNotFoundException("no hotel : " + hotelNo));

        return Campaign.builder()
                .campaignKind(campaignKind)
                .hotel(hotel)
                .campaignInventory(inventory)
                .serviceBeginDate(LocalDateTime.parse(beginDate,
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .serviceEndDate(
                        LocalDateTime.parse(endDate,
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
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
}