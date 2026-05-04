package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sg.d0 f17124a = new sg.d0("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final sg.d0 f17125b = new sg.d0("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final sg.d0 f17126c = new sg.d0("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final sg.d0 f17127d = new sg.d0("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final sg.d0 f17128e = new sg.d0("SEALED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h1 f17129f = new h1(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h1 f17130g = new h1(true);

    public static final Object g(Object obj) {
        return obj instanceof u1 ? new v1((u1) obj) : obj;
    }

    public static final Object h(Object obj) {
        u1 u1Var;
        v1 v1Var = obj instanceof v1 ? (v1) obj : null;
        return (v1Var == null || (u1Var = v1Var.f17189a) == null) ? obj : u1Var;
    }
}
