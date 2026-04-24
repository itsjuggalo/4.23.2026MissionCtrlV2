package o5;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2481i implements Comparable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f21966e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2481i f21967f = C2482j.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21971d;

    /* JADX INFO: renamed from: o5.i$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C2481i(int i8, int i9) {
        this(i8, i9, 0);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C2481i other) {
        AbstractC2304t.f(other, "other");
        return this.f21971d - other.f21971d;
    }

    public final int b(int i8, int i9, int i10) {
        if (i8 >= 0 && i8 < 256 && i9 >= 0 && i9 < 256 && i10 >= 0 && i10 < 256) {
            return (i8 << 16) + (i9 << 8) + i10;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i8 + com.amazon.a.a.o.c.a.b.f14112a + i9 + com.amazon.a.a.o.c.a.b.f14112a + i10).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        C2481i c2481i = obj instanceof C2481i ? (C2481i) obj : null;
        return c2481i != null && this.f21971d == c2481i.f21971d;
    }

    public int hashCode() {
        return this.f21971d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f21968a);
        sb.append(com.amazon.a.a.o.c.a.b.f14112a);
        sb.append(this.f21969b);
        sb.append(com.amazon.a.a.o.c.a.b.f14112a);
        sb.append(this.f21970c);
        return sb.toString();
    }

    public C2481i(int i8, int i9, int i10) {
        this.f21968a = i8;
        this.f21969b = i9;
        this.f21970c = i10;
        this.f21971d = b(i8, i9, i10);
    }
}
