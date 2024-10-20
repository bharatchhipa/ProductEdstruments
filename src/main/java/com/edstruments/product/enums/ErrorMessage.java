package com.edstruments.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    GENERIC("Oops! Something went wrong, please try again."),
    PROCESSING_ERROR("Oops! Something went wrong while processing the data. Please try again."),
    UNEXPECTED_ERROR("Unexpected Error"),

    BAD_REQUEST("Invalid request"),
    ACCESS_DENIED("You are not authorised to access this portal, please login from correct portal"),
    QR_EXPIRED("We're sorry, the QR code you scanned is either invalid or has expired."),

    RESPONSE_PARSING("Error in Response Parsing"),

    MAX_RETRY_ATTEMPTS("Maximum number of attempts reached, Please try after sometime"),

    OTP_ALREADY_GENERATED("Otp already generated, Please try after sometime"),

    INVALID_OTP("Invalid OTP. Please use the most recent OTP you received to proceed."),

    INVALID_MOBILE("Please enter a valid mobile number to continue."),

    OTP_VERIFICATION_FAILED("OTP verification failed. Please request a new OTP and try again."),

    OTP_GENERATION_FAILURE("Failed to generate Otp, Please try after sometime"),

    OTP_NOT_GENERATED("Generate an otp first"),

    OTP_EXPIRED("Otp Expired, Please generate a new Otp"),

    OTP_VALIDATION_FAILURE("Failed to verify Otp"),

    DATA_NOT_FOUND("Requested Data Not Found"),

    OTP_ALREADY_VALIDATED("This otp is already verified. Kindly generate a new one."),

    TOKEN_GENERATION_FAILURE("Please refresh the page and try again."),

    USER_AUTHENTICATION_FAILURE("Failed to verify user"),

    INVALID_PIN_CODE("Please enter a valid pin code"),

    FAST_RESEND("Retrying too fast, please wait for a few seconds"),

    OTP_SEND_FAILURE("Could not send otp, please try again"),
    OTP_VERIFY_FAILURE("Could not verify otp, please try again"),

    DECRYPTION_ERROR("Could not decrypt incoming values, please check encryption mechanism"),

    WRONG_OTP("The otp is incorrect, please try again"),
    OFFER_FETCH_FAILURE("Could not fetch offers, please try again"),

    AGENT_ID_NOT_FOUND("Agent id not found."),
    INVALID_FILE_TYPE("We are not able to detect the file type, please upload a valid document"),
    APPLICATION_NUMBER_DOES_NOT_EXIST("Provided Application Number is not present in the System."),
    PAYLOAD_TOO_LARGE("File size exceeds the maximum limit of 5MB");


    private String message;
}