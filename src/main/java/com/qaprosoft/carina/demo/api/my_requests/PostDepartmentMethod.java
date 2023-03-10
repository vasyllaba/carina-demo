package com.qaprosoft.carina.demo.api.my_requests;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/departments", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/departments/_post/rq.json")
@ResponseTemplatePath(path = "api/departments/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostDepartmentMethod extends AbstractApiMethodV2 {
    public PostDepartmentMethod() {
        super("api/departments/_post/rq.json",
                "api/departments/_post/rs.json",
                "api/departments/departments.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
