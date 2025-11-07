package com.teprotejo.service;

import com.teprotejo.dto.CAIDto;
import com.teprotejo.entity.CAI;
import com.teprotejo.mapper.CAIMapper;
import com.teprotejo.repository.CAIRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CAIService {


    private final CAIRepository caiRepository;

    private final CAIMapper caiMapper;


    public CAIService(CAIRepository caiRepository, CAIMapper caiMapper) {
        this.caiRepository = caiRepository;
        this.caiMapper = caiMapper;
    }

    /**metodo para crear un CAI*/
    public boolean createCai(CAIDto caiDto){

        CAI cai = caiMapper.caiDtoToCai(caiDto);

        caiRepository.save(cai);
        return true;
    }

    /**Metodo para listar todos los CAI's*/
    public List<CAI> findAllCai(){
        return caiRepository.findAll();
    }


    public CAI findCaiById(Long id){
        return caiRepository.findById(id).get();
    }


    /**metodo para actualizar un cai*/
    public CAI updateCai(Long id, CAIDto caiDto){

        CAI cai = caiRepository.findById(id).
                orElseThrow(()-> new RuntimeException("ID de CAI no existente. "));


        caiMapper.updateCai(caiDto, cai);


        return caiRepository.save(cai);
    }

    /**Metodo para eliminar un cai por medio del ID*/
    public boolean deleteCai(Long id){

        if(caiRepository.existsById(id)){
            caiRepository.deleteById(id);
            return true;
        }

        return false;

    }



}
