package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.AbstractC0939q;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0898c f9731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1986d f9732b;

    public /* synthetic */ S(C0898c c0898c, C1986d c1986d, Q q4) {
        this.f9731a = c0898c;
        this.f9732b = c1986d;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof S)) {
            S s4 = (S) obj;
            if (AbstractC0939q.b(this.f9731a, s4.f9731a) && AbstractC0939q.b(this.f9732b, s4.f9732b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0939q.c(this.f9731a, this.f9732b);
    }

    public final String toString() {
        return AbstractC0939q.d(this).a("key", this.f9731a).a("feature", this.f9732b).toString();
    }
}
