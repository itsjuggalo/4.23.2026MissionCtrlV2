package w2;

/* JADX INFO: loaded from: classes.dex */
public final class x extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f24050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f24051i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f24052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f24053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object[] f24054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f24055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f24056g;

    static {
        Object[] objArr = new Object[0];
        f24050h = objArr;
        f24051i = new x(objArr, 0, objArr, 0, 0);
    }

    public x(Object[] objArr, int i8, Object[] objArr2, int i9, int i10) {
        this.f24052c = objArr;
        this.f24053d = i8;
        this.f24054e = objArr2;
        this.f24055f = i9;
        this.f24056g = i10;
    }

    @Override // w2.m
    public k I() {
        return k.F(this.f24052c, this.f24056g);
    }

    @Override // w2.m
    public boolean J() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public AbstractC2910B iterator() {
        return a().iterator();
    }

    @Override // w2.AbstractC2921j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f24054e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iB = AbstractC2920i.b(obj);
        while (true) {
            int i8 = iB & this.f24055f;
            Object obj2 = objArr[i8];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iB = i8 + 1;
        }
    }

    @Override // w2.AbstractC2921j
    public int d(Object[] objArr, int i8) {
        System.arraycopy(this.f24052c, 0, objArr, i8, this.f24056g);
        return i8 + this.f24056g;
    }

    @Override // w2.AbstractC2921j
    public Object[] e() {
        return this.f24052c;
    }

    @Override // w2.AbstractC2921j
    public int f() {
        return this.f24056g;
    }

    @Override // w2.AbstractC2921j
    public int h() {
        return 0;
    }

    @Override // w2.m, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f24053d;
    }

    @Override // w2.AbstractC2921j
    public boolean n() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f24056g;
    }
}
