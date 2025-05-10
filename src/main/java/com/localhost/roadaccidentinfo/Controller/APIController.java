package com.localhost.roadaccidentinfo.Controller;

import com.localhost.roadaccidentinfo.DTO.AccidentDTO;
import com.localhost.roadaccidentinfo.DTO.AreaDTO;
import com.localhost.roadaccidentinfo.Service.AccidentIndividuallyService;
import com.localhost.roadaccidentinfo.Service.AccidentService;
import com.localhost.roadaccidentinfo.Service.AccidentTypeService;
import com.localhost.roadaccidentinfo.Service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://127.0.0.1:3000")
@RequestMapping(path = "/apis")
public class APIController {

    @Autowired
    private AccidentService accidentService;

    @Autowired
    private AccidentIndividuallyService individuallyService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private AccidentTypeService accidentTypeService;

    @GetMapping(path = "/save.do")
    public void saveAccident() {
        String freezing_key = "%2Fyz7%2B5oJdHsLRXj8VQC4GkHppBql4XDXrcojVqBe8u0RwQUI48ShT2vXoWHXTF8P";
        String freezing_url = "https://opendata.koroad.or.kr/data/rest/frequentzone/freezing?authKey=";

        String drunk_key = "cvK%2FhgAQhJm3sI35rYkUnvG%2FyUKdWCUX%2BXHxs0nSxjM8IWzb7vtNx8gHaChOs7ts";
        String drunk_url = "https://opendata.koroad.or.kr/data/rest/frequentzone/drunk?authKey=";

        accidentTypeService.searchAndCreateAccidentTypeList();

        accidentService.searchAndCreateAccidentList();
        individuallyService.searchAndCreateIndividuallyAccidentList(freezing_url, freezing_key, "결빙");
        individuallyService.searchAndCreateIndividuallyAccidentList(drunk_url, drunk_key, "음주운전");

        accidentService.changeSigunNameFromAccidentList();
    }

    @GetMapping(path = "/queryall.do")
    public List<AccidentDTO> queryAccidentAll() { return accidentService.showAllAccident(); }

    @GetMapping(path = "/query_accident.do")
    public List<AccidentDTO> queryAccident(@RequestParam String param) {
        return accidentService.queryAccident(param);
    }

    @GetMapping(path = "/queryidx_accident.do")
    public AccidentDTO queryAccidentByIdx(@RequestParam String param) { return accidentService.queryAccidentByIdx(param); }

    @GetMapping(path = "/querytype_accident.do")
    public List<AccidentDTO> queryAccidentByType(@RequestParam String param) { return accidentService.queryByType(param); }

    @GetMapping(path = "/query_area.do")
    public List<AreaDTO> queryArea(@RequestParam String param) { return areaService.queryArea(param); }

    @GetMapping(path = "/queryidx_area.do")
    public AreaDTO queryAreaByIdx(@RequestParam String param) { return areaService.queryAreaByIdx(param); }


}
