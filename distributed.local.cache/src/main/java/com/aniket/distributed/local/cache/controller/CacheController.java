package com.aniket.distributed.local.cache.controller;

import com.aniket.distributed.local.cache.exception.BadRequestException;
import com.aniket.distributed.local.cache.exception.DaoException;
import com.aniket.distributed.local.cache.exception.ResourceNotExistsException;
import com.aniket.distributed.local.cache.model.ErrorResponse;
import com.aniket.distributed.local.cache.service.CacheDataUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CacheController {

    private static final Logger logger = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private CacheDataUploadService cacheDataUploadService;

    @RequestMapping(method = RequestMethod.GET, value="/uploadData")
    @ResponseStatus(HttpStatus.OK)
    public void uploadData() throws Exception{
        try{
            cacheDataUploadService.cacheData();
        } catch (DaoException ex) {
            logger.error("Caught exception while uploading initial data. Exception=" + ex.getMessage());
            throw new Exception(ex.getMessage());
        }

    }

    @ExceptionHandler(ResourceNotExistsException.class)
    public @ResponseBody
    ResponseEntity<ErrorResponse> handleResourceNotExistsException(HttpServletRequest req, Exception exception)
            throws ResourceNotExistsException {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse(exception.getMessage()),  HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleBadRequestException(HttpServletRequest req, Exception exception)
            throws Exception {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse(exception.getLocalizedMessage()),  HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleException(HttpServletRequest req, Exception exception)
            throws Exception {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse("Internal Server Error"),  HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
