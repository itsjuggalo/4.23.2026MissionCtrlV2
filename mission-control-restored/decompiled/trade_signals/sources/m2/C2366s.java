package m2;

import android.os.RemoteException;
import l2.C2329m;
import n2.AbstractRunnableC2413t;

/* JADX INFO: renamed from: m2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2366s extends AbstractRunnableC2413t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2329m f21380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f21381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C2370w f21382d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2366s(C2370w c2370w, C2329m c2329m, C2329m c2329m2, String str) {
        super(c2329m);
        this.f21382d = c2370w;
        this.f21380b = c2329m2;
        this.f21381c = str;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, n2.l] */
    @Override // n2.AbstractRunnableC2413t
    public final void a() {
        try {
            this.f21382d.f21390a.e().h(this.f21382d.f21391b, C2370w.i(), new BinderC2368u(this.f21382d, this.f21380b));
        } catch (RemoteException e8) {
            C2370w.f21388e.c(e8, "completeUpdate(%s)", this.f21381c);
            this.f21380b.d(new RuntimeException(e8));
        }
    }
}
