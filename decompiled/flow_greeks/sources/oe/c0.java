package oe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f17953d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f17954e = new c0(o0.f18048e, null, null, 6, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f17955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cd.i f17956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o0 f17957c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final c0 a() {
            return c0.f17954e;
        }

        public a() {
        }
    }

    public c0(o0 reportLevelBefore, cd.i iVar, o0 reportLevelAfter) {
        kotlin.jvm.internal.t.f(reportLevelBefore, "reportLevelBefore");
        kotlin.jvm.internal.t.f(reportLevelAfter, "reportLevelAfter");
        this.f17955a = reportLevelBefore;
        this.f17956b = iVar;
        this.f17957c = reportLevelAfter;
    }

    public final o0 b() {
        return this.f17957c;
    }

    public final o0 c() {
        return this.f17955a;
    }

    public final cd.i d() {
        return this.f17956b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f17955a == c0Var.f17955a && kotlin.jvm.internal.t.b(this.f17956b, c0Var.f17956b) && this.f17957c == c0Var.f17957c;
    }

    public int hashCode() {
        int iHashCode = this.f17955a.hashCode() * 31;
        cd.i iVar = this.f17956b;
        return ((iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31) + this.f17957c.hashCode();
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f17955a + ", sinceVersion=" + this.f17956b + ", reportLevelAfter=" + this.f17957c + ')';
    }

    public /* synthetic */ c0(o0 o0Var, cd.i iVar, o0 o0Var2, int i10, kotlin.jvm.internal.k kVar) {
        this(o0Var, (i10 & 2) != 0 ? new cd.i(1, 0) : iVar, (i10 & 4) != 0 ? o0Var : o0Var2);
    }
}
