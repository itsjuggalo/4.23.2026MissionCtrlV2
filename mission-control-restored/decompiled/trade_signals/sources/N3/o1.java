package N3;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f5722a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5725d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5724c = d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5723b = e();

    public o1(n1 n1Var) {
        this.f5722a = n1Var;
    }

    public boolean a() {
        return this.f5724c;
    }

    public boolean b() {
        return this.f5723b;
    }

    public void c(r4.e eVar) {
        if (this.f5723b) {
            return;
        }
        h();
        Iterator it = eVar.V().iterator();
        while (it.hasNext()) {
            if (((q4.c) it.next()).V()) {
                g(true);
                I0.c("Setting this device as a test device");
                return;
            }
        }
    }

    public final boolean d() {
        return this.f5722a.a("fresh_install", true);
    }

    public final boolean e() {
        return this.f5722a.a("test_device", false);
    }

    public final void f(boolean z7) {
        this.f5724c = z7;
        this.f5722a.f("fresh_install", z7);
    }

    public final void g(boolean z7) {
        this.f5723b = z7;
        this.f5722a.f("test_device", z7);
    }

    public final void h() {
        if (this.f5724c) {
            int i8 = this.f5725d + 1;
            this.f5725d = i8;
            if (i8 >= 5) {
                f(false);
            }
        }
    }
}
