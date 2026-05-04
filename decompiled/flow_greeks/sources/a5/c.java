package a5;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f81b = new c(new Bundle(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f82a;

    public /* synthetic */ c(Bundle bundle, i iVar) {
        this.f82a = bundle;
    }

    public final Bundle a() {
        return new Bundle(this.f82a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return q.a(this.f82a, ((c) obj).f82a);
        }
        return false;
    }

    public final int hashCode() {
        return q.c(this.f82a);
    }
}
