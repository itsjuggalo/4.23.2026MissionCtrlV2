package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class z implements a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f5810b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5811a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5812a;

        public /* synthetic */ a(byte[] bArr) {
        }

        public z a() {
            return new z(this.f5812a, null);
        }

        public a b(String str) {
            this.f5812a = str;
            return this;
        }
    }

    public /* synthetic */ z(String str, byte[] bArr) {
        this.f5811a = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f5811a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            return q.b(this.f5811a, ((z) obj).f5811a);
        }
        return false;
    }

    public final int hashCode() {
        return q.c(this.f5811a);
    }
}
