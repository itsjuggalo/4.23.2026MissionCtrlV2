package q;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f9139d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f9140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f9141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9142c;

    public l() {
        int i;
        int i6 = 4;
        while (true) {
            i = 40;
            if (i6 >= 32) {
                break;
            }
            int i7 = (1 << i6) - 12;
            if (40 <= i7) {
                i = i7;
                break;
            }
            i6++;
        }
        int i8 = i / 4;
        this.f9140a = new int[i8];
        this.f9141b = new Object[i8];
    }

    public final void a(int i, Object obj) {
        int i6 = this.f9142c;
        if (i6 != 0 && i <= this.f9140a[i6 - 1]) {
            c(i, obj);
            return;
        }
        if (i6 >= this.f9140a.length) {
            int i7 = (i6 + 1) * 4;
            int i8 = 4;
            while (true) {
                if (i8 >= 32) {
                    break;
                }
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
                i8++;
            }
            int i10 = i7 / 4;
            int[] iArr = new int[i10];
            Object[] objArr = new Object[i10];
            int[] iArr2 = this.f9140a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f9141b;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f9140a = iArr;
            this.f9141b = objArr;
        }
        this.f9140a[i6] = i;
        this.f9141b[i6] = obj;
        this.f9142c = i6 + 1;
    }

    public final Object b(int i, Integer num) {
        Object obj;
        int iA = AbstractC0912d.a(this.f9142c, i, this.f9140a);
        return (iA < 0 || (obj = this.f9141b[iA]) == f9139d) ? num : obj;
    }

    public final void c(int i, Object obj) {
        int iA = AbstractC0912d.a(this.f9142c, i, this.f9140a);
        if (iA >= 0) {
            this.f9141b[iA] = obj;
            return;
        }
        int i6 = ~iA;
        int i7 = this.f9142c;
        if (i6 < i7) {
            Object[] objArr = this.f9141b;
            if (objArr[i6] == f9139d) {
                this.f9140a[i6] = i;
                objArr[i6] = obj;
                return;
            }
        }
        if (i7 >= this.f9140a.length) {
            int i8 = (i7 + 1) * 4;
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
            int i11 = i8 / 4;
            int[] iArr = new int[i11];
            Object[] objArr2 = new Object[i11];
            int[] iArr2 = this.f9140a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f9141b;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f9140a = iArr;
            this.f9141b = objArr2;
        }
        int i12 = this.f9142c - i6;
        if (i12 != 0) {
            int[] iArr3 = this.f9140a;
            int i13 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i13, i12);
            Object[] objArr4 = this.f9141b;
            System.arraycopy(objArr4, i6, objArr4, i13, this.f9142c - i6);
        }
        this.f9140a[i6] = i;
        this.f9141b[i6] = obj;
        this.f9142c++;
    }

    public final Object clone() {
        try {
            l lVar = (l) super.clone();
            lVar.f9140a = (int[]) this.f9140a.clone();
            lVar.f9141b = (Object[]) this.f9141b.clone();
            return lVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final String toString() {
        int i = this.f9142c;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f9142c; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(this.f9140a[i6]);
            sb.append('=');
            Object obj = this.f9141b[i6];
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
