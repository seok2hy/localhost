package com.localhost.roadaccidentinfo.Repository;

import com.localhost.roadaccidentinfo.Entity.AccidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AccidentRepository extends JpaRepository<AccidentEntity, Long> {

    public List<AccidentEntity> findByMapPlaceAddressContains(String addr);

    public AccidentEntity findByIdx(Long idx);

    public List<AccidentEntity> findByAccidentTypeIdx(Long idx);

    @Modifying
    @Query("UPDATE AccidentEntity a set a.accidentArea =:area where a.idx = :idx")
    void updateAccidentArea(String area, Long idx);

    List<AccidentEntity> findByAccidentArea(String area);

    List<AccidentEntity> findByAccidentAreaContains(String area);

    List<AccidentEntity> findByMapPlaceAddress(String area);

    List<AccidentEntity> findByAccidentYear(Integer year);

    List<AccidentEntity> findByAccidentYearAndAccidentTypeIdx(Integer year, Long typeIdx);
}
