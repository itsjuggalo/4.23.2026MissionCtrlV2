package u;

/* JADX INFO: renamed from: u.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1860h implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f15086e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f15088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f15089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15090d;

    public C1860h() {
        this(10);
    }

    public void a(int i4, Object obj) {
        int i5 = this.f15090d;
        if (i5 != 0 && i4 <= this.f15088b[i5 - 1]) {
            h(i4, obj);
            return;
        }
        if (this.f15087a && i5 >= this.f15088b.length) {
            d();
        }
        int i6 = this.f15090d;
        if (i6 >= this.f15088b.length) {
            int iE = AbstractC1855c.e(i6 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f15088b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f15089c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f15088b = iArr;
            this.f15089c = objArr;
        }
        this.f15088b[i6] = i4;
        this.f15089c[i6] = obj;
        this.f15090d = i6 + 1;
    }

    public void b() {
        int i4 = this.f15090d;
        Object[] objArr = this.f15089c;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        this.f15090d = 0;
        this.f15087a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public C1860h clone() {
        try {
            C1860h c1860h = (C1860h) super.clone();
            c1860h.f15088b = (int[]) this.f15088b.clone();
            c1860h.f15089c = (Object[]) this.f15089c.clone();
            return c1860h;
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    public final void d() {
        int i4 = this.f15090d;
        int[] iArr = this.f15088b;
        Object[] objArr = this.f15089c;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (obj != f15086e) {
                if (i6 != i5) {
                    iArr[i5] = iArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.f15087a = false;
        this.f15090d = i5;
    }

    public Object e(int i4) {
        return f(i4, null);
    }

    public Object f(int i4, Object obj) {
        Object obj2;
        int iA = AbstractC1855c.a(this.f15088b, this.f15090d, i4);
        return (iA < 0 || (obj2 = this.f15089c[iA]) == f15086e) ? obj : obj2;
    }

    public int g(int i4) {
        if (this.f15087a) {
            d();
        }
        return this.f15088b[i4];
    }

    public void h(int i4, Object obj) {
        int iA = AbstractC1855c.a(this.f15088b, this.f15090d, i4);
        if (iA >= 0) {
            this.f15089c[iA] = obj;
            return;
        }
        int i5 = ~iA;
        int i6 = this.f15090d;
        if (i5 < i6) {
            Object[] objArr = this.f15089c;
            if (objArr[i5] == f15086e) {
                this.f15088b[i5] = i4;
                objArr[i5] = obj;
                return;
            }
        }
        if (this.f15087a && i6 >= this.f15088b.length) {
            d();
            i5 = ~AbstractC1855c.a(this.f15088b, this.f15090d, i4);
        }
        int i7 = this.f15090d;
        if (i7 >= this.f15088b.length) {
            int iE = AbstractC1855c.e(i7 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f15088b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f15089c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15088b = iArr;
            this.f15089c = objArr2;
        }
        int i8 = this.f15090d;
        if (i8 - i5 != 0) {
            int[] iArr3 = this.f15088b;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr4 = this.f15089c;
            System.arraycopy(objArr4, i5, objArr4, i9, this.f15090d - i5);
        }
        this.f15088b[i5] = i4;
        this.f15089c[i5] = obj;
        this.f15090d++;
    }

    public int i() {
        if (this.f15087a) {
            d();
        }
        return this.f15090d;
    }

    public Object j(int i4) {
        if (this.f15087a) {
            d();
        }
        return this.f15089c[i4];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15090d * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f15090d; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(g(i4));
            sb.append('=');
            Object objJ = j(i4);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C1860h(int i4) {
        this.f15087a = false;
        if (i4 == 0) {
            this.f15088b = AbstractC1855c.f15056a;
            this.f15089c = AbstractC1855c.f15058c;
        } else {
            int iE = AbstractC1855c.e(i4);
            this.f15088b = new int[iE];
            this.f15089c = new Object[iE];
        }
    }
}
