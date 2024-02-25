package com.example.test.flexcitytest.services;

import com.example.test.flexcitytest.exceptions.NoAssetsAvailableException;
import com.example.test.flexcitytest.models.AssetsModel;
import com.example.test.flexcitytest.models.TsoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class AssetsService {
    private List<AssetsModel> getAllAssets() {
        AssetsModel firstAsset = new AssetsModel(1, "ASS1", "Véolia's pumps", 25.16, List.of("monday", "tuesday"), 100);
        AssetsModel secondAsset = new AssetsModel(2, "ASS2", "Aquiris's generators", 280.56, List.of("tuesday","sunday"), 1000);
        AssetsModel thirdAsset = new AssetsModel(3, "ASS3", "Orange's batteries", 45.34, List.of("wenesday"), 200);
        AssetsModel fourthAsset = new AssetsModel(4, "ASS4", "Beneo's turbines", 23.39, List.of("monday", "wenesday", "friday", "sunday"), 120);

        return new ArrayList<>(List.of(firstAsset, secondAsset, thirdAsset, fourthAsset));
    }

    public List<AssetsModel> getCheapestAvailableAssets(TsoModel request) throws NoAssetsAvailableException {
        List<AssetsModel> allAssets = getAllAssets();

        List<AssetsModel> assetsAvailable = allAssets.stream().filter(asset -> asset.getAvailability().contains(
                request.getDate().getDayOfWeek().toString().toLowerCase()) && request.getVolume() <= asset.getVolume()
        ).toList();

        if (assetsAvailable.isEmpty()) {
            throw new NoAssetsAvailableException("There are no assets available during this period for the requested volume.");
        }

        return assetsAvailable.stream().sorted(Comparator.comparingDouble(AssetsModel::getActivationCost)).toList();
    }
}
