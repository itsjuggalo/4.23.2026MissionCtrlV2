package m2;

import android.os.Bundle;
import l2.C2329m;
import n2.C2412s;
import p2.C2544a;

/* JADX INFO: renamed from: m2.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC2369v extends AbstractBinderC2367t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C2370w f21387e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC2369v(C2370w c2370w, C2329m c2329m, String str) {
        super(c2370w, new C2412s("OnRequestInstallCallback"), c2329m);
        this.f21387e = c2370w;
        this.f21386d = str;
    }

    @Override // m2.AbstractBinderC2367t, n2.InterfaceC2407n
    public final void n(Bundle bundle) {
        super.n(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f21384b.d(new C2544a(bundle.getInt("error.code", -2)));
        } else {
            this.f21384b.e(C2370w.f(this.f21387e, bundle, this.f21386d));
        }
    }
}
