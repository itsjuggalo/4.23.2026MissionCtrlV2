package com.google.android.gms.common.internal;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0444w implements com.google.android.gms.common.api.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0444w f5288b = new C0444w(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5289a;

    public /* synthetic */ C0444w(String str) {
        this.f5289a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0444w) {
            return I.j(this.f5289a, ((C0444w) obj).f5289a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5289a});
    }
}
