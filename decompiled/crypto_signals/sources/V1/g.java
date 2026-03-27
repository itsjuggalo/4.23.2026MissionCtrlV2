package V1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends a implements Set {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3204c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient e f3205b;

    public static int l(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            D.f("collection too large", iMax < 1073741824);
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static g m(int i, Object... objArr) {
        if (i == 0) {
            return o.f3223n;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new r(obj);
        }
        int iL = l(i);
        Object[] objArr2 = new Object[iL];
        int i6 = iL - 1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            Object obj2 = objArr[i9];
            if (obj2 == null) {
                throw new NullPointerException(a3.d.f(i9, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iT = y5.a.T(iHashCode);
            while (true) {
                int i10 = iT & i6;
                Object obj3 = objArr2[i10];
                if (obj3 == null) {
                    objArr[i8] = obj2;
                    objArr2[i10] = obj2;
                    i7 += iHashCode;
                    i8++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iT++;
            }
        }
        Arrays.fill(objArr, i8, i, (Object) null);
        if (i8 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new r(obj4);
        }
        if (l(i8) < iL / 2) {
            return m(i8, objArr);
        }
        int length = objArr.length;
        if (i8 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i8);
        }
        return new o(objArr, i7, objArr2, i6, i8);
    }

    @Override // V1.a
    public e a() {
        e eVar = this.f3205b;
        if (eVar != null) {
            return eVar;
        }
        e eVarN = n();
        this.f3205b = eVarN;
        return eVarN;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof g) && (this instanceof o)) {
            g gVar = (g) obj;
            gVar.getClass();
            if ((gVar instanceof o) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (size() == set.size()) {
                        if (containsAll(set)) {
                        }
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public e n() {
        Object[] array = toArray(a.f3190a);
        c cVar = e.f3200b;
        return e.l(array.length, array);
    }
}
