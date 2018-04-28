package net.kprod.productivity.wekanhook.data;

/**
 * Wekan login response bean
 * {"id":"xmdv9qb4fbp3ssjXH","token":"K2lFoJ_oXnLXSRbw8dkoE-fnyYL3cNSt_NVv01jwoVQ","tokenExpires":"2018-07-25T13:55:22.606Z"}
 */
public class WekanLoginResponse {
        private String id;
        private String token;
        private String tokenExpires;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getTokenExpires() {
            return tokenExpires;
        }

        public void setTokenExpires(String tokenExpires) {
            this.tokenExpires = tokenExpires;
        }

        @Override
        public String toString() {
            return "WekanLoginResponse{" +
                    "id='" + id + '\'' +
                    ", token='" + token + '\'' +
                    ", tokenExpires='" + tokenExpires + '\'' +
                    '}';
        }
    }