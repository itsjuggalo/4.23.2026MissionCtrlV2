package a2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends j implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient k f6150b;

    public static int n(int i4) {
        int iMax = Math.max(i4, 2);
        if (iMax >= 751619276) {
            Z1.m.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static m o(int i4, Object... objArr) {
        if (i4 == 0) {
            return t();
        }
        if (i4 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return u(obj);
        }
        int iN = n(i4);
        Object[] objArr2 = new Object[iN];
        int i5 = iN - 1;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            Object objA = s.a(objArr[i8], i8);
            int iHashCode = objA.hashCode();
            int iA = i.a(iHashCode);
            while (true) {
                int i9 = iA & i5;
                Object obj2 = objArr2[i9];
                if (obj2 == null) {
                    objArr[i7] = objA;
                    objArr2[i9] = objA;
                    i6 += iHashCode;
                    i7++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iA++;
            }
        }
        Arrays.fill(objArr, i7, i4, (Object) null);
        if (i7 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new z(obj3);
        }
        if (n(i7) < iN / 2) {
            return o(i7, objArr);
        }
        if (x(i7, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i7);
        }
        return new x(objArr, i6, objArr2, i5, i7);
    }

    public static m p(Collection collection) {
        if ((collection instanceof m) && !(collection instanceof SortedSet)) {
            m mVar = (m) collection;
            if (!mVar.m()) {
                return mVar;
            }
        }
        Object[] array = collection.toArray();
        return o(array.length, array);
    }

    public static m t() {
        return x.f6174i;
    }

    public static m u(Object obj) {
        return new z(obj);
    }

    public static m v(Object obj, Object obj2, Object obj3) {
        return o(3, obj, obj2, obj3);
    }

    public static m w(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Z1.m.e(objArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return o(length, objArr2);
    }

    public static boolean x(int i4, int i5) {
        return i4 < (i5 >> 1) + (i5 >> 2);
    }

    @Override // a2.j
    public k c() {
        k kVar = this.f6150b;
        if (kVar != null) {
            return kVar;
        }
        k kVarQ = q();
        this.f6150b = kVarQ;
        return kVarQ;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof m) && r() && ((m) obj).r() && hashCode() != obj.hashCode()) {
            return false;
        }
        return y.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return y.b(this);
    }

    public k q() {
        return k.n(toArray());
    }

    public boolean r() {
        return false;
    }

    /* JADX INFO: renamed from: s */
    public abstract B iterator();
}
