package com.revenuecat.purchases.common;

import W2.o;
import W2.t;
import X2.K;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import i3.k;
import i3.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class BackendHelper {
    private final String apiKey;
    private final AppConfig appConfig;
    private final Map<String, String> authenticationHeaders;
    private final Dispatcher dispatcher;
    private final HTTPClient httpClient;

    public BackendHelper(String apiKey, Dispatcher dispatcher, AppConfig appConfig, HTTPClient httpClient) {
        r.f(apiKey, "apiKey");
        r.f(dispatcher, "dispatcher");
        r.f(appConfig, "appConfig");
        r.f(httpClient, "httpClient");
        this.apiKey = apiKey;
        this.dispatcher = dispatcher;
        this.appConfig = appConfig;
        this.httpClient = httpClient;
        this.authenticationHeaders = K.c(t.a("Authorization", "Bearer " + apiKey));
    }

    public static /* synthetic */ void enqueue$default(BackendHelper backendHelper, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Delay delay, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            delay = Delay.NONE;
        }
        backendHelper.enqueue(asyncCall, dispatcher, delay);
    }

    public final void enqueue(Dispatcher.AsyncCall call, Dispatcher dispatcher, Delay delay) {
        r.f(call, "call");
        r.f(dispatcher, "dispatcher");
        r.f(delay, "delay");
        if (dispatcher.isClosed()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Enqueuing operation in closed dispatcher.", null);
        } else {
            dispatcher.enqueue(call, delay);
        }
    }

    public final Map<String, String> getAuthenticationHeaders$purchases_defaultsRelease() {
        return this.authenticationHeaders;
    }

    public final void performRequest(final Endpoint endpoint, final Map<String, ? extends Object> map, final List<o> list, Delay delay, final k onError, final p onCompleted) {
        r.f(endpoint, "endpoint");
        r.f(delay, "delay");
        r.f(onError, "onError");
        r.f(onCompleted, "onCompleted");
        enqueue(new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.BackendHelper.performRequest.1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(BackendHelper.this.httpClient, BackendHelper.this.appConfig.getBaseURL(), endpoint, map, list, BackendHelper.this.getAuthenticationHeaders$purchases_defaultsRelease(), false, BackendHelper.this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                PurchasesError purchasesError;
                r.f(result, "result");
                if (BackendHelperKt.isSuccessful(result)) {
                    purchasesError = null;
                } else {
                    purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                }
                onCompleted.invoke(purchasesError, Integer.valueOf(result.getResponseCode()), result.getBody());
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                r.f(error, "error");
                onError.invoke(error);
            }
        }, this.dispatcher, delay);
    }
}
