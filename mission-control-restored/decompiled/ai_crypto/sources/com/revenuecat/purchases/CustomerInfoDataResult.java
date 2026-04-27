package com.revenuecat.purchases;

import com.revenuecat.purchases.utils.Result;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
final class CustomerInfoDataResult {
    private final Boolean hadUnsyncedPurchasesBefore;
    private final Result<CustomerInfo, PurchasesError> result;

    public CustomerInfoDataResult(Result<CustomerInfo, PurchasesError> result, Boolean bool) {
        r.f(result, "result");
        this.result = result;
        this.hadUnsyncedPurchasesBefore = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerInfoDataResult copy$default(CustomerInfoDataResult customerInfoDataResult, Result result, Boolean bool, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            result = customerInfoDataResult.result;
        }
        if ((i7 & 2) != 0) {
            bool = customerInfoDataResult.hadUnsyncedPurchasesBefore;
        }
        return customerInfoDataResult.copy(result, bool);
    }

    public final Result<CustomerInfo, PurchasesError> component1() {
        return this.result;
    }

    public final Boolean component2() {
        return this.hadUnsyncedPurchasesBefore;
    }

    public final CustomerInfoDataResult copy(Result<CustomerInfo, PurchasesError> result, Boolean bool) {
        r.f(result, "result");
        return new CustomerInfoDataResult(result, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerInfoDataResult)) {
            return false;
        }
        CustomerInfoDataResult customerInfoDataResult = (CustomerInfoDataResult) obj;
        return r.b(this.result, customerInfoDataResult.result) && r.b(this.hadUnsyncedPurchasesBefore, customerInfoDataResult.hadUnsyncedPurchasesBefore);
    }

    public final Boolean getHadUnsyncedPurchasesBefore() {
        return this.hadUnsyncedPurchasesBefore;
    }

    public final Result<CustomerInfo, PurchasesError> getResult() {
        return this.result;
    }

    public int hashCode() {
        int iHashCode = this.result.hashCode() * 31;
        Boolean bool = this.hadUnsyncedPurchasesBefore;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "CustomerInfoDataResult(result=" + this.result + ", hadUnsyncedPurchasesBefore=" + this.hadUnsyncedPurchasesBefore + ')';
    }

    public /* synthetic */ CustomerInfoDataResult(Result result, Boolean bool, int i7, AbstractC2148j abstractC2148j) {
        this(result, (i7 & 2) != 0 ? null : bool);
    }
}
