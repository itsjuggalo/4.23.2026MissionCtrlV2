package cd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements Comparable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3853e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i f3854f = j.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3858d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public i(int i10, int i11, int i12) {
        this.f3855a = i10;
        this.f3856b = i11;
        this.f3857c = i12;
        this.f3858d = b(i10, i11, i12);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(i other) {
        kotlin.jvm.internal.t.f(other, "other");
        return this.f3858d - other.f3858d;
    }

    public final int b(int i10, int i11, int i12) {
        if (i10 >= 0 && i10 < 256 && i11 >= 0 && i11 < 256 && i12 >= 0 && i12 < 256) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + com.amazon.a.a.o.c.a.b.f4610a + i11 + com.amazon.a.a.o.c.a.b.f4610a + i12).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        i iVar = obj instanceof i ? (i) obj : null;
        return iVar != null && this.f3858d == iVar.f3858d;
    }

    public int hashCode() {
        return this.f3858d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f3855a);
        sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
        sb2.append(this.f3856b);
        sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
        sb2.append(this.f3857c);
        return sb2.toString();
    }

    public i(int i10, int i11) {
        this(i10, i11, 0);
    }
}
