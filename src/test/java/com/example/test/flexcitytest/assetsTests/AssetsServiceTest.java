package com.example.test.flexcitytest.assetsTests;

import com.example.test.flexcitytest.exceptions.NoAssetsAvailableException;
import com.example.test.flexcitytest.models.AssetsModel;
import com.example.test.flexcitytest.models.TsoModel;
import com.example.test.flexcitytest.services.AssetsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AssetsServiceTest {
    @InjectMocks
    AssetsService assetsService;

    @Test
    void getOneAssetsAvailable() throws NoAssetsAvailableException {
        // given
        TsoModel tsoModel = TsoModel.builder()
                .date(LocalDate.of(2024,2,25))
                .volume(150)
                .build();

        // when
        List<AssetsModel> result = assetsService.getCheapestAvailableAssets(tsoModel);

        // then
        assertThat(result).hasSize(1);
        assertThat(result.stream().findFirst().get().getName()).isEqualTo("Aquiris's generators");
    }

    @Test
    void getNoAssetsAvailable() {
        // given
        TsoModel tsoModel = TsoModel.builder()
                .date(LocalDate.of(2024,2,24))
                .volume(50)
                .build();

        // when & then
        Assertions.assertThrows(NoAssetsAvailableException.class, () -> {
            assetsService.getCheapestAvailableAssets(tsoModel);
        });
    }

    @Test
    void getTwoAssetsAvailable() throws NoAssetsAvailableException {
        // given
        TsoModel tsoModel = TsoModel.builder()
                .date(LocalDate.of(2024,2,25))
                .volume(100)
                .build();

        // when
        List<AssetsModel> result = assetsService.getCheapestAvailableAssets(tsoModel);

        // then
        assertThat(result).hasSize(2);
        assertThat(result.stream().findFirst().get().getName()).isEqualTo("Beneo's turbines");
    }
}
