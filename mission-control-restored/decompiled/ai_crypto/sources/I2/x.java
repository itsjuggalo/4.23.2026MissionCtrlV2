package I2;

/* JADX INFO: loaded from: classes.dex */
public final class x extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f3002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f3003i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f3004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f3005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object[] f3006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f3007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f3008g;

    static {
        Object[] objArr = new Object[0];
        f3002h = objArr;
        f3003i = new x(objArr, 0, objArr, 0, 0);
    }

    public x(Object[] objArr, int i7, Object[] objArr2, int i8, int i9) {
        this.f3004c = objArr;
        this.f3005d = i7;
        this.f3006e = objArr2;
        this.f3007f = i8;
        this.f3008g = i9;
    }

    @Override // I2.j
    public int b(Object[] objArr, int i7) {
        System.arraycopy(this.f3004c, 0, objArr, i7, this.f3008g);
        return i7 + this.f3008g;
    }

    @Override // I2.j
    public Object[] c() {
        return this.f3004c;
    }

    @Override // I2.j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f3006e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iB = i.b(obj);
        while (true) {
            int i7 = iB & this.f3007f;
            Object obj2 = objArr[i7];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iB = i7 + 1;
        }
    }

    @Override // I2.j
    public int g() {
        return this.f3008g;
    }

    @Override // I2.j
    public int h() {
        return 0;
    }

    @Override // I2.m, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f3005d;
    }

    @Override // I2.j
    public boolean j() {
        return false;
    }

    @Override // I2.m
    public k n() {
        return k.l(this.f3004c, this.f3008g);
    }

    @Override // I2.m
    public boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public B iterator() {
        return a().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f3008g;
    }
}
