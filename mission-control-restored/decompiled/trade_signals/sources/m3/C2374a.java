package m3;

import h3.C1875k;
import p3.C2548b;
import p3.C2555i;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: m3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2374a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2555i f21398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f21400c;

    public C2374a(C2555i c2555i, boolean z7, boolean z8) {
        this.f21398a = c2555i;
        this.f21399b = z7;
        this.f21400c = z8;
    }

    public C2555i a() {
        return this.f21398a;
    }

    public InterfaceC2560n b() {
        return this.f21398a.n();
    }

    public boolean c(C2548b c2548b) {
        return (f() && !this.f21400c) || this.f21398a.n().u(c2548b);
    }

    public boolean d(C1875k c1875k) {
        return c1875k.isEmpty() ? f() && !this.f21400c : c(c1875k.P());
    }

    public boolean e() {
        return this.f21400c;
    }

    public boolean f() {
        return this.f21399b;
    }
}
