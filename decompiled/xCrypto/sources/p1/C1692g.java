package p1;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: p1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1692g implements a.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1692g f13991d = new C1692g(new C1691f());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13994c;

    public C1692g(C1691f c1691f) {
        this.f13993b = c1691f.f13989a.booleanValue();
        this.f13994c = c1691f.f13990b;
    }

    public static /* bridge */ /* synthetic */ String b(C1692g c1692g) {
        String str = c1692g.f13992a;
        return null;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putBoolean("force_save_dialog", this.f13993b);
        bundle.putString("log_session_id", this.f13994c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1692g)) {
            return false;
        }
        C1692g c1692g = (C1692g) obj;
        String str = c1692g.f13992a;
        return AbstractC0939q.b(null, null) && this.f13993b == c1692g.f13993b && AbstractC0939q.b(this.f13994c, c1692g.f13994c);
    }

    public final int hashCode() {
        return AbstractC0939q.c(null, Boolean.valueOf(this.f13993b), this.f13994c);
    }
}
