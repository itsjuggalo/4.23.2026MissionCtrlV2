package m2;

import android.os.Bundle;
import l2.C2329m;
import n2.C2412s;
import p2.C2544a;

/* JADX INFO: renamed from: m2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC2368u extends AbstractBinderC2367t {
    public BinderC2368u(C2370w c2370w, C2329m c2329m) {
        super(c2370w, new C2412s("OnCompleteUpdateCallback"), c2329m);
    }

    @Override // m2.AbstractBinderC2367t, n2.InterfaceC2407n
    public final void zzb(Bundle bundle) {
        super.zzb(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f21384b.d(new C2544a(bundle.getInt("error.code", -2)));
        } else {
            this.f21384b.e(null);
        }
    }
}
