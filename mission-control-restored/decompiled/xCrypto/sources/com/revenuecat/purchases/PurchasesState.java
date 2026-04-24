package com.revenuecat.purchases;

import X2.L;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesState {
    private final Boolean allowSharingPlayStoreAccount;
    private final boolean appInBackground;
    private final ProductChangeCallback deprecatedProductChangeCallback;
    private final boolean firstTimeInForeground;
    private final Map<String, PurchaseCallback> purchaseCallbacksByProductId;

    public PurchasesState() {
        this(null, null, null, false, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PurchasesState copy$default(PurchasesState purchasesState, Boolean bool, Map map, ProductChangeCallback productChangeCallback, boolean z4, boolean z5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bool = purchasesState.allowSharingPlayStoreAccount;
        }
        if ((i4 & 2) != 0) {
            map = purchasesState.purchaseCallbacksByProductId;
        }
        if ((i4 & 4) != 0) {
            productChangeCallback = purchasesState.deprecatedProductChangeCallback;
        }
        if ((i4 & 8) != 0) {
            z4 = purchasesState.appInBackground;
        }
        if ((i4 & 16) != 0) {
            z5 = purchasesState.firstTimeInForeground;
        }
        boolean z6 = z5;
        ProductChangeCallback productChangeCallback2 = productChangeCallback;
        return purchasesState.copy(bool, map, productChangeCallback2, z4, z6);
    }

    public final Boolean component1() {
        return this.allowSharingPlayStoreAccount;
    }

    public final Map<String, PurchaseCallback> component2() {
        return this.purchaseCallbacksByProductId;
    }

    public final ProductChangeCallback component3() {
        return this.deprecatedProductChangeCallback;
    }

    public final boolean component4() {
        return this.appInBackground;
    }

    public final boolean component5() {
        return this.firstTimeInForeground;
    }

    public final PurchasesState copy(Boolean bool, Map<String, ? extends PurchaseCallback> purchaseCallbacksByProductId, ProductChangeCallback productChangeCallback, boolean z4, boolean z5) {
        r.f(purchaseCallbacksByProductId, "purchaseCallbacksByProductId");
        return new PurchasesState(bool, purchaseCallbacksByProductId, productChangeCallback, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchasesState)) {
            return false;
        }
        PurchasesState purchasesState = (PurchasesState) obj;
        return r.b(this.allowSharingPlayStoreAccount, purchasesState.allowSharingPlayStoreAccount) && r.b(this.purchaseCallbacksByProductId, purchasesState.purchaseCallbacksByProductId) && r.b(this.deprecatedProductChangeCallback, purchasesState.deprecatedProductChangeCallback) && this.appInBackground == purchasesState.appInBackground && this.firstTimeInForeground == purchasesState.firstTimeInForeground;
    }

    public final Boolean getAllowSharingPlayStoreAccount() {
        return this.allowSharingPlayStoreAccount;
    }

    public final boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final ProductChangeCallback getDeprecatedProductChangeCallback() {
        return this.deprecatedProductChangeCallback;
    }

    public final boolean getFirstTimeInForeground() {
        return this.firstTimeInForeground;
    }

    public final Map<String, PurchaseCallback> getPurchaseCallbacksByProductId() {
        return this.purchaseCallbacksByProductId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        Boolean bool = this.allowSharingPlayStoreAccount;
        int iHashCode = (((bool == null ? 0 : bool.hashCode()) * 31) + this.purchaseCallbacksByProductId.hashCode()) * 31;
        ProductChangeCallback productChangeCallback = this.deprecatedProductChangeCallback;
        int iHashCode2 = (iHashCode + (productChangeCallback != null ? productChangeCallback.hashCode() : 0)) * 31;
        boolean z4 = this.appInBackground;
        ?? r12 = z4;
        if (z4) {
            r12 = 1;
        }
        int i4 = (iHashCode2 + r12) * 31;
        boolean z5 = this.firstTimeInForeground;
        return i4 + (z5 ? 1 : z5);
    }

    public String toString() {
        return "PurchasesState(allowSharingPlayStoreAccount=" + this.allowSharingPlayStoreAccount + ", purchaseCallbacksByProductId=" + this.purchaseCallbacksByProductId + ", deprecatedProductChangeCallback=" + this.deprecatedProductChangeCallback + ", appInBackground=" + this.appInBackground + ", firstTimeInForeground=" + this.firstTimeInForeground + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PurchasesState(Boolean bool, Map<String, ? extends PurchaseCallback> purchaseCallbacksByProductId, ProductChangeCallback productChangeCallback, boolean z4, boolean z5) {
        r.f(purchaseCallbacksByProductId, "purchaseCallbacksByProductId");
        this.allowSharingPlayStoreAccount = bool;
        this.purchaseCallbacksByProductId = purchaseCallbacksByProductId;
        this.deprecatedProductChangeCallback = productChangeCallback;
        this.appInBackground = z4;
        this.firstTimeInForeground = z5;
    }

    public /* synthetic */ PurchasesState(Boolean bool, Map map, ProductChangeCallback productChangeCallback, boolean z4, boolean z5, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? null : bool, (i4 & 2) != 0 ? L.e() : map, (i4 & 4) != 0 ? null : productChangeCallback, (i4 & 8) != 0 ? true : z4, (i4 & 16) != 0 ? true : z5);
    }
}
