package com.salci_study.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    //URI ile versiyonlama
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Salih", "Alci"));
    }

    //Parametre ile versiyonlama
    /**
     *
     * http://localhost:8080/person?version=1
     * @return
     */
    @GetMapping(path="/person",params="version=1")
    public String getFirstVersionWithRequestParameter() {
        return "First version of request parameter.";
    }

    /**
     * http://localhost:8080/person?version=2
     * @return
     */
    @GetMapping(path="/person",params="version=2")
    public String getFirstVersionWithRequestParameter2() {
        return "Second version of request parameter.";
    }

    //Header ile versiyonlama
    /**
     *http://localhost:8080/person/header
     * X-API-VERSION=1
     * @return
     */
    @GetMapping(path="/person/header",headers="X-API-VERSION=1")
    public String getFirstVersionWithHeader1() {
        return "First version for header mapping.";
    }
}
