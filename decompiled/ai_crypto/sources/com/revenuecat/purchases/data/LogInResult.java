package com.revenuecat.purchases.data;

import com.revenuecat.purchases.CustomerInfo;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class LogInResult {
    private final boolean created;
    private final CustomerInfo customerInfo;

    public LogInResult(CustomerInfo customerInfo, boolean z7) {
        r.f(customerInfo, "customerInfo");
        this.customerInfo = customerInfo;
        this.created = z7;
    }

    public static /* synthetic */ LogInResult copy$default(LogInResult logInResult, CustomerInfo customerInfo, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            customerInfo = logInResult.customerInfo;
        }
        if ((i7 & 2) != 0) {
            z7 = logInResult.created;
        }
        return logInResult.copy(customerInfo, z7);
    }

    public final CustomerInfo component1() {
        return this.customerInfo;
    }

    public final boolean component2() {
        return this.created;
    }

    public final LogInResult copy(CustomerInfo customerInfo, boolean z7) {
        r.f(customerInfo, "customerInfo");
        return new LogInResult(customerInfo, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogInResult)) {
            return false;
        }
        LogInResult logInResult = (LogInResult) obj;
        return r.b(this.customerInfo, logInResult.customerInfo) && this.created == logInResult.created;
    }

    public final boolean getCreated() {
        return this.created;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.customerInfo.hashCode() * 31;
        boolean z7 = this.created;
        ?? r12 = z7;
        if (z7) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    public String toString() {
        return "LogInResult(customerInfo=" + this.customerInfo + ", created=" + this.created + ')';
    }
}
