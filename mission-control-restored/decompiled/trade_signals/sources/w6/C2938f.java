package w6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: w6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2938f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.b f24075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24076b;

    public C2938f(q6.b classId, int i8) {
        AbstractC2304t.f(classId, "classId");
        this.f24075a = classId;
        this.f24076b = i8;
    }

    public final q6.b a() {
        return this.f24075a;
    }

    public final int b() {
        return this.f24076b;
    }

    public final int c() {
        return this.f24076b;
    }

    public final q6.b d() {
        return this.f24075a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2938f)) {
            return false;
        }
        C2938f c2938f = (C2938f) obj;
        return AbstractC2304t.b(this.f24075a, c2938f.f24075a) && this.f24076b == c2938f.f24076b;
    }

    public int hashCode() {
        return (this.f24075a.hashCode() * 31) + Integer.hashCode(this.f24076b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i8 = this.f24076b;
        for (int i9 = 0; i9 < i8; i9++) {
            sb.append("kotlin/Array<");
        }
        sb.append(this.f24075a);
        int i10 = this.f24076b;
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append(">");
        }
        return sb.toString();
    }
}
