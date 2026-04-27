package io.flutter.plugins.firebase.storage;

import com.google.firebase.storage.StorageException;
import io.flutter.plugins.firebase.storage.GeneratedAndroidFirebaseStorage;

/* JADX INFO: loaded from: classes3.dex */
class FlutterFirebaseStorageException {
    public static String getCode(int i4) {
        if (i4 == -13040) {
            return "canceled";
        }
        if (i4 == -13031) {
            return "invalid-checksum";
        }
        if (i4 == -13030) {
            return "retry-limit-exceeded";
        }
        if (i4 == -13021) {
            return "unauthorized";
        }
        if (i4 == -13020) {
            return "unauthenticated";
        }
        switch (i4) {
            case StorageException.ERROR_QUOTA_EXCEEDED /* -13013 */:
                return "quota-exceeded";
            case StorageException.ERROR_PROJECT_NOT_FOUND /* -13012 */:
                return "project-not-found";
            case StorageException.ERROR_BUCKET_NOT_FOUND /* -13011 */:
                return "bucket-not-found";
            case StorageException.ERROR_OBJECT_NOT_FOUND /* -13010 */:
                return "object-not-found";
            default:
                return "unknown";
        }
    }

    public static String getMessage(int i4) {
        if (i4 == -13040) {
            return "User cancelled the operation.";
        }
        if (i4 == -13031) {
            return "File on the client does not match the checksum of the file received by the server.";
        }
        if (i4 == -13030) {
            return "The maximum time limit on an operation (upload, download, delete, etc.) has been exceeded.";
        }
        if (i4 == -13021) {
            return "User is not authorized to perform the desired action.";
        }
        if (i4 == -13020) {
            return "User is unauthenticated. Authenticate and try again.";
        }
        switch (i4) {
            case StorageException.ERROR_QUOTA_EXCEEDED /* -13013 */:
                return "Quota on your Firebase Storage bucket has been exceeded.";
            case StorageException.ERROR_PROJECT_NOT_FOUND /* -13012 */:
                return "No project is configured for Firebase Storage.";
            case StorageException.ERROR_BUCKET_NOT_FOUND /* -13011 */:
                return "No bucket is configured for Firebase Storage.";
            case StorageException.ERROR_OBJECT_NOT_FOUND /* -13010 */:
                return "No object exists at the desired reference.";
            default:
                return "An unknown error occurred";
        }
    }

    public static GeneratedAndroidFirebaseStorage.FlutterError parserExceptionToFlutter(Exception exc) {
        String code = "UNKNOWN";
        if (exc == null) {
            return new GeneratedAndroidFirebaseStorage.FlutterError("UNKNOWN", "An unknown error occurred", null);
        }
        String message = "An unknown error occurred:" + exc.getMessage();
        if (exc instanceof StorageException) {
            int errorCode = ((StorageException) exc).getErrorCode();
            code = getCode(errorCode);
            message = getMessage(errorCode);
        }
        return new GeneratedAndroidFirebaseStorage.FlutterError(code, message, null);
    }
}
