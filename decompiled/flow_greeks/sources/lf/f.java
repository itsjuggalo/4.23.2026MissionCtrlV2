package lf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.b f15652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15653b;

    public f(ef.b classId, int i10) {
        kotlin.jvm.internal.t.f(classId, "classId");
        this.f15652a = classId;
        this.f15653b = i10;
    }

    public final ef.b a() {
        return this.f15652a;
    }

    public final int b() {
        return this.f15653b;
    }

    public final int c() {
        return this.f15653b;
    }

    public final ef.b d() {
        return this.f15652a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.t.b(this.f15652a, fVar.f15652a) && this.f15653b == fVar.f15653b;
    }

    public int hashCode() {
        return (this.f15652a.hashCode() * 31) + Integer.hashCode(this.f15653b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f15653b;
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("kotlin/Array<");
        }
        sb2.append(this.f15652a);
        int i12 = this.f15653b;
        for (int i13 = 0; i13 < i12; i13++) {
            sb2.append(">");
        }
        return sb2.toString();
    }
}
