package com.revenuecat.purchases.common;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public enum BackendErrorCode {
    BackendInvalidPlatform(7000),
    BackendStoreProblem(7101),
    BackendCannotTransferPurchase(7102),
    BackendInvalidReceiptToken(7103),
    BackendInvalidAppStoreSharedSecret(7104),
    BackendInvalidPaymentModeOrIntroPriceNotProvided(7105),
    BackendProductIdForGoogleReceiptNotProvided(7106),
    BackendInvalidPlayStoreCredentials(7107),
    BackendInternalServerError(7110),
    BackendEmptyAppUserId(7220),
    BackendInvalidAuthToken(7224),
    BackendInvalidAPIKey(7225),
    BackendBadRequest(7226),
    BackendPlayStoreQuotaExceeded(7229),
    BackendPlayStoreInvalidPackageName(7230),
    BackendPlayStoreGenericError(7231),
    BackendUserIneligibleForPromoOffer(7232),
    BackendInvalidAppleSubscriptionKey(7234),
    BackendCouldNotCreateAlias(7255),
    BackendInvalidAppUserId(7256),
    BackendInvalidSubscriberAttributes(7263),
    BackendInvalidSubscriberAttributesBody(7264),
    BackendSubscriberAttributesAreBeingUpdated(7629),
    BackendPaymentNotComplete(7651),
    BackendRequestAlreadyInProgress(7638),
    BackendProductIDsMalformed(7662),
    BackendInvalidWebRedemptionToken(7849),
    BackendPurchaseBelongsToOtherUser(7852),
    BackendExpiredWebRedemptionToken(7853);

    public static final Companion Companion = new Companion(null);
    private final int value;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final BackendErrorCode valueOf(int i4) {
            for (BackendErrorCode backendErrorCode : BackendErrorCode.values()) {
                if (backendErrorCode.getValue() == i4) {
                    return backendErrorCode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    BackendErrorCode(int i4) {
        this.value = i4;
    }

    public final int getValue() {
        return this.value;
    }
}
