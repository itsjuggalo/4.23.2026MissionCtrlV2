package v3;

import android.content.Context;
import v3.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f23093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.a f23094b;

    public d(Context context, b.a aVar) {
        this.f23093a = context.getApplicationContext();
        this.f23094b = aVar;
    }

    @Override // v3.l
    public void a() {
        l();
    }

    @Override // v3.l
    public void h() {
        m();
    }

    public final void l() {
        r.a(this.f23093a).d(this.f23094b);
    }

    public final void m() {
        r.a(this.f23093a).e(this.f23094b);
    }

    @Override // v3.l
    public void e() {
    }
}
