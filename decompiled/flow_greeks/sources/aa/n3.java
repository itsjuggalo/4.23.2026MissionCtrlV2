package aa;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m3 f531a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f534d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f533c = d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f532b = e();

    public n3(m3 m3Var) {
        this.f531a = m3Var;
    }

    public boolean a() {
        return this.f533c;
    }

    public boolean b() {
        return this.f532b;
    }

    public void c(ib.e eVar) {
        if (this.f532b) {
            return;
        }
        h();
        Iterator it = eVar.d0().iterator();
        while (it.hasNext()) {
            if (((hb.c) it.next()).d0()) {
                g(true);
                h2.c("Setting this device as a test device");
                return;
            }
        }
    }

    public final boolean d() {
        return this.f531a.a("fresh_install", true);
    }

    public final boolean e() {
        return this.f531a.a("test_device", false);
    }

    public final void f(boolean z10) {
        this.f533c = z10;
        this.f531a.f("fresh_install", z10);
    }

    public final void g(boolean z10) {
        this.f532b = z10;
        this.f531a.f("test_device", z10);
    }

    public final void h() {
        if (this.f533c) {
            int i10 = this.f534d + 1;
            this.f534d = i10;
            if (i10 >= 5) {
                f(false);
            }
        }
    }
}
