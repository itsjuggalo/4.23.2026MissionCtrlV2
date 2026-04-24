package kotlin.jvm.internal;

import L5.b1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P f20470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final I5.d[] f20471b;

    static {
        P p8 = null;
        try {
            p8 = (P) b1.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (p8 == null) {
            p8 = new P();
        }
        f20470a = p8;
        f20471b = new I5.d[0];
    }

    public static I5.h a(AbstractC2301p abstractC2301p) {
        return f20470a.a(abstractC2301p);
    }

    public static I5.d b(Class cls) {
        return f20470a.b(cls);
    }

    public static I5.g c(Class cls) {
        return f20470a.c(cls, "");
    }

    public static I5.j d(x xVar) {
        return f20470a.d(xVar);
    }

    public static I5.k e(z zVar) {
        return f20470a.e(zVar);
    }

    public static I5.n f(D d8) {
        return f20470a.f(d8);
    }

    public static I5.o g(F f8) {
        return f20470a.g(f8);
    }

    public static I5.p h(H h8) {
        return f20470a.h(h8);
    }

    public static String i(InterfaceC2300o interfaceC2300o) {
        return f20470a.i(interfaceC2300o);
    }

    public static String j(AbstractC2306v abstractC2306v) {
        return f20470a.j(abstractC2306v);
    }
}
