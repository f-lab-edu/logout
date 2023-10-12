package com.example.hotelproject.campaign.controller;

import com.example.hotelproject.campaign.controller.request.CampaignDeleteRequest;
import com.example.hotelproject.campaign.controller.request.CampaignRegistRequest;
import com.example.hotelproject.campaign.controller.request.CampaignSearchRequest;
import com.example.hotelproject.campaign.controller.response.CampaignSearchResponse;
import com.example.hotelproject.campaign.service.CampaignService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Campaign", description = "Campaign API")
@RequestMapping("api/v1/campaign")
public class CampaignController {

    private CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping("/regist")
    @ApiOperation(value = "광고 등록", notes = "owner가 호텔에 광고를 등록합니다.")
    public void registCampaign(@RequestBody CampaignRegistRequest request) {
        campaignService.registCampaign(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "광고 삭제", notes = "광고를 중지합니다.")
    public void deleteCampaign(@RequestBody CampaignDeleteRequest request) {
        campaignService.deleteCampaign(request);
    }

    @PostMapping("/expire")
    @ApiOperation(value = "광고 만료", notes = "광고 기간을 체크하여 만료(중지)시킵니다.")
    public void expiredCampaign() {
        campaignService.expireCampaign();
    }

    @GetMapping
    @ApiOperation(value = "광고 조회", notes = "광고 인벤토리, 광고 종류에 따라 기간을 체크하여 조회합니다.")
    public List<CampaignSearchResponse> findCapaign(CampaignSearchRequest request) {
        return campaignService.getCampaign(request);
    }
}
