package u4;

/* JADX INFO: renamed from: u4.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1230l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1229k f10456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f10457b;

    public C1230l(EnumC1229k enumC1229k, j0 j0Var) {
        this.f10456a = enumC1229k;
        s3.D.j(j0Var, "status is null");
        this.f10457b = j0Var;
    }

    public static C1230l a(EnumC1229k enumC1229k) {
        s3.D.f("state is TRANSIENT_ERROR. Use forError() instead", enumC1229k != EnumC1229k.f10451c);
        return new C1230l(enumC1229k, j0.e);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1230l)) {
            return false;
        }
        C1230l c1230l = (C1230l) obj;
        return this.f10456a.equals(c1230l.f10456a) && this.f10457b.equals(c1230l.f10457b);
    }

    public final int hashCode() {
        return this.f10456a.hashCode() ^ this.f10457b.hashCode();
    }

    public final String toString() {
        j0 j0Var = this.f10457b;
        boolean zE = j0Var.e();
        EnumC1229k enumC1229k = this.f10456a;
        if (zE) {
            return enumC1229k.toString();
        }
        return enumC1229k + "(" + j0Var + ")";
    }
}
