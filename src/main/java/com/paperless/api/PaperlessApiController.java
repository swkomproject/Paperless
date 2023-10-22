package com.paperless.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "com.paperless.codegen.languages.SpringCodegen", date = "2023-10-22T12:32:07.613318Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class PaperlessApiController implements PaperlessApi {

    private final NativeWebRequest request;

    @Autowired
    public PaperlessApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
