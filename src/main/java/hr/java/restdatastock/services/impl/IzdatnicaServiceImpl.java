package hr.java.restdatastock.services.impl;

import hr.java.restdatastock.exceptions.IzdatnicaEntityNotFoundRuntimeException;
import hr.java.restdatastock.model.entities.IzdatnicaEntity;
import hr.java.restdatastock.repositories.IzdatnicaRepository;
import hr.java.restdatastock.services.IzdatnicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IzdatnicaServiceImpl implements IzdatnicaService {

    private final IzdatnicaRepository izdatnicaRepository;

    @Override
    public List<IzdatnicaEntity> getAll() {
        return this.izdatnicaRepository.findAll();
    }

    @Override
    public IzdatnicaEntity getOneById(final Long id) {
        return this.izdatnicaRepository.findById(id).orElseThrow(() -> new IzdatnicaEntityNotFoundRuntimeException(id));
    }

    @Override
    public IzdatnicaEntity createIzdatnica(final IzdatnicaEntity izdatnica) {
        return this.izdatnicaRepository.save(izdatnica);
    }

    @Override
    public HttpStatus deleteById(Long id) {
        final HttpStatus httpStatus;
        if (this.izdatnicaRepository.deleteIzdatnicaEntityById(id) > 0){
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NO_CONTENT;
        }
        return httpStatus;
    }
//    @Override
//    public void deleteIzdatnica(final Long id) {
//        this.izdatnicaRepository.deleteById(id);
//    }
}
