package t3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class F0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y3.F f14934a = new y3.F("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y3.F f14935b = new y3.F("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y3.F f14936c = new y3.F("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y3.F f14937d = new y3.F("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y3.F f14938e = new y3.F("SEALED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1813f0 f14939f = new C1813f0(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1813f0 f14940g = new C1813f0(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC1836r0 ? new C1838s0((InterfaceC1836r0) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC1836r0 interfaceC1836r0;
        C1838s0 c1838s0 = obj instanceof C1838s0 ? (C1838s0) obj : null;
        return (c1838s0 == null || (interfaceC1836r0 = c1838s0.f15032a) == null) ? obj : interfaceC1836r0;
    }
}
