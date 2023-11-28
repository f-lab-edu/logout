package com.example.hotelproject.campaign.service;

import com.example.hotelproject.campaign.controller.request.CampaignDeleteRequest;
import com.example.hotelproject.campaign.controller.request.CampaignRegistRequest;
import com.example.hotelproject.campaign.controller.request.CampaignSearchRequest;
import com.example.hotelproject.campaign.controller.response.CampaignSearchResponse;
import com.example.hotelproject.campaign.controller.response.CampaignWithHotelSearchResponse;
import com.example.hotelproject.campaign.entity.Campaign;
import com.example.hotelproject.campaign.entity.CampaignInventory;
import com.example.hotelproject.campaign.entity.CampaignKind;
import com.example.hotelproject.campaign.repository.CampaignInventoryRepository;
import com.example.hotelproject.campaign.repository.CampaignKindRepository;
import com.example.hotelproject.campaign.repository.CampaignRepository;
import com.example.hotelproject.hotel.entity.Hotel;
import com.example.hotelproject.hotel.repository.HotelRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    private CampaignKindRepository campaignKindRepository;
    private CampaignRepository campaignRepository;
    private CampaignInventoryRepository campaignInventoryRepository;
    private HotelRepository hotelRepository;

    public CampaignService(CampaignKindRepository campaignKindRepository,
            CampaignRepository campaignRepository, HotelRepository hotelRepository) {
        this.campaignKindRepository = campaignKindRepository;
        this.campaignRepository = campaignRepository;
        this.hotelRepository = hotelRepository;
    }

    public void registCampaign(CampaignRegistRequest request) {
        CampaignKind campaignKind = campaignKindRepository.findById(request.getCampaignKindId())
                .orElseThrow(() -> new EntityNotFoundException("no campaign kind"));

        Campaign campaign = request.toCampaign(campaignKind, request.getHotelNo());

        campaignRepository.save(campaign);
    }

    public void deleteCampaign(CampaignDeleteRequest deleteRequest) {
        Campaign campaign = campaignRepository.findById(deleteRequest.getCampaignId())
                .orElseThrow(() -> new EntityNotFoundException("no campaign"));

        campaign.updateDelete(deleteRequest.isDelete());
    }


    public void expireCampaign() {

        //날짜체크
        //1.신청한 기간 체크 - enddate == today
        List<Campaign> campaignList = campaignRepository.findByServiceEndDate(LocalDateTime.now());

        campaignList.forEach(campaign -> campaign.updateExpire(campaign.isExpired())); //TODO: test

        //2. kind의 기간 체크
        List<Campaign> campaignList1 = campaignRepository.findMatchingWithCampaignKind();
        campaignList1.forEach(campaign -> campaign.updateExpire(campaign.isExpired())); //TODO: test

    }

    public List<CampaignSearchResponse> getCampaign(CampaignSearchRequest searchRequest) {
        List<Campaign> campaignList = campaignRepository.findWithCampaignInventoryIdAndKindId(
                searchRequest.getCampaignKindId(), searchRequest.getCampaignInventoryId());

        return campaignList.stream().map(CampaignSearchResponse::of)
                .collect(Collectors.toList());
    }

    public List<CampaignWithHotelSearchResponse> findPowerLinkCampaign(Long inventoryId,
            Long kindId) {

        CampaignKind kind = campaignKindRepository.findById(kindId)
                .orElseThrow(() -> new EntityNotFoundException("no Campaignkind :" + kindId));
        CampaignInventory inventory = campaignInventoryRepository.findById(inventoryId)
                .orElseThrow((() -> new EntityNotFoundException("no inventory :" + inventoryId)));

        List<Long> powerLinkHotelNoList = campaignRepository.findPowerLinkCampaign(
                inventory.getId(), kind.getId());

        List<Hotel> hotelList = hotelRepository.findAllById(powerLinkHotelNoList);

        return hotelList.stream().map(CampaignWithHotelSearchResponse::of)
                .collect(Collectors.toList());
    }

    public List<CampaignWithHotelSearchResponse> searchHotelWithCampaign(Long inventoryId,
            Long kindId) {
        List<Long> campaignHotelNoList = campaignRepository.findSearchCampaign(inventoryId, kindId);

        // 상단노출할 호텔
        List<Hotel> campaignHotelList = hotelRepository.findAllByHotelNo(campaignHotelNoList, true);
        // 기본호텔
        List<Hotel> basicHotelList = hotelRepository.findAllByHotelNo(campaignHotelNoList, false);

        campaignHotelList.addAll(basicHotelList);

        return campaignHotelList.stream().map(CampaignWithHotelSearchResponse::of)
                .collect(Collectors.toList());
    }
}
