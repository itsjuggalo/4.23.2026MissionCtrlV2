package r1;

import o1.AbstractC2292d;
import o1.C2291c;
import o1.InterfaceC2296h;
import o1.InterfaceC2297i;
import o1.InterfaceC2299k;

/* JADX INFO: loaded from: classes.dex */
public final class s implements InterfaceC2297i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f22436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2291c f22438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2296h f22439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f22440e;

    public s(p pVar, String str, C2291c c2291c, InterfaceC2296h interfaceC2296h, t tVar) {
        this.f22436a = pVar;
        this.f22437b = str;
        this.f22438c = c2291c;
        this.f22439d = interfaceC2296h;
        this.f22440e = tVar;
    }

    @Override // o1.InterfaceC2297i
    public void a(AbstractC2292d abstractC2292d) {
        b(abstractC2292d, new InterfaceC2299k() { // from class: r1.r
            @Override // o1.InterfaceC2299k
            public final void a(Exception exc) {
                s.e(exc);
            }
        });
    }

    @Override // o1.InterfaceC2297i
    public void b(AbstractC2292d abstractC2292d, InterfaceC2299k interfaceC2299k) {
        this.f22440e.a(o.a().e(this.f22436a).c(abstractC2292d).f(this.f22437b).d(this.f22439d).b(this.f22438c).a(), interfaceC2299k);
    }

    public p d() {
        return this.f22436a;
    }

    public static /* synthetic */ void e(Exception exc) {
    }
}
