package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0947z implements a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0947z f9993b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9994a;

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.z$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9995a;

        public /* synthetic */ a(C c4) {
        }

        public C0947z a() {
            return new C0947z(this.f9995a, null);
        }

        public a b(String str) {
            this.f9995a = str;
            return this;
        }
    }

    public /* synthetic */ C0947z(String str, D d4) {
        this.f9994a = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f9994a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0947z) {
            return AbstractC0939q.b(this.f9994a, ((C0947z) obj).f9994a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0939q.c(this.f9994a);
    }
}
