package com.google.android.gms.internal.play_billing;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class S extends K implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient N f15350b;

    public N C() {
        Object[] array = toArray();
        AbstractC1327e0 abstractC1327e0 = N.f15185b;
        return N.F(array, array.length);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.K
    public N f() {
        N n8 = this.f15350b;
        if (n8 != null) {
            return n8;
        }
        N nC = C();
        this.f15350b = nC;
        return nC;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return AbstractC1317c0.a(this);
    }
}
