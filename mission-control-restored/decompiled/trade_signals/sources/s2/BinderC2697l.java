package s2;

import android.app.PendingIntent;
import android.os.Bundle;
import l2.C2329m;
import t2.C2742i;

/* JADX INFO: renamed from: s2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC2697l extends AbstractBinderC2696k {
    public BinderC2697l(C2698m c2698m, C2329m c2329m, String str) {
        super(c2698m, new C2742i("OnRequestInstallCallback"), c2329m);
    }

    @Override // s2.AbstractBinderC2696k, t2.InterfaceC2741h
    public final void zzb(Bundle bundle) {
        super.zzb(bundle);
        this.f23076b.e(new C2690e((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
