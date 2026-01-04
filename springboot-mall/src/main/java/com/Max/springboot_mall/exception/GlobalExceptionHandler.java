package com.Max.springboot_mall.exception;

import com.Max.springboot_mall.constant.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatus(ResponseStatusException e){

        HttpStatusCode status = e.getStatusCode();
        log.warn("業務異常: status={}, message={}", status.value(), e.getReason());
        //保證回傳給前端的訊息永遠不會是 null。
        return ResponseEntity.status(status.value()).body(e.getReason() != null ? e.getReason(): "業務錯誤");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException e) {
        //Spring Validation 裡的一個物件，用來 描述某個欄位的驗證失敗情況。
        //getBindingResult() 裡面就是所有欄位的驗證結果, getAllErrors() 裡面就是所有欄位的驗證結果。, 取第一個錯誤
        FieldError fieldError = (FieldError) e.getBindingResult().getAllErrors().get(0);

        //取得自訂錯誤訊息
        String message = fieldError.getDefaultMessage();

        // 判斷是否是 ProductCategory 轉換失敗
        //fieldError.getField() 裡面就是出錯的欄位名稱，也就是 DTO 裡的屬性名。
        if ("category".equals(fieldError.getField())) {
            Object rejected = fieldError.getRejectedValue();
            if (rejected != null) {
                message = "category 值 '" + rejected + "' 不正確，可選值：FOOD / E_BOOK / CAR";
            }
        }

        log.warn("參數驗證異常: {}", message);
        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidNumber(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body("請傳有效的數字");
    }
}
