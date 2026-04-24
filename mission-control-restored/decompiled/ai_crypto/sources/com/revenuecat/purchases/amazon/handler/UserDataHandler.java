package com.revenuecat.purchases.amazon.handler;

import E5.E;
import Q5.k;
import android.os.Handler;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.utils.DefaultTimestampProvider;
import com.revenuecat.purchases.utils.TimestampProvider;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class UserDataHandler implements UserDataResponseListener {
    private static final long CACHE_EXPIRATION_TIME_MILLIS = 300000;
    public static final Companion Companion = new Companion(null);
    private static final long GET_USER_DATA_TIMEOUT_MILLIS = 10000;
    private Long lastUserDataRequestTimestamp;
    private final Handler mainHandler;
    private final PurchasingServiceProvider purchasingServiceProvider;
    private final Map<RequestId, Request> requests;
    private final TimestampProvider timestampProvider;
    private UserData userDataCache;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Request {
        private final k onError;
        private final k onReceive;

        public Request(k onReceive, k onError) {
            r.f(onReceive, "onReceive");
            r.f(onError, "onError");
            this.onReceive = onReceive;
            this.onError = onError;
        }

        public static /* synthetic */ Request copy$default(Request request, k kVar, k kVar2, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                kVar = request.onReceive;
            }
            if ((i7 & 2) != 0) {
                kVar2 = request.onError;
            }
            return request.copy(kVar, kVar2);
        }

        public final k component1() {
            return this.onReceive;
        }

        public final k component2() {
            return this.onError;
        }

        public final Request copy(k onReceive, k onError) {
            r.f(onReceive, "onReceive");
            r.f(onError, "onError");
            return new Request(onReceive, onError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return r.b(this.onReceive, request.onReceive) && r.b(this.onError, request.onError);
        }

        public final k getOnError() {
            return this.onError;
        }

        public final k getOnReceive() {
            return this.onReceive;
        }

        public int hashCode() {
            return (this.onReceive.hashCode() * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "Request(onReceive=" + this.onReceive + ", onError=" + this.onError + ')';
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UserDataResponse.RequestStatus.values().length];
            try {
                iArr[UserDataResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UserDataResponse.RequestStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UserDataResponse.RequestStatus.NOT_SUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public UserDataHandler(PurchasingServiceProvider purchasingServiceProvider, Handler mainHandler, TimestampProvider timestampProvider) {
        r.f(purchasingServiceProvider, "purchasingServiceProvider");
        r.f(mainHandler, "mainHandler");
        r.f(timestampProvider, "timestampProvider");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.mainHandler = mainHandler;
        this.timestampProvider = timestampProvider;
        this.requests = new LinkedHashMap();
    }

    private final void addTimeoutToUserDataRequest(final RequestId requestId) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.amazon.handler.b
            @Override // java.lang.Runnable
            public final void run() {
                UserDataHandler.addTimeoutToUserDataRequest$lambda$5(this.f12915a, requestId);
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTimeoutToUserDataRequest$lambda$5(UserDataHandler this$0, RequestId requestId) {
        r.f(this$0, "this$0");
        r.f(requestId, "$requestId");
        Request request = this$0.getRequest(requestId);
        if (request == null) {
            return;
        }
        request.getOnError().invoke(new PurchasesError(PurchasesErrorCode.UnknownError, AmazonStrings.ERROR_TIMEOUT_GETTING_USER_DATA));
    }

    private final synchronized UserData getCachedUserDataIfAvailable() {
        Long l7;
        UserData userData = this.userDataCache;
        if (userData != null && (l7 = this.lastUserDataRequestTimestamp) != null) {
            if (this.timestampProvider.getCurrentTimeMillis() - l7.longValue() < CACHE_EXPIRATION_TIME_MILLIS) {
                return userData;
            }
        }
        return null;
    }

    private final synchronized Request getRequest(RequestId requestId) {
        return this.requests.remove(requestId);
    }

    private final void invokeWithStoreProblem(k kVar, String str) {
        kVar.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, str));
    }

    @Override // com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void getUserData(k onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        UserData cachedUserDataIfAvailable = getCachedUserDataIfAvailable();
        if (cachedUserDataIfAvailable != null) {
            LogWrapperKt.log(LogIntent.DEBUG, AmazonStrings.USER_DATA_REQUEST_FROM_CACHE);
            onSuccess.invoke(cachedUserDataIfAvailable);
            return;
        }
        RequestId userData = this.purchasingServiceProvider.getUserData();
        Request request = new Request(onSuccess, onError);
        synchronized (this) {
            this.requests.put(userData, request);
            addTimeoutToUserDataRequest(userData);
            E e7 = E.f1657a;
        }
    }

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener
    public void onUserDataResponse(UserDataResponse response) throws Exception {
        r.f(response, "response");
        try {
            LogIntent logIntent = LogIntent.DEBUG;
            String str = String.format(AmazonStrings.USER_DATA_REQUEST_FINISHED, Arrays.copyOf(new Object[]{response.getRequestStatus().name()}, 1));
            r.e(str, "format(this, *args)");
            LogWrapperKt.log(logIntent, str);
            RequestId requestId = response.getRequestId();
            r.e(requestId, "response.requestId");
            Request request = getRequest(requestId);
            if (request == null) {
                return;
            }
            UserDataResponse.RequestStatus requestStatus = response.getRequestStatus();
            int i7 = requestStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestStatus.ordinal()];
            if (i7 != 1) {
                if (i7 == 2) {
                    invokeWithStoreProblem(request.getOnError(), AmazonStrings.ERROR_FAILED_USER_DATA);
                    return;
                } else if (i7 != 3) {
                    invokeWithStoreProblem(request.getOnError(), AmazonStrings.ERROR_USER_DATA_STORE_PROBLEM);
                    return;
                } else {
                    invokeWithStoreProblem(request.getOnError(), AmazonStrings.ERROR_UNSUPPORTED_USER_DATA);
                    return;
                }
            }
            synchronized (this) {
                this.lastUserDataRequestTimestamp = Long.valueOf(this.timestampProvider.getCurrentTimeMillis());
                this.userDataCache = response.getUserData();
                E e7 = E.f1657a;
            }
            k onReceive = request.getOnReceive();
            UserData userData = response.getUserData();
            r.e(userData, "response.userData");
            onReceive.invoke(userData);
        } catch (Exception e8) {
            LogUtilsKt.errorLog("Exception in onUserDataResponse", e8);
            throw e8;
        }
    }

    public /* synthetic */ UserDataHandler(PurchasingServiceProvider purchasingServiceProvider, Handler handler, TimestampProvider timestampProvider, int i7, AbstractC2148j abstractC2148j) {
        this(purchasingServiceProvider, handler, (i7 & 4) != 0 ? new DefaultTimestampProvider() : timestampProvider);
    }
}
