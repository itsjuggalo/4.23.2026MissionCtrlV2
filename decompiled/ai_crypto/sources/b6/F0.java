package b6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class F0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g6.F f8992a = new g6.F("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g6.F f8993b = new g6.F("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g6.F f8994c = new g6.F("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g6.F f8995d = new g6.F("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g6.F f8996e = new g6.F("SEALED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1068f0 f8997f = new C1068f0(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1068f0 f8998g = new C1068f0(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC1091r0 ? new C1093s0((InterfaceC1091r0) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC1091r0 interfaceC1091r0;
        C1093s0 c1093s0 = obj instanceof C1093s0 ? (C1093s0) obj : null;
        return (c1093s0 == null || (interfaceC1091r0 = c1093s0.f9090a) == null) ? obj : interfaceC1091r0;
    }
}
