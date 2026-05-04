package q6;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import q6.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f18836h = new w(null, new Object[0], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object f18837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient Object[] f18838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f18839g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient l f18840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Object[] f18841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f18842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient int f18843f;

        /* JADX INFO: renamed from: q6.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0325a extends k {
            public C0325a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i10) {
                p6.n.l(i10, a.this.f18843f);
                int i11 = i10 * 2;
                Object obj = a.this.f18841d[a.this.f18842e + i11];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f18841d[i11 + (a.this.f18842e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // q6.j
            public boolean g() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f18843f;
            }
        }

        public a(l lVar, Object[] objArr, int i10, int i11) {
            this.f18840c = lVar;
            this.f18841d = objArr;
            this.f18842e = i10;
            this.f18843f = i11;
        }

        @Override // q6.j
        public int c(Object[] objArr, int i10) {
            return a().c(objArr, i10);
        }

        @Override // q6.j, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null && value.equals(this.f18840c.get(key))) {
                    return true;
                }
            }
            return false;
        }

        @Override // q6.j
        public boolean g() {
            return true;
        }

        @Override // q6.m
        public k s() {
            return new C0325a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f18843f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: v */
        public b0 iterator() {
            return a().iterator();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient l f18845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient k f18846d;

        public b(l lVar, k kVar) {
            this.f18845c = lVar;
            this.f18846d = kVar;
        }

        @Override // q6.m, q6.j
        public k a() {
            return this.f18846d;
        }

        @Override // q6.j
        public int c(Object[] objArr, int i10) {
            return a().c(objArr, i10);
        }

        @Override // q6.j, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f18845c.get(obj) != null;
        }

        @Override // q6.j
        public boolean g() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f18845c.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: v */
        public b0 iterator() {
            return a().iterator();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient Object[] f18847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f18848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f18849e;

        public c(Object[] objArr, int i10, int i11) {
            this.f18847c = objArr;
            this.f18848d = i10;
            this.f18849e = i11;
        }

        @Override // q6.j
        public boolean g() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i10) {
            p6.n.l(i10, this.f18849e);
            Object obj = this.f18847c[(i10 * 2) + this.f18848d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f18849e;
        }
    }

    public w(Object obj, Object[] objArr, int i10) {
        this.f18837e = obj;
        this.f18838f = objArr;
        this.f18839g = i10;
    }

    public static w p(int i10, Object[] objArr) {
        return q(i10, objArr, null);
    }

    public static w q(int i10, Object[] objArr, l.a aVar) {
        if (i10 == 0) {
            return (w) f18836h;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            d.a(obj, obj2);
            return new w(null, objArr, 1);
        }
        p6.n.q(i10, objArr.length >> 1);
        Object objR = r(objArr, i10, m.p(i10), 0);
        if (objR instanceof Object[]) {
            Object[] objArr2 = (Object[]) objR;
            l.a.C0323a c0323a = (l.a.C0323a) objArr2[2];
            if (aVar == null) {
                throw c0323a.a();
            }
            aVar.f18823e = c0323a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objR = obj3;
            i10 = iIntValue;
        }
        return new w(objR, objArr, i10);
    }

    public static Object r(Object[] objArr, int i10, int i11, int i12) {
        int i13;
        l.a.C0323a c0323a = null;
        int i14 = 1;
        if (i10 == 1) {
            Object obj = objArr[i12];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i12 ^ 1];
            Objects.requireNonNull(obj2);
            d.a(obj, obj2);
            return null;
        }
        int i15 = i11 - 1;
        if (i11 <= 128) {
            byte[] bArr = new byte[i11];
            Arrays.fill(bArr, (byte) -1);
            int i16 = 0;
            for (int i17 = 0; i17 < i10; i17++) {
                int i18 = (i17 * 2) + i12;
                int i19 = (i16 * 2) + i12;
                Object obj3 = objArr[i18];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i18 ^ 1];
                Objects.requireNonNull(obj4);
                d.a(obj3, obj4);
                int iA = i.a(obj3.hashCode());
                while (true) {
                    int i20 = iA & i15;
                    int i21 = bArr[i20] & 255;
                    if (i21 == 255) {
                        bArr[i20] = (byte) i19;
                        if (i16 < i17) {
                            objArr[i19] = obj3;
                            objArr[i19 ^ 1] = obj4;
                        }
                        i16++;
                    } else {
                        if (obj3.equals(objArr[i21])) {
                            int i22 = i21 ^ 1;
                            Object obj5 = objArr[i22];
                            Objects.requireNonNull(obj5);
                            c0323a = new l.a.C0323a(obj3, obj4, obj5);
                            objArr[i22] = obj4;
                            break;
                        }
                        iA = i20 + 1;
                    }
                }
            }
            return i16 == i10 ? bArr : new Object[]{bArr, Integer.valueOf(i16), c0323a};
        }
        if (i11 <= 32768) {
            short[] sArr = new short[i11];
            Arrays.fill(sArr, (short) -1);
            int i23 = 0;
            for (int i24 = 0; i24 < i10; i24++) {
                int i25 = (i24 * 2) + i12;
                int i26 = (i23 * 2) + i12;
                Object obj6 = objArr[i25];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i25 ^ 1];
                Objects.requireNonNull(obj7);
                d.a(obj6, obj7);
                int iA2 = i.a(obj6.hashCode());
                while (true) {
                    int i27 = iA2 & i15;
                    int i28 = sArr[i27] & 65535;
                    if (i28 == 65535) {
                        sArr[i27] = (short) i26;
                        if (i23 < i24) {
                            objArr[i26] = obj6;
                            objArr[i26 ^ 1] = obj7;
                        }
                        i23++;
                    } else {
                        if (obj6.equals(objArr[i28])) {
                            int i29 = i28 ^ 1;
                            Object obj8 = objArr[i29];
                            Objects.requireNonNull(obj8);
                            c0323a = new l.a.C0323a(obj6, obj7, obj8);
                            objArr[i29] = obj7;
                            break;
                        }
                        iA2 = i27 + 1;
                    }
                }
            }
            return i23 == i10 ? sArr : new Object[]{sArr, Integer.valueOf(i23), c0323a};
        }
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        int i30 = 0;
        int i31 = 0;
        while (i30 < i10) {
            int i32 = (i30 * 2) + i12;
            int i33 = (i31 * 2) + i12;
            Object obj9 = objArr[i32];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i32 ^ i14];
            Objects.requireNonNull(obj10);
            d.a(obj9, obj10);
            int iA3 = i.a(obj9.hashCode());
            while (true) {
                int i34 = iA3 & i15;
                int i35 = iArr[i34];
                if (i35 == -1) {
                    iArr[i34] = i33;
                    if (i31 < i30) {
                        objArr[i33] = obj9;
                        objArr[i33 ^ 1] = obj10;
                    }
                    i31++;
                    i13 = i14;
                } else {
                    i13 = i14;
                    if (obj9.equals(objArr[i35])) {
                        int i36 = i35 ^ 1;
                        Object obj11 = objArr[i36];
                        Objects.requireNonNull(obj11);
                        c0323a = new l.a.C0323a(obj9, obj10, obj11);
                        objArr[i36] = obj10;
                        break;
                    }
                    iA3 = i34 + 1;
                    i14 = i13;
                }
            }
            i30++;
            i14 = i13;
        }
        int i37 = i14;
        if (i31 == i10) {
            return iArr;
        }
        Object[] objArr2 = new Object[3];
        objArr2[0] = iArr;
        objArr2[i37] = Integer.valueOf(i31);
        objArr2[2] = c0323a;
        return objArr2;
    }

    public static Object s(Object obj, Object[] objArr, int i10, int i11, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i10 == 1) {
            Object obj3 = objArr[i11];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i11 ^ 1];
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
                int i12 = iA & length;
                int i13 = bArr[i12] & 255;
                if (i13 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                iA = i12 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iA2 = i.a(obj2.hashCode());
            while (true) {
                int i14 = iA2 & length2;
                int i15 = sArr[i14] & 65535;
                if (i15 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i15])) {
                    return objArr[i15 ^ 1];
                }
                iA2 = i14 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iA3 = i.a(obj2.hashCode());
            while (true) {
                int i16 = iA3 & length3;
                int i17 = iArr[i16];
                if (i17 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i17])) {
                    return objArr[i17 ^ 1];
                }
                iA3 = i16 + 1;
            }
        }
    }

    @Override // q6.l
    public m e() {
        return new a(this, this.f18838f, 0, this.f18839g);
    }

    @Override // q6.l
    public m f() {
        return new b(this, new c(this.f18838f, 0, this.f18839g));
    }

    @Override // q6.l
    public j g() {
        return new c(this.f18838f, 1, this.f18839g);
    }

    @Override // q6.l, java.util.Map
    public Object get(Object obj) {
        Object objS = s(this.f18837e, this.f18838f, this.f18839g, 0, obj);
        if (objS == null) {
            return null;
        }
        return objS;
    }

    @Override // q6.l
    public boolean i() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f18839g;
    }
}
