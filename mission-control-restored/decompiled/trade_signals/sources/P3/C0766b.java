package P3;

import N3.C0710c;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0766b implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0765a f6393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6394b;

    public C0766b(C0765a c0765a, InterfaceC2426a interfaceC2426a) {
        this.f6393a = c0765a;
        this.f6394b = interfaceC2426a;
    }

    public static C0766b a(C0765a c0765a, InterfaceC2426a interfaceC2426a) {
        return new C0766b(c0765a, interfaceC2426a);
    }

    public static U4.a c(C0765a c0765a, C0710c c0710c) {
        return (U4.a) E3.d.e(c0765a.a(c0710c));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public U4.a get() {
        return c(this.f6393a, (C0710c) this.f6394b.get());
    }
}
