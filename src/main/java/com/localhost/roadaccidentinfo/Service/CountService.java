package com.localhost.roadaccidentinfo.Service;

import com.localhost.roadaccidentinfo.DTO.CountCityDTO;
import com.localhost.roadaccidentinfo.DTO.CountDTO;
import com.localhost.roadaccidentinfo.Entity.AccidentEntity;
import com.localhost.roadaccidentinfo.Repository.AccidentRepository;
import com.localhost.roadaccidentinfo.Repository.AreaRepository;
import com.localhost.roadaccidentinfo.Repository.MapPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountService {

    private final AccidentRepository accidentRepository;

    // ==================== 테이블의 특정 값 중복 제거해서 출력하는 함수 ====================

    //저장된 데이터들의 연도 목록을 출력하는 함수
    public List<Integer> findYearList() {

        try {

            //전체 사고 목록을 가지는 리스트 선언
            List<AccidentEntity> accidentEntityList = accidentRepository.findAll();
            //중복 제거를 위한 HashSet 리스트 선언
            HashSet<Integer> distinctList = new HashSet<>();

            //리스트의 각 엔티티를 인자로 가지는 반복문
            for (AccidentEntity entity : accidentEntityList) {
                //HashSet 리스트에 사고 연도 추가
                distinctList.add(entity.getAccidentYear());
            }

            //HastSet 리스트를 리스트로 변환
            List<Integer> afterList = new ArrayList<>(distinctList);

            //내림차순 정렬 (람다식)
            afterList.sort((i1, i2) -> i2 - i1);

            return afterList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //저장된 도시 리스트를 출력하는 함수
    public List<String> findCities() {

        try {

            //전체 사고 목록을 가지는 리스트 선언
            List<AccidentEntity> entityList = accidentRepository.findAll();
            //중복 제거를 위한 HashSet 리스트 선언
            HashSet<String> hashSetList = new HashSet<>();

            //리스트의 각 엔티티를 인자로 가지는 반복문
            for (AccidentEntity entity : entityList) {
                //도시를 자르기 위해 2개의 조각을 갖는 String List로 split
                String area = entity.getAccidentArea();
                String[] parts = area.split(" ", 2);
                //첫번째 조각을 HashSet에 추가
                hashSetList.add(parts[0]);
            }

            return new ArrayList<>(hashSetList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // ================================================================================

    // ==================== 인수를 받아 특정 범위의 정보를 출력하는 함수 ====================


    //연도를 인수로 받아 그 해 사고 횟수를 출력하는 함수
    public CountDTO countAccidentByYear(Integer year) {
        try {
            //인수로 준 연도와 일치하는 리스트를 가지는 리스트 선언
            List<AccidentEntity> entityList = accidentRepository.findByAccidentYear(year);

            //각 횟수를 더하기 위한 초기화된 변수 선언
            Integer accidentOccurCnt = 0;
            Integer accidentCasltCnt = 0;
            Integer accidentDprCnt = 0;
            Integer accidentSerinjuryCnt = 0;
            Integer accidentSltinjuryCnt = 0;
            Integer accidentInjuryCnt = 0;

            //리스트의 각 엔티티를 인자로 가지는 반복문
            for(AccidentEntity entity: entityList) {
                //인자 하나의 개별 숫자를 더함
                accidentOccurCnt += entity.getSumOfAccidentOccurCnt();
                accidentCasltCnt += entity.getSumOfAccidentCasltCnt();
                accidentDprCnt += entity.getSumOfAccidentDprCnt();
                accidentSerinjuryCnt += entity.getSumOfAccidentSerinjuryCnt();
                accidentSltinjuryCnt += entity.getSumOfAccidentSltinjuryCnt();
                accidentInjuryCnt += entity.getSumOfAccidentInjuryCnt();
            }

            return CountDTO.builder()
                    .countIdx(1)
                    .year(year)
                    .accidentOccurCnt(accidentOccurCnt)
                    .accidentCasltCnt(accidentCasltCnt)
                    .accidentDprCnt(accidentDprCnt)
                    .accidentSerinjuryCnt(accidentSerinjuryCnt)
                    .accidentSltinjuryCnt(accidentSltinjuryCnt)
                    .accidentInjuryCnt(accidentInjuryCnt)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //연도와 유형을 인수로 받아 그 해 사고 횟수를 출력하는 함수
    public CountDTO countAccidentByYearAndType(Integer year, Long typeIdx) {
        try {
            List<AccidentEntity> entityList = accidentRepository.findByAccidentYearAndAccidentTypeIdx(year, typeIdx);

            Integer accidentOccurCnt = 0;
            Integer accidentCasltCnt = 0;
            Integer accidentDprCnt = 0;
            Integer accidentSerinjuryCnt = 0;
            Integer accidentSltinjuryCnt = 0;
            Integer accidentInjuryCnt = 0;

            for(AccidentEntity entity: entityList) {
                accidentOccurCnt += entity.getSumOfAccidentOccurCnt();
                accidentCasltCnt += entity.getSumOfAccidentCasltCnt();
                accidentDprCnt += entity.getSumOfAccidentDprCnt();
                accidentSerinjuryCnt += entity.getSumOfAccidentSerinjuryCnt();
                accidentSltinjuryCnt += entity.getSumOfAccidentSltinjuryCnt();
                accidentInjuryCnt += entity.getSumOfAccidentInjuryCnt();
            }

            return CountDTO.builder()
                    .countIdx(1)
                    .year(year)
                    .accidentOccurCnt(accidentOccurCnt)
                    .accidentCasltCnt(accidentCasltCnt)
                    .accidentDprCnt(accidentDprCnt)
                    .accidentSerinjuryCnt(accidentSerinjuryCnt)
                    .accidentSltinjuryCnt(accidentSltinjuryCnt)
                    .accidentInjuryCnt(accidentInjuryCnt)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //도시를 인수로 받아 해당 도시의 사고 횟수를 출력하는 함수
    public CountCityDTO findCitiesCount(String city) {

        try {

            List<AccidentEntity> entityList = accidentRepository.findByAccidentAreaContains(city);

            Integer accidentOccurCnt = 0;
            Integer accidentCasltCnt = 0;
            Integer accidentDprCnt = 0;
            Integer accidentSerinjuryCnt = 0;
            Integer accidentSltinjuryCnt = 0;
            Integer accidentInjuryCnt = 0;

            String area = entityList.get(0).getAccidentArea();
            String[] parts = area.split(" ", 2);


            for (AccidentEntity entity : entityList) {
                accidentOccurCnt += entity.getSumOfAccidentOccurCnt();
                accidentCasltCnt += entity.getSumOfAccidentCasltCnt();
                accidentDprCnt += entity.getSumOfAccidentDprCnt();
                accidentSerinjuryCnt += entity.getSumOfAccidentSerinjuryCnt();
                accidentSltinjuryCnt += entity.getSumOfAccidentSltinjuryCnt();
                accidentInjuryCnt += entity.getSumOfAccidentInjuryCnt();
            }

            return CountCityDTO.builder()
                    .countIdx(1)
                    .city(parts[0])
                    .accidentOccurCnt(accidentOccurCnt)
                    .accidentCasltCnt(accidentCasltCnt)
                    .accidentDprCnt(accidentDprCnt)
                    .accidentSerinjuryCnt(accidentSerinjuryCnt)
                    .accidentSltinjuryCnt(accidentSltinjuryCnt)
                    .accidentInjuryCnt(accidentInjuryCnt)
                    .build();

        } catch (Exception e) {
            return null;
        }
    }

    // ================================================================================


    //전체 사고 횟수를 출력하는 함수
    public CountDTO countAllAccident() {

        try {
            List<AccidentEntity> entityList = accidentRepository.findAll();

            Integer accidentOccurCnt = 0;
            Integer accidentCasltCnt = 0;
            Integer accidentDprCnt = 0;
            Integer accidentSerinjuryCnt = 0;
            Integer accidentSltinjuryCnt = 0;
            Integer accidentInjuryCnt = 0;

            for(AccidentEntity entity: entityList) {
                accidentOccurCnt += entity.getSumOfAccidentOccurCnt();
                accidentCasltCnt += entity.getSumOfAccidentCasltCnt();
                accidentDprCnt += entity.getSumOfAccidentDprCnt();
                accidentSerinjuryCnt += entity.getSumOfAccidentSerinjuryCnt();
                accidentSltinjuryCnt += entity.getSumOfAccidentSltinjuryCnt();
                accidentInjuryCnt += entity.getSumOfAccidentInjuryCnt();
            }

            return CountDTO.builder()
                    .countIdx(1)
                    .accidentOccurCnt(accidentOccurCnt)
                    .accidentCasltCnt(accidentCasltCnt)
                    .accidentDprCnt(accidentDprCnt)
                    .accidentSerinjuryCnt(accidentSerinjuryCnt)
                    .accidentSltinjuryCnt(accidentSltinjuryCnt)
                    .accidentInjuryCnt(accidentInjuryCnt)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //연도별 총 사고 횟수를 출력하는 함수
    public List<CountDTO> findAllYearList() {

        List<Integer> yearList = findYearList();
        List<CountDTO> dtoList = new ArrayList<>();

        for (Integer year: yearList) {
            dtoList.add(countAccidentByYear(year));
        }

        return dtoList;

    }

    //테이블에 저장된 모든 도시의 총 사고 횟수를 출력하는 함수
    public List<CountCityDTO> findAllCitiesCount() {

        //각 도시 리스트와 결과를 담을 countCityDTOS 선언
        List<String> cities = findCities();
        List<CountCityDTO> countCityDTOS = new ArrayList<>();

        //각 도시 이름을 인자로 갖는 반복문
        for(String city: cities) {
            //도시 이름을 가지는 총 사고 횟수를 DTO 리스트에 추가
            countCityDTOS.add(findCitiesCount(city));
        }

        return countCityDTOS;

    }

}
