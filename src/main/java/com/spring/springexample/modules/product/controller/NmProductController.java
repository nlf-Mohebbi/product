package com.spring.springexample.modules.product.controller;

import com.spring.springexample.common.NmBaseController;
import com.spring.springexample.common.NmBaseRequestModel;
import com.spring.springexample.common.NmBaseResponse;
import com.spring.springexample.modules.module.service.NmModuleService;
import com.spring.springexample.modules.product.model.NmProductModel;
import com.spring.springexample.modules.product.model.NmProductRequest;
import com.spring.springexample.modules.product.model.NmProductResponse;
import com.spring.springexample.modules.product.service.NmProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/products")
public class NmProductController extends NmBaseController {

    @Autowired
    NmProductService service;

    @Autowired
    NmBaseRequestModel requestModel;

    NmModuleService moduleService;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public NmProductResponse get(@RequestParam(required = false,value = "0") Integer pi,
                                 @RequestParam(required = false,value = "20")Integer ps,
                                 @RequestParam(required = false,value = "DESC")String order,
                                 @RequestParam(required = false,value = "id")String field)
    {
        if(requestModel.validate()){

            if(this.hasPermission(requestModel.getUserId(),moduleService.getByTitle("PRODUCT").getTitle()).getReadAction()){

                List<NmProductModel> models=service.getAll(pi,ps,order,field);
                NmProductResponse response=new NmProductResponse();
                if (models.size()>0){
                    response=(NmProductResponse) NmBaseResponse.success("Find All Record Successfully! ");
                    response.setResults(models);
                    return response;
                }
                return (NmProductResponse) NmBaseResponse.notFound("Nothing Found! ");
            }
            return (NmProductResponse) NmBaseResponse.accessDenied("Access denied! ");
        }
        return (NmProductResponse) NmBaseResponse.badRequest("No valid header data! ");
    }

    @RequestMapping(value = "{/id}",method = RequestMethod.GET)
    public NmProductResponse getById(@PathVariable Long id)
    {
        if(requestModel.validate()) {

            if (this.hasPermission(requestModel.getUserId(), moduleService.getByTitle("PRODUCT").getTitle()).getReadAction()) {

                NmProductResponse response = new NmProductResponse();
                NmProductModel model = service.getById(id);
                if (model != null) {
                    response = (NmProductResponse) NmBaseResponse.success("Record Found! ");
                    response.setResult(model);
                    return response;
                }
                return (NmProductResponse) NmBaseResponse.notFound("Nothing Found matched record! ");
            }
            return (NmProductResponse) NmBaseResponse.accessDenied("Access denied! ");
        }
        return (NmProductResponse) NmBaseResponse.badRequest("No valid header data! ");
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public NmProductResponse post(@RequestBody NmProductRequest input)
    {
        if(requestModel.validate()) {

            if (this.hasPermission(requestModel.getUserId(), moduleService.getByTitle("PRODUCT").getTitle()).getCreateAction()) {

                NmProductResponse response = service.save(input);
                return response;
            }
            return (NmProductResponse) NmBaseResponse.accessDenied("Access denied! ");
        }
        return (NmProductResponse) NmBaseResponse.badRequest("No valid header data! ");
    }

    @RequestMapping(value = "" , method = RequestMethod.PUT)
    public NmProductResponse put(@RequestBody NmProductRequest input)
    {
        if(requestModel.validate()) {

            if (this.hasPermission(requestModel.getUserId(), moduleService.getByTitle("PRODUCT").getTitle()).getUpdateAction()) {

                NmProductResponse response = service.update(input);
                return response;
            }
            return (NmProductResponse) NmBaseResponse.accessDenied("Access denied! ");
        }
        return (NmProductResponse) NmBaseResponse.badRequest("No valid header data! ");
    }

    @RequestMapping(value = "{/id}",method = RequestMethod.DELETE)
    public NmProductResponse delete(@PathVariable Long id)
    {
        if(requestModel.validate()) {

            if (this.hasPermission(requestModel.getUserId(), moduleService.getByTitle("PRODUCT").getTitle()).getDeleteAction()) {

                NmProductResponse response = service.delete(id);
                return response;
            }
            return (NmProductResponse) NmBaseResponse.accessDenied("Access denied! ");
        }
        return (NmProductResponse) NmBaseResponse.badRequest("No valid header data! ");
    }
}
