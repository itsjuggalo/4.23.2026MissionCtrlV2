package wd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f23907c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f23908d = new s(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f23909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f23910b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final s a(q type) {
            kotlin.jvm.internal.t.f(type, "type");
            return new s(t.f23913b, type);
        }

        public final s b(q type) {
            kotlin.jvm.internal.t.f(type, "type");
            return new s(t.f23914c, type);
        }

        public final s c() {
            return s.f23908d;
        }

        public final s d(q type) {
            kotlin.jvm.internal.t.f(type, "type");
            return new s(t.f23912a, type);
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23911a;

        static {
            int[] iArr = new int[t.values().length];
            try {
                iArr[t.f23912a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[t.f23913b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[t.f23914c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f23911a = iArr;
        }
    }

    public s(t tVar, q qVar) {
        String str;
        this.f23909a = tVar;
        this.f23910b = qVar;
        if ((tVar == null) == (qVar == null)) {
            return;
        }
        if (tVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + tVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final t a() {
        return this.f23909a;
    }

    public final q b() {
        return this.f23910b;
    }

    public final q c() {
        return this.f23910b;
    }

    public final t d() {
        return this.f23909a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f23909a == sVar.f23909a && kotlin.jvm.internal.t.b(this.f23910b, sVar.f23910b);
    }

    public int hashCode() {
        t tVar = this.f23909a;
        int iHashCode = (tVar == null ? 0 : tVar.hashCode()) * 31;
        q qVar = this.f23910b;
        return iHashCode + (qVar != null ? qVar.hashCode() : 0);
    }

    public String toString() {
        t tVar = this.f23909a;
        int i10 = tVar == null ? -1 : b.f23911a[tVar.ordinal()];
        if (i10 == -1) {
            return "*";
        }
        if (i10 == 1) {
            return String.valueOf(this.f23910b);
        }
        if (i10 == 2) {
            return "in " + this.f23910b;
        }
        if (i10 != 3) {
            throw new cd.o();
        }
        return "out " + this.f23910b;
    }
}
