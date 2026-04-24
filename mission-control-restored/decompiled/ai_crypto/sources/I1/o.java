package I1;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: loaded from: classes.dex */
public final class o implements a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2944a;

    public o(String str) {
        this.f2944a = str;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("session_id", this.f2944a);
        return bundle;
    }

    public final String b() {
        return this.f2944a;
    }

    public final boolean equals(Object obj) {
        return obj instanceof o;
    }

    public final int hashCode() {
        return AbstractC1206q.c(o.class);
    }
}
