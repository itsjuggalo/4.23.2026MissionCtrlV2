package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.api.a f5519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.d f5520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5521d;

    public b(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        this.f5519b = aVar;
        this.f5520c = dVar;
        this.f5521d = str;
        this.f5518a = com.google.android.gms.common.internal.q.c(aVar, dVar, str);
    }

    public static b a(com.google.android.gms.common.api.a aVar, a.d dVar, String str) {
        return new b(aVar, dVar, str);
    }

    public final String b() {
        return this.f5519b.c();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return com.google.android.gms.common.internal.q.b(this.f5519b, bVar.f5519b) && com.google.android.gms.common.internal.q.b(this.f5520c, bVar.f5520c) && com.google.android.gms.common.internal.q.b(this.f5521d, bVar.f5521d);
    }

    public final int hashCode() {
        return this.f5518a;
    }
}
