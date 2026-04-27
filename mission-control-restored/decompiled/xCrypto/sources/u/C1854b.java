package u;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: u.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1854b implements Collection, Set {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f15045e = new int[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f15046f = new Object[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Object[] f15047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f15048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Object[] f15049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f15050j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f15051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f15052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbstractC1858f f15054d;

    /* JADX INFO: renamed from: u.b$a */
    public class a extends AbstractC1858f {
        public a() {
        }

        @Override // u.AbstractC1858f
        public void a() {
            C1854b.this.clear();
        }

        @Override // u.AbstractC1858f
        public Object b(int i4, int i5) {
            return C1854b.this.f15052b[i4];
        }

        @Override // u.AbstractC1858f
        public Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // u.AbstractC1858f
        public int d() {
            return C1854b.this.f15053c;
        }

        @Override // u.AbstractC1858f
        public int e(Object obj) {
            return C1854b.this.indexOf(obj);
        }

        @Override // u.AbstractC1858f
        public int f(Object obj) {
            return C1854b.this.indexOf(obj);
        }

        @Override // u.AbstractC1858f
        public void g(Object obj, Object obj2) {
            C1854b.this.add(obj);
        }

        @Override // u.AbstractC1858f
        public void h(int i4) {
            C1854b.this.n(i4);
        }

        @Override // u.AbstractC1858f
        public Object i(int i4, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public C1854b() {
        this(0);
    }

    public static void i(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (C1854b.class) {
                try {
                    if (f15050j < 10) {
                        objArr[0] = f15049i;
                        objArr[1] = iArr;
                        for (int i5 = i4 - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f15049i = objArr;
                        f15050j++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C1854b.class) {
                try {
                    if (f15048h < 10) {
                        objArr[0] = f15047g;
                        objArr[1] = iArr;
                        for (int i6 = i4 - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f15047g = objArr;
                        f15048h++;
                    }
                } finally {
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i4;
        int iL;
        if (obj == null) {
            iL = m();
            i4 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i4 = iHashCode;
            iL = l(obj, iHashCode);
        }
        if (iL >= 0) {
            return false;
        }
        int i5 = ~iL;
        int i6 = this.f15053c;
        int[] iArr = this.f15051a;
        if (i6 >= iArr.length) {
            int i7 = 8;
            if (i6 >= 8) {
                i7 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i7 = 4;
            }
            Object[] objArr = this.f15052b;
            c(i7);
            int[] iArr2 = this.f15051a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f15052b, 0, objArr.length);
            }
            i(iArr, objArr, this.f15053c);
        }
        int i8 = this.f15053c;
        if (i5 < i8) {
            int[] iArr3 = this.f15051a;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr2 = this.f15052b;
            System.arraycopy(objArr2, i5, objArr2, i9, this.f15053c - i5);
        }
        this.f15051a[i5] = i4;
        this.f15052b[i5] = obj;
        this.f15053c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        f(this.f15053c + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final void c(int i4) {
        if (i4 == 8) {
            synchronized (C1854b.class) {
                try {
                    Object[] objArr = f15049i;
                    if (objArr != null) {
                        this.f15052b = objArr;
                        f15049i = (Object[]) objArr[0];
                        this.f15051a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f15050j--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i4 == 4) {
            synchronized (C1854b.class) {
                try {
                    Object[] objArr2 = f15047g;
                    if (objArr2 != null) {
                        this.f15052b = objArr2;
                        f15047g = (Object[]) objArr2[0];
                        this.f15051a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f15048h--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f15051a = new int[i4];
        this.f15052b = new Object[i4];
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i4 = this.f15053c;
        if (i4 != 0) {
            i(this.f15051a, this.f15052b, i4);
            this.f15051a = f15045e;
            this.f15052b = f15046f;
            this.f15053c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f15053c; i4++) {
                try {
                    if (!set.contains(o(i4))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void f(int i4) {
        int[] iArr = this.f15051a;
        if (iArr.length < i4) {
            Object[] objArr = this.f15052b;
            c(i4);
            int i5 = this.f15053c;
            if (i5 > 0) {
                System.arraycopy(iArr, 0, this.f15051a, 0, i5);
                System.arraycopy(objArr, 0, this.f15052b, 0, this.f15053c);
            }
            i(iArr, objArr, this.f15053c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f15051a;
        int i4 = this.f15053c;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    public int indexOf(Object obj) {
        return obj == null ? m() : l(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f15053c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return k().m().iterator();
    }

    public final AbstractC1858f k() {
        if (this.f15054d == null) {
            this.f15054d = new a();
        }
        return this.f15054d;
    }

    public final int l(Object obj, int i4) {
        int i5 = this.f15053c;
        if (i5 == 0) {
            return -1;
        }
        int iA = AbstractC1855c.a(this.f15051a, i5, i4);
        if (iA < 0 || obj.equals(this.f15052b[iA])) {
            return iA;
        }
        int i6 = iA + 1;
        while (i6 < i5 && this.f15051a[i6] == i4) {
            if (obj.equals(this.f15052b[i6])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = iA - 1; i7 >= 0 && this.f15051a[i7] == i4; i7--) {
            if (obj.equals(this.f15052b[i7])) {
                return i7;
            }
        }
        return ~i6;
    }

    public final int m() {
        int i4 = this.f15053c;
        if (i4 == 0) {
            return -1;
        }
        int iA = AbstractC1855c.a(this.f15051a, i4, 0);
        if (iA < 0 || this.f15052b[iA] == null) {
            return iA;
        }
        int i5 = iA + 1;
        while (i5 < i4 && this.f15051a[i5] == 0) {
            if (this.f15052b[i5] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iA - 1; i6 >= 0 && this.f15051a[i6] == 0; i6--) {
            if (this.f15052b[i6] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public Object n(int i4) {
        Object[] objArr = this.f15052b;
        Object obj = objArr[i4];
        int i5 = this.f15053c;
        if (i5 <= 1) {
            i(this.f15051a, objArr, i5);
            this.f15051a = f15045e;
            this.f15052b = f15046f;
            this.f15053c = 0;
            return obj;
        }
        int[] iArr = this.f15051a;
        if (iArr.length <= 8 || i5 >= iArr.length / 3) {
            int i6 = i5 - 1;
            this.f15053c = i6;
            if (i4 < i6) {
                int i7 = i4 + 1;
                System.arraycopy(iArr, i7, iArr, i4, i6 - i4);
                Object[] objArr2 = this.f15052b;
                System.arraycopy(objArr2, i7, objArr2, i4, this.f15053c - i4);
            }
            this.f15052b[this.f15053c] = null;
            return obj;
        }
        c(i5 > 8 ? i5 + (i5 >> 1) : 8);
        this.f15053c--;
        if (i4 > 0) {
            System.arraycopy(iArr, 0, this.f15051a, 0, i4);
            System.arraycopy(objArr, 0, this.f15052b, 0, i4);
        }
        int i8 = this.f15053c;
        if (i4 < i8) {
            int i9 = i4 + 1;
            System.arraycopy(iArr, i9, this.f15051a, i4, i8 - i4);
            System.arraycopy(objArr, i9, this.f15052b, i4, this.f15053c - i4);
        }
        return obj;
    }

    public Object o(int i4) {
        return this.f15052b[i4];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        n(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z4 = false;
        for (int i4 = this.f15053c - 1; i4 >= 0; i4--) {
            if (!collection.contains(this.f15052b[i4])) {
                n(i4);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f15053c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i4 = this.f15053c;
        Object[] objArr = new Object[i4];
        System.arraycopy(this.f15052b, 0, objArr, 0, i4);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15053c * 14);
        sb.append('{');
        for (int i4 = 0; i4 < this.f15053c; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object objO = o(i4);
            if (objO != this) {
                sb.append(objO);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C1854b(int i4) {
        if (i4 == 0) {
            this.f15051a = f15045e;
            this.f15052b = f15046f;
        } else {
            c(i4);
        }
        this.f15053c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f15053c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f15053c);
        }
        System.arraycopy(this.f15052b, 0, objArr, 0, this.f15053c);
        int length = objArr.length;
        int i4 = this.f15053c;
        if (length > i4) {
            objArr[i4] = null;
        }
        return objArr;
    }
}
