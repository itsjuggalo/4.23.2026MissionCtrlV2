package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1165b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.api.a f10934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.d f10935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10936d;

    public C1165b(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        this.f10934b = aVar;
        this.f10935c = dVar;
        this.f10936d = str;
        this.f10933a = AbstractC1206q.c(aVar, dVar, str);
    }

    public static C1165b a(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        return new C1165b(aVar, dVar, str);
    }

    public final String b() {
        return this.f10934b.c();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1165b)) {
            return false;
        }
        C1165b c1165b = (C1165b) obj;
        return AbstractC1206q.b(this.f10934b, c1165b.f10934b) && AbstractC1206q.b(this.f10935c, c1165b.f10935c) && AbstractC1206q.b(this.f10936d, c1165b.f10936d);
    }

    public final int hashCode() {
        return this.f10933a;
    }
}
