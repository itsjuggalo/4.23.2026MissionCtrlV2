package H5;

import kotlin.jvm.internal.AbstractC2296k;
import p5.I;
import w5.AbstractC2927c;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Iterable, C5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3954d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3957c;

    public static final class a {
        public a() {
        }

        public final b a(int i8, int i9, int i10) {
            return new b(i8, i9, i10);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public b(int i8, int i9, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3955a = i8;
        this.f3956b = AbstractC2927c.c(i8, i9, i10);
        this.f3957c = i10;
    }

    public final int e() {
        return this.f3955a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.f3955a != bVar.f3955a || this.f3956b != bVar.f3956b || this.f3957c != bVar.f3957c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f3956b;
    }

    public final int h() {
        return this.f3957c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3955a * 31) + this.f3956b) * 31) + this.f3957c;
    }

    public boolean isEmpty() {
        if (this.f3957c > 0) {
            if (this.f3955a <= this.f3956b) {
                return false;
            }
        } else if (this.f3955a >= this.f3956b) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public I iterator() {
        return new c(this.f3955a, this.f3956b, this.f3957c);
    }

    public String toString() {
        StringBuilder sb;
        int i8;
        if (this.f3957c > 0) {
            sb = new StringBuilder();
            sb.append(this.f3955a);
            sb.append("..");
            sb.append(this.f3956b);
            sb.append(" step ");
            i8 = this.f3957c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f3955a);
            sb.append(" downTo ");
            sb.append(this.f3956b);
            sb.append(" step ");
            i8 = -this.f3957c;
        }
        sb.append(i8);
        return sb.toString();
    }
}
