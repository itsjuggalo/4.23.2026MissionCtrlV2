package i3;

/* JADX INFO: loaded from: classes.dex */
public final class D {
    public static final C Companion = new C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6829b;

    public /* synthetic */ D(int i, int i6, String str) {
        if (3 != (i & 3)) {
            p5.k.a(i, 3, C0673B.f6827a.d());
            throw null;
        }
        this.f6828a = i6;
        this.f6829b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d4 = (D) obj;
        return this.f6828a == d4.f6828a && kotlin.jvm.internal.j.a(this.f6829b, d4.f6829b);
    }

    public final int hashCode() {
        return this.f6829b.hashCode() + (Integer.hashCode(this.f6828a) * 31);
    }

    public final String toString() {
        return "ProcessData(pid=" + this.f6828a + ", uuid=" + this.f6829b + ')';
    }

    public D(int i, String uuid) {
        kotlin.jvm.internal.j.e(uuid, "uuid");
        this.f6828a = i;
        this.f6829b = uuid;
    }
}
