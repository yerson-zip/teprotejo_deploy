package com.teprotejo.service;

import com.teprotejo.dto.EmergencyDto;
import com.teprotejo.entity.CAI;
import com.teprotejo.entity.Emergency;
import com.teprotejo.entity.User;
import com.teprotejo.mapper.EmergencyMapper;
import com.teprotejo.repository.CAIRepository;
import com.teprotejo.repository.EmergencyRepository;
import com.teprotejo.repository.UserRepository;
import com.teprotejo.util.Calculate;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EmergencyService {


    private final EmergencyRepository emergencyRepository;

    private final EmergencyMapper  emergencyMapper;

    private final CAIRepository  caiRepository;

    private final UserRepository userRepository;

    /**
     * Constructor para la inyección de dependencias
     */
    public EmergencyService(EmergencyRepository emergencyRepository, EmergencyMapper emergencyMapper, CAIRepository caiRepository, UserRepository userRepository) {
        this.emergencyRepository = emergencyRepository;
        this.emergencyMapper = emergencyMapper;
        this.caiRepository = caiRepository;
        this.userRepository = userRepository;
    }

    /**
     * Este metodo recibe como parametro un EmergencyDto
     * y crea un objeto de tipo Emergency triangulando el
     * CAI más cercano con la fórmula de haversine, devolviendo
     * la información de dicho CAI
     * */
    public CAI createEmergency(EmergencyDto emergencyDto) {

        CAI caiShort = caiRepository.findByCity(emergencyDto.getCity() )
                .stream()
                .min(Comparator.comparing(cai ->
                        Calculate.calcularDistancia(emergencyDto.getLatitude(), emergencyDto.getLongitude()
                                                    ,cai.getLatitude(), cai.getLongitude())
                ))
                .orElse(null);


        Emergency emergency = emergencyMapper.emergency(emergencyDto);
        emergency.setUser(userRepository.findById(emergencyDto.getUserId()).orElse(null));
        emergency.setCai(caiShort);

        emergencyRepository.save(emergency);

        return caiShort;

    }


    /**
     *Este metodo recibe el ID del usuario con la intencion de mostrar
     * todas sus emergencias, si el ID no existe se lanzará una excepcion
     * en tiempo de ejecución
     * */
    public List<Emergency> getEmergenciesByUserId(Long userId) throws Exception{

        if(userRepository.findById(userId).isEmpty()) {
            throw new Exception("ID no existente");
        }

        return emergencyRepository.findByUserId(userId);
    }

    public List<Emergency> getAllEmergencies() {
        return emergencyRepository.findAll();
    }

    public boolean deleteEmergency(Long id){
        if(emergencyRepository.findById(id).isPresent()) {
            emergencyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
