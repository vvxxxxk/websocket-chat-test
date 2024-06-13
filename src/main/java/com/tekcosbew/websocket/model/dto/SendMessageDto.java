package com.tekcosbew.websocket.model.dto;

import com.tekcosbew.websocket.common.constants.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendMessageDto {

    private MessageType type;
    private Object data;
}
