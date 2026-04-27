package com.revenuecat.purchases.deeplinks;

import W2.E;
import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.CustomerInfoUpdateHandler;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.WebPurchaseRedemption;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import i3.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class WebPurchaseRedemptionHelper {
    private final Backend backend;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final IdentityManager identityManager;
    private final Handler mainHandler;
    private final OfflineEntitlementsManager offlineEntitlementsManager;

    /* JADX INFO: renamed from: com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper$dispatchResult$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        final /* synthetic */ RedeemWebPurchaseListener.Result $result;
        final /* synthetic */ RedeemWebPurchaseListener $resultListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RedeemWebPurchaseListener redeemWebPurchaseListener, RedeemWebPurchaseListener.Result result) {
            super(0);
            this.$resultListener = redeemWebPurchaseListener;
            this.$result = result;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m129invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m129invoke() {
            this.$resultListener.handleResult(this.$result);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper$handleRedeemWebPurchase$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ RedeemWebPurchaseListener $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RedeemWebPurchaseListener redeemWebPurchaseListener) {
            super(1);
            this.$listener = redeemWebPurchaseListener;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((RedeemWebPurchaseListener.Result) obj);
            return E.f5463a;
        }

        public final void invoke(RedeemWebPurchaseListener.Result result) {
            r.f(result, "result");
            if (!(result instanceof RedeemWebPurchaseListener.Result.Success)) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error redeeming web purchase: " + result, null);
                WebPurchaseRedemptionHelper.this.dispatchResult(this.$listener, result);
                return;
            }
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Successfully redeemed web purchase. Updating customer info.");
            }
            WebPurchaseRedemptionHelper.this.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
            WebPurchaseRedemptionHelper.this.customerInfoUpdateHandler.cacheAndNotifyListeners(((RedeemWebPurchaseListener.Result.Success) result).getCustomerInfo());
            WebPurchaseRedemptionHelper.this.dispatchResult(this.$listener, result);
        }
    }

    public WebPurchaseRedemptionHelper(Backend backend, IdentityManager identityManager, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, Handler handler) {
        r.f(backend, "backend");
        r.f(identityManager, "identityManager");
        r.f(offlineEntitlementsManager, "offlineEntitlementsManager");
        r.f(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        this.backend = backend;
        this.identityManager = identityManager;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.mainHandler = handler;
    }

    private final void dispatch(final Function0 function0) {
        if (r.b(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            function0.invoke();
            return;
        }
        Handler handler = this.mainHandler;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.deeplinks.a
            @Override // java.lang.Runnable
            public final void run() {
                WebPurchaseRedemptionHelper.dispatch$lambda$1(function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatch$lambda$1(Function0 tmp0) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchResult(RedeemWebPurchaseListener redeemWebPurchaseListener, RedeemWebPurchaseListener.Result result) {
        dispatch(new AnonymousClass1(redeemWebPurchaseListener, result));
    }

    public final void handleRedeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, RedeemWebPurchaseListener listener) {
        r.f(webPurchaseRedemption, "webPurchaseRedemption");
        r.f(listener, "listener");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Starting web purchase redemption.");
        }
        this.backend.postRedeemWebPurchase(this.identityManager.getCurrentAppUserID(), webPurchaseRedemption.getRedemptionToken$purchases_defaultsRelease(), new AnonymousClass2(listener));
    }

    public /* synthetic */ WebPurchaseRedemptionHelper(Backend backend, IdentityManager identityManager, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, Handler handler, int i4, AbstractC1585j abstractC1585j) {
        this(backend, identityManager, offlineEntitlementsManager, customerInfoUpdateHandler, (i4 & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }
}
