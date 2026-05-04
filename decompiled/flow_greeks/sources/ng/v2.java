package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2 f17190a = new v2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f17191b = sg.l0.a(new sg.d0("ThreadLocalEventLoop"));

    public final i1 a() {
        return (i1) f17191b.get();
    }

    public final i1 b() {
        ThreadLocal threadLocal = f17191b;
        i1 i1Var = (i1) threadLocal.get();
        if (i1Var != null) {
            return i1Var;
        }
        i1 i1VarA = l1.a();
        threadLocal.set(i1VarA);
        return i1VarA;
    }

    public final void c() {
        f17191b.set(null);
    }

    public final void d(i1 i1Var) {
        f17191b.set(i1Var);
    }
}
