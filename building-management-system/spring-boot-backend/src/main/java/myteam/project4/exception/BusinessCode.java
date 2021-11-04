package myteam.project4.exception;

import org.springframework.http.HttpStatus;

public class BusinessCode {

    private BusinessCode() {
    }

    public static final ErrorResponse SUCCESS =
            new ErrorResponse("SUCCESS-01", "SUCCESS", HttpStatus.OK);

    public static final ErrorResponse INTERNAL_SERVER =
            new ErrorResponse("INTERNAL-SERVER", "Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

    public static final ErrorResponse NOT_FOUND_COMPANY_EMPLOYEE =
            new ErrorResponse("NOT_FOUND_COMPANY_EMPLOYEE", "Not found company employee with id", HttpStatus.NOT_FOUND);

    public static final ErrorResponse NOT_FOUND_BUILDING_EMPLOYEE =
            new ErrorResponse("NOT_FOUND_BUILDING_EMPLOYEE", "Not found building employee with id", HttpStatus.NOT_FOUND);
}