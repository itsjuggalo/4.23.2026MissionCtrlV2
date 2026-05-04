package xe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24912a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f24913b = new d(of.e.BOOLEAN);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f24914c = new d(of.e.CHAR);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f24915d = new d(of.e.BYTE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f24916e = new d(of.e.SHORT);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f24917f = new d(of.e.INT);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f24918g = new d(of.e.FLOAT);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f24919h = new d(of.e.LONG);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f24920i = new d(of.e.DOUBLE);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends s {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final s f24921j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s elementType) {
            super(null);
            kotlin.jvm.internal.t.f(elementType, "elementType");
            this.f24921j = elementType;
        }

        public final s i() {
            return this.f24921j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final d a() {
            return s.f24913b;
        }

        public final d b() {
            return s.f24915d;
        }

        public final d c() {
            return s.f24914c;
        }

        public final d d() {
            return s.f24920i;
        }

        public final d e() {
            return s.f24918g;
        }

        public final d f() {
            return s.f24917f;
        }

        public final d g() {
            return s.f24919h;
        }

        public final d h() {
            return s.f24916e;
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends s {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f24922j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String internalName) {
            super(null);
            kotlin.jvm.internal.t.f(internalName, "internalName");
            this.f24922j = internalName;
        }

        public final String i() {
            return this.f24922j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends s {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final of.e f24923j;

        public d(of.e eVar) {
            super(null);
            this.f24923j = eVar;
        }

        public final of.e i() {
            return this.f24923j;
        }
    }

    public /* synthetic */ s(kotlin.jvm.internal.k kVar) {
        this();
    }

    public String toString() {
        return u.f24924a.a(this);
    }

    public s() {
    }
}
