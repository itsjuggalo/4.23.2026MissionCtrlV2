package com.revenuecat.purchases.google.usecase;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class QueryPurchaseHistoryUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final String productType;

    public QueryPurchaseHistoryUseCaseParams(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, String productType, boolean z4) {
        r.f(dateProvider, "dateProvider");
        r.f(productType, "productType");
        this.dateProvider = dateProvider;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.productType = productType;
        this.appInBackground = z4;
    }

    public static /* synthetic */ QueryPurchaseHistoryUseCaseParams copy$default(QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams, DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, String str, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            dateProvider = queryPurchaseHistoryUseCaseParams.dateProvider;
        }
        if ((i4 & 2) != 0) {
            diagnosticsTracker = queryPurchaseHistoryUseCaseParams.diagnosticsTrackerIfEnabled;
        }
        if ((i4 & 4) != 0) {
            str = queryPurchaseHistoryUseCaseParams.productType;
        }
        if ((i4 & 8) != 0) {
            z4 = queryPurchaseHistoryUseCaseParams.appInBackground;
        }
        return queryPurchaseHistoryUseCaseParams.copy(dateProvider, diagnosticsTracker, str, z4);
    }

    public final DateProvider component1() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker component2() {
        return this.diagnosticsTrackerIfEnabled;
    }

    public final String component3() {
        return this.productType;
    }

    public final boolean component4() {
        return this.appInBackground;
    }

    public final QueryPurchaseHistoryUseCaseParams copy(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, String productType, boolean z4) {
        r.f(dateProvider, "dateProvider");
        r.f(productType, "productType");
        return new QueryPurchaseHistoryUseCaseParams(dateProvider, diagnosticsTracker, productType, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryPurchaseHistoryUseCaseParams)) {
            return false;
        }
        QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams = (QueryPurchaseHistoryUseCaseParams) obj;
        return r.b(this.dateProvider, queryPurchaseHistoryUseCaseParams.dateProvider) && r.b(this.diagnosticsTrackerIfEnabled, queryPurchaseHistoryUseCaseParams.diagnosticsTrackerIfEnabled) && r.b(this.productType, queryPurchaseHistoryUseCaseParams.productType) && this.appInBackground == queryPurchaseHistoryUseCaseParams.appInBackground;
    }

    @Override // com.revenuecat.purchases.google.usecase.UseCaseParams
    public boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker getDiagnosticsTrackerIfEnabled() {
        return this.diagnosticsTrackerIfEnabled;
    }

    public final String getProductType() {
        return this.productType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = this.dateProvider.hashCode() * 31;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        int iHashCode2 = (((iHashCode + (diagnosticsTracker == null ? 0 : diagnosticsTracker.hashCode())) * 31) + this.productType.hashCode()) * 31;
        boolean z4 = this.appInBackground;
        ?? r12 = z4;
        if (z4) {
            r12 = 1;
        }
        return iHashCode2 + r12;
    }

    public String toString() {
        return "QueryPurchaseHistoryUseCaseParams(dateProvider=" + this.dateProvider + ", diagnosticsTrackerIfEnabled=" + this.diagnosticsTrackerIfEnabled + ", productType=" + this.productType + ", appInBackground=" + this.appInBackground + ')';
    }

    public /* synthetic */ QueryPurchaseHistoryUseCaseParams(DateProvider dateProvider, DiagnosticsTracker diagnosticsTracker, String str, boolean z4, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? new DefaultDateProvider() : dateProvider, diagnosticsTracker, str, z4);
    }
}
