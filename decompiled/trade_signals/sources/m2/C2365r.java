package m2;

import android.os.RemoteException;
import l2.C2329m;
import n2.AbstractRunnableC2413t;

/* JADX INFO: renamed from: m2.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2365r extends AbstractRunnableC2413t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C2329m f21378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C2370w f21379d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2365r(C2370w c2370w, C2329m c2329m, String str, C2329m c2329m2) {
        super(c2329m);
        this.f21379d = c2370w;
        this.f21377b = str;
        this.f21378c = c2329m2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, n2.l] */
    @Override // n2.AbstractRunnableC2413t
    public final void a() {
        try {
            ?? E7 = this.f21379d.f21390a.e();
            C2370w c2370w = this.f21379d;
            E7.d(c2370w.f21391b, C2370w.b(c2370w, this.f21377b), new BinderC2369v(this.f21379d, this.f21378c, this.f21377b));
        } catch (RemoteException e8) {
            C2370w.f21388e.c(e8, "requestUpdateInfo(%s)", this.f21377b);
            this.f21378c.d(new RuntimeException(e8));
        }
    }
}
