package com.revenuecat.purchases;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesStateCache implements PurchasesStateProvider {
    private PurchasesState purchasesState;

    public PurchasesStateCache(PurchasesState purchasesState) {
        r.f(purchasesState, "purchasesState");
        this.purchasesState = purchasesState;
    }

    public static /* synthetic */ PurchasesStateCache copy$default(PurchasesStateCache purchasesStateCache, PurchasesState purchasesState, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            purchasesState = purchasesStateCache.purchasesState;
        }
        return purchasesStateCache.copy(purchasesState);
    }

    public final PurchasesState component1() {
        return this.purchasesState;
    }

    public final PurchasesStateCache copy(PurchasesState purchasesState) {
        r.f(purchasesState, "purchasesState");
        return new PurchasesStateCache(purchasesState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PurchasesStateCache) && r.b(this.purchasesState, ((PurchasesStateCache) obj).purchasesState);
    }

    @Override // com.revenuecat.purchases.PurchasesStateProvider
    public synchronized PurchasesState getPurchasesState() {
        return this.purchasesState;
    }

    public int hashCode() {
        return this.purchasesState.hashCode();
    }

    public synchronized void setPurchasesState(PurchasesState purchasesState) {
        r.f(purchasesState, "<set-?>");
        this.purchasesState = purchasesState;
    }

    public String toString() {
        return "PurchasesStateCache(purchasesState=" + this.purchasesState + ')';
    }
}
