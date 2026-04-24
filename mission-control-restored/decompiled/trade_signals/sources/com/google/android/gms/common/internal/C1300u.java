package com.google.android.gms.common.internal;

import R1.a;
import android.os.Bundle;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1300u implements a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1300u f15055b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15056a;

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.u$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15057a;

        public /* synthetic */ a(AbstractC1302w abstractC1302w) {
        }

        public C1300u a() {
            return new C1300u(this.f15057a, null);
        }

        public a b(String str) {
            this.f15057a = str;
            return this;
        }
    }

    public /* synthetic */ C1300u(String str, AbstractC1303x abstractC1303x) {
        this.f15056a = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f15056a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1300u) {
            return AbstractC1293m.a(this.f15056a, ((C1300u) obj).f15056a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1293m.b(this.f15056a);
    }
}
