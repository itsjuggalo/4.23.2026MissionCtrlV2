package u;

/* JADX INFO: loaded from: classes.dex */
public class h implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f24385e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f24387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f24388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24389d;

    public h() {
        this(10);
    }

    public void a(int i7, Object obj) {
        int i8 = this.f24389d;
        if (i8 != 0 && i7 <= this.f24387b[i8 - 1]) {
            j(i7, obj);
            return;
        }
        if (this.f24386a && i8 >= this.f24387b.length) {
            d();
        }
        int i9 = this.f24389d;
        if (i9 >= this.f24387b.length) {
            int iE = AbstractC2738c.e(i9 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f24387b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f24388c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f24387b = iArr;
            this.f24388c = objArr;
        }
        this.f24387b[i9] = i7;
        this.f24388c[i9] = obj;
        this.f24389d = i9 + 1;
    }

    public void b() {
        int i7 = this.f24389d;
        Object[] objArr = this.f24388c;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f24389d = 0;
        this.f24386a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f24387b = (int[]) this.f24387b.clone();
            hVar.f24388c = (Object[]) this.f24388c.clone();
            return hVar;
        } catch (CloneNotSupportedException e7) {
            throw new AssertionError(e7);
        }
    }

    public final void d() {
        int i7 = this.f24389d;
        int[] iArr = this.f24387b;
        Object[] objArr = this.f24388c;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            Object obj = objArr[i9];
            if (obj != f24385e) {
                if (i9 != i8) {
                    iArr[i8] = iArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        this.f24386a = false;
        this.f24389d = i8;
    }

    public Object e(int i7) {
        return f(i7, null);
    }

    public Object f(int i7, Object obj) {
        Object obj2;
        int iA = AbstractC2738c.a(this.f24387b, this.f24389d, i7);
        return (iA < 0 || (obj2 = this.f24388c[iA]) == f24385e) ? obj : obj2;
    }

    public int g(Object obj) {
        if (this.f24386a) {
            d();
        }
        for (int i7 = 0; i7 < this.f24389d; i7++) {
            if (this.f24388c[i7] == obj) {
                return i7;
            }
        }
        return -1;
    }

    public int i(int i7) {
        if (this.f24386a) {
            d();
        }
        return this.f24387b[i7];
    }

    public void j(int i7, Object obj) {
        int iA = AbstractC2738c.a(this.f24387b, this.f24389d, i7);
        if (iA >= 0) {
            this.f24388c[iA] = obj;
            return;
        }
        int i8 = ~iA;
        int i9 = this.f24389d;
        if (i8 < i9) {
            Object[] objArr = this.f24388c;
            if (objArr[i8] == f24385e) {
                this.f24387b[i8] = i7;
                objArr[i8] = obj;
                return;
            }
        }
        if (this.f24386a && i9 >= this.f24387b.length) {
            d();
            i8 = ~AbstractC2738c.a(this.f24387b, this.f24389d, i7);
        }
        int i10 = this.f24389d;
        if (i10 >= this.f24387b.length) {
            int iE = AbstractC2738c.e(i10 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f24387b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f24388c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f24387b = iArr;
            this.f24388c = objArr2;
        }
        int i11 = this.f24389d;
        if (i11 - i8 != 0) {
            int[] iArr3 = this.f24387b;
            int i12 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i12, i11 - i8);
            Object[] objArr4 = this.f24388c;
            System.arraycopy(objArr4, i8, objArr4, i12, this.f24389d - i8);
        }
        this.f24387b[i8] = i7;
        this.f24388c[i8] = obj;
        this.f24389d++;
    }

    public int k() {
        if (this.f24386a) {
            d();
        }
        return this.f24389d;
    }

    public Object l(int i7) {
        if (this.f24386a) {
            d();
        }
        return this.f24388c[i7];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f24389d * 28);
        sb.append('{');
        for (int i7 = 0; i7 < this.f24389d; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            sb.append(i(i7));
            sb.append('=');
            Object objL = l(i7);
            if (objL != this) {
                sb.append(objL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i7) {
        this.f24386a = false;
        if (i7 == 0) {
            this.f24387b = AbstractC2738c.f24355a;
            this.f24388c = AbstractC2738c.f24357c;
        } else {
            int iE = AbstractC2738c.e(i7);
            this.f24387b = new int[iE];
            this.f24388c = new Object[iE];
        }
    }
}
