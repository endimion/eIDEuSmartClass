/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aegean.eIdEuSmartClass.model.service.impl;

import gr.aegean.eIdEuSmartClass.model.dao.GenderRepository;
import gr.aegean.eIdEuSmartClass.model.dao.RoleRepository;
import gr.aegean.eIdEuSmartClass.model.dao.UserRepository;
import gr.aegean.eIdEuSmartClass.model.dmo.Gender;
import gr.aegean.eIdEuSmartClass.model.dmo.Role;
import gr.aegean.eIdEuSmartClass.model.dmo.User;
import gr.aegean.eIdEuSmartClass.model.service.UserService;
import gr.aegean.eIdEuSmartClass.utils.pojo.BaseResponse;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nikos
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private GenderRepository genderRepo;

    @Override
    @Transactional
    public BaseResponse saveUser(User user) {
        try {
            userRepo.save(user);
            return new BaseResponse(BaseResponse.SUCCESS);
        } catch (Error e) {
            log.info("ERROR Saving user " + user.toString());
            log.error("ERROR", e);
        }

        return new BaseResponse(BaseResponse.FAILED);
    }

    /*
        date format dd/MM/yyyy
     */
    @Override
    @Transactional
    public BaseResponse saveUser(String eIDASid, String name, String surname, String gend, String dateOfBirth,
            String email, String mobile, String affiliation, String country) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-DD");
            LocalDate birthDay = LocalDate.parse(dateOfBirth, formatter);

            User user = userRepo.findFirstByEIDASId(eIDASid);
            Role role = roleRepo.findFirstByName(Role.UNREGISTERED);
            Gender gender = genderRepo.findFirstByName(Gender.UNSPECIFIED);
            if (user == null) {
                user = new User(role, eIDASid, name, surname, email, mobile, affiliation, country, gender, birthDay, 
                                Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                userRepo.save(user);
            } else {
                user.setName(name);
                user.setSurname(surname);
                user.setLastLogin(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                user.setBirthday(birthDay);
                userRepo.save(user);
            }
            return new BaseResponse(BaseResponse.SUCCESS);

        } catch (Error e) {
            log.error("ERROR", e);
        }
        return new BaseResponse(BaseResponse.FAILED);
    }

    @Override
    @Transactional
    public BaseResponse updateLogin(String eIDasid) {
        if (userRepo.findFirstByEIDASId(eIDasid) != null) {
            try {
                Timestamp time = Timestamp.valueOf(LocalDateTime.now());
                userRepo.updateLastLoginByeIDASID(eIDasid, time);
                return new BaseResponse(BaseResponse.SUCCESS);
            } catch (Error e) {
                log.error("ERROR", e);
            }
        }
        return new BaseResponse(BaseResponse.FAILED);
    }

    @Override
    public User findByEid(String eID) {
        return userRepo.findFirstByEIDASId(eID);
    }

}
