package gf;

import com.google.android.gms.common.api.a;
import gf.d;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class t extends gf.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f10696h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f10698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gf.d f10699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10702g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack f10703a;

        public b() {
            this.f10703a = new Stack();
        }

        public final gf.d b(gf.d dVar, gf.d dVar2) {
            c(dVar);
            c(dVar2);
            gf.d tVar = (gf.d) this.f10703a.pop();
            while (!this.f10703a.isEmpty()) {
                tVar = new t((gf.d) this.f10703a.pop(), tVar);
            }
            return tVar;
        }

        public final void c(gf.d dVar) {
            if (dVar.s()) {
                e(dVar);
                return;
            }
            if (dVar instanceof t) {
                t tVar = (t) dVar;
                c(tVar.f10698c);
                c(tVar.f10699d);
            } else {
                String strValueOf = String.valueOf(dVar.getClass());
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
                sb2.append("Has a new type of ByteString been created? Found ");
                sb2.append(strValueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        public final int d(int i10) {
            int iBinarySearch = Arrays.binarySearch(t.f10696h, i10);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        public final void e(gf.d dVar) {
            int iD = d(dVar.size());
            int i10 = t.f10696h[iD + 1];
            if (this.f10703a.isEmpty() || ((gf.d) this.f10703a.peek()).size() >= i10) {
                this.f10703a.push(dVar);
                return;
            }
            int i11 = t.f10696h[iD];
            gf.d tVar = (gf.d) this.f10703a.pop();
            while (true) {
                if (this.f10703a.isEmpty() || ((gf.d) this.f10703a.peek()).size() >= i11) {
                    break;
                } else {
                    tVar = new t((gf.d) this.f10703a.pop(), tVar);
                }
            }
            t tVar2 = new t(tVar, dVar);
            while (!this.f10703a.isEmpty()) {
                if (((gf.d) this.f10703a.peek()).size() >= t.f10696h[d(tVar2.size()) + 1]) {
                    break;
                } else {
                    tVar2 = new t((gf.d) this.f10703a.pop(), tVar2);
                }
            }
            this.f10703a.push(tVar2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack f10704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f10705b;

        public final o b(gf.d dVar) {
            while (dVar instanceof t) {
                t tVar = (t) dVar;
                this.f10704a.push(tVar);
                dVar = tVar.f10698c;
            }
            return (o) dVar;
        }

        public final o c() {
            while (!this.f10704a.isEmpty()) {
                o oVarB = b(((t) this.f10704a.pop()).f10699d);
                if (!oVarB.isEmpty()) {
                    return oVarB;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public o next() {
            o oVar = this.f10705b;
            if (oVar == null) {
                throw new NoSuchElementException();
            }
            this.f10705b = c();
            return oVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10705b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public c(gf.d dVar) {
            this.f10704a = new Stack();
            this.f10705b = b(dVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f10706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d.a f10707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10708c;

        @Override // gf.d.a
        public byte a() {
            if (!this.f10707b.hasNext()) {
                this.f10707b = this.f10706a.next().iterator();
            }
            this.f10708c--;
            return this.f10707b.a();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10708c > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public d() {
            c cVar = new c(t.this);
            this.f10706a = cVar;
            this.f10707b = cVar.next().iterator();
            this.f10708c = t.this.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 1;
        while (i10 > 0) {
            arrayList.add(Integer.valueOf(i10));
            int i12 = i11 + i10;
            i11 = i10;
            i10 = i12;
        }
        arrayList.add(Integer.valueOf(a.e.API_PRIORITY_OTHER));
        f10696h = new int[arrayList.size()];
        int i13 = 0;
        while (true) {
            int[] iArr = f10696h;
            if (i13 >= iArr.length) {
                return;
            }
            iArr[i13] = ((Integer) arrayList.get(i13)).intValue();
            i13++;
        }
    }

    public static gf.d W(gf.d dVar, gf.d dVar2) {
        t tVar = dVar instanceof t ? (t) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() == 0) {
            return dVar2;
        }
        int size = dVar.size() + dVar2.size();
        if (size < 128) {
            return X(dVar, dVar2);
        }
        if (tVar != null && tVar.f10699d.size() + dVar2.size() < 128) {
            return new t(tVar.f10698c, X(tVar.f10699d, dVar2));
        }
        if (tVar == null || tVar.f10698c.r() <= tVar.f10699d.r() || tVar.r() <= dVar2.r()) {
            return size >= f10696h[Math.max(dVar.r(), dVar2.r()) + 1] ? new t(dVar, dVar2) : new b().b(dVar, dVar2);
        }
        return new t(tVar.f10698c, new t(tVar.f10699d, dVar2));
    }

    public static o X(gf.d dVar, gf.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.p(bArr, 0, 0, size);
        dVar2.p(bArr, 0, size, size2);
        return new o(bArr);
    }

    @Override // gf.d
    public int A() {
        return this.f10702g;
    }

    @Override // gf.d
    public String K(String str) {
        return new String(G(), str);
    }

    @Override // gf.d
    public void S(OutputStream outputStream, int i10, int i11) {
        int i12 = i10 + i11;
        int i13 = this.f10700e;
        if (i12 <= i13) {
            this.f10698c.S(outputStream, i10, i11);
        } else {
            if (i10 >= i13) {
                this.f10699d.S(outputStream, i10 - i13, i11);
                return;
            }
            int i14 = i13 - i10;
            this.f10698c.S(outputStream, i10, i14);
            this.f10699d.S(outputStream, 0, i11 - i14);
        }
    }

    public final boolean Y(gf.d dVar) {
        c cVar = new c(this);
        o oVar = (o) cVar.next();
        c cVar2 = new c(dVar);
        o oVar2 = (o) cVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int size = oVar.size() - i10;
            int size2 = oVar2.size() - i11;
            int iMin = Math.min(size, size2);
            if (!(i10 == 0 ? oVar.T(oVar2, i11, iMin) : oVar2.T(oVar, i10, iMin))) {
                return false;
            }
            i12 += iMin;
            int i13 = this.f10697b;
            if (i12 >= i13) {
                if (i12 == i13) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                oVar = (o) cVar.next();
                i10 = 0;
            } else {
                i10 += iMin;
            }
            if (iMin == size2) {
                oVar2 = (o) cVar2.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
        }
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new d();
    }

    public boolean equals(Object obj) {
        int iA;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gf.d)) {
            return false;
        }
        gf.d dVar = (gf.d) obj;
        if (this.f10697b != dVar.size()) {
            return false;
        }
        if (this.f10697b == 0) {
            return true;
        }
        if (this.f10702g == 0 || (iA = dVar.A()) == 0 || this.f10702g == iA) {
            return Y(dVar);
        }
        return false;
    }

    public int hashCode() {
        int iW = this.f10702g;
        if (iW == 0) {
            int i10 = this.f10697b;
            iW = w(i10, 0, i10);
            if (iW == 0) {
                iW = 1;
            }
            this.f10702g = iW;
        }
        return iW;
    }

    @Override // gf.d
    public void q(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.f10700e;
        if (i13 <= i14) {
            this.f10698c.q(bArr, i10, i11, i12);
        } else {
            if (i10 >= i14) {
                this.f10699d.q(bArr, i10 - i14, i11, i12);
                return;
            }
            int i15 = i14 - i10;
            this.f10698c.q(bArr, i10, i11, i15);
            this.f10699d.q(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    @Override // gf.d
    public int r() {
        return this.f10701f;
    }

    @Override // gf.d
    public boolean s() {
        return this.f10697b >= f10696h[this.f10701f];
    }

    @Override // gf.d
    public int size() {
        return this.f10697b;
    }

    @Override // gf.d
    public boolean u() {
        int iY = this.f10698c.y(0, 0, this.f10700e);
        gf.d dVar = this.f10699d;
        return dVar.y(iY, 0, dVar.size()) == 0;
    }

    @Override // gf.d
    public int w(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f10700e;
        if (i13 <= i14) {
            return this.f10698c.w(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f10699d.w(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f10699d.w(this.f10698c.w(i10, i11, i15), 0, i12 - i15);
    }

    @Override // gf.d
    public int y(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f10700e;
        if (i13 <= i14) {
            return this.f10698c.y(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f10699d.y(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f10699d.y(this.f10698c.y(i10, i11, i15), 0, i12 - i15);
    }

    public t(gf.d dVar, gf.d dVar2) {
        this.f10702g = 0;
        this.f10698c = dVar;
        this.f10699d = dVar2;
        int size = dVar.size();
        this.f10700e = size;
        this.f10697b = size + dVar2.size();
        this.f10701f = Math.max(dVar.r(), dVar2.r()) + 1;
    }
}
