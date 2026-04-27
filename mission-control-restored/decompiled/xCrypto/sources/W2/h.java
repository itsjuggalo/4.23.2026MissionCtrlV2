package W2;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Comparable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5472e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f5473f = i.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5477d;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public h(int i4, int i5, int i6) {
        this.f5474a = i4;
        this.f5475b = i5;
        this.f5476c = i6;
        this.f5477d = c(i4, i5, i6);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h other) {
        kotlin.jvm.internal.r.f(other, "other");
        return this.f5477d - other.f5477d;
    }

    public final int c(int i4, int i5, int i6) {
        if (i4 >= 0 && i4 < 256 && i5 >= 0 && i5 < 256 && i6 >= 0 && i6 < 256) {
            return (i4 << 16) + (i5 << 8) + i6;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i4 + com.amazon.a.a.o.c.a.b.f8816a + i5 + com.amazon.a.a.o.c.a.b.f8816a + i6).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        h hVar = obj instanceof h ? (h) obj : null;
        return hVar != null && this.f5477d == hVar.f5477d;
    }

    public int hashCode() {
        return this.f5477d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5474a);
        sb.append(com.amazon.a.a.o.c.a.b.f8816a);
        sb.append(this.f5475b);
        sb.append(com.amazon.a.a.o.c.a.b.f8816a);
        sb.append(this.f5476c);
        return sb.toString();
    }
}
