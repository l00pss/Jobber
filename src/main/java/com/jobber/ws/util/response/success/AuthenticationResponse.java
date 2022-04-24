package com.jobber.ws.util.response.success;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 8929499253726531083L;

    private String userId;
    private String token;
}