package G1;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: loaded from: classes.dex */
public final class c implements a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f2416b = new c(new Bundle(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f2417a;

    public /* synthetic */ c(Bundle bundle, i iVar) {
        this.f2417a = bundle;
    }

    public final Bundle a() {
        return new Bundle(this.f2417a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return AbstractC1206q.a(this.f2417a, ((c) obj).f2417a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1206q.c(this.f2417a);
    }
}
