package com.example.test.flexcitytest.controllers;

import com.example.test.flexcitytest.exceptions.NoAssetsAvailableException;
import com.example.test.flexcitytest.models.AssetsModel;
import com.example.test.flexcitytest.models.TsoModel;
import com.example.test.flexcitytest.services.AssetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AssetsController {
    private final AssetsService assetsService;

    @PostMapping("/api/v1/assets")
    public List<AssetsModel> findAllAvailableAssets(@RequestBody TsoModel request) throws NoAssetsAvailableException {
        return assetsService.getCheapestAvailableAssets(request);
    }
}
