package z1;

import w1.AbstractC2901d;
import w1.C2900c;
import w1.InterfaceC2905h;
import w1.InterfaceC2906i;
import w1.InterfaceC2908k;

/* JADX INFO: loaded from: classes.dex */
public final class s implements InterfaceC2906i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f24717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2900c f24719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2905h f24720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f24721e;

    public s(p pVar, String str, C2900c c2900c, InterfaceC2905h interfaceC2905h, t tVar) {
        this.f24717a = pVar;
        this.f24718b = str;
        this.f24719c = c2900c;
        this.f24720d = interfaceC2905h;
        this.f24721e = tVar;
    }

    @Override // w1.InterfaceC2906i
    public void a(AbstractC2901d abstractC2901d, InterfaceC2908k interfaceC2908k) {
        this.f24721e.a(o.a().e(this.f24717a).c(abstractC2901d).f(this.f24718b).d(this.f24720d).b(this.f24719c).a(), interfaceC2908k);
    }

    @Override // w1.InterfaceC2906i
    public void b(AbstractC2901d abstractC2901d) {
        a(abstractC2901d, new InterfaceC2908k() { // from class: z1.r
            @Override // w1.InterfaceC2908k
            public final void a(Exception exc) {
                s.e(exc);
            }
        });
    }

    public p d() {
        return this.f24717a;
    }

    public static /* synthetic */ void e(Exception exc) {
    }
}
