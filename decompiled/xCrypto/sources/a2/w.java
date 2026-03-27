package a2;

import a2.l;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class w extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f6159h = new w(null, new Object[0], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object f6160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient Object[] f6161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f6162g;

    public static class a extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient l f6163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Object[] f6164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f6165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient int f6166f;

        /* JADX INFO: renamed from: a2.w$a$a, reason: collision with other inner class name */
        public class C0089a extends k {
            public C0089a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i4) {
                Z1.m.l(i4, a.this.f6166f);
                int i5 = i4 * 2;
                Object obj = a.this.f6164d[a.this.f6165e + i5];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f6164d[i5 + (a.this.f6165e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // a2.j
            public boolean m() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f6166f;
            }
        }

        public a(l lVar, Object[] objArr, int i4, int i5) {
            this.f6163c = lVar;
            this.f6164d = objArr;
            this.f6165e = i4;
            this.f6166f = i5;
        }

        @Override // a2.j, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null && value.equals(this.f6163c.get(key))) {
                    return true;
                }
            }
            return false;
        }

        @Override // a2.j
        public int f(Object[] objArr, int i4) {
            return c().f(objArr, i4);
        }

        @Override // a2.j
        public boolean m() {
            return true;
        }

        @Override // a2.m
        public k q() {
            return new C0089a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: s */
        public B iterator() {
            return c().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f6166f;
        }
    }

    public static final class b extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient l f6168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient k f6169d;

        public b(l lVar, k kVar) {
            this.f6168c = lVar;
            this.f6169d = kVar;
        }

        @Override // a2.m, a2.j
        public k c() {
            return this.f6169d;
        }

        @Override // a2.j, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f6168c.get(obj) != null;
        }

        @Override // a2.j
        public int f(Object[] objArr, int i4) {
            return c().f(objArr, i4);
        }

        @Override // a2.j
        public boolean m() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: s */
        public B iterator() {
            return c().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f6168c.size();
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient Object[] f6170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f6171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f6172e;

        public c(Object[] objArr, int i4, int i5) {
            this.f6170c = objArr;
            this.f6171d = i4;
            this.f6172e = i5;
        }

        @Override // java.util.List
        public Object get(int i4) {
            Z1.m.l(i4, this.f6172e);
            Object obj = this.f6170c[(i4 * 2) + this.f6171d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // a2.j
        public boolean m() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f6172e;
        }
    }

    public w(Object obj, Object[] objArr, int i4) {
        this.f6160e = obj;
        this.f6161f = objArr;
        this.f6162g = i4;
    }

    public static w p(int i4, Object[] objArr) {
        return q(i4, objArr, null);
    }

    public static w q(int i4, Object[] objArr, l.a aVar) {
        if (i4 == 0) {
            return (w) f6159h;
        }
        if (i4 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            d.a(obj, obj2);
            return new w(null, objArr, 1);
        }
        Z1.m.q(i4, objArr.length >> 1);
        Object objR = r(objArr, i4, m.n(i4), 0);
        if (objR instanceof Object[]) {
            Object[] objArr2 = (Object[]) objR;
            l.a.C0087a c0087a = (l.a.C0087a) objArr2[2];
            if (aVar == null) {
                throw c0087a.a();
            }
            aVar.f6146e = c0087a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objR = obj3;
            i4 = iIntValue;
        }
        return new w(objR, objArr, i4);
    }

    public static Object r(Object[] objArr, int i4, int i5, int i6) {
        int i7;
        l.a.C0087a c0087a = null;
        int i8 = 1;
        if (i4 == 1) {
            Object obj = objArr[i6];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i6 ^ 1];
            Objects.requireNonNull(obj2);
            d.a(obj, obj2);
            return null;
        }
        int i9 = i5 - 1;
        if (i5 <= 128) {
            byte[] bArr = new byte[i5];
            Arrays.fill(bArr, (byte) -1);
            int i10 = 0;
            for (int i11 = 0; i11 < i4; i11++) {
                int i12 = (i11 * 2) + i6;
                int i13 = (i10 * 2) + i6;
                Object obj3 = objArr[i12];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i12 ^ 1];
                Objects.requireNonNull(obj4);
                d.a(obj3, obj4);
                int iA = i.a(obj3.hashCode());
                while (true) {
                    int i14 = iA & i9;
                    int i15 = bArr[i14] & 255;
                    if (i15 == 255) {
                        bArr[i14] = (byte) i13;
                        if (i10 < i11) {
                            objArr[i13] = obj3;
                            objArr[i13 ^ 1] = obj4;
                        }
                        i10++;
                    } else {
                        if (obj3.equals(objArr[i15])) {
                            int i16 = i15 ^ 1;
                            Object obj5 = objArr[i16];
                            Objects.requireNonNull(obj5);
                            c0087a = new l.a.C0087a(obj3, obj4, obj5);
                            objArr[i16] = obj4;
                            break;
                        }
                        iA = i14 + 1;
                    }
                }
            }
            return i10 == i4 ? bArr : new Object[]{bArr, Integer.valueOf(i10), c0087a};
        }
        if (i5 <= 32768) {
            short[] sArr = new short[i5];
            Arrays.fill(sArr, (short) -1);
            int i17 = 0;
            for (int i18 = 0; i18 < i4; i18++) {
                int i19 = (i18 * 2) + i6;
                int i20 = (i17 * 2) + i6;
                Object obj6 = objArr[i19];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i19 ^ 1];
                Objects.requireNonNull(obj7);
                d.a(obj6, obj7);
                int iA2 = i.a(obj6.hashCode());
                while (true) {
                    int i21 = iA2 & i9;
                    int i22 = sArr[i21] & 65535;
                    if (i22 == 65535) {
                        sArr[i21] = (short) i20;
                        if (i17 < i18) {
                            objArr[i20] = obj6;
                            objArr[i20 ^ 1] = obj7;
                        }
                        i17++;
                    } else {
                        if (obj6.equals(objArr[i22])) {
                            int i23 = i22 ^ 1;
                            Object obj8 = objArr[i23];
                            Objects.requireNonNull(obj8);
                            c0087a = new l.a.C0087a(obj6, obj7, obj8);
                            objArr[i23] = obj7;
                            break;
                        }
                        iA2 = i21 + 1;
                    }
                }
            }
            return i17 == i4 ? sArr : new Object[]{sArr, Integer.valueOf(i17), c0087a};
        }
        int[] iArr = new int[i5];
        Arrays.fill(iArr, -1);
        int i24 = 0;
        int i25 = 0;
        while (i24 < i4) {
            int i26 = (i24 * 2) + i6;
            int i27 = (i25 * 2) + i6;
            Object obj9 = objArr[i26];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i26 ^ i8];
            Objects.requireNonNull(obj10);
            d.a(obj9, obj10);
            int iA3 = i.a(obj9.hashCode());
            while (true) {
                int i28 = iA3 & i9;
                int i29 = iArr[i28];
                if (i29 == -1) {
                    iArr[i28] = i27;
                    if (i25 < i24) {
                        objArr[i27] = obj9;
                        objArr[i27 ^ 1] = obj10;
                    }
                    i25++;
                    i7 = i8;
                } else {
                    i7 = i8;
                    if (obj9.equals(objArr[i29])) {
                        int i30 = i29 ^ 1;
                        Object obj11 = objArr[i30];
                        Objects.requireNonNull(obj11);
                        c0087a = new l.a.C0087a(obj9, obj10, obj11);
                        objArr[i30] = obj10;
                        break;
                    }
                    iA3 = i28 + 1;
                    i8 = i7;
                }
            }
            i24++;
            i8 = i7;
        }
        int i31 = i8;
        if (i25 == i4) {
            return iArr;
        }
        Object[] objArr2 = new Object[3];
        objArr2[0] = iArr;
        objArr2[i31] = Integer.valueOf(i25);
        objArr2[2] = c0087a;
        return objArr2;
    }

    public static Object s(Object obj, Object[] objArr, int i4, int i5, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i4 == 1) {
            Object obj3 = objArr[i5];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i5 ^ 1];
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
                int i6 = iA & length;
                int i7 = bArr[i6] & 255;
                if (i7 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i7])) {
                    return objArr[i7 ^ 1];
                }
                iA = i6 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iA2 = i.a(obj2.hashCode());
            while (true) {
                int i8 = iA2 & length2;
                int i9 = sArr[i8] & 65535;
                if (i9 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i9])) {
                    return objArr[i9 ^ 1];
                }
                iA2 = i8 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iA3 = i.a(obj2.hashCode());
            while (true) {
                int i10 = iA3 & length3;
                int i11 = iArr[i10];
                if (i11 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i11])) {
                    return objArr[i11 ^ 1];
                }
                iA3 = i10 + 1;
            }
        }
    }

    @Override // a2.l
    public m e() {
        return new a(this, this.f6161f, 0, this.f6162g);
    }

    @Override // a2.l
    public m f() {
        return new b(this, new c(this.f6161f, 0, this.f6162g));
    }

    @Override // a2.l
    public j g() {
        return new c(this.f6161f, 1, this.f6162g);
    }

    @Override // a2.l, java.util.Map
    public Object get(Object obj) {
        Object objS = s(this.f6160e, this.f6161f, this.f6162g, 0, obj);
        if (objS == null) {
            return null;
        }
        return objS;
    }

    @Override // a2.l
    public boolean i() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f6162g;
    }
}
