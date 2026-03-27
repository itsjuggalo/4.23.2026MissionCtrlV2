package s2;

import android.os.Bundle;
import l2.C2329m;
import t2.AbstractBinderC2740g;
import t2.C2742i;
import t2.t;

/* JADX INFO: renamed from: s2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC2696k extends AbstractBinderC2740g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2742i f23075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2329m f23076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C2698m f23077c;

    public AbstractBinderC2696k(C2698m c2698m, C2742i c2742i, C2329m c2329m) {
        this.f23077c = c2698m;
        this.f23075a = c2742i;
        this.f23076b = c2329m;
    }

    @Override // t2.InterfaceC2741h
    public void zzb(Bundle bundle) {
        t tVar = this.f23077c.f23079a;
        if (tVar != null) {
            tVar.u(this.f23076b);
        }
        this.f23075a.c("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
