package u;

/* JADX INFO: renamed from: u.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2739d implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f24358e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f24360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f24361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24362d;

    public C2739d() {
        this(10);
    }

    public void a() {
        int i7 = this.f24362d;
        Object[] objArr = this.f24361c;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f24362d = 0;
        this.f24359a = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2739d clone() {
        try {
            C2739d c2739d = (C2739d) super.clone();
            c2739d.f24360b = (long[]) this.f24360b.clone();
            c2739d.f24361c = (Object[]) this.f24361c.clone();
            return c2739d;
        } catch (CloneNotSupportedException e7) {
            throw new AssertionError(e7);
        }
    }

    public final void c() {
        int i7 = this.f24362d;
        long[] jArr = this.f24360b;
        Object[] objArr = this.f24361c;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            Object obj = objArr[i9];
            if (obj != f24358e) {
                if (i9 != i8) {
                    jArr[i8] = jArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        this.f24359a = false;
        this.f24362d = i8;
    }

    public Object d(long j7) {
        return e(j7, null);
    }

    public Object e(long j7, Object obj) {
        Object obj2;
        int iB = AbstractC2738c.b(this.f24360b, this.f24362d, j7);
        return (iB < 0 || (obj2 = this.f24361c[iB]) == f24358e) ? obj : obj2;
    }

    public int f(long j7) {
        if (this.f24359a) {
            c();
        }
        return AbstractC2738c.b(this.f24360b, this.f24362d, j7);
    }

    public long g(int i7) {
        if (this.f24359a) {
            c();
        }
        return this.f24360b[i7];
    }

    public void i(long j7, Object obj) {
        int iB = AbstractC2738c.b(this.f24360b, this.f24362d, j7);
        if (iB >= 0) {
            this.f24361c[iB] = obj;
            return;
        }
        int i7 = ~iB;
        int i8 = this.f24362d;
        if (i7 < i8) {
            Object[] objArr = this.f24361c;
            if (objArr[i7] == f24358e) {
                this.f24360b[i7] = j7;
                objArr[i7] = obj;
                return;
            }
        }
        if (this.f24359a && i8 >= this.f24360b.length) {
            c();
            i7 = ~AbstractC2738c.b(this.f24360b, this.f24362d, j7);
        }
        int i9 = this.f24362d;
        if (i9 >= this.f24360b.length) {
            int iF = AbstractC2738c.f(i9 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f24360b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f24361c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f24360b = jArr;
            this.f24361c = objArr2;
        }
        int i10 = this.f24362d;
        if (i10 - i7 != 0) {
            long[] jArr3 = this.f24360b;
            int i11 = i7 + 1;
            System.arraycopy(jArr3, i7, jArr3, i11, i10 - i7);
            Object[] objArr4 = this.f24361c;
            System.arraycopy(objArr4, i7, objArr4, i11, this.f24362d - i7);
        }
        this.f24360b[i7] = j7;
        this.f24361c[i7] = obj;
        this.f24362d++;
    }

    public void j(long j7) {
        int iB = AbstractC2738c.b(this.f24360b, this.f24362d, j7);
        if (iB >= 0) {
            Object[] objArr = this.f24361c;
            Object obj = objArr[iB];
            Object obj2 = f24358e;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f24359a = true;
            }
        }
    }

    public void k(int i7) {
        Object[] objArr = this.f24361c;
        Object obj = objArr[i7];
        Object obj2 = f24358e;
        if (obj != obj2) {
            objArr[i7] = obj2;
            this.f24359a = true;
        }
    }

    public int l() {
        if (this.f24359a) {
            c();
        }
        return this.f24362d;
    }

    public Object m(int i7) {
        if (this.f24359a) {
            c();
        }
        return this.f24361c[i7];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f24362d * 28);
        sb.append('{');
        for (int i7 = 0; i7 < this.f24362d; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            sb.append(g(i7));
            sb.append('=');
            Object objM = m(i7);
            if (objM != this) {
                sb.append(objM);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C2739d(int i7) {
        this.f24359a = false;
        if (i7 == 0) {
            this.f24360b = AbstractC2738c.f24356b;
            this.f24361c = AbstractC2738c.f24357c;
        } else {
            int iF = AbstractC2738c.f(i7);
            this.f24360b = new long[iF];
            this.f24361c = new Object[iF];
        }
    }
}
