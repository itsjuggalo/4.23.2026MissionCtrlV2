package com.google.android.gms.common.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComponentName f5743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f5745e;

    public l1(String str, String str2, int i10, boolean z10) {
        s.e(str);
        this.f5741a = str;
        s.e(str2);
        this.f5742b = str2;
        this.f5743c = null;
        this.f5744d = 4225;
        this.f5745e = z10;
    }

    public final String a() {
        return this.f5741a;
    }

    public final String b() {
        return this.f5742b;
    }

    public final ComponentName c() {
        return this.f5743c;
    }

    public final boolean d() {
        return this.f5745e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return q.b(this.f5741a, l1Var.f5741a) && q.b(this.f5742b, l1Var.f5742b) && q.b(this.f5743c, l1Var.f5743c) && this.f5745e == l1Var.f5745e;
    }

    public final int hashCode() {
        return q.c(this.f5741a, this.f5742b, this.f5743c, 4225, Boolean.valueOf(this.f5745e));
    }

    public final String toString() {
        String str = this.f5741a;
        if (str != null) {
            return str;
        }
        ComponentName componentName = this.f5743c;
        s.k(componentName);
        return componentName.flattenToString();
    }
}
