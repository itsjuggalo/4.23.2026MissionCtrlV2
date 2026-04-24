package Z3;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5971d;

    public s(String processName, int i7, int i8, boolean z7) {
        kotlin.jvm.internal.r.f(processName, "processName");
        this.f5968a = processName;
        this.f5969b = i7;
        this.f5970c = i8;
        this.f5971d = z7;
    }

    public final int a() {
        return this.f5970c;
    }

    public final int b() {
        return this.f5969b;
    }

    public final String c() {
        return this.f5968a;
    }

    public final boolean d() {
        return this.f5971d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.r.b(this.f5968a, sVar.f5968a) && this.f5969b == sVar.f5969b && this.f5970c == sVar.f5970c && this.f5971d == sVar.f5971d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.f5968a.hashCode() * 31) + Integer.hashCode(this.f5969b)) * 31) + Integer.hashCode(this.f5970c)) * 31;
        boolean z7 = this.f5971d;
        ?? r12 = z7;
        if (z7) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.f5968a + ", pid=" + this.f5969b + ", importance=" + this.f5970c + ", isDefaultProcess=" + this.f5971d + ')';
    }
}
