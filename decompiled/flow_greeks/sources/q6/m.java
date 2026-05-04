package q6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends j implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient k f18827b;

    public static m A(Object obj, Object obj2, Object obj3) {
        return q(3, obj, obj2, obj3);
    }

    public static m G(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        p6.n.e(objArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return q(length, objArr2);
    }

    public static boolean K(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    public static int p(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax >= 751619276) {
            p6.n.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static m q(int i10, Object... objArr) {
        if (i10 == 0) {
            return w();
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return y(obj);
        }
        int iP = p(i10);
        Object[] objArr2 = new Object[iP];
        int i11 = iP - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object objA = s.a(objArr[i14], i14);
            int iHashCode = objA.hashCode();
            int iA = i.a(iHashCode);
            while (true) {
                int i15 = iA & i11;
                Object obj2 = objArr2[i15];
                if (obj2 == null) {
                    objArr[i13] = objA;
                    objArr2[i15] = objA;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iA++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new z(obj3);
        }
        if (p(i13) < iP / 2) {
            return q(i13, objArr);
        }
        if (K(i13, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new x(objArr, i12, objArr2, i11, i13);
    }

    public static m r(Collection collection) {
        if ((collection instanceof m) && !(collection instanceof SortedSet)) {
            m mVar = (m) collection;
            if (!mVar.g()) {
                return mVar;
            }
        }
        Object[] array = collection.toArray();
        return q(array.length, array);
    }

    public static m w() {
        return x.f18851i;
    }

    public static m y(Object obj) {
        return new z(obj);
    }

    @Override // q6.j
    public k a() {
        k kVar = this.f18827b;
        if (kVar != null) {
            return kVar;
        }
        k kVarS = s();
        this.f18827b = kVarS;
        return kVarS;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof m) && u() && ((m) obj).u() && hashCode() != obj.hashCode()) {
            return false;
        }
        return y.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return y.b(this);
    }

    public k s() {
        return k.p(toArray());
    }

    public boolean u() {
        return false;
    }

    /* JADX INFO: renamed from: v */
    public abstract b0 iterator();
}
