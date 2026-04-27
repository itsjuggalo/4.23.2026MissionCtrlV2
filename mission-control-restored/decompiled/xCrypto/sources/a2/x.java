package a2;

/* JADX INFO: loaded from: classes.dex */
public final class x extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f6173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f6174i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f6175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f6176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object[] f6177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f6178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f6179g;

    static {
        Object[] objArr = new Object[0];
        f6173h = objArr;
        f6174i = new x(objArr, 0, objArr, 0, 0);
    }

    public x(Object[] objArr, int i4, Object[] objArr2, int i5, int i6) {
        this.f6175c = objArr;
        this.f6176d = i4;
        this.f6177e = objArr2;
        this.f6178f = i5;
        this.f6179g = i6;
    }

    @Override // a2.j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f6177e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iB = i.b(obj);
        while (true) {
            int i4 = iB & this.f6178f;
            Object obj2 = objArr[i4];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iB = i4 + 1;
        }
    }

    @Override // a2.j
    public int f(Object[] objArr, int i4) {
        System.arraycopy(this.f6175c, 0, objArr, i4, this.f6179g);
        return i4 + this.f6179g;
    }

    @Override // a2.m, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f6176d;
    }

    @Override // a2.j
    public Object[] i() {
        return this.f6175c;
    }

    @Override // a2.j
    public int k() {
        return this.f6179g;
    }

    @Override // a2.j
    public int l() {
        return 0;
    }

    @Override // a2.j
    public boolean m() {
        return false;
    }

    @Override // a2.m
    public k q() {
        return k.o(this.f6175c, this.f6179g);
    }

    @Override // a2.m
    public boolean r() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public B iterator() {
        return c().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f6179g;
    }
}
