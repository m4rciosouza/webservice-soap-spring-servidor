package com.exemplo.wsdlservidor.endpoints;

import com.exemplo.wsdlservidor.assets.GetPaisRequest;
import com.exemplo.wsdlservidor.assets.GetPaisResponse;
import com.exemplo.wsdlservidor.repositories.PaisRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaisEndpoint {
    private static final String NAMESPACE_URI = "http://exemplo.com/wsdlservidor/assets";

    private final PaisRepository paisRepository;

    public PaisEndpoint(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
    @ResponsePayload
    public GetPaisResponse getCountry(@RequestPayload GetPaisRequest request) {
        GetPaisResponse response = new GetPaisResponse();
        response.setPais(paisRepository.buscarPorPais(request.getNome()));

        return response;
    }
}
