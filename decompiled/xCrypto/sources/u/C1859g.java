package u;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: renamed from: u.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1859g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object[] f15079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f15080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Object[] f15081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f15082g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f15083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f15084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15085c;

    public C1859g() {
        this.f15083a = AbstractC1855c.f15056a;
        this.f15084b = AbstractC1855c.f15058c;
        this.f15085c = 0;
    }

    public static int b(int[] iArr, int i4, int i5) {
        try {
            return AbstractC1855c.a(iArr, i4, i5);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void e(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (C1859g.class) {
                try {
                    if (f15082g < 10) {
                        objArr[0] = f15081f;
                        objArr[1] = iArr;
                        for (int i5 = (i4 << 1) - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f15081f = objArr;
                        f15082g++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C1859g.class) {
                try {
                    if (f15080e < 10) {
                        objArr[0] = f15079d;
                        objArr[1] = iArr;
                        for (int i6 = (i4 << 1) - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f15079d = objArr;
                        f15080e++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i4) {
        if (i4 == 8) {
            synchronized (C1859g.class) {
                try {
                    Object[] objArr = f15081f;
                    if (objArr != null) {
                        this.f15084b = objArr;
                        f15081f = (Object[]) objArr[0];
                        this.f15083a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f15082g--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i4 == 4) {
            synchronized (C1859g.class) {
                try {
                    Object[] objArr2 = f15079d;
                    if (objArr2 != null) {
                        this.f15084b = objArr2;
                        f15079d = (Object[]) objArr2[0];
                        this.f15083a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f15080e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f15083a = new int[i4];
        this.f15084b = new Object[i4 << 1];
    }

    public void clear() {
        int i4 = this.f15085c;
        if (i4 > 0) {
            int[] iArr = this.f15083a;
            Object[] objArr = this.f15084b;
            this.f15083a = AbstractC1855c.f15056a;
            this.f15084b = AbstractC1855c.f15058c;
            this.f15085c = 0;
            e(iArr, objArr, i4);
        }
        if (this.f15085c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public void d(int i4) {
        int i5 = this.f15085c;
        int[] iArr = this.f15083a;
        if (iArr.length < i4) {
            Object[] objArr = this.f15084b;
            a(i4);
            if (this.f15085c > 0) {
                System.arraycopy(iArr, 0, this.f15083a, 0, i5);
                System.arraycopy(objArr, 0, this.f15084b, 0, i5 << 1);
            }
            e(iArr, objArr, i5);
        }
        if (this.f15085c != i5) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1859g) {
            C1859g c1859g = (C1859g) obj;
            if (size() != c1859g.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f15085c; i4++) {
                try {
                    Object objJ = j(i4);
                    Object objN = n(i4);
                    Object obj2 = c1859g.get(objJ);
                    if (objN == null) {
                        if (obj2 != null || !c1859g.containsKey(objJ)) {
                            return false;
                        }
                    } else if (!objN.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f15085c; i5++) {
                try {
                    Object objJ2 = j(i5);
                    Object objN2 = n(i5);
                    Object obj3 = map.get(objJ2);
                    if (objN2 == null) {
                        if (obj3 != null || !map.containsKey(objJ2)) {
                            return false;
                        }
                    } else if (!objN2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj, int i4) {
        int i5 = this.f15085c;
        if (i5 == 0) {
            return -1;
        }
        int iB = b(this.f15083a, i5, i4);
        if (iB < 0 || obj.equals(this.f15084b[iB << 1])) {
            return iB;
        }
        int i6 = iB + 1;
        while (i6 < i5 && this.f15083a[i6] == i4) {
            if (obj.equals(this.f15084b[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = iB - 1; i7 >= 0 && this.f15083a[i7] == i4; i7--) {
            if (obj.equals(this.f15084b[i7 << 1])) {
                return i7;
            }
        }
        return ~i6;
    }

    public int g(Object obj) {
        return obj == null ? h() : f(obj, obj.hashCode());
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iG = g(obj);
        return iG >= 0 ? this.f15084b[(iG << 1) + 1] : obj2;
    }

    public int h() {
        int i4 = this.f15085c;
        if (i4 == 0) {
            return -1;
        }
        int iB = b(this.f15083a, i4, 0);
        if (iB < 0 || this.f15084b[iB << 1] == null) {
            return iB;
        }
        int i5 = iB + 1;
        while (i5 < i4 && this.f15083a[i5] == 0) {
            if (this.f15084b[i5 << 1] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iB - 1; i6 >= 0 && this.f15083a[i6] == 0; i6--) {
            if (this.f15084b[i6 << 1] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public int hashCode() {
        int[] iArr = this.f15083a;
        Object[] objArr = this.f15084b;
        int i4 = this.f15085c;
        int i5 = 1;
        int i6 = 0;
        int iHashCode = 0;
        while (i6 < i4) {
            Object obj = objArr[i5];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i6];
            i6++;
            i5 += 2;
        }
        return iHashCode;
    }

    public int i(Object obj) {
        int i4 = this.f15085c * 2;
        Object[] objArr = this.f15084b;
        if (obj == null) {
            for (int i5 = 1; i5 < i4; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i4; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.f15085c <= 0;
    }

    public Object j(int i4) {
        return this.f15084b[i4 << 1];
    }

    public void k(C1859g c1859g) {
        int i4 = c1859g.f15085c;
        d(this.f15085c + i4);
        if (this.f15085c != 0) {
            for (int i5 = 0; i5 < i4; i5++) {
                put(c1859g.j(i5), c1859g.n(i5));
            }
        } else if (i4 > 0) {
            System.arraycopy(c1859g.f15083a, 0, this.f15083a, 0, i4);
            System.arraycopy(c1859g.f15084b, 0, this.f15084b, 0, i4 << 1);
            this.f15085c = i4;
        }
    }

    public Object l(int i4) {
        Object[] objArr = this.f15084b;
        int i5 = i4 << 1;
        Object obj = objArr[i5 + 1];
        int i6 = this.f15085c;
        int i7 = 0;
        if (i6 <= 1) {
            e(this.f15083a, objArr, i6);
            this.f15083a = AbstractC1855c.f15056a;
            this.f15084b = AbstractC1855c.f15058c;
        } else {
            int i8 = i6 - 1;
            int[] iArr = this.f15083a;
            if (iArr.length <= 8 || i6 >= iArr.length / 3) {
                if (i4 < i8) {
                    int i9 = i4 + 1;
                    int i10 = i8 - i4;
                    System.arraycopy(iArr, i9, iArr, i4, i10);
                    Object[] objArr2 = this.f15084b;
                    System.arraycopy(objArr2, i9 << 1, objArr2, i5, i10 << 1);
                }
                Object[] objArr3 = this.f15084b;
                int i11 = i8 << 1;
                objArr3[i11] = null;
                objArr3[i11 + 1] = null;
            } else {
                a(i6 > 8 ? i6 + (i6 >> 1) : 8);
                if (i6 != this.f15085c) {
                    throw new ConcurrentModificationException();
                }
                if (i4 > 0) {
                    System.arraycopy(iArr, 0, this.f15083a, 0, i4);
                    System.arraycopy(objArr, 0, this.f15084b, 0, i5);
                }
                if (i4 < i8) {
                    int i12 = i4 + 1;
                    int i13 = i8 - i4;
                    System.arraycopy(iArr, i12, this.f15083a, i4, i13);
                    System.arraycopy(objArr, i12 << 1, this.f15084b, i5, i13 << 1);
                }
            }
            i7 = i8;
        }
        if (i6 != this.f15085c) {
            throw new ConcurrentModificationException();
        }
        this.f15085c = i7;
        return obj;
    }

    public Object m(int i4, Object obj) {
        int i5 = (i4 << 1) + 1;
        Object[] objArr = this.f15084b;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        return obj2;
    }

    public Object n(int i4) {
        return this.f15084b[(i4 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i4;
        int iF;
        int i5 = this.f15085c;
        if (obj == null) {
            iF = h();
            i4 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i4 = iHashCode;
            iF = f(obj, iHashCode);
        }
        if (iF >= 0) {
            int i6 = (iF << 1) + 1;
            Object[] objArr = this.f15084b;
            Object obj3 = objArr[i6];
            objArr[i6] = obj2;
            return obj3;
        }
        int i7 = ~iF;
        int[] iArr = this.f15083a;
        if (i5 >= iArr.length) {
            int i8 = 8;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i8 = 4;
            }
            Object[] objArr2 = this.f15084b;
            a(i8);
            if (i5 != this.f15085c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f15083a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f15084b, 0, objArr2.length);
            }
            e(iArr, objArr2, i5);
        }
        if (i7 < i5) {
            int[] iArr3 = this.f15083a;
            int i9 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i9, i5 - i7);
            Object[] objArr3 = this.f15084b;
            System.arraycopy(objArr3, i7 << 1, objArr3, i9 << 1, (this.f15085c - i7) << 1);
        }
        int i10 = this.f15085c;
        if (i5 == i10) {
            int[] iArr4 = this.f15083a;
            if (i7 < iArr4.length) {
                iArr4[i7] = i4;
                Object[] objArr4 = this.f15084b;
                int i11 = i7 << 1;
                objArr4[i11] = obj;
                objArr4[i11 + 1] = obj2;
                this.f15085c = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iG = g(obj);
        if (iG >= 0) {
            return l(iG);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int iG = g(obj);
        if (iG >= 0) {
            return m(iG, obj2);
        }
        return null;
    }

    public int size() {
        return this.f15085c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15085c * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f15085c; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object objJ = j(i4);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objN = n(i4);
            if (objN != this) {
                sb.append(objN);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int iG = g(obj);
        if (iG < 0) {
            return false;
        }
        Object objN = n(iG);
        if (obj2 != objN && (obj2 == null || !obj2.equals(objN))) {
            return false;
        }
        l(iG);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iG = g(obj);
        if (iG < 0) {
            return false;
        }
        Object objN = n(iG);
        if (objN != obj2 && (obj2 == null || !obj2.equals(objN))) {
            return false;
        }
        m(iG, obj3);
        return true;
    }

    public C1859g(int i4) {
        if (i4 == 0) {
            this.f15083a = AbstractC1855c.f15056a;
            this.f15084b = AbstractC1855c.f15058c;
        } else {
            a(i4);
        }
        this.f15085c = 0;
    }

    public C1859g(C1859g c1859g) {
        this();
        if (c1859g != null) {
            k(c1859g);
        }
    }
}
