package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1214z implements a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1214z f11176b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11177a;

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.z$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11178a;

        public /* synthetic */ a(C c7) {
        }

        public C1214z a() {
            return new C1214z(this.f11178a, null);
        }

        public a b(String str) {
            this.f11178a = str;
            return this;
        }
    }

    public /* synthetic */ C1214z(String str, D d7) {
        this.f11177a = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f11177a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1214z) {
            return AbstractC1206q.b(this.f11177a, ((C1214z) obj).f11177a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1206q.c(this.f11177a);
    }
}
