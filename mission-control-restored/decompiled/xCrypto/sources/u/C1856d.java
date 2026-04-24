package u;

/* JADX INFO: renamed from: u.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1856d implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f15059e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f15061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f15062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15063d;

    public C1856d() {
        this(10);
    }

    public void a() {
        int i4 = this.f15063d;
        Object[] objArr = this.f15062c;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        this.f15063d = 0;
        this.f15060a = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1856d clone() {
        try {
            C1856d c1856d = (C1856d) super.clone();
            c1856d.f15061b = (long[]) this.f15061b.clone();
            c1856d.f15062c = (Object[]) this.f15062c.clone();
            return c1856d;
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    public void c(long j4) {
        j(j4);
    }

    public final void d() {
        int i4 = this.f15063d;
        long[] jArr = this.f15061b;
        Object[] objArr = this.f15062c;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (obj != f15059e) {
                if (i6 != i5) {
                    jArr[i5] = jArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.f15060a = false;
        this.f15063d = i5;
    }

    public Object e(long j4) {
        return f(j4, null);
    }

    public Object f(long j4, Object obj) {
        Object obj2;
        int iB = AbstractC1855c.b(this.f15061b, this.f15063d, j4);
        return (iB < 0 || (obj2 = this.f15062c[iB]) == f15059e) ? obj : obj2;
    }

    public int g(long j4) {
        if (this.f15060a) {
            d();
        }
        return AbstractC1855c.b(this.f15061b, this.f15063d, j4);
    }

    public long h(int i4) {
        if (this.f15060a) {
            d();
        }
        return this.f15061b[i4];
    }

    public void i(long j4, Object obj) {
        int iB = AbstractC1855c.b(this.f15061b, this.f15063d, j4);
        if (iB >= 0) {
            this.f15062c[iB] = obj;
            return;
        }
        int i4 = ~iB;
        int i5 = this.f15063d;
        if (i4 < i5) {
            Object[] objArr = this.f15062c;
            if (objArr[i4] == f15059e) {
                this.f15061b[i4] = j4;
                objArr[i4] = obj;
                return;
            }
        }
        if (this.f15060a && i5 >= this.f15061b.length) {
            d();
            i4 = ~AbstractC1855c.b(this.f15061b, this.f15063d, j4);
        }
        int i6 = this.f15063d;
        if (i6 >= this.f15061b.length) {
            int iF = AbstractC1855c.f(i6 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f15061b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f15062c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15061b = jArr;
            this.f15062c = objArr2;
        }
        int i7 = this.f15063d;
        if (i7 - i4 != 0) {
            long[] jArr3 = this.f15061b;
            int i8 = i4 + 1;
            System.arraycopy(jArr3, i4, jArr3, i8, i7 - i4);
            Object[] objArr4 = this.f15062c;
            System.arraycopy(objArr4, i4, objArr4, i8, this.f15063d - i4);
        }
        this.f15061b[i4] = j4;
        this.f15062c[i4] = obj;
        this.f15063d++;
    }

    public void j(long j4) {
        int iB = AbstractC1855c.b(this.f15061b, this.f15063d, j4);
        if (iB >= 0) {
            Object[] objArr = this.f15062c;
            Object obj = objArr[iB];
            Object obj2 = f15059e;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f15060a = true;
            }
        }
    }

    public int k() {
        if (this.f15060a) {
            d();
        }
        return this.f15063d;
    }

    public Object l(int i4) {
        if (this.f15060a) {
            d();
        }
        return this.f15062c[i4];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15063d * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f15063d; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(h(i4));
            sb.append('=');
            Object objL = l(i4);
            if (objL != this) {
                sb.append(objL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C1856d(int i4) {
        this.f15060a = false;
        if (i4 == 0) {
            this.f15061b = AbstractC1855c.f15057b;
            this.f15062c = AbstractC1855c.f15058c;
        } else {
            int iF = AbstractC1855c.f(i4);
            this.f15061b = new long[iF];
            this.f15062c = new Object[iF];
        }
    }
}
