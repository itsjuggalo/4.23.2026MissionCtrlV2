package m3;

import p3.C2555i;
import p3.InterfaceC2560n;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2374a f21448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2374a f21449b;

    public k(C2374a c2374a, C2374a c2374a2) {
        this.f21448a = c2374a;
        this.f21449b = c2374a2;
    }

    public InterfaceC2560n a() {
        if (this.f21448a.f()) {
            return this.f21448a.b();
        }
        return null;
    }

    public InterfaceC2560n b() {
        if (this.f21449b.f()) {
            return this.f21449b.b();
        }
        return null;
    }

    public C2374a c() {
        return this.f21448a;
    }

    public C2374a d() {
        return this.f21449b;
    }

    public k e(C2555i c2555i, boolean z7, boolean z8) {
        return new k(new C2374a(c2555i, z7, z8), this.f21449b);
    }

    public k f(C2555i c2555i, boolean z7, boolean z8) {
        return new k(this.f21448a, new C2374a(c2555i, z7, z8));
    }
}
