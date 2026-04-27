package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0898c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.api.a f9752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.d f9753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9754d;

    public C0898c(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        this.f9752b = aVar;
        this.f9753c = dVar;
        this.f9754d = str;
        this.f9751a = AbstractC0939q.c(aVar, dVar, str);
    }

    public static C0898c a(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        return new C0898c(aVar, dVar, str);
    }

    public final String b() {
        return this.f9752b.c();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0898c)) {
            return false;
        }
        C0898c c0898c = (C0898c) obj;
        return AbstractC0939q.b(this.f9752b, c0898c.f9752b) && AbstractC0939q.b(this.f9753c, c0898c.f9753c) && AbstractC0939q.b(this.f9754d, c0898c.f9754d);
    }

    public final int hashCode() {
        return this.f9751a;
    }
}
