package a5;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements a.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f85d = new g(new f());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f86a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f87b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f88c;

    public g(f fVar) {
        this.f87b = fVar.f83a.booleanValue();
        this.f88c = fVar.f84b;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putBoolean("force_save_dialog", this.f87b);
        bundle.putString("log_session_id", this.f88c);
        return bundle;
    }

    public final /* synthetic */ boolean b() {
        return this.f87b;
    }

    public final /* synthetic */ String c() {
        return this.f88c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return q.b(null, null) && this.f87b == gVar.f87b && q.b(this.f88c, gVar.f88c);
    }

    public final int hashCode() {
        return q.c(null, Boolean.valueOf(this.f87b), this.f88c);
    }
}
