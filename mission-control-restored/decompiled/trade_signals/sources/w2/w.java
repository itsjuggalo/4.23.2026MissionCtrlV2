package w2;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import v2.AbstractC2848n;
import w2.l;

/* JADX INFO: loaded from: classes.dex */
public final class w extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f24036h = new w(null, new Object[0], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object f24037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient Object[] f24038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f24039g;

    public static class a extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient l f24040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Object[] f24041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f24042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient int f24043f;

        /* JADX INFO: renamed from: w2.w$a$a, reason: collision with other inner class name */
        public class C0423a extends k {
            public C0423a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i8) {
                AbstractC2848n.l(i8, a.this.f24043f);
                int i9 = i8 * 2;
                Object obj = a.this.f24041d[a.this.f24042e + i9];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f24041d[i9 + (a.this.f24042e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // w2.AbstractC2921j
            public boolean n() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f24043f;
            }
        }

        public a(l lVar, Object[] objArr, int i8, int i9) {
            this.f24040c = lVar;
            this.f24041d = objArr;
            this.f24042e = i8;
            this.f24043f = i9;
        }

        @Override // w2.m
        public k I() {
            return new C0423a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: K */
        public AbstractC2910B iterator() {
            return a().iterator();
        }

        @Override // w2.AbstractC2921j, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f24040c.get(key));
        }

        @Override // w2.AbstractC2921j
        public int d(Object[] objArr, int i8) {
            return a().d(objArr, i8);
        }

        @Override // w2.AbstractC2921j
        public boolean n() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f24043f;
        }
    }

    public static final class b extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient l f24045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient k f24046d;

        public b(l lVar, k kVar) {
            this.f24045c = lVar;
            this.f24046d = kVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: K */
        public AbstractC2910B iterator() {
            return a().iterator();
        }

        @Override // w2.m, w2.AbstractC2921j
        public k a() {
            return this.f24046d;
        }

        @Override // w2.AbstractC2921j, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f24045c.get(obj) != null;
        }

        @Override // w2.AbstractC2921j
        public int d(Object[] objArr, int i8) {
            return a().d(objArr, i8);
        }

        @Override // w2.AbstractC2921j
        public boolean n() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f24045c.size();
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient Object[] f24047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f24048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f24049e;

        public c(Object[] objArr, int i8, int i9) {
            this.f24047c = objArr;
            this.f24048d = i8;
            this.f24049e = i9;
        }

        @Override // java.util.List
        public Object get(int i8) {
            AbstractC2848n.l(i8, this.f24049e);
            Object obj = this.f24047c[(i8 * 2) + this.f24048d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // w2.AbstractC2921j
        public boolean n() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f24049e;
        }
    }

    public w(Object obj, Object[] objArr, int i8) {
        this.f24037e = obj;
        this.f24038f = objArr;
        this.f24039g = i8;
    }

    public static w o(int i8, Object[] objArr) {
        return p(i8, objArr, null);
    }

    public static w p(int i8, Object[] objArr, l.a aVar) {
        if (i8 == 0) {
            return (w) f24036h;
        }
        if (i8 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            AbstractC2915d.a(obj, obj2);
            return new w(null, objArr, 1);
        }
        AbstractC2848n.q(i8, objArr.length >> 1);
        Object objQ = q(objArr, i8, m.C(i8), 0);
        if (objQ instanceof Object[]) {
            Object[] objArr2 = (Object[]) objQ;
            l.a.C0421a c0421a = (l.a.C0421a) objArr2[2];
            if (aVar == null) {
                throw c0421a.a();
            }
            aVar.f24023e = c0421a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objQ = obj3;
            i8 = iIntValue;
        }
        return new w(objQ, objArr, i8);
    }

    public static Object q(Object[] objArr, int i8, int i9, int i10) {
        l.a.C0421a c0421a = null;
        if (i8 == 1) {
            Object obj = objArr[i10];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i10 ^ 1];
            Objects.requireNonNull(obj2);
            AbstractC2915d.a(obj, obj2);
            return null;
        }
        int i11 = i9 - 1;
        int i12 = -1;
        if (i9 <= 128) {
            byte[] bArr = new byte[i9];
            Arrays.fill(bArr, (byte) -1);
            int i13 = 0;
            for (int i14 = 0; i14 < i8; i14++) {
                int i15 = (i14 * 2) + i10;
                int i16 = (i13 * 2) + i10;
                Object obj3 = objArr[i15];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i15 ^ 1];
                Objects.requireNonNull(obj4);
                AbstractC2915d.a(obj3, obj4);
                int iA = AbstractC2920i.a(obj3.hashCode());
                while (true) {
                    int i17 = iA & i11;
                    int i18 = bArr[i17] & 255;
                    if (i18 == 255) {
                        bArr[i17] = (byte) i16;
                        if (i13 < i14) {
                            objArr[i16] = obj3;
                            objArr[i16 ^ 1] = obj4;
                        }
                        i13++;
                    } else {
                        if (obj3.equals(objArr[i18])) {
                            int i19 = i18 ^ 1;
                            Object obj5 = objArr[i19];
                            Objects.requireNonNull(obj5);
                            c0421a = new l.a.C0421a(obj3, obj4, obj5);
                            objArr[i19] = obj4;
                            break;
                        }
                        iA = i17 + 1;
                    }
                }
            }
            return i13 == i8 ? bArr : new Object[]{bArr, Integer.valueOf(i13), c0421a};
        }
        if (i9 <= 32768) {
            short[] sArr = new short[i9];
            Arrays.fill(sArr, (short) -1);
            int i20 = 0;
            for (int i21 = 0; i21 < i8; i21++) {
                int i22 = (i21 * 2) + i10;
                int i23 = (i20 * 2) + i10;
                Object obj6 = objArr[i22];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i22 ^ 1];
                Objects.requireNonNull(obj7);
                AbstractC2915d.a(obj6, obj7);
                int iA2 = AbstractC2920i.a(obj6.hashCode());
                while (true) {
                    int i24 = iA2 & i11;
                    int i25 = sArr[i24] & 65535;
                    if (i25 == 65535) {
                        sArr[i24] = (short) i23;
                        if (i20 < i21) {
                            objArr[i23] = obj6;
                            objArr[i23 ^ 1] = obj7;
                        }
                        i20++;
                    } else {
                        if (obj6.equals(objArr[i25])) {
                            int i26 = i25 ^ 1;
                            Object obj8 = objArr[i26];
                            Objects.requireNonNull(obj8);
                            c0421a = new l.a.C0421a(obj6, obj7, obj8);
                            objArr[i26] = obj7;
                            break;
                        }
                        iA2 = i24 + 1;
                    }
                }
            }
            return i20 == i8 ? sArr : new Object[]{sArr, Integer.valueOf(i20), c0421a};
        }
        int[] iArr = new int[i9];
        Arrays.fill(iArr, -1);
        int i27 = 0;
        int i28 = 0;
        while (i27 < i8) {
            int i29 = (i27 * 2) + i10;
            int i30 = (i28 * 2) + i10;
            Object obj9 = objArr[i29];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i29 ^ 1];
            Objects.requireNonNull(obj10);
            AbstractC2915d.a(obj9, obj10);
            int iA3 = AbstractC2920i.a(obj9.hashCode());
            while (true) {
                int i31 = iA3 & i11;
                int i32 = iArr[i31];
                if (i32 == i12) {
                    iArr[i31] = i30;
                    if (i28 < i27) {
                        objArr[i30] = obj9;
                        objArr[i30 ^ 1] = obj10;
                    }
                    i28++;
                } else {
                    if (obj9.equals(objArr[i32])) {
                        int i33 = i32 ^ 1;
                        Object obj11 = objArr[i33];
                        Objects.requireNonNull(obj11);
                        c0421a = new l.a.C0421a(obj9, obj10, obj11);
                        objArr[i33] = obj10;
                        break;
                    }
                    iA3 = i31 + 1;
                    i12 = -1;
                }
            }
            i27++;
            i12 = -1;
        }
        return i28 == i8 ? iArr : new Object[]{iArr, Integer.valueOf(i28), c0421a};
    }

    public static Object r(Object obj, Object[] objArr, int i8, int i9, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i8 == 1) {
            Object obj3 = objArr[i9];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i9 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iA = AbstractC2920i.a(obj2.hashCode());
            while (true) {
                int i10 = iA & length;
                int i11 = bArr[i10] & 255;
                if (i11 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i11])) {
                    return objArr[i11 ^ 1];
                }
                iA = i10 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iA2 = AbstractC2920i.a(obj2.hashCode());
            while (true) {
                int i12 = iA2 & length2;
                int i13 = sArr[i12] & 65535;
                if (i13 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                iA2 = i12 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iA3 = AbstractC2920i.a(obj2.hashCode());
            while (true) {
                int i14 = iA3 & length3;
                int i15 = iArr[i14];
                if (i15 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i15])) {
                    return objArr[i15 ^ 1];
                }
                iA3 = i14 + 1;
            }
        }
    }

    @Override // w2.l
    public m d() {
        return new a(this, this.f24038f, 0, this.f24039g);
    }

    @Override // w2.l
    public m e() {
        return new b(this, new c(this.f24038f, 0, this.f24039g));
    }

    @Override // w2.l
    public AbstractC2921j f() {
        return new c(this.f24038f, 1, this.f24039g);
    }

    @Override // w2.l, java.util.Map
    public Object get(Object obj) {
        Object objR = r(this.f24037e, this.f24038f, this.f24039g, 0, obj);
        if (objR == null) {
            return null;
        }
        return objR;
    }

    @Override // w2.l
    public boolean h() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f24039g;
    }
}
