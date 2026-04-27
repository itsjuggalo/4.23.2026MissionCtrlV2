package m2;

import android.os.Bundle;
import l2.C2329m;
import n2.AbstractBinderC2406m;
import n2.C2412s;

/* JADX INFO: renamed from: m2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC2367t extends AbstractBinderC2406m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2412s f21383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2329m f21384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C2370w f21385c;

    public AbstractBinderC2367t(C2370w c2370w, C2412s c2412s, C2329m c2329m) {
        this.f21385c = c2370w;
        this.f21383a = c2412s;
        this.f21384b = c2329m;
    }

    @Override // n2.InterfaceC2407n
    public void n(Bundle bundle) {
        this.f21385c.f21390a.u(this.f21384b);
        this.f21383a.d("onRequestInfo", new Object[0]);
    }

    @Override // n2.InterfaceC2407n
    public void zzb(Bundle bundle) {
        this.f21385c.f21390a.u(this.f21384b);
        this.f21383a.d("onCompleteUpdate", new Object[0]);
    }
}
