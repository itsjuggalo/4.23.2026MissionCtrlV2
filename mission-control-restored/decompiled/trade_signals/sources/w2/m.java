package w2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends AbstractC2921j implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient k f24027b;

    public static int C(int i8) {
        int iMax = Math.max(i8, 2);
        if (iMax >= 751619276) {
            AbstractC2848n.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static m F(int i8, Object... objArr) {
        if (i8 == 0) {
            return L();
        }
        if (i8 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return M(obj);
        }
        int iC = C(i8);
        Object[] objArr2 = new Object[iC];
        int i9 = iC - 1;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i8; i12++) {
            Object objA = s.a(objArr[i12], i12);
            int iHashCode = objA.hashCode();
            int iA = AbstractC2920i.a(iHashCode);
            while (true) {
                int i13 = iA & i9;
                Object obj2 = objArr2[i13];
                if (obj2 == null) {
                    objArr[i11] = objA;
                    objArr2[i13] = objA;
                    i10 += iHashCode;
                    i11++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iA++;
            }
        }
        Arrays.fill(objArr, i11, i8, (Object) null);
        if (i11 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new z(obj3);
        }
        if (C(i11) < iC / 2) {
            return F(i11, objArr);
        }
        if (P(i11, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i11);
        }
        return new x(objArr, i10, objArr2, i9, i11);
    }

    public static m H(Collection collection) {
        if ((collection instanceof m) && !(collection instanceof SortedSet)) {
            m mVar = (m) collection;
            if (!mVar.n()) {
                return mVar;
            }
        }
        Object[] array = collection.toArray();
        return F(array.length, array);
    }

    public static m L() {
        return x.f24051i;
    }

    public static m M(Object obj) {
        return new z(obj);
    }

    public static m N(Object obj, Object obj2, Object obj3) {
        return F(3, obj, obj2, obj3);
    }

    public static m O(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        AbstractC2848n.e(objArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return F(length, objArr2);
    }

    public static boolean P(int i8, int i9) {
        return i8 < (i9 >> 1) + (i9 >> 2);
    }

    public k I() {
        return k.C(toArray());
    }

    public boolean J() {
        return false;
    }

    /* JADX INFO: renamed from: K */
    public abstract AbstractC2910B iterator();

    @Override // w2.AbstractC2921j
    public k a() {
        k kVar = this.f24027b;
        if (kVar != null) {
            return kVar;
        }
        k kVarI = I();
        this.f24027b = kVarI;
        return kVarI;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof m) && J() && ((m) obj).J() && hashCode() != obj.hashCode()) {
            return false;
        }
        return y.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return y.b(this);
    }
}
