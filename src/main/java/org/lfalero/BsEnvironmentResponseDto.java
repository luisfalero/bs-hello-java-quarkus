package org.lfalero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BsEnvironmentResponseDto {

    private String user1;
    private String user2;
    private String password1;
    private String password2;
    private String version;
}
