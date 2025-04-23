package com.salci_study.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public MappingJacksonValue filtering() {
        SomeBean bean = new SomeBean("value1", "value2", "value2");
        MappingJacksonValue jacksonValue = new MappingJacksonValue(bean);
        //Filtering logic is here!
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept( "field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        jacksonValue.setFilters(filters);

        return jacksonValue;
    }

    @GetMapping(path = "/filtering-list")
    public MappingJacksonValue filteringList() {


        List<SomeBean> list = new ArrayList<>();
        list.add(new SomeBean("value1", "value2", "value2"));
        list.add(new SomeBean("value3", "value4", "value5"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);


        //Filter logic is here
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept( "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);


        return mappingJacksonValue;
    }
}
