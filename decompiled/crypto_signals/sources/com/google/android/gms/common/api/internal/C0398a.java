package com.google.android.gms.common.api.internal;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0398a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.api.i f5137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.e f5138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5139d;

    public C0398a(com.google.android.gms.common.api.i iVar, com.google.android.gms.common.api.e eVar, String str) {
        this.f5137b = iVar;
        this.f5138c = eVar;
        this.f5139d = str;
        this.f5136a = Arrays.hashCode(new Object[]{iVar, eVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0398a)) {
            return false;
        }
        C0398a c0398a = (C0398a) obj;
        return com.google.android.gms.common.internal.I.j(this.f5137b, c0398a.f5137b) && com.google.android.gms.common.internal.I.j(this.f5138c, c0398a.f5138c) && com.google.android.gms.common.internal.I.j(this.f5139d, c0398a.f5139d);
    }

    public final int hashCode() {
        return this.f5136a;
    }
}
