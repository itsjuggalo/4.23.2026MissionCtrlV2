package w;

import dd.l;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f23572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f23573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23574c;

    public i() {
        this(0, 1, null);
    }

    public final int a(Object obj) {
        int i10 = this.f23574c * 2;
        Object[] objArr = this.f23573b;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (t.b(obj, objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public void b(int i10) {
        int i11 = this.f23574c;
        int[] iArr = this.f23572a;
        if (iArr.length < i10) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
            t.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f23572a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23573b, i10 * 2);
            t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23573b = objArrCopyOf;
        }
        if (this.f23574c != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(Object obj, int i10) {
        int i11 = this.f23574c;
        if (i11 == 0) {
            return -1;
        }
        int iA = x.a.a(this.f23572a, i11, i10);
        if (iA < 0 || t.b(obj, this.f23573b[iA << 1])) {
            return iA;
        }
        int i12 = iA + 1;
        while (i12 < i11 && this.f23572a[i12] == i10) {
            if (t.b(obj, this.f23573b[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iA - 1; i13 >= 0 && this.f23572a[i13] == i10; i13--) {
            if (t.b(obj, this.f23573b[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public void clear() {
        if (this.f23574c > 0) {
            this.f23572a = x.a.f24120a;
            this.f23573b = x.a.f24122c;
            this.f23574c = 0;
        }
        if (this.f23574c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public int e(Object obj) {
        return obj == null ? f() : c(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof i) {
                if (size() != ((i) obj).size()) {
                    return false;
                }
                i iVar = (i) obj;
                int i10 = this.f23574c;
                for (int i11 = 0; i11 < i10; i11++) {
                    Object objG = g(i11);
                    Object objK = k(i11);
                    Object obj2 = iVar.get(objG);
                    if (objK == null) {
                        if (obj2 != null || !iVar.containsKey(objG)) {
                            return false;
                        }
                    } else if (!t.b(objK, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i12 = this.f23574c;
            for (int i13 = 0; i13 < i12; i13++) {
                Object objG2 = g(i13);
                Object objK2 = k(i13);
                Object obj3 = ((Map) obj).get(objG2);
                if (objK2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objG2)) {
                        return false;
                    }
                } else if (!t.b(objK2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final int f() {
        int i10 = this.f23574c;
        if (i10 == 0) {
            return -1;
        }
        int iA = x.a.a(this.f23572a, i10, 0);
        if (iA < 0 || this.f23573b[iA << 1] == null) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f23572a[i11] == 0) {
            if (this.f23573b[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f23572a[i12] == 0; i12--) {
            if (this.f23573b[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public Object g(int i10) {
        if (i10 >= 0 && i10 < this.f23574c) {
            return this.f23573b[i10 << 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
    }

    public Object get(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return this.f23573b[(iE << 1) + 1];
        }
        return null;
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iE = e(obj);
        return iE >= 0 ? this.f23573b[(iE << 1) + 1] : obj2;
    }

    public void h(i map) {
        t.f(map, "map");
        int i10 = map.f23574c;
        b(this.f23574c + i10);
        if (this.f23574c != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(map.g(i11), map.k(i11));
            }
        } else if (i10 > 0) {
            l.f(map.f23572a, this.f23572a, 0, 0, i10);
            l.h(map.f23573b, this.f23573b, 0, 0, i10 << 1);
            this.f23574c = i10;
        }
    }

    public int hashCode() {
        int[] iArr = this.f23572a;
        Object[] objArr = this.f23573b;
        int i10 = this.f23574c;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    public Object i(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f23574c)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
        }
        Object[] objArr = this.f23573b;
        int i12 = i10 << 1;
        Object obj = objArr[i12 + 1];
        if (i11 <= 1) {
            clear();
            return obj;
        }
        int i13 = i11 - 1;
        int[] iArr = this.f23572a;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (i10 < i13) {
                int i14 = i10 + 1;
                l.f(iArr, iArr, i10, i14, i11);
                Object[] objArr2 = this.f23573b;
                l.h(objArr2, objArr2, i12, i14 << 1, i11 << 1);
            }
            Object[] objArr3 = this.f23573b;
            int i15 = i13 << 1;
            objArr3[i15] = null;
            objArr3[i15 + 1] = null;
        } else {
            int i16 = i11 > 8 ? i11 + (i11 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i16);
            t.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f23572a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23573b, i16 << 1);
            t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23573b = objArrCopyOf;
            if (i11 != this.f23574c) {
                throw new ConcurrentModificationException();
            }
            if (i10 > 0) {
                l.f(iArr, this.f23572a, 0, 0, i10);
                l.h(objArr, this.f23573b, 0, 0, i12);
            }
            if (i10 < i13) {
                int i17 = i10 + 1;
                l.f(iArr, this.f23572a, i10, i17, i11);
                l.h(objArr, this.f23573b, i12, i17 << 1, i11 << 1);
            }
        }
        if (i11 != this.f23574c) {
            throw new ConcurrentModificationException();
        }
        this.f23574c = i13;
        return obj;
    }

    public boolean isEmpty() {
        return this.f23574c <= 0;
    }

    public Object j(int i10, Object obj) {
        if (i10 < 0 || i10 >= this.f23574c) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
        }
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f23573b;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        return obj2;
    }

    public Object k(int i10) {
        if (i10 >= 0 && i10 < this.f23574c) {
            return this.f23573b[(i10 << 1) + 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
    }

    public Object put(Object obj, Object obj2) {
        int i10 = this.f23574c;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(obj, iHashCode) : f();
        if (iC >= 0) {
            int i11 = (iC << 1) + 1;
            Object[] objArr = this.f23573b;
            Object obj3 = objArr[i11];
            objArr[i11] = obj2;
            return obj3;
        }
        int i12 = ~iC;
        int[] iArr = this.f23572a;
        if (i10 >= iArr.length) {
            int i13 = 8;
            if (i10 >= 8) {
                i13 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i13 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i13);
            t.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f23572a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23573b, i13 << 1);
            t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23573b = objArrCopyOf;
            if (i10 != this.f23574c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i12 < i10) {
            int[] iArr2 = this.f23572a;
            int i14 = i12 + 1;
            l.f(iArr2, iArr2, i14, i12, i10);
            Object[] objArr2 = this.f23573b;
            l.h(objArr2, objArr2, i14 << 1, i12 << 1, this.f23574c << 1);
        }
        int i15 = this.f23574c;
        if (i10 == i15) {
            int[] iArr3 = this.f23572a;
            if (i12 < iArr3.length) {
                iArr3[i12] = iHashCode;
                Object[] objArr3 = this.f23573b;
                int i16 = i12 << 1;
                objArr3[i16] = obj;
                objArr3[i16 + 1] = obj2;
                this.f23574c = i15 + 1;
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
        int iE = e(obj);
        if (iE >= 0) {
            return i(iE);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE >= 0) {
            return j(iE, obj2);
        }
        return null;
    }

    public int size() {
        return this.f23574c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f23574c * 28);
        sb2.append('{');
        int i10 = this.f23574c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object objG = g(i11);
            if (objG != sb2) {
                sb2.append(objG);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object objK = k(i11);
            if (objK != sb2) {
                sb2.append(objK);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        t.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public i(int i10) {
        this.f23572a = i10 == 0 ? x.a.f24120a : new int[i10];
        this.f23573b = i10 == 0 ? x.a.f24122c : new Object[i10 << 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0 || !t.b(obj2, k(iE))) {
            return false;
        }
        i(iE);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iE = e(obj);
        if (iE < 0 || !t.b(obj2, k(iE))) {
            return false;
        }
        j(iE, obj3);
        return true;
    }

    public /* synthetic */ i(int i10, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    public i(i iVar) {
        this(0, 1, null);
        if (iVar != null) {
            h(iVar);
        }
    }
}
