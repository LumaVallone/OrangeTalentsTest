package com.orangetalents3.orangetalents3.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.orangetalents3.orangetalents3.DTOs.FipeInformationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.orangetalents3.orangetalents3.DTOs.FipeDefaultDTO;
import com.orangetalents3.orangetalents3.DTOs.ModelsDTO;
import com.orangetalents3.orangetalents3.apis.FipeAPI;
import com.orangetalents3.orangetalents3.models.Car;
import com.orangetalents3.orangetalents3.repositories.CarRepository;

import feign.FeignException;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private FipeAPI fipeAPI;

	@PostMapping
	public FipeInformationDTO create(@Valid @RequestBody Car car) {
		try {
			FipeDefaultDTO foundBrand = this.findBrand(car);
			if (foundBrand == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca nâo encontrada");
			}

			FipeDefaultDTO foundModel = this.findModel(car, foundBrand);
			if (foundModel == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo nâo encontrado");
			}

			FipeDefaultDTO foundYear = this.findYear(car, foundBrand, foundModel);
			if (foundYear == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ano nâo encontrado");
			}

			return this.findFipeInformation(foundBrand, foundModel, foundYear);
			// carRepository.save(Car with all parameters)
		} catch (FeignException e) {
			if (e.status() == 404) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
			}
			throw e;
		}
	}

	private FipeDefaultDTO findBrand(Car car) {
		List<FipeDefaultDTO> brandList = fipeAPI.getBrands();

		List<FipeDefaultDTO> filteredBrand = brandList.stream().filter(brand -> {
			String carBrandAsLower = car.getBrand().toLowerCase();
			return brand.getNome().toLowerCase().equals(carBrandAsLower);
		}).collect(Collectors.toList());

		return filteredBrand.size() > 0 ? filteredBrand.get(0) : null;
	}

	private FipeDefaultDTO findModel(Car car, FipeDefaultDTO brand) {
		ModelsDTO models = fipeAPI.getModels(brand.getCodigo());

		List<FipeDefaultDTO> filteredModel = models.getModelos().stream().filter(model -> {
			String modelNameAsLower = car.getModel().toLowerCase();
			return model.getNome().toLowerCase().equals(modelNameAsLower);
		}).collect(Collectors.toList());

		return filteredModel.size() > 0 ? filteredModel.get(0) : null;
	}

	private FipeDefaultDTO findYear(Car car, FipeDefaultDTO brand, FipeDefaultDTO model) {
		List<FipeDefaultDTO> years = fipeAPI.getYears(brand.getCodigo(), model.getCodigo());

		List<FipeDefaultDTO> filteredYear = years.stream().filter(year -> {
			return year.getNome().contains(car.getYear());
		}).collect(Collectors.toList());

		return filteredYear.size() > 0 ? filteredYear.get(0) : null;
	}

	private FipeInformationDTO findFipeInformation(FipeDefaultDTO brand, FipeDefaultDTO model, FipeDefaultDTO year) {
		return fipeAPI.getFipeInformation(brand.getCodigo(), model.getCodigo(), year.getCodigo());
	}
}