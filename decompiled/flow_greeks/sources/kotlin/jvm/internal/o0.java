package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class o0 {
    public wd.d b(Class cls) {
        return new i(cls);
    }

    public wd.g c(Class cls, String str) {
        return new c0(cls, str);
    }

    public String i(o oVar) {
        String string = oVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String j(v vVar) {
        return i(vVar);
    }

    public wd.h a(p pVar) {
        return pVar;
    }

    public wd.j d(x xVar) {
        return xVar;
    }

    public wd.k e(z zVar) {
        return zVar;
    }

    public wd.n f(d0 d0Var) {
        return d0Var;
    }

    public wd.o g(f0 f0Var) {
        return f0Var;
    }

    public wd.p h(h0 h0Var) {
        return h0Var;
    }
}
