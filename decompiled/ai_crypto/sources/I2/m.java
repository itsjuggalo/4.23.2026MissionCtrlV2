package I2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends j implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient k f2979b;

    public static int k(int i7) {
        int iMax = Math.max(i7, 2);
        if (iMax >= 751619276) {
            H2.m.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static m l(int i7, Object... objArr) {
        if (i7 == 0) {
            return r();
        }
        if (i7 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return s(obj);
        }
        int iK = k(i7);
        Object[] objArr2 = new Object[iK];
        int i8 = iK - 1;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i7; i11++) {
            Object objA = s.a(objArr[i11], i11);
            int iHashCode = objA.hashCode();
            int iA = i.a(iHashCode);
            while (true) {
                int i12 = iA & i8;
                Object obj2 = objArr2[i12];
                if (obj2 == null) {
                    objArr[i10] = objA;
                    objArr2[i12] = objA;
                    i9 += iHashCode;
                    i10++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iA++;
            }
        }
        Arrays.fill(objArr, i10, i7, (Object) null);
        if (i10 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new z(obj3);
        }
        if (k(i10) < iK / 2) {
            return l(i10, objArr);
        }
        if (w(i10, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i10);
        }
        return new x(objArr, i9, objArr2, i8, i10);
    }

    public static m m(Collection collection) {
        if ((collection instanceof m) && !(collection instanceof SortedSet)) {
            m mVar = (m) collection;
            if (!mVar.j()) {
                return mVar;
            }
        }
        Object[] array = collection.toArray();
        return l(array.length, array);
    }

    public static m r() {
        return x.f3003i;
    }

    public static m s(Object obj) {
        return new z(obj);
    }

    public static m t(Object obj, Object obj2, Object obj3) {
        return l(3, obj, obj2, obj3);
    }

    public static m u(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        H2.m.e(objArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return l(length, objArr2);
    }

    public static boolean w(int i7, int i8) {
        return i7 < (i8 >> 1) + (i8 >> 2);
    }

    @Override // I2.j
    public k a() {
        k kVar = this.f2979b;
        if (kVar != null) {
            return kVar;
        }
        k kVarN = n();
        this.f2979b = kVarN;
        return kVarN;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof m) && p() && ((m) obj).p() && hashCode() != obj.hashCode()) {
            return false;
        }
        return y.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return y.b(this);
    }

    public k n() {
        return k.k(toArray());
    }

    public boolean p() {
        return false;
    }

    /* JADX INFO: renamed from: q */
    public abstract B iterator();
}
