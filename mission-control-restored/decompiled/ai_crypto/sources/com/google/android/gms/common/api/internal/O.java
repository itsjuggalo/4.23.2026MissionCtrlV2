package com.google.android.gms.common.api.internal;

import P1.C0650d;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;

/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1165b f10906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0650d f10907b;

    public /* synthetic */ O(C1165b c1165b, C0650d c0650d, N n7) {
        this.f10906a = c1165b;
        this.f10907b = c0650d;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof O)) {
            O o7 = (O) obj;
            if (AbstractC1206q.b(this.f10906a, o7.f10906a) && AbstractC1206q.b(this.f10907b, o7.f10907b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1206q.c(this.f10906a, this.f10907b);
    }

    public final String toString() {
        return AbstractC1206q.d(this).a(SubscriberAttributeKt.JSON_NAME_KEY, this.f10906a).a("feature", this.f10907b).toString();
    }
}
