package oe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f17958d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d0 f17959e = new d0(b0.b(null, 1, null), a.f17963a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f17960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f17961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17962c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17963a = new a();

        public a() {
            super(1, b0.class, "getDefaultReportLevelForAnnotation", "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;", 1);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final o0 invoke(ef.c p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return b0.d(p02);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final d0 a() {
            return d0.f17959e;
        }

        public b() {
        }
    }

    public d0(g0 jsr305, pd.k getReportLevelForAnnotation) {
        kotlin.jvm.internal.t.f(jsr305, "jsr305");
        kotlin.jvm.internal.t.f(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.f17960a = jsr305;
        this.f17961b = getReportLevelForAnnotation;
        this.f17962c = jsr305.f() || getReportLevelForAnnotation.invoke(b0.e()) == o0.f18046c;
    }

    public final boolean b() {
        return this.f17962c;
    }

    public final pd.k c() {
        return this.f17961b;
    }

    public final g0 d() {
        return this.f17960a;
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f17960a + ", getReportLevelForAnnotation=" + this.f17961b + ')';
    }
}
