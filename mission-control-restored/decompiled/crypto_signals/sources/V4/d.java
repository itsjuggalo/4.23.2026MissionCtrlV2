package V4;

import java.util.Iterator;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public class d implements Iterable, S4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3300c;

    public d(int i, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3298a = i;
        this.f3299b = u0.u(i, i6, i7);
        this.f3300c = i7;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (isEmpty() && ((d) obj).isEmpty()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f3298a == dVar.f3298a && this.f3299b == dVar.f3299b && this.f3300c == dVar.f3300c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3298a * 31) + this.f3299b) * 31) + this.f3300c;
    }

    public boolean isEmpty() {
        int i = this.f3300c;
        int i6 = this.f3299b;
        int i7 = this.f3298a;
        return i > 0 ? i7 > i6 : i7 < i6;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this.f3298a, this.f3299b, this.f3300c);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.f3299b;
        int i6 = this.f3298a;
        int i7 = this.f3300c;
        if (i7 > 0) {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i7);
        } else {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i7);
        }
        return sb.toString();
    }
}
