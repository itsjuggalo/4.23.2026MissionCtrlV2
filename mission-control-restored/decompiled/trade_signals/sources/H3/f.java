package H3;

import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class f implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f3679a;

    public f(InterfaceC2426a interfaceC2426a) {
        this.f3679a = interfaceC2426a;
    }

    public static f a(InterfaceC2426a interfaceC2426a) {
        return new f(interfaceC2426a);
    }

    public static e c(com.bumptech.glide.k kVar) {
        return new e(kVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c((com.bumptech.glide.k) this.f3679a.get());
    }
}
