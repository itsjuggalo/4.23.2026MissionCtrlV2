package com.revenuecat.purchases.google;

import com.android.billingclient.api.a;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import java.lang.reflect.Field;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class ErrorsKt {
    public static final String IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE = "Google Play In-app Billing API version is less than 3";

    public static final PurchasesError billingResponseToPurchasesError(int i7, String underlyingErrorMessage) {
        PurchasesErrorCode purchasesErrorCode;
        r.f(underlyingErrorMessage, "underlyingErrorMessage");
        if (i7 != 12) {
            switch (i7) {
                case -3:
                case -1:
                case 2:
                case 6:
                    purchasesErrorCode = PurchasesErrorCode.StoreProblemError;
                    break;
                case -2:
                case 3:
                case 8:
                    purchasesErrorCode = PurchasesErrorCode.PurchaseNotAllowedError;
                    break;
                case 0:
                    purchasesErrorCode = PurchasesErrorCode.UnknownError;
                    break;
                case 1:
                    purchasesErrorCode = PurchasesErrorCode.PurchaseCancelledError;
                    break;
                case 4:
                    purchasesErrorCode = PurchasesErrorCode.ProductNotAvailableForPurchaseError;
                    break;
                case 5:
                    purchasesErrorCode = PurchasesErrorCode.PurchaseInvalidError;
                    break;
                case 7:
                    purchasesErrorCode = PurchasesErrorCode.ProductAlreadyPurchasedError;
                    break;
                default:
                    purchasesErrorCode = PurchasesErrorCode.UnknownError;
                    break;
            }
        } else {
            purchasesErrorCode = PurchasesErrorCode.NetworkError;
        }
        return new PurchasesError(purchasesErrorCode, underlyingErrorMessage);
    }

    public static final String getBillingResponseCodeName(int i7) {
        Field field;
        Field[] allPossibleBillingResponseCodes = a.InterfaceC0176a.class.getDeclaredFields();
        r.e(allPossibleBillingResponseCodes, "allPossibleBillingResponseCodes");
        int length = allPossibleBillingResponseCodes.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                field = null;
                break;
            }
            field = allPossibleBillingResponseCodes[i8];
            if (field.getInt(field) == i7) {
                break;
            }
            i8++;
        }
        String name = field != null ? field.getName() : null;
        return name == null ? String.valueOf(i7) : name;
    }
}
