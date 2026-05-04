package vd;

import dd.j0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Iterable, qd.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f23386d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23389c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final e a(int i10, int i11, int i12) {
            return new e(i10, i11, i12);
        }

        public a() {
        }
    }

    public e(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f23387a = i10;
        this.f23388b = kd.c.c(i10, i11, i12);
        this.f23389c = i12;
    }

    public final int e() {
        return this.f23387a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (isEmpty() && ((e) obj).isEmpty()) {
            return true;
        }
        e eVar = (e) obj;
        return this.f23387a == eVar.f23387a && this.f23388b == eVar.f23388b && this.f23389c == eVar.f23389c;
    }

    public final int f() {
        return this.f23388b;
    }

    public final int g() {
        return this.f23389c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f23387a * 31) + this.f23388b) * 31) + this.f23389c;
    }

    public boolean isEmpty() {
        return this.f23389c > 0 ? this.f23387a > this.f23388b : this.f23387a < this.f23388b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public j0 iterator() {
        return new f(this.f23387a, this.f23388b, this.f23389c);
    }

    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f23389c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f23387a);
            sb2.append("..");
            sb2.append(this.f23388b);
            sb2.append(" step ");
            i10 = this.f23389c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f23387a);
            sb2.append(" downTo ");
            sb2.append(this.f23388b);
            sb2.append(" step ");
            i10 = -this.f23389c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
