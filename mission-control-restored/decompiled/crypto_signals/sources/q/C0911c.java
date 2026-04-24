package q;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: q.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0911c implements Collection, Set {
    public static final int[] e = new int[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f9107f = new Object[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Object[] f9108k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f9109l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Object[] f9110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f9111n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f9112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f9113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0909a f9115d;

    public C0911c(int i) {
        if (i == 0) {
            this.f9112a = e;
            this.f9113b = f9107f;
        } else {
            a(i);
        }
        this.f9114c = 0;
    }

    public static void b(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0911c.class) {
                try {
                    if (f9111n < 10) {
                        objArr[0] = f9110m;
                        objArr[1] = iArr;
                        for (int i6 = i - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f9110m = objArr;
                        f9111n++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0911c.class) {
                try {
                    if (f9109l < 10) {
                        objArr[0] = f9108k;
                        objArr[1] = iArr;
                        for (int i7 = i - 1; i7 >= 2; i7--) {
                            objArr[i7] = null;
                        }
                        f9108k = objArr;
                        f9109l++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (C0911c.class) {
                try {
                    Object[] objArr = f9110m;
                    if (objArr != null) {
                        this.f9113b = objArr;
                        f9110m = (Object[]) objArr[0];
                        this.f9112a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f9111n--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (C0911c.class) {
                try {
                    Object[] objArr2 = f9108k;
                    if (objArr2 != null) {
                        this.f9113b = objArr2;
                        f9108k = (Object[]) objArr2[0];
                        this.f9112a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f9109l--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f9112a = new int[i];
        this.f9113b = new Object[i];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iC;
        if (obj == null) {
            iC = f();
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iC = c(iHashCode, obj);
        }
        if (iC >= 0) {
            return false;
        }
        int i6 = ~iC;
        int i7 = this.f9114c;
        int[] iArr = this.f9112a;
        if (i7 >= iArr.length) {
            int i8 = 8;
            if (i7 >= 8) {
                i8 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i8 = 4;
            }
            Object[] objArr = this.f9113b;
            a(i8);
            int[] iArr2 = this.f9112a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f9113b, 0, objArr.length);
            }
            b(iArr, objArr, this.f9114c);
        }
        int i9 = this.f9114c;
        if (i6 < i9) {
            int[] iArr3 = this.f9112a;
            int i10 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i10, i9 - i6);
            Object[] objArr2 = this.f9113b;
            System.arraycopy(objArr2, i6, objArr2, i10, this.f9114c - i6);
        }
        this.f9112a[i6] = i;
        this.f9113b[i6] = obj;
        this.f9114c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f9114c;
        int[] iArr = this.f9112a;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f9113b;
            a(size);
            int i = this.f9114c;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f9112a, 0, i);
                System.arraycopy(objArr, 0, this.f9113b, 0, this.f9114c);
            }
            b(iArr, objArr, this.f9114c);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final int c(int i, Object obj) {
        int i6 = this.f9114c;
        if (i6 == 0) {
            return -1;
        }
        int iA = AbstractC0912d.a(i6, i, this.f9112a);
        if (iA < 0 || obj.equals(this.f9113b[iA])) {
            return iA;
        }
        int i7 = iA + 1;
        while (i7 < i6 && this.f9112a[i7] == i) {
            if (obj.equals(this.f9113b[i7])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = iA - 1; i8 >= 0 && this.f9112a[i8] == i; i8--) {
            if (obj.equals(this.f9113b[i8])) {
                return i8;
            }
        }
        return ~i7;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.f9114c;
        if (i != 0) {
            b(this.f9112a, this.f9113b, i);
            this.f9112a = e;
            this.f9113b = f9107f;
            this.f9114c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? f() : c(obj.hashCode(), obj)) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f9114c != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f9114c; i++) {
                try {
                    if (!set.contains(this.f9113b[i])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i = this.f9114c;
        if (i == 0) {
            return -1;
        }
        int iA = AbstractC0912d.a(i, 0, this.f9112a);
        if (iA < 0 || this.f9113b[iA] == null) {
            return iA;
        }
        int i6 = iA + 1;
        while (i6 < i && this.f9112a[i6] == 0) {
            if (this.f9113b[i6] == null) {
                return i6;
            }
            i6++;
        }
        for (int i7 = iA - 1; i7 >= 0 && this.f9112a[i7] == 0; i7--) {
            if (this.f9113b[i7] == null) {
                return i7;
            }
        }
        return ~i6;
    }

    public final void h(int i) {
        Object[] objArr = this.f9113b;
        Object obj = objArr[i];
        int i6 = this.f9114c;
        if (i6 <= 1) {
            b(this.f9112a, objArr, i6);
            this.f9112a = e;
            this.f9113b = f9107f;
            this.f9114c = 0;
            return;
        }
        int[] iArr = this.f9112a;
        if (iArr.length <= 8 || i6 >= iArr.length / 3) {
            int i7 = i6 - 1;
            this.f9114c = i7;
            if (i < i7) {
                int i8 = i + 1;
                System.arraycopy(iArr, i8, iArr, i, i7 - i);
                Object[] objArr2 = this.f9113b;
                System.arraycopy(objArr2, i8, objArr2, i, this.f9114c - i);
            }
            this.f9113b[this.f9114c] = null;
            return;
        }
        a(i6 > 8 ? i6 + (i6 >> 1) : 8);
        this.f9114c--;
        if (i > 0) {
            System.arraycopy(iArr, 0, this.f9112a, 0, i);
            System.arraycopy(objArr, 0, this.f9113b, 0, i);
        }
        int i9 = this.f9114c;
        if (i < i9) {
            int i10 = i + 1;
            System.arraycopy(iArr, i10, this.f9112a, i, i9 - i);
            System.arraycopy(objArr, i10, this.f9113b, i, this.f9114c - i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f9112a;
        int i = this.f9114c;
        int i6 = 0;
        for (int i7 = 0; i7 < i; i7++) {
            i6 += iArr[i7];
        }
        return i6;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f9114c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f9115d == null) {
            this.f9115d = new C0909a(this, 1);
        }
        C0909a c0909a = this.f9115d;
        if (c0909a.f9103b == null) {
            c0909a.f9103b = new C0916h(c0909a, 1);
        }
        return c0909a.f9103b.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iF = obj == null ? f() : c(obj.hashCode(), obj);
        if (iF < 0) {
            return false;
        }
        h(iF);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z6 = false;
        for (int i = this.f9114c - 1; i >= 0; i--) {
            if (!collection.contains(this.f9113b[i])) {
                h(i);
                z6 = true;
            }
        }
        return z6;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f9114c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i = this.f9114c;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f9113b, 0, objArr, 0, i);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f9114c * 14);
        sb.append('{');
        for (int i = 0; i < this.f9114c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.f9113b[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f9114c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f9114c);
        }
        System.arraycopy(this.f9113b, 0, objArr, 0, this.f9114c);
        int length = objArr.length;
        int i = this.f9114c;
        if (length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
