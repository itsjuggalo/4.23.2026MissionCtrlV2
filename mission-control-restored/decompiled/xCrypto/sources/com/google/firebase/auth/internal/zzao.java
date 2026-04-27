package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.revenuecat.purchases.common.Constants;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzao {
    private static Status zza(String str, String str2) {
        int i4;
        str.getClass();
        switch (str) {
            case "USER_CANCELLED":
                i4 = 18001;
                break;
            case "INVALID_RECIPIENT_EMAIL":
                i4 = 17033;
                break;
            case "WEB_CONTEXT_ALREADY_PRESENTED":
                i4 = 17057;
                break;
            case "INTERNAL_SUCCESS_SIGN_OUT":
                i4 = 17091;
                break;
            case "INVALID_IDP_RESPONSE":
            case "INVALID_LOGIN_CREDENTIALS":
            case "INVALID_PENDING_TOKEN":
                i4 = FirebaseError.ERROR_INVALID_CREDENTIAL;
                break;
            case "DYNAMIC_LINK_NOT_ACTIVATED":
                i4 = 17068;
                break;
            case "QUOTA_EXCEEDED":
                i4 = 17052;
                break;
            case "WEB_NETWORK_REQUEST_FAILED":
                i4 = 17061;
                break;
            case "INVALID_RECAPTCHA_VERSION":
                i4 = 17206;
                break;
            case "RECAPTCHA_NOT_ENABLED":
                i4 = 17200;
                break;
            case "EXPIRED_OOB_CODE":
                i4 = 17029;
                break;
            case "UNAUTHORIZED_DOMAIN":
                i4 = 17038;
                break;
            case "INVALID_OOB_CODE":
                i4 = 17030;
                break;
            case "MISSING_EMAIL":
                i4 = 17034;
                break;
            case "INVALID_CODE":
                i4 = 17044;
                break;
            case "INVALID_HOSTING_LINK_DOMAIN":
                i4 = 17214;
                break;
            case "TOKEN_EXPIRED":
                i4 = FirebaseError.ERROR_USER_TOKEN_EXPIRED;
                break;
            case "INVALID_TENANT_ID":
                i4 = 17079;
                break;
            case "ALTERNATE_CLIENT_IDENTIFIER_REQUIRED":
                i4 = 18002;
                break;
            case "INVALID_SESSION_INFO":
                i4 = 17046;
                break;
            case "SECOND_FACTOR_EXISTS":
                i4 = 17087;
                break;
            case "INVALID_EMAIL":
            case "INVALID_IDENTIFIER":
                i4 = FirebaseError.ERROR_INVALID_EMAIL;
                break;
            case "ADMIN_ONLY_OPERATION":
                i4 = 17085;
                break;
            case "MISSING_OR_INVALID_NONCE":
                i4 = 17094;
                break;
            case "INVALID_CERT_HASH":
                i4 = 17064;
                break;
            case "NO_SUCH_PROVIDER":
                i4 = FirebaseError.ERROR_NO_SUCH_PROVIDER;
                break;
            case "MFA_ENROLLMENT_NOT_FOUND":
                i4 = 17084;
                break;
            case "MISSING_PASSWORD":
                i4 = 17035;
                break;
            case "CREDENTIAL_TOO_OLD_LOGIN_AGAIN":
                i4 = FirebaseError.ERROR_REQUIRES_RECENT_LOGIN;
                break;
            case "TIMEOUT":
            case "<<Network Error>>":
                i4 = FirebaseError.ERROR_NETWORK_REQUEST_FAILED;
                break;
            case "INVALID_REQ_TYPE":
                i4 = 17207;
                break;
            case "INVALID_RECAPTCHA_ACTION":
                i4 = 17203;
                break;
            case "OPERATION_NOT_ALLOWED":
            case "PASSWORD_LOGIN_DISABLED":
                i4 = FirebaseError.ERROR_OPERATION_NOT_ALLOWED;
                break;
            case "WEB_INTERNAL_ERROR":
                i4 = 17062;
                break;
            case "SECOND_FACTOR_LIMIT_EXCEEDED":
                i4 = 17088;
                break;
            case "MISSING_MFA_ENROLLMENT_ID":
                i4 = 17082;
                break;
            case "USER_NOT_FOUND":
            case "EMAIL_NOT_FOUND":
                i4 = FirebaseError.ERROR_USER_NOT_FOUND;
                break;
            case "CAPTCHA_CHECK_FAILED":
                i4 = 17056;
                break;
            case "WEAK_PASSWORD":
                i4 = FirebaseError.ERROR_WEAK_PASSWORD;
                break;
            case "UNSUPPORTED_FIRST_FACTOR":
                i4 = 17089;
                break;
            case "INVALID_SENDER":
                i4 = 17032;
                break;
            case "MISSING_PHONE_NUMBER":
                i4 = 17041;
                break;
            case "INVALID_DYNAMIC_LINK_DOMAIN":
                i4 = 17074;
                break;
            case "MISSING_MFA_PENDING_CREDENTIAL":
                i4 = 17081;
                break;
            case "UNSUPPORTED_PASSTHROUGH_OPERATION":
                i4 = 17095;
                break;
            case "EMAIL_EXISTS":
                i4 = FirebaseError.ERROR_EMAIL_ALREADY_IN_USE;
                break;
            case "INVALID_ID_TOKEN":
                i4 = FirebaseError.ERROR_INVALID_USER_TOKEN;
                break;
            case "WEB_STORAGE_UNSUPPORTED":
                i4 = 17065;
                break;
            case "MISSING_CLIENT_TYPE":
                i4 = 17204;
                break;
            case "MISSING_RECAPTCHA_VERSION":
                i4 = 17205;
                break;
            case "UNVERIFIED_EMAIL":
                i4 = 17086;
                break;
            case "REJECTED_CREDENTIAL":
                i4 = 17075;
                break;
            case "INVALID_MFA_PENDING_CREDENTIAL":
                i4 = 17083;
                break;
            case "INVALID_VERIFICATION_PROOF":
                i4 = 17049;
                break;
            case "INVALID_PROVIDER_ID":
                i4 = 17071;
                break;
            case "CREDENTIAL_MISMATCH":
                i4 = FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH;
                break;
            case "WEB_CONTEXT_CANCELED":
                i4 = 17058;
                break;
            case "REQUIRES_SECOND_FACTOR_AUTH":
                i4 = 17078;
                break;
            case "MISSING_CLIENT_IDENTIFIER":
                i4 = 17093;
                break;
            case "INVALID_MESSAGE_PAYLOAD":
                i4 = 17031;
                break;
            case "RESET_PASSWORD_EXCEED_LIMIT":
            case "TOO_MANY_ATTEMPTS_TRY_LATER":
                i4 = FirebaseError.ERROR_TOO_MANY_REQUESTS;
                break;
            case "INVALID_CUSTOM_TOKEN":
                i4 = FirebaseError.ERROR_INVALID_CUSTOM_TOKEN;
                break;
            case "INVALID_PASSWORD":
                i4 = FirebaseError.ERROR_WRONG_PASSWORD;
                break;
            case "INVALID_RECAPTCHA_TOKEN":
                i4 = 17202;
                break;
            case "SESSION_EXPIRED":
                i4 = 17051;
                break;
            case "MISSING_CODE":
                i4 = 17043;
                break;
            case "FEDERATED_USER_ID_ALREADY_LINKED":
                i4 = FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE;
                break;
            case "MISSING_RECAPTCHA_TOKEN":
                i4 = 17201;
                break;
            case "USER_DISABLED":
                i4 = FirebaseError.ERROR_USER_DISABLED;
                break;
            case "INVALID_PHONE_NUMBER":
                i4 = 17042;
                break;
            case "INVALID_APP_CREDENTIAL":
                i4 = FirebaseError.ERROR_APP_NOT_AUTHORIZED;
                break;
            case "MISSING_CONTINUE_URI":
                i4 = 17040;
                break;
            case "MISSING_SESSION_INFO":
                i4 = 17045;
                break;
            case "EMAIL_CHANGE_NEEDS_VERIFICATION":
                i4 = 17090;
                break;
            case "UNSUPPORTED_TENANT_OPERATION":
                i4 = 17073;
                break;
            default:
                i4 = 17499;
                break;
        }
        if (i4 != 17499) {
            return new Status(i4, str2);
        }
        if (str2 == null) {
            return new Status(i4, str);
        }
        return new Status(i4, str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2);
    }

    public static Status zza(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new Status(FirebaseError.ERROR_INTERNAL_ERROR);
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 2);
        strArrSplit[0] = strArrSplit[0].trim();
        if (strArrSplit.length > 1 && (str2 = strArrSplit[1]) != null) {
            strArrSplit[1] = str2.trim();
        }
        List listAsList = Arrays.asList(strArrSplit);
        if (listAsList.size() > 1) {
            return zza((String) listAsList.get(0), (String) listAsList.get(1));
        }
        return zza((String) listAsList.get(0), null);
    }
}
