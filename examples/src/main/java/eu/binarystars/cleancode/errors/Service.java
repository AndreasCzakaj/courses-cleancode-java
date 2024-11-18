package eu.binarystars.cleancode.errors;

import java.util.function.Consumer;

class Service {
    ErrorCode processWithErrorCode() {
        return ErrorCode.VALIDATION_ERROR;
    }

    ProcessResult processWithResultObject() {
        var out = new ProcessResult();
        out.errorMessage = "drama!";
        return out;
    }

    void processWithResultObject(Consumer<ProcessData> resolve, Consumer<ErrorCode> reject) {
        reject.accept(ErrorCode.VALIDATION_ERROR);
    }

    ProcessData processWithExceptions() {
        throw new ValidationException();
    }

    static class ProcessResult {
        String errorMessage;
        boolean isSuccess() {
            return errorMessage == null;
        }
        ProcessData data;
    }

    static class ProcessData {}
}
