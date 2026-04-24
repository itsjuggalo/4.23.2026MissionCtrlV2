package com.revenuecat.purchases.google.usecase;

import W2.E;
import X2.L;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.k;
import i3.o;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryPurchasesUseCase extends BillingClientUseCase<Map<String, ? extends StoreTransaction>> {
    private final k onError;
    private final k onSuccess;
    private final QueryPurchasesUseCaseParams useCaseParams;
    private final k withConnectedClient;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase$executeAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {

        /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase$executeAsync$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01771 extends s implements k {
            final /* synthetic */ QueryPurchasesUseCase this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase$executeAsync$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01781 extends s implements k {
                final /* synthetic */ Map<String, StoreTransaction> $activeSubs;
                final /* synthetic */ QueryPurchasesUseCase this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01781(QueryPurchasesUseCase queryPurchasesUseCase, Map<String, StoreTransaction> map) {
                    super(1);
                    this.this$0 = queryPurchasesUseCase;
                    this.$activeSubs = map;
                }

                @Override // i3.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Map<String, StoreTransaction>) obj);
                    return E.f5463a;
                }

                public final void invoke(Map<String, StoreTransaction> unconsumedInApps) {
                    r.f(unconsumedInApps, "unconsumedInApps");
                    this.this$0.onOk2(L.k(this.$activeSubs, unconsumedInApps));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01771(QueryPurchasesUseCase queryPurchasesUseCase) {
                super(1);
                this.this$0 = queryPurchasesUseCase;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, StoreTransaction>) obj);
                return E.f5463a;
            }

            public final void invoke(Map<String, StoreTransaction> activeSubs) {
                r.f(activeSubs, "activeSubs");
                QueryPurchasesUseCase queryPurchasesUseCase = this.this$0;
                queryPurchasesUseCase.queryInApps(new C01781(queryPurchasesUseCase, activeSubs), this.this$0.getOnError());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((com.android.billingclient.api.a) obj);
            return E.f5463a;
        }

        public final void invoke(com.android.billingclient.api.a invoke) {
            r.f(invoke, "$this$invoke");
            QueryPurchasesUseCase queryPurchasesUseCase = QueryPurchasesUseCase.this;
            queryPurchasesUseCase.querySubscriptions(new C01771(queryPurchasesUseCase), QueryPurchasesUseCase.this.getOnError());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryPurchasesUseCase(QueryPurchasesUseCaseParams useCaseParams, k onSuccess, k onError, k withConnectedClient, o executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        r.f(useCaseParams, "useCaseParams");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        r.f(withConnectedClient, "withConnectedClient");
        r.f(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onSuccess = onSuccess;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryInApps(k kVar, k kVar2) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.useCaseParams.getDateProvider(), this.useCaseParams.getDiagnosticsTrackerIfEnabled(), this.useCaseParams.getAppInBackground(), "inapp"), kVar, kVar2, this.withConnectedClient, getExecuteRequestOnUIThread()), 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void querySubscriptions(k kVar, k kVar2) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.useCaseParams.getDateProvider(), this.useCaseParams.getDiagnosticsTrackerIfEnabled(), this.useCaseParams.getAppInBackground(), "subs"), kVar, kVar2, this.withConnectedClient, getExecuteRequestOnUIThread()), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error when querying purchases";
    }

    public final k getOnError() {
        return this.onError;
    }

    public final k getOnSuccess() {
        return this.onSuccess;
    }

    public final k getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public /* bridge */ /* synthetic */ void onOk(Map<String, ? extends StoreTransaction> map) {
        onOk2((Map<String, StoreTransaction>) map);
    }

    /* JADX INFO: renamed from: onOk, reason: avoid collision after fix types in other method */
    public void onOk2(Map<String, StoreTransaction> received) {
        r.f(received, "received");
        this.onSuccess.invoke(received);
    }
}
