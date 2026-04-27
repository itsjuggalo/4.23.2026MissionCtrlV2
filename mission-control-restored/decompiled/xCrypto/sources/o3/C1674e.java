package o3;

import X2.G;
import j3.InterfaceC1564a;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: o3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1674e implements Iterable, InterfaceC1564a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13934d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13937c;

    /* JADX INFO: renamed from: o3.e$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final C1674e a(int i4, int i5, int i6) {
            return new C1674e(i4, i5, i6);
        }

        public a() {
        }
    }

    public C1674e(int i4, int i5, int i6) {
        if (i6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i6 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f13935a = i4;
        this.f13936b = d3.c.c(i4, i5, i6);
        this.f13937c = i6;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1674e)) {
            return false;
        }
        if (isEmpty() && ((C1674e) obj).isEmpty()) {
            return true;
        }
        C1674e c1674e = (C1674e) obj;
        return this.f13935a == c1674e.f13935a && this.f13936b == c1674e.f13936b && this.f13937c == c1674e.f13937c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f13935a * 31) + this.f13936b) * 31) + this.f13937c;
    }

    public boolean isEmpty() {
        return this.f13937c > 0 ? this.f13935a > this.f13936b : this.f13935a < this.f13936b;
    }

    public final int k() {
        return this.f13935a;
    }

    public final int l() {
        return this.f13936b;
    }

    public final int m() {
        return this.f13937c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public G iterator() {
        return new C1675f(this.f13935a, this.f13936b, this.f13937c);
    }

    public String toString() {
        StringBuilder sb;
        int i4;
        if (this.f13937c > 0) {
            sb = new StringBuilder();
            sb.append(this.f13935a);
            sb.append("..");
            sb.append(this.f13936b);
            sb.append(" step ");
            i4 = this.f13937c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f13935a);
            sb.append(" downTo ");
            sb.append(this.f13936b);
            sb.append(" step ");
            i4 = -this.f13937c;
        }
        sb.append(i4);
        return sb.toString();
    }
}
