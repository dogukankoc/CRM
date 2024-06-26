package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.characteristicRequests.CreateCharacteristicRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.characteristicRequests.UpdateCharacteristicRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.characteristicResponses.*;

import java.util.List;

public interface CharacteristicService {
    CreatedCharacteristicResponse add(CreateCharacteristicRequest createCharacteristicRequest);
    UpdatedCharacteristicResponse update(UpdateCharacteristicRequest updateCharacteristicRequest, String id);
    List<GetAllCharacteristicResponse> getAll();
    GetCharacteristicResponse getById(String id);
    DeletedCharacteristicResponse delete(String id);
}
