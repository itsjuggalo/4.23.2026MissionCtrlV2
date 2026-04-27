package q;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object[] f9133d;
    public static int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Object[] f9134f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f9135k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f9136a = AbstractC0912d.f9116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f9137b = AbstractC0912d.f9117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9138c = 0;

    public static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (k.class) {
                try {
                    if (f9135k < 10) {
                        objArr[0] = f9134f;
                        objArr[1] = iArr;
                        for (int i6 = (i << 1) - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f9134f = objArr;
                        f9135k++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (k.class) {
                try {
                    if (e < 10) {
                        objArr[0] = f9133d;
                        objArr[1] = iArr;
                        for (int i7 = (i << 1) - 1; i7 >= 2; i7--) {
                            objArr[i7] = null;
                        }
                        f9133d = objArr;
                        e++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (k.class) {
                try {
                    Object[] objArr = f9134f;
                    if (objArr != null) {
                        this.f9137b = objArr;
                        f9134f = (Object[]) objArr[0];
                        this.f9136a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f9135k--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (k.class) {
                try {
                    Object[] objArr2 = f9133d;
                    if (objArr2 != null) {
                        this.f9137b = objArr2;
                        f9133d = (Object[]) objArr2[0];
                        this.f9136a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f9136a = new int[i];
        this.f9137b = new Object[i << 1];
    }

    public final void clear() {
        int i = this.f9138c;
        if (i > 0) {
            int[] iArr = this.f9136a;
            Object[] objArr = this.f9137b;
            this.f9136a = AbstractC0912d.f9116a;
            this.f9137b = AbstractC0912d.f9117b;
            this.f9138c = 0;
            c(iArr, objArr, i);
        }
        if (this.f9138c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final int d(int i, Object obj) {
        int i6 = this.f9138c;
        if (i6 == 0) {
            return -1;
        }
        try {
            int iA = AbstractC0912d.a(i6, i, this.f9136a);
            if (iA < 0 || obj.equals(this.f9137b[iA << 1])) {
                return iA;
            }
            int i7 = iA + 1;
            while (i7 < i6 && this.f9136a[i7] == i) {
                if (obj.equals(this.f9137b[i7 << 1])) {
                    return i7;
                }
                i7++;
            }
            for (int i8 = iA - 1; i8 >= 0 && this.f9136a[i8] == i; i8--) {
                if (obj.equals(this.f9137b[i8 << 1])) {
                    return i8;
                }
            }
            return ~i7;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f9138c != kVar.f9138c) {
                return false;
            }
            for (int i = 0; i < this.f9138c; i++) {
                try {
                    Object objH = h(i);
                    Object objJ = j(i);
                    Object orDefault = kVar.getOrDefault(objH, null);
                    if (objJ == null) {
                        if (orDefault != null || !kVar.containsKey(objH)) {
                            return false;
                        }
                    } else if (!objJ.equals(orDefault)) {
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
            if (this.f9138c != map.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.f9138c; i6++) {
                try {
                    Object objH2 = h(i6);
                    Object objJ2 = j(i6);
                    Object obj2 = map.get(objH2);
                    if (objJ2 == null) {
                        if (obj2 != null || !map.containsKey(objH2)) {
                            return false;
                        }
                    } else if (!objJ2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i = this.f9138c;
        if (i == 0) {
            return -1;
        }
        try {
            int iA = AbstractC0912d.a(i, 0, this.f9136a);
            if (iA < 0 || this.f9137b[iA << 1] == null) {
                return iA;
            }
            int i6 = iA + 1;
            while (i6 < i && this.f9136a[i6] == 0) {
                if (this.f9137b[i6 << 1] == null) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = iA - 1; i7 >= 0 && this.f9136a[i7] == 0; i7--) {
                if (this.f9137b[i7 << 1] == null) {
                    return i7;
                }
            }
            return ~i6;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int g(Object obj) {
        int i = this.f9138c * 2;
        Object[] objArr = this.f9137b;
        if (obj == null) {
            for (int i6 = 1; i6 < i; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i; i7 += 2) {
            if (obj.equals(objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iE = e(obj);
        return iE >= 0 ? this.f9137b[(iE << 1) + 1] : obj2;
    }

    public final Object h(int i) {
        return this.f9137b[i << 1];
    }

    public final int hashCode() {
        int[] iArr = this.f9136a;
        Object[] objArr = this.f9137b;
        int i = this.f9138c;
        int i6 = 1;
        int i7 = 0;
        int iHashCode = 0;
        while (i7 < i) {
            Object obj = objArr[i6];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i) {
        Object[] objArr = this.f9137b;
        int i6 = i << 1;
        Object obj = objArr[i6 + 1];
        int i7 = this.f9138c;
        int i8 = 0;
        if (i7 <= 1) {
            c(this.f9136a, objArr, i7);
            this.f9136a = AbstractC0912d.f9116a;
            this.f9137b = AbstractC0912d.f9117b;
        } else {
            int i9 = i7 - 1;
            int[] iArr = this.f9136a;
            if (iArr.length <= 8 || i7 >= iArr.length / 3) {
                if (i < i9) {
                    int i10 = i + 1;
                    int i11 = i9 - i;
                    System.arraycopy(iArr, i10, iArr, i, i11);
                    Object[] objArr2 = this.f9137b;
                    System.arraycopy(objArr2, i10 << 1, objArr2, i6, i11 << 1);
                }
                Object[] objArr3 = this.f9137b;
                int i12 = i9 << 1;
                objArr3[i12] = null;
                objArr3[i12 + 1] = null;
            } else {
                a(i7 > 8 ? i7 + (i7 >> 1) : 8);
                if (i7 != this.f9138c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f9136a, 0, i);
                    System.arraycopy(objArr, 0, this.f9137b, 0, i6);
                }
                if (i < i9) {
                    int i13 = i + 1;
                    int i14 = i9 - i;
                    System.arraycopy(iArr, i13, this.f9136a, i, i14);
                    System.arraycopy(objArr, i13 << 1, this.f9137b, i6, i14 << 1);
                }
            }
            i8 = i9;
        }
        if (i7 != this.f9138c) {
            throw new ConcurrentModificationException();
        }
        this.f9138c = i8;
        return obj;
    }

    public final boolean isEmpty() {
        return this.f9138c <= 0;
    }

    public final Object j(int i) {
        return this.f9137b[(i << 1) + 1];
    }

    public final Object put(Object obj, Object obj2) {
        int i;
        int iD;
        int i6 = this.f9138c;
        if (obj == null) {
            iD = f();
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iD = d(iHashCode, obj);
        }
        if (iD >= 0) {
            int i7 = (iD << 1) + 1;
            Object[] objArr = this.f9137b;
            Object obj3 = objArr[i7];
            objArr[i7] = obj2;
            return obj3;
        }
        int i8 = ~iD;
        int[] iArr = this.f9136a;
        if (i6 >= iArr.length) {
            int i9 = 8;
            if (i6 >= 8) {
                i9 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i9 = 4;
            }
            Object[] objArr2 = this.f9137b;
            a(i9);
            if (i6 != this.f9138c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f9136a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f9137b, 0, objArr2.length);
            }
            c(iArr, objArr2, i6);
        }
        if (i8 < i6) {
            int[] iArr3 = this.f9136a;
            int i10 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i10, i6 - i8);
            Object[] objArr3 = this.f9137b;
            System.arraycopy(objArr3, i8 << 1, objArr3, i10 << 1, (this.f9138c - i8) << 1);
        }
        int i11 = this.f9138c;
        if (i6 == i11) {
            int[] iArr4 = this.f9136a;
            if (i8 < iArr4.length) {
                iArr4[i8] = i;
                Object[] objArr4 = this.f9137b;
                int i12 = i8 << 1;
                objArr4[i12] = obj;
                objArr4[i12 + 1] = obj2;
                this.f9138c = i11 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final Object remove(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return i(iE);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0) {
            return null;
        }
        int i = (iE << 1) + 1;
        Object[] objArr = this.f9137b;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    public final int size() {
        return this.f9138c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f9138c * 28);
        sb.append('{');
        for (int i = 0; i < this.f9138c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object objH = h(i);
            if (objH != this) {
                sb.append(objH);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objJ = j(i);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean remove(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        Object objJ = j(iE);
        if (obj2 != objJ && (obj2 == null || !obj2.equals(objJ))) {
            return false;
        }
        i(iE);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        Object objJ = j(iE);
        if (objJ != obj2 && (obj2 == null || !obj2.equals(objJ))) {
            return false;
        }
        int i = (iE << 1) + 1;
        Object[] objArr = this.f9137b;
        Object obj4 = objArr[i];
        objArr[i] = obj3;
        return true;
    }
}
