package q6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f18850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f18851i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f18852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f18853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object[] f18854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f18855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f18856g;

    static {
        Object[] objArr = new Object[0];
        f18850h = objArr;
        f18851i = new x(objArr, 0, objArr, 0, 0);
    }

    public x(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f18852c = objArr;
        this.f18853d = i10;
        this.f18854e = objArr2;
        this.f18855f = i11;
        this.f18856g = i12;
    }

    @Override // q6.j
    public int c(Object[] objArr, int i10) {
        System.arraycopy(this.f18852c, 0, objArr, i10, this.f18856g);
        return i10 + this.f18856g;
    }

    @Override // q6.j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f18854e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iB = i.b(obj);
        while (true) {
            int i10 = iB & this.f18855f;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iB = i10 + 1;
        }
    }

    @Override // q6.j
    public Object[] d() {
        return this.f18852c;
    }

    @Override // q6.j
    public int e() {
        return this.f18856g;
    }

    @Override // q6.j
    public int f() {
        return 0;
    }

    @Override // q6.j
    public boolean g() {
        return false;
    }

    @Override // q6.m, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f18853d;
    }

    @Override // q6.m
    public k s() {
        return k.q(this.f18852c, this.f18856g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f18856g;
    }

    @Override // q6.m
    public boolean u() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public b0 iterator() {
        return a().iterator();
    }
}
