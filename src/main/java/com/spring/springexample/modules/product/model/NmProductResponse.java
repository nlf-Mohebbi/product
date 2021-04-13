package com.spring.springexample.modules.product.model;

import com.spring.springexample.common.NmBaseResponse;

import java.util.List;

public class NmProductResponse extends NmBaseResponse {

    NmProductModel result;
    List<NmProductModel> results;

    public NmProductModel getResult() {
        return result;
    }

    public void setResult(NmProductModel result) {
        this.result = result;
    }

    public List<NmProductModel> getResults() {
        return results;
    }

    public void setResults(List<NmProductModel> results) {
        this.results = results;
    }
}
