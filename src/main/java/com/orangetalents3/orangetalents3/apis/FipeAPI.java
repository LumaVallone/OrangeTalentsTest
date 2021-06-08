package com.orangetalents3.orangetalents3.apis;

import java.util.List;

import com.orangetalents3.orangetalents3.DTOs.FipeInformationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangetalents3.orangetalents3.DTOs.FipeDefaultDTO;
import com.orangetalents3.orangetalents3.DTOs.ModelsDTO;


@FeignClient(name = "fipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeAPI {

	@RequestMapping(method = RequestMethod.GET, value = "/carros/marcas")
	List<FipeDefaultDTO> getBrands();

	@RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{brandId}/modelos")
	ModelsDTO getModels(@RequestParam("brandId") String brandId);

	@RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{brandId}/modelos/{modelId}/anos")
	List<FipeDefaultDTO> getYears(@RequestParam("brandId") String brandId, @RequestParam("modelId") String modelId);

	@RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{brandId}/modelos/{modelId}/anos/{yearId}")
	FipeInformationDTO getFipeInformation(
		@RequestParam("brandId") String brandId,
		@RequestParam("modelId") String modelId,
		@RequestParam("yearId") String yearId
	);

}
