package E5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Comparable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f1666e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f1667f = i.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1671d;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public h(int i7, int i8, int i9) {
        this.f1668a = i7;
        this.f1669b = i8;
        this.f1670c = i9;
        this.f1671d = b(i7, i8, i9);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h other) {
        kotlin.jvm.internal.r.f(other, "other");
        return this.f1671d - other.f1671d;
    }

    public final int b(int i7, int i8, int i9) {
        if (i7 >= 0 && i7 < 256 && i8 >= 0 && i8 < 256 && i9 >= 0 && i9 < 256) {
            return (i7 << 16) + (i8 << 8) + i9;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i7 + com.amazon.a.a.o.c.a.b.f10001a + i8 + com.amazon.a.a.o.c.a.b.f10001a + i9).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        h hVar = obj instanceof h ? (h) obj : null;
        return hVar != null && this.f1671d == hVar.f1671d;
    }

    public int hashCode() {
        return this.f1671d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1668a);
        sb.append(com.amazon.a.a.o.c.a.b.f10001a);
        sb.append(this.f1669b);
        sb.append(com.amazon.a.a.o.c.a.b.f10001a);
        sb.append(this.f1670c);
        return sb.toString();
    }
}
