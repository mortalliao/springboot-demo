package com.springboot.demo.socketio.domain;

import lombok.*;

/**
 * @author Jim
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PushMessage {
    /**
     * 登录用户编号
     */
    private String loginUserNum;

    /**
     * 推送内容
     */
    private String content;

    // Other Detail Property...
}
