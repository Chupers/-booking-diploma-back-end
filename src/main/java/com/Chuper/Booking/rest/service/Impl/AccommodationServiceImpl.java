package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.*;
import com.Chuper.Booking.rest.repository.AccommodationInfoRepository;
import com.Chuper.Booking.rest.repository.AccommodationRepository;
import com.Chuper.Booking.rest.repository.CharacteristicChildRepository;
import com.Chuper.Booking.rest.repository.CharacteristicRepository;
import com.Chuper.Booking.rest.service.AccommodationService;
import com.Chuper.Booking.rest.service.OrganizationService;
import com.Chuper.Booking.rest.service.UserService;
import com.Chuper.Booking.rest.service.google.GoogleDriveService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final AccommodationInfoRepository accommodationInfoRepository;
    private final CharacteristicChildRepository characteristicChildRepository;
    private final CharacteristicRepository characteristicRepository;
    private final UserService userService;
    private final OrganizationService organizationService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, AccommodationInfoRepository accommodationInfoRepository, CharacteristicChildRepository characteristicChildRepository, CharacteristicRepository characteristicRepository, UserService userService, OrganizationService organizationService) {
        this.accommodationRepository = accommodationRepository;
        this.accommodationInfoRepository = accommodationInfoRepository;
        this.characteristicChildRepository = characteristicChildRepository;
        this.characteristicRepository = characteristicRepository;
        this.userService = userService;
        this.organizationService = organizationService;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation findById(Long id) {
        return accommodationRepository.findByAccommodationId(id);
    }

    @Override
    public List<Accommodation> findByEmployerId(Long id) {
        return null;
    }

    @Override
    public Accommodation save(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation updateBasicInfo(Long accommodationId, AccommodationInfo accommodationInfo) {
        Accommodation accommodation = findById(accommodationId);
        accommodation.setAccommodationInfo(accommodationInfo);
        saveBasicInfo(accommodationInfo);
        return save(accommodation);
    }

    @Override
    public void saveBasicInfo(AccommodationInfo accommodationInfo) {
         accommodationInfoRepository.save(accommodationInfo);
    }

    public void submit(Long accommodationId){
        Accommodation accommodation = findById(accommodationId);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserFacade userFacade = userService.findByUserName(userName);
        Organization organization = userFacade.getEmployee().getOrganization();
        accommodation.setOrganization(organization);
        organization.getAccommodations().add(accommodation);
        accommodation.setSubmit(true);
        accommodationRepository.save(accommodation);

    }

    @Override
    public List<Accommodation> findAllSubmitAccommodation() {
        List<Accommodation> accommodationList = new ArrayList<>();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee = userService.findByUserName(userName).getEmployee();
        for (Accommodation accommodation: employee.getOrganization().getAccommodations()) {
            accommodationList.add(accommodation);
        }
        return accommodationList;
    }

    @Override
    public List<Accommodation> findAllAvailableAccommodation() {
        return accommodationRepository.findAll().stream()
                .filter(accommodation -> accommodation.getAccommodationInfo() != null)
                .filter(Accommodation::getSubmit).collect(Collectors.toList());
    }

    @Override
    public Accommodation updatePhotoId(MultipartFile file, Long accommodationId){
        Accommodation accommodation = findById(accommodationId);
        try {
            String path = GoogleDriveService.saveImage(file).getId();
            accommodation.setImageId(GoogleDriveService.GOOGLE_PATH + path);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accommodationRepository.save(accommodation);
    }

    @Transactional
    @Override
    public void characteristicSave(Long accommodationId, List<Characteristic> characteristicList) {
        Accommodation accommodation = findById(accommodationId);
        for (Characteristic characteristic: characteristicList){
            characteristic.setAccommodation(accommodation);
            characteristicRepository.save(characteristic);
            for(CharacteristicChild characteristicChild : characteristic.getCharacteristicChildren()){
                characteristicChild.setCharacteristic(characteristic);
                characteristicChildRepository.save(characteristicChild);
            }
        }
    }


}
