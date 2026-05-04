package we;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f23999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24000b;

    public l(k qualifier, boolean z10) {
        kotlin.jvm.internal.t.f(qualifier, "qualifier");
        this.f23999a = qualifier;
        this.f24000b = z10;
    }

    public static /* synthetic */ l b(l lVar, k kVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = lVar.f23999a;
        }
        if ((i10 & 2) != 0) {
            z10 = lVar.f24000b;
        }
        return lVar.a(kVar, z10);
    }

    public final l a(k qualifier, boolean z10) {
        kotlin.jvm.internal.t.f(qualifier, "qualifier");
        return new l(qualifier, z10);
    }

    public final k c() {
        return this.f23999a;
    }

    public final boolean d() {
        return this.f24000b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f23999a == lVar.f23999a && this.f24000b == lVar.f24000b;
    }

    public int hashCode() {
        return (this.f23999a.hashCode() * 31) + Boolean.hashCode(this.f24000b);
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f23999a + ", isForWarningOnly=" + this.f24000b + ')';
    }

    public /* synthetic */ l(k kVar, boolean z10, int i10, kotlin.jvm.internal.k kVar2) {
        this(kVar, (i10 & 2) != 0 ? false : z10);
    }
}
