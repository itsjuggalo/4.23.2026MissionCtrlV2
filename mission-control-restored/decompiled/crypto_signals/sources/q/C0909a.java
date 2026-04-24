package q;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: q.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0909a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0916h f9102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0916h f9103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0918j f9104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9105d;
    public final /* synthetic */ Object e;

    public /* synthetic */ C0909a(Object obj, int i) {
        this.f9105d = i;
        this.e = obj;
    }

    public static boolean h(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
                return set.containsAll(set2);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final void a() {
        switch (this.f9105d) {
            case 0:
                ((C0910b) this.e).clear();
                break;
            default:
                ((C0911c) this.e).clear();
                break;
        }
    }

    public final Object b(int i, int i6) {
        switch (this.f9105d) {
            case 0:
                return ((C0910b) this.e).f9137b[(i << 1) + i6];
            default:
                return ((C0911c) this.e).f9113b[i];
        }
    }

    public final Map c() {
        switch (this.f9105d) {
            case 0:
                return (C0910b) this.e;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    public final int d() {
        switch (this.f9105d) {
            case 0:
                return ((C0910b) this.e).f9138c;
            default:
                return ((C0911c) this.e).f9114c;
        }
    }

    public final int e(Object obj) {
        switch (this.f9105d) {
            case 0:
                return ((C0910b) this.e).e(obj);
            default:
                C0911c c0911c = (C0911c) this.e;
                return obj == null ? c0911c.f() : c0911c.c(obj.hashCode(), obj);
        }
    }

    public final int f(Object obj) {
        switch (this.f9105d) {
            case 0:
                return ((C0910b) this.e).g(obj);
            default:
                C0911c c0911c = (C0911c) this.e;
                return obj == null ? c0911c.f() : c0911c.c(obj.hashCode(), obj);
        }
    }

    public final void g(int i) {
        switch (this.f9105d) {
            case 0:
                ((C0910b) this.e).i(i);
                break;
            default:
                ((C0911c) this.e).h(i);
                break;
        }
    }

    public final Object[] i(int i, Object[] objArr) {
        int iD = d();
        if (objArr.length < iD) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iD);
        }
        for (int i6 = 0; i6 < iD; i6++) {
            objArr[i6] = b(i6, i);
        }
        if (objArr.length > iD) {
            objArr[iD] = null;
        }
        return objArr;
    }
}
