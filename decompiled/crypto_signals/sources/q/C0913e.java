package q;

/* JADX INFO: renamed from: q.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0913e implements Cloneable {
    public static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9118a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f9119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f9120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9121d;

    public C0913e() {
        int i;
        int i6 = 4;
        while (true) {
            i = 80;
            if (i6 >= 32) {
                break;
            }
            int i7 = (1 << i6) - 12;
            if (80 <= i7) {
                i = i7;
                break;
            }
            i6++;
        }
        int i8 = i / 8;
        this.f9119b = new long[i8];
        this.f9120c = new Object[i8];
    }

    public final void a() {
        int i = this.f9121d;
        long[] jArr = this.f9119b;
        Object[] objArr = this.f9120c;
        int i6 = 0;
        for (int i7 = 0; i7 < i; i7++) {
            Object obj = objArr[i7];
            if (obj != e) {
                if (i7 != i6) {
                    jArr[i6] = jArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        this.f9118a = false;
        this.f9121d = i6;
    }

    public final void b(Object obj, long j4) {
        int iB = AbstractC0912d.b(this.f9119b, this.f9121d, j4);
        if (iB >= 0) {
            this.f9120c[iB] = obj;
            return;
        }
        int i = ~iB;
        int i6 = this.f9121d;
        if (i < i6) {
            Object[] objArr = this.f9120c;
            if (objArr[i] == e) {
                this.f9119b[i] = j4;
                objArr[i] = obj;
                return;
            }
        }
        if (this.f9118a && i6 >= this.f9119b.length) {
            a();
            i = ~AbstractC0912d.b(this.f9119b, this.f9121d, j4);
        }
        int i7 = this.f9121d;
        if (i7 >= this.f9119b.length) {
            int i8 = (i7 + 1) * 8;
            int i9 = 4;
            while (true) {
                if (i9 >= 32) {
                    break;
                }
                int i10 = (1 << i9) - 12;
                if (i8 <= i10) {
                    i8 = i10;
                    break;
                }
                i9++;
            }
            int i11 = i8 / 8;
            long[] jArr = new long[i11];
            Object[] objArr2 = new Object[i11];
            long[] jArr2 = this.f9119b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f9120c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f9119b = jArr;
            this.f9120c = objArr2;
        }
        int i12 = this.f9121d - i;
        if (i12 != 0) {
            long[] jArr3 = this.f9119b;
            int i13 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i13, i12);
            Object[] objArr4 = this.f9120c;
            System.arraycopy(objArr4, i, objArr4, i13, this.f9121d - i);
        }
        this.f9119b[i] = j4;
        this.f9120c[i] = obj;
        this.f9121d++;
    }

    public final Object clone() {
        try {
            C0913e c0913e = (C0913e) super.clone();
            c0913e.f9119b = (long[]) this.f9119b.clone();
            c0913e.f9120c = (Object[]) this.f9120c.clone();
            return c0913e;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String toString() {
        if (this.f9118a) {
            a();
        }
        if (this.f9121d <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f9121d * 28);
        sb.append('{');
        for (int i = 0; i < this.f9121d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.f9118a) {
                a();
            }
            sb.append(this.f9119b[i]);
            sb.append('=');
            if (this.f9118a) {
                a();
            }
            Object obj = this.f9120c[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
