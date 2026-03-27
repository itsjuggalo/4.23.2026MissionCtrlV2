package K2;

/* JADX INFO: renamed from: K2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0059j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f939d;

    public C0059j(c0 c0Var, int i, int i6, int i7) {
        this.f936a = i;
        this.f937b = c0Var;
        this.f938c = i6;
        this.f939d = i7;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0059j)) {
            return false;
        }
        C0059j c0059j = (C0059j) obj;
        return S.i.b(this.f936a, c0059j.f936a) && this.f937b.equals(c0059j.f937b) && this.f938c == c0059j.f938c && this.f939d == c0059j.f939d;
    }

    public final int hashCode() {
        return ((((this.f937b.hashCode() + (S.i.c(this.f936a) * 31)) * 31) + this.f938c) * 31) + this.f939d;
    }
}
