package com.study_spring.ticketing.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.study_spring.ticketing.dto.LocationDTO;
import com.study_spring.ticketing.dto.LocationList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Service
public class PrfPlcService {

    @Value("${kospi.serviceKey}")
    private String serviceKey;
    @Autowired
    private WebClient webClient;

    private final XmlMapper xmlMapper;

    public PrfPlcService(XmlMapper xmlMapper) {
        this.xmlMapper = new XmlMapper();
    }

    // http://www.kopis.or.kr/openApi/restful/prfplc?service={ServiceKey}&cpage=1&rows=5&shprfnmfct=예술의전당
    /*
    공연시설
        request : cpage, rows
        response : 공연시설명, 공연시설ID, 공연장 수, 지역(시도), 지역(구군)


     공연시설상세
        request : 공연시설ID, newsql
        response :

      1. 공연시설에서 공연시설명, 공연시설ID, 공연장 수, 지역(시도), 지역(구군) 채우고
      중첩으로 공연시설상세에서 공연시설ID로 검색해서 남은 데이터 다 가져옴..
     */

    public Flux<LocationDTO.responseDTO> getData() {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("service", serviceKey)
                        .queryParam("cpage", 1)
                        .queryParam("rows", 5)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .flatMapMany(this::parseXmlToFlux);
    }

    private Flux<LocationDTO.responseDTO> parseXmlToFlux(String xmlData) {

        try {
            LocationList locationList = xmlMapper.readValue(xmlData, LocationList.class);
            return Flux.fromIterable(locationList.getLocationList());
        } catch (IOException e) {
            return Flux.error(e);
        }
    }
//    public Mono<String> getDetailData(String location_id) {
//
//        return webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/{location_id}/")
//                        .queryParam("service", serviceKey)
//                        .queryParam("newsql", "Y")
//                        .build(location_id))
//                .retrieve()
//                .bodyToMono(String.class);
//
//
//    }

//    public Mono<String> getAllData() {
//        return getData()
//                .flatMap(data -> getDetailData(data.))
//    }

/*
    public List<LocationDTO.responseDTO> PrfPlcApiParseXml(Mono<String> xmlData) throws Exception {
        List<LocationDTO.responseDTO> locationList = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(String.valueOf(xmlData))));

        NodeList itemListNodes = document.getElementsByTagName("db");

        for (int i = 0; i < itemListNodes.getLength(); i++) {
            Node itemListNode = itemListNodes.item(i);

            if (itemListNode.getNodeType() == Node.ELEMENT_NODE) {
                Element itemListElement = (Element) itemListNode;

                LocationDTO.responseDTO location;

                String loc_name = getElementValue(itemListElement, "fcltynm");
                String location_id = getElementValue(itemListElement, "mt10id");
                int venue_cnt = Integer.parseInt(getElementValue(itemListElement, "mt13cnt"));
                String sidonm = getElementValue(itemListElement, "sidonm");
                String gugunnm = getElementValue(itemListElement, "gugunnm");

                // 영화시설상세목록 불러오기
                getDetailData(location_id);
                String address = "";
                Double latitude = 0.0;
                Double longitude = 0.0;
                location = new LocationDTO.responseDTO(location_id, loc_name, sidonm, gugunnm, venue_cnt, address, latitude, longitude);

                locationList.add(location);
            }
        }

        return locationList;
    }

    private String getElementValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        }
        return null;
    }*/
}