package Y6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d7.D f9614a = new d7.D("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d7.D f9615b = new d7.D("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d7.D f9616c = new d7.D("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d7.D f9617d = new d7.D("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d7.D f9618e = new d7.D("SEALED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1000d0 f9619f = new C1000d0(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1000d0 f9620g = new C1000d0(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC1026q0 ? new C1027r0((InterfaceC1026q0) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC1026q0 interfaceC1026q0;
        C1027r0 c1027r0 = obj instanceof C1027r0 ? (C1027r0) obj : null;
        return (c1027r0 == null || (interfaceC1026q0 = c1027r0.f9689a) == null) ? obj : interfaceC1026q0;
    }
}
