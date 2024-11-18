package eu.binarystars.cleancode.errors;

public class Client {
    private final Service service;

    Client(Service service) {
        this.service = service;
    }

    void consumeWithErrorCode() {
        ErrorCode errorCode = service.processWithErrorCode();
        if (errorCode == ErrorCode.VALIDATION_ERROR) {
            // handle error
        } else {
            // where's my data?
        }
    }

    void consumeWithResultObject() {
        Service.ProcessResult result = service.processWithResultObject();
        if (result.isSuccess()) {
            System.out.println(result.data);
        } else {
            // handle error
        }
    }

    void consumeWithCallbacks() {
        service.processWithResultObject(
                System.out::println,
                System.err::println // handleError,
        );
    }

    void consumeWithExceptions() {
        try {
            var data = service.processWithExceptions();
        } catch (ValidationException e) {
            // handle here, e.g. return HTTP 400
            // ... or re-throw it so a generic error handler can deal with it
        } catch (InternalProblemException e) {
            // handle here, e.g. return HTTP 500
            // ... or re-throw it so a generic error handler can deal with it
        }
        // everything else will be thrown up the call stack
    }
}
