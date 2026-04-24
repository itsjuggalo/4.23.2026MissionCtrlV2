package r1;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: loaded from: classes.dex */
public final class o implements a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14560a;

    public o(String str) {
        this.f14560a = str;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("session_id", this.f14560a);
        return bundle;
    }

    public final String b() {
        return this.f14560a;
    }

    public final boolean equals(Object obj) {
        return obj instanceof o;
    }

    public final int hashCode() {
        return AbstractC0939q.c(o.class);
    }
}
