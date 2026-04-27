package I2;

import I2.l;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class w extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f2988h = new w(null, new Object[0], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object f2989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient Object[] f2990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f2991g;

    public static class a extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient l f2992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Object[] f2993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f2994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient int f2995f;

        /* JADX INFO: renamed from: I2.w$a$a, reason: collision with other inner class name */
        public class C0033a extends k {
            public C0033a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i7) {
                H2.m.l(i7, a.this.f2995f);
                int i8 = i7 * 2;
                Object obj = a.this.f2993d[a.this.f2994e + i8];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f2993d[i8 + (a.this.f2994e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // I2.j
            public boolean j() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f2995f;
            }
        }

        public a(l lVar, Object[] objArr, int i7, int i8) {
            this.f2992c = lVar;
            this.f2993d = objArr;
            this.f2994e = i7;
            this.f2995f = i8;
        }

        @Override // I2.j
        public int b(Object[] objArr, int i7) {
            return a().b(objArr, i7);
        }

        @Override // I2.j, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f2992c.get(key));
        }

        @Override // I2.j
        public boolean j() {
            return true;
        }

        @Override // I2.m
        public k n() {
            return new C0033a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: q */
        public B iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f2995f;
        }
    }

    public static final class b extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient l f2997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient k f2998d;

        public b(l lVar, k kVar) {
            this.f2997c = lVar;
            this.f2998d = kVar;
        }

        @Override // I2.m, I2.j
        public k a() {
            return this.f2998d;
        }

        @Override // I2.j
        public int b(Object[] objArr, int i7) {
            return a().b(objArr, i7);
        }

        @Override // I2.j, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f2997c.get(obj) != null;
        }

        @Override // I2.j
        public boolean j() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: q */
        public B iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f2997c.size();
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient Object[] f2999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f3000d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f3001e;

        public c(Object[] objArr, int i7, int i8) {
            this.f2999c = objArr;
            this.f3000d = i7;
            this.f3001e = i8;
        }

        @Override // java.util.List
        public Object get(int i7) {
            H2.m.l(i7, this.f3001e);
            Object obj = this.f2999c[(i7 * 2) + this.f3000d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // I2.j
        public boolean j() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f3001e;
        }
    }

    public w(Object obj, Object[] objArr, int i7) {
        this.f2989e = obj;
        this.f2990f = objArr;
        this.f2991g = i7;
    }

    public static w p(int i7, Object[] objArr) {
        return q(i7, objArr, null);
    }

    public static w q(int i7, Object[] objArr, l.a aVar) {
        if (i7 == 0) {
            return (w) f2988h;
        }
        if (i7 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            d.a(obj, obj2);
            return new w(null, objArr, 1);
        }
        H2.m.q(i7, objArr.length >> 1);
        Object objR = r(objArr, i7, m.k(i7), 0);
        if (objR instanceof Object[]) {
            Object[] objArr2 = (Object[]) objR;
            l.a.C0031a c0031a = (l.a.C0031a) objArr2[2];
            if (aVar == null) {
                throw c0031a.a();
            }
            aVar.f2975e = c0031a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objR = obj3;
            i7 = iIntValue;
        }
        return new w(objR, objArr, i7);
    }

    public static Object r(Object[] objArr, int i7, int i8, int i9) {
        l.a.C0031a c0031a = null;
        if (i7 == 1) {
            Object obj = objArr[i9];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i9 ^ 1];
            Objects.requireNonNull(obj2);
            d.a(obj, obj2);
            return null;
        }
        int i10 = i8 - 1;
        int i11 = -1;
        if (i8 <= 128) {
            byte[] bArr = new byte[i8];
            Arrays.fill(bArr, (byte) -1);
            int i12 = 0;
            for (int i13 = 0; i13 < i7; i13++) {
                int i14 = (i13 * 2) + i9;
                int i15 = (i12 * 2) + i9;
                Object obj3 = objArr[i14];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i14 ^ 1];
                Objects.requireNonNull(obj4);
                d.a(obj3, obj4);
                int iA = i.a(obj3.hashCode());
                while (true) {
                    int i16 = iA & i10;
                    int i17 = bArr[i16] & 255;
                    if (i17 == 255) {
                        bArr[i16] = (byte) i15;
                        if (i12 < i13) {
                            objArr[i15] = obj3;
                            objArr[i15 ^ 1] = obj4;
                        }
                        i12++;
                    } else {
                        if (obj3.equals(objArr[i17])) {
                            int i18 = i17 ^ 1;
                            Object obj5 = objArr[i18];
                            Objects.requireNonNull(obj5);
                            c0031a = new l.a.C0031a(obj3, obj4, obj5);
                            objArr[i18] = obj4;
                            break;
                        }
                        iA = i16 + 1;
                    }
                }
            }
            return i12 == i7 ? bArr : new Object[]{bArr, Integer.valueOf(i12), c0031a};
        }
        if (i8 <= 32768) {
            short[] sArr = new short[i8];
            Arrays.fill(sArr, (short) -1);
            int i19 = 0;
            for (int i20 = 0; i20 < i7; i20++) {
                int i21 = (i20 * 2) + i9;
                int i22 = (i19 * 2) + i9;
                Object obj6 = objArr[i21];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i21 ^ 1];
                Objects.requireNonNull(obj7);
                d.a(obj6, obj7);
                int iA2 = i.a(obj6.hashCode());
                while (true) {
                    int i23 = iA2 & i10;
                    int i24 = sArr[i23] & 65535;
                    if (i24 == 65535) {
                        sArr[i23] = (short) i22;
                        if (i19 < i20) {
                            objArr[i22] = obj6;
                            objArr[i22 ^ 1] = obj7;
                        }
                        i19++;
                    } else {
                        if (obj6.equals(objArr[i24])) {
                            int i25 = i24 ^ 1;
                            Object obj8 = objArr[i25];
                            Objects.requireNonNull(obj8);
                            c0031a = new l.a.C0031a(obj6, obj7, obj8);
                            objArr[i25] = obj7;
                            break;
                        }
                        iA2 = i23 + 1;
                    }
                }
            }
            return i19 == i7 ? sArr : new Object[]{sArr, Integer.valueOf(i19), c0031a};
        }
        int[] iArr = new int[i8];
        Arrays.fill(iArr, -1);
        int i26 = 0;
        int i27 = 0;
        while (i26 < i7) {
            int i28 = (i26 * 2) + i9;
            int i29 = (i27 * 2) + i9;
            Object obj9 = objArr[i28];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i28 ^ 1];
            Objects.requireNonNull(obj10);
            d.a(obj9, obj10);
            int iA3 = i.a(obj9.hashCode());
            while (true) {
                int i30 = iA3 & i10;
                int i31 = iArr[i30];
                if (i31 == i11) {
                    iArr[i30] = i29;
                    if (i27 < i26) {
                        objArr[i29] = obj9;
                        objArr[i29 ^ 1] = obj10;
                    }
                    i27++;
                } else {
                    if (obj9.equals(objArr[i31])) {
                        int i32 = i31 ^ 1;
                        Object obj11 = objArr[i32];
                        Objects.requireNonNull(obj11);
                        c0031a = new l.a.C0031a(obj9, obj10, obj11);
                        objArr[i32] = obj10;
                        break;
                    }
                    iA3 = i30 + 1;
                    i11 = -1;
                }
            }
            i26++;
            i11 = -1;
        }
        return i27 == i7 ? iArr : new Object[]{iArr, Integer.valueOf(i27), c0031a};
    }

    public static Object s(Object obj, Object[] objArr, int i7, int i8, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i7 == 1) {
            Object obj3 = objArr[i8];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i8 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iA = i.a(obj2.hashCode());
            while (true) {
                int i9 = iA & length;
                int i10 = bArr[i9] & 255;
                if (i10 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i10])) {
                    return objArr[i10 ^ 1];
                }
                iA = i9 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iA2 = i.a(obj2.hashCode());
            while (true) {
                int i11 = iA2 & length2;
                int i12 = sArr[i11] & 65535;
                if (i12 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i12])) {
                    return objArr[i12 ^ 1];
                }
                iA2 = i11 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iA3 = i.a(obj2.hashCode());
            while (true) {
                int i13 = iA3 & length3;
                int i14 = iArr[i13];
                if (i14 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i14])) {
                    return objArr[i14 ^ 1];
                }
                iA3 = i13 + 1;
            }
        }
    }

    @Override // I2.l
    public m e() {
        return new a(this, this.f2990f, 0, this.f2991g);
    }

    @Override // I2.l
    public m f() {
        return new b(this, new c(this.f2990f, 0, this.f2991g));
    }

    @Override // I2.l
    public j g() {
        return new c(this.f2990f, 1, this.f2991g);
    }

    @Override // I2.l, java.util.Map
    public Object get(Object obj) {
        Object objS = s(this.f2989e, this.f2990f, this.f2991g, 0, obj);
        if (objS == null) {
            return null;
        }
        return objS;
    }

    @Override // I2.l
    public boolean i() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f2991g;
    }
}
