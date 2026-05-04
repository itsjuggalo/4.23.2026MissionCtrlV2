package we;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f23975e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f23976f = new h(null, null, false, false, 8, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f23977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f23978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f23979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23980d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final h a() {
            return h.f23976f;
        }

        public a() {
        }
    }

    public h(k kVar, i iVar, boolean z10, boolean z11) {
        this.f23977a = kVar;
        this.f23978b = iVar;
        this.f23979c = z10;
        this.f23980d = z11;
    }

    public static /* synthetic */ h c(h hVar, k kVar, i iVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = hVar.f23977a;
        }
        if ((i10 & 2) != 0) {
            iVar = hVar.f23978b;
        }
        if ((i10 & 4) != 0) {
            z10 = hVar.f23979c;
        }
        if ((i10 & 8) != 0) {
            z11 = hVar.f23980d;
        }
        return hVar.b(kVar, iVar, z10, z11);
    }

    public final h b(k kVar, i iVar, boolean z10, boolean z11) {
        return new h(kVar, iVar, z10, z11);
    }

    public final boolean d() {
        return this.f23979c;
    }

    public final i e() {
        return this.f23978b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f23977a == hVar.f23977a && this.f23978b == hVar.f23978b && this.f23979c == hVar.f23979c && this.f23980d == hVar.f23980d;
    }

    public final k f() {
        return this.f23977a;
    }

    public final boolean g() {
        return this.f23980d;
    }

    public int hashCode() {
        k kVar = this.f23977a;
        int iHashCode = (kVar == null ? 0 : kVar.hashCode()) * 31;
        i iVar = this.f23978b;
        return ((((iHashCode + (iVar != null ? iVar.hashCode() : 0)) * 31) + Boolean.hashCode(this.f23979c)) * 31) + Boolean.hashCode(this.f23980d);
    }

    public String toString() {
        return "JavaTypeQualifiers(nullability=" + this.f23977a + ", mutability=" + this.f23978b + ", definitelyNotNull=" + this.f23979c + ", isNullabilityQualifierForWarning=" + this.f23980d + ')';
    }

    public /* synthetic */ h(k kVar, i iVar, boolean z10, boolean z11, int i10, kotlin.jvm.internal.k kVar2) {
        this(kVar, iVar, z10, (i10 & 8) != 0 ? false : z11);
    }
}
