package tf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f22077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f22078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f22079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ef.b f22081f;

    public y(Object obj, Object obj2, Object obj3, Object obj4, String filePath, ef.b classId) {
        kotlin.jvm.internal.t.f(filePath, "filePath");
        kotlin.jvm.internal.t.f(classId, "classId");
        this.f22076a = obj;
        this.f22077b = obj2;
        this.f22078c = obj3;
        this.f22079d = obj4;
        this.f22080e = filePath;
        this.f22081f = classId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return kotlin.jvm.internal.t.b(this.f22076a, yVar.f22076a) && kotlin.jvm.internal.t.b(this.f22077b, yVar.f22077b) && kotlin.jvm.internal.t.b(this.f22078c, yVar.f22078c) && kotlin.jvm.internal.t.b(this.f22079d, yVar.f22079d) && kotlin.jvm.internal.t.b(this.f22080e, yVar.f22080e) && kotlin.jvm.internal.t.b(this.f22081f, yVar.f22081f);
    }

    public int hashCode() {
        Object obj = this.f22076a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f22077b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f22078c;
        int iHashCode3 = (iHashCode2 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.f22079d;
        return ((((iHashCode3 + (obj4 != null ? obj4.hashCode() : 0)) * 31) + this.f22080e.hashCode()) * 31) + this.f22081f.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f22076a + ", compilerVersion=" + this.f22077b + ", languageVersion=" + this.f22078c + ", expectedVersion=" + this.f22079d + ", filePath=" + this.f22080e + ", classId=" + this.f22081f + ')';
    }
}
