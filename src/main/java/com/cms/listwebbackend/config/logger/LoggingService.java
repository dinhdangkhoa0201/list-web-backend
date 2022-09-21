package com.cms.listwebbackend.config.logger;

import com.cms.listwebbackend.utils.GsonParserUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggingService {

    private static final String REQUEST_ID = "request_id";

    public void logRequest(HttpServletRequest request, Object body) {
        if (request.getRequestURI().contains("medias")) {
            return;
        }
        Object requestId = request.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data.append("\nLOGGING REQUEST BODY-----------------------------------\n")
                .append("[REQUEST-ID]: ").append(requestId).append("\n")
                .append("[BODY REQUEST]: ").append("\n\n")
                .append(GsonParserUtils.parseObjectToString(body))
                .append("\n\n")
                .append("LOGGING REQUEST BODY-----------------------------------\n");

        log.info(data.toString());
    }

    public void logResponse(HttpServletRequest request, HttpServletResponse response, Object body) {
        if (request.getRequestURI().contains("medias")) {
            return;
        }
        Object requestId = request.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data.append("\nLOGGING RESPONSE-----------------------------------\n")
                .append("[REQUEST-ID]: ").append(requestId).append("\n")
                .append("[BODY RESPONSE]: ").append("\n\n")
                .append(GsonParserUtils.parseObjectToString(body))
                .append("\n\n")
                .append("LOGGING RESPONSE-----------------------------------\n");

        log.info(data.toString());
    }
}
