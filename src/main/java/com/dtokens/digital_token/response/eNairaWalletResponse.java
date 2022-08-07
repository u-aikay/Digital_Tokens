package com.dtokens.digital_token.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class eNairaWalletResponse {
    private String response_code;
    private String response_message;
    private Data response_data;

    public eNairaWalletResponse() {
    }

    public Data getResponse_data() {
        return response_data;
    }

    public void setResponse_data(Data response_data) {
        this.response_data = response_data;
    }

    public String getResponse_message() {
        return response_message;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    @Override
    public String toString() {
        return "eNairaWalletResponse{" + "response_code=" + response_code + ", response_message="
                + response_message + ", response_data=" + response_data + '}';
    }



    public static class Data {
        @JsonProperty(value = "status")
        private String status;
        @JsonProperty(value = "code")
        private String code;
        @JsonProperty(value = "nuban")
        private String nuban;
        @JsonProperty(value = "message")
        private String message;

        public Data() {
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
        public String getNuban() {
            return nuban;
        }
        public void setNuban(String nuban) {
            this.nuban = nuban;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString(){
            return "Data{" + ", code=" + code
                    + ", nuban=" + nuban + ", message=" + message + '}';
        }
    }


}