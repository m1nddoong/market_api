package com.example.market.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode {
    // 쇼핑몰 관련 에러
    SHOP_NOT_EXISTS(404, "3001", "존재하지 않는 쇼핑몰 입니다."),
    SHOP_INCOMPLETE(400, "3002", "쇼핑몰의 이름, 소개, 분류가 모두 작성되지 않았습니다."),

    // 쇼핑몰 상품 관련 에러
    ITEM_NOT_EXISTS(404, "3003", "존재하지 않는 쇼핑몰 상품 입니다."),
    ITEM_NO_PERMISSION(403, "3004", "해당 상품에 대한 권한이 없습니다."),
    ITEM_OUT_OF_STOCK(404, "3005", "해당 상품의 재고가 없습니다.");



    private final int status;
    private final String code;
    private final String message;
}

/**
 * <<<<<<<<<<<<<<<< HHP 상태 코드 >>>>>>>>>>>>>>>>
 * [1xx : 정보 응답]
 *   - 100 Contiunue : 요청이 계속 진행될 수 있음
 *   - 101 Switching Protocols : 프로토콜을 변경하겠다는 응답
 * [2xx : 성공]
 *   - 200 Ok : 요청이 성공적으로 처리되었다
 *   - 201 Created : 요청이 성공적으로 처리되었고 새로운 리소스가 생성되었다
 *   - 204 No Content : 요청은 성공적이었으나 응답할 내용이 없다.
 * [3xx : 리다이렉션]
 *   - 301 Moved Permanently : 리소스가  영구적으로 다른 위치로 이동했다.
 *   - 302 Found : 리소스가 임시적으로 다른 위치로 이동했다.
 *   - 304 Not Modified : 리소스가 수정되지 않았다.
 * [4xx : 클라이언트 오류]
 *   - 400 Bad Request : 잘못된 요청, 클라이언트가 오류를 수정해야한다.
 *   - 401 Unauthorized : 인증이 필요하거나 인증 실패
 *   - 403 Forbidden : 서버가 요청을 이해했지만 권한이 없다.
 *   - 404 Not Found : 요청한 리소스를 찾을 수 없다.
 *   - 405 Method Not Allowed : 요청된 HTTP 메서드가 허용되지 않는다.
 *   - 408 Request Timeout : 클라이언트의 요청이 시간 초과되었다.
 *   - 409 Conflict : 요청이 현재 서버의 상태와 충돌한다.
 *   - 410 Gone : 요청한 리소스가 더 이상 사용되지 않으며, 영구적으로 제거되었다.
 *   - 413 Payload Too Large : 요청이 너무 커서 처리할 수 없다.
 *   - 422 Unprocessable Entity : 요청이 이해되었지만 처리할 수 없다.
 * [5xx 서버 오류]
 *   - 500 Internal Server Error : 서버 내부에서 오류가 발생했다.
 *   - 501 Not Implemented : 서버가 요청된 기능을 지원하지 않는다.
 *   - 502 Bad Gateway : 게이트웨이 또는 프록시 서버가 잘못된 응답을 받았다.
 *   - 503 Service Unavailable : 서버가 과부하 상태이거나 유지 관리중이다.
 *   - 504 Gateway Timeout : 게이트웨이 또는 프록시 서버가 응답을 기다리는 동안 시간 초과가 발생했다.
 */