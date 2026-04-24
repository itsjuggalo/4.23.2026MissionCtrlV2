package com.revenuecat.purchases.google;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BillingResponse {
    public static final Companion Companion = new Companion(null);

    public static final class BillingUnavailable extends BillingResponse {
        public static final BillingUnavailable INSTANCE = new BillingUnavailable();

        private BillingUnavailable() {
            super(null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final BillingResponse fromCode(int i7) {
            if (i7 == 12) {
                return NetworkError.INSTANCE;
            }
            switch (i7) {
                case -3:
                    return ServiceUnavailable.INSTANCE;
                case -2:
                    return FeatureNotSupported.INSTANCE;
                case -1:
                    return ServiceDisconnected.INSTANCE;
                case 0:
                    return OK.INSTANCE;
                case 1:
                    return UserCanceled.INSTANCE;
                case 2:
                    return ServiceUnavailable.INSTANCE;
                case 3:
                    return BillingUnavailable.INSTANCE;
                case 4:
                    return ItemUnavailable.INSTANCE;
                case 5:
                    return DeveloperError.INSTANCE;
                case 6:
                    return Error.INSTANCE;
                case 7:
                    return ItemAlreadyOwned.INSTANCE;
                case 8:
                    return ItemNotOwned.INSTANCE;
                default:
                    return Unknown.INSTANCE;
            }
        }

        private Companion() {
        }
    }

    public static final class DeveloperError extends BillingResponse {
        public static final DeveloperError INSTANCE = new DeveloperError();

        private DeveloperError() {
            super(null);
        }
    }

    public static final class Error extends BillingResponse {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }

    public static final class FeatureNotSupported extends BillingResponse {
        public static final FeatureNotSupported INSTANCE = new FeatureNotSupported();

        private FeatureNotSupported() {
            super(null);
        }
    }

    public static final class ItemAlreadyOwned extends BillingResponse {
        public static final ItemAlreadyOwned INSTANCE = new ItemAlreadyOwned();

        private ItemAlreadyOwned() {
            super(null);
        }
    }

    public static final class ItemNotOwned extends BillingResponse {
        public static final ItemNotOwned INSTANCE = new ItemNotOwned();

        private ItemNotOwned() {
            super(null);
        }
    }

    public static final class ItemUnavailable extends BillingResponse {
        public static final ItemUnavailable INSTANCE = new ItemUnavailable();

        private ItemUnavailable() {
            super(null);
        }
    }

    public static final class NetworkError extends BillingResponse {
        public static final NetworkError INSTANCE = new NetworkError();

        private NetworkError() {
            super(null);
        }
    }

    public static final class OK extends BillingResponse {
        public static final OK INSTANCE = new OK();

        private OK() {
            super(null);
        }
    }

    public static final class ServiceDisconnected extends BillingResponse {
        public static final ServiceDisconnected INSTANCE = new ServiceDisconnected();

        private ServiceDisconnected() {
            super(null);
        }
    }

    public static final class ServiceUnavailable extends BillingResponse {
        public static final ServiceUnavailable INSTANCE = new ServiceUnavailable();

        private ServiceUnavailable() {
            super(null);
        }
    }

    public static final class Unknown extends BillingResponse {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    public static final class UserCanceled extends BillingResponse {
        public static final UserCanceled INSTANCE = new UserCanceled();

        private UserCanceled() {
            super(null);
        }
    }

    public /* synthetic */ BillingResponse(AbstractC2148j abstractC2148j) {
        this();
    }

    private BillingResponse() {
    }
}
