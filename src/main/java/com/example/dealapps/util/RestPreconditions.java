package com.example.dealapps.util;

import com.example.dealapps.exception.MyResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author NEJMEDDINE Ayoub
 * @created 03/08/2020 -11:20
 */
@Slf4j
public class RestPreconditions {

   // private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    public static <T> T checkFound(T resource) throws MyResourceNotFoundException {
        if (resource == null) {
            log.error("checkFound exception");
            throw new MyResourceNotFoundException("Resource not found");
        }
        return resource;
    }


}
