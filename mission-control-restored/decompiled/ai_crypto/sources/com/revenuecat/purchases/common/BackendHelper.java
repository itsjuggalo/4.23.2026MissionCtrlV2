package com.revenuecat.purchases.common;

import E5.o;
import E5.t;
import F5.AbstractC0556n;
import F5.I;
import Q5.k;
import Q5.p;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
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
        this.authenticationHeaders = I.c(t.a("Authorization", "Bearer " + apiKey));
    }

    public static /* synthetic */ void enqueue$default(BackendHelper backendHelper, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Delay delay, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            delay = Delay.NONE;
        }
        backendHelper.enqueue(asyncCall, dispatcher, delay);
    }

    public final void enqueue(Dispatcher.AsyncCall call, Dispatcher dispatcher, Delay delay) {
        r.f(call, "call");
        r.f(dispatcher, "dispatcher");
        r.f(delay, "delay");
        if (dispatcher.isClosed()) {
            LogUtilsKt.errorLog$default("Enqueuing operation in closed dispatcher.", null, 2, null);
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
                return BackendHelper.this.httpClient.performRequest(BackendHelper.this.appConfig.getBaseURL(), endpoint, map, list, BackendHelper.this.getAuthenticationHeaders$purchases_defaultsRelease(), (160 & 32) != 0 ? false : false, (160 & 64) != 0 ? AbstractC0556n.g() : BackendHelper.this.appConfig.getFallbackBaseURLs(), (160 & 128) != 0 ? 0 : 0);
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
