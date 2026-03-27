package E6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: E6.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0485y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q6.b f1050f;

    public C0485y(Object obj, Object obj2, Object obj3, Object obj4, String filePath, q6.b classId) {
        AbstractC2304t.f(filePath, "filePath");
        AbstractC2304t.f(classId, "classId");
        this.f1045a = obj;
        this.f1046b = obj2;
        this.f1047c = obj3;
        this.f1048d = obj4;
        this.f1049e = filePath;
        this.f1050f = classId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0485y)) {
            return false;
        }
        C0485y c0485y = (C0485y) obj;
        return AbstractC2304t.b(this.f1045a, c0485y.f1045a) && AbstractC2304t.b(this.f1046b, c0485y.f1046b) && AbstractC2304t.b(this.f1047c, c0485y.f1047c) && AbstractC2304t.b(this.f1048d, c0485y.f1048d) && AbstractC2304t.b(this.f1049e, c0485y.f1049e) && AbstractC2304t.b(this.f1050f, c0485y.f1050f);
    }

    public int hashCode() {
        Object obj = this.f1045a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f1046b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f1047c;
        int iHashCode3 = (iHashCode2 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.f1048d;
        return ((((iHashCode3 + (obj4 != null ? obj4.hashCode() : 0)) * 31) + this.f1049e.hashCode()) * 31) + this.f1050f.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f1045a + ", compilerVersion=" + this.f1046b + ", languageVersion=" + this.f1047c + ", expectedVersion=" + this.f1048d + ", filePath=" + this.f1049e + ", classId=" + this.f1050f + ')';
    }
}
