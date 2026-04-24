package j1;

import android.content.Context;
import j1.InterfaceC2199b;

/* JADX INFO: renamed from: j1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2201d implements InterfaceC2199b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2199b.a f19945b;

    public C2201d(Context context, InterfaceC2199b.a aVar) {
        this.f19944a = context.getApplicationContext();
        this.f19945b = aVar;
    }

    @Override // j1.l
    public void a() {
        l();
    }

    @Override // j1.l
    public void f() {
        m();
    }

    public final void l() {
        r.a(this.f19944a).d(this.f19945b);
    }

    public final void m() {
        r.a(this.f19944a).e(this.f19945b);
    }

    @Override // j1.l
    public void c() {
    }
}
