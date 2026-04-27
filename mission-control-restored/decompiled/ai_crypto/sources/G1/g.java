package G1;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: loaded from: classes.dex */
public final class g implements a.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f2420d = new g(new f());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2421a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2423c;

    public g(f fVar) {
        this.f2422b = fVar.f2418a.booleanValue();
        this.f2423c = fVar.f2419b;
    }

    public static /* bridge */ /* synthetic */ String b(g gVar) {
        String str = gVar.f2421a;
        return null;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putBoolean("force_save_dialog", this.f2422b);
        bundle.putString("log_session_id", this.f2423c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        String str = gVar.f2421a;
        return AbstractC1206q.b(null, null) && this.f2422b == gVar.f2422b && AbstractC1206q.b(this.f2423c, gVar.f2423c);
    }

    public final int hashCode() {
        return AbstractC1206q.c(null, Boolean.valueOf(this.f2422b), this.f2423c);
    }
}
