package p1;

import android.os.Bundle;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: p1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1688c implements a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1688c f13987b = new C1688c(new Bundle(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f13988a;

    public /* synthetic */ C1688c(Bundle bundle, AbstractC1694i abstractC1694i) {
        this.f13988a = bundle;
    }

    public final Bundle a() {
        return new Bundle(this.f13988a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1688c) {
            return AbstractC0939q.a(this.f13988a, ((C1688c) obj).f13988a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0939q.c(this.f13988a);
    }
}
