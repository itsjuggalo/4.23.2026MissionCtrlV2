package j5;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f20115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f20119e;

    public j() {
        this(16, 0.75f);
    }

    public static int c(int i8) {
        int i9 = i8 * (-1640531527);
        return i9 ^ (i9 >>> 16);
    }

    public boolean a(Object obj) {
        Object obj2;
        Object[] objArr = this.f20119e;
        int i8 = this.f20116b;
        int iC = c(obj.hashCode()) & i8;
        Object obj3 = objArr[iC];
        if (obj3 != null) {
            if (obj3.equals(obj)) {
                return false;
            }
            do {
                iC = (iC + 1) & i8;
                obj2 = objArr[iC];
                if (obj2 == null) {
                }
            } while (!obj2.equals(obj));
            return false;
        }
        objArr[iC] = obj;
        int i9 = this.f20117c + 1;
        this.f20117c = i9;
        if (i9 >= this.f20118d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f20119e;
    }

    public void d() {
        Object obj;
        Object[] objArr = this.f20119e;
        int length = objArr.length;
        int i8 = length << 1;
        int i9 = i8 - 1;
        Object[] objArr2 = new Object[i8];
        int i10 = this.f20117c;
        while (true) {
            int i11 = i10 - 1;
            if (i10 == 0) {
                this.f20116b = i9;
                this.f20118d = (int) (i8 * this.f20115a);
                this.f20119e = objArr2;
                return;
            }
            do {
                length--;
                obj = objArr[length];
            } while (obj == null);
            int iC = c(obj.hashCode()) & i9;
            if (objArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i9;
                } while (objArr2[iC] != null);
            }
            objArr2[iC] = objArr[length];
            i10 = i11;
        }
    }

    public boolean e(Object obj) {
        Object obj2;
        Object[] objArr = this.f20119e;
        int i8 = this.f20116b;
        int iC = c(obj.hashCode()) & i8;
        Object obj3 = objArr[iC];
        if (obj3 == null) {
            return false;
        }
        if (obj3.equals(obj)) {
            return f(iC, objArr, i8);
        }
        do {
            iC = (iC + 1) & i8;
            obj2 = objArr[iC];
            if (obj2 == null) {
                return false;
            }
        } while (!obj2.equals(obj));
        return f(iC, objArr, i8);
    }

    public boolean f(int i8, Object[] objArr, int i9) {
        int i10;
        Object obj;
        this.f20117c--;
        while (true) {
            int i11 = i8 + 1;
            while (true) {
                i10 = i11 & i9;
                obj = objArr[i10];
                if (obj == null) {
                    objArr[i8] = null;
                    return true;
                }
                int iC = c(obj.hashCode()) & i9;
                if (i8 <= i10) {
                    if (i8 >= iC || iC > i10) {
                        break;
                    }
                    i11 = i10 + 1;
                } else if (i8 < iC || iC <= i10) {
                    i11 = i10 + 1;
                }
            }
            objArr[i8] = obj;
            i8 = i10;
        }
    }

    public j(int i8, float f8) {
        this.f20115a = f8;
        int iA = k.a(i8);
        this.f20116b = iA - 1;
        this.f20118d = (int) (f8 * iA);
        this.f20119e = new Object[iA];
    }
}
