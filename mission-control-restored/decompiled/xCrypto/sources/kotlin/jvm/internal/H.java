package kotlin.jvm.internal;

import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public class H {
    public InterfaceC1716c b(Class cls) {
        return new C1583h(cls);
    }

    public p3.e c(Class cls, String str) {
        return new x(cls, str);
    }

    public String g(m mVar) {
        String string = mVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String h(s sVar) {
        return g(sVar);
    }

    public p3.f a(n nVar) {
        return nVar;
    }

    public p3.g d(u uVar) {
        return uVar;
    }

    public p3.i e(y yVar) {
        return yVar;
    }

    public p3.j f(A a4) {
        return a4;
    }
}
