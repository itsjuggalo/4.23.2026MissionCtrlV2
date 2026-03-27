package s6;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import s6.AbstractC2717d;

/* JADX INFO: loaded from: classes2.dex */
public class t extends AbstractC2717d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f23194h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2717d f23196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC2717d f23197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f23199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f23200g;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack f23201a;

        public b() {
            this.f23201a = new Stack();
        }

        public final AbstractC2717d b(AbstractC2717d abstractC2717d, AbstractC2717d abstractC2717d2) {
            c(abstractC2717d);
            c(abstractC2717d2);
            AbstractC2717d tVar = (AbstractC2717d) this.f23201a.pop();
            while (!this.f23201a.isEmpty()) {
                tVar = new t((AbstractC2717d) this.f23201a.pop(), tVar);
            }
            return tVar;
        }

        public final void c(AbstractC2717d abstractC2717d) {
            if (abstractC2717d.I()) {
                e(abstractC2717d);
                return;
            }
            if (abstractC2717d instanceof t) {
                t tVar = (t) abstractC2717d;
                c(tVar.f23196c);
                c(tVar.f23197d);
            } else {
                String strValueOf = String.valueOf(abstractC2717d.getClass());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public final int d(int i8) {
            int iBinarySearch = Arrays.binarySearch(t.f23194h, i8);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        public final void e(AbstractC2717d abstractC2717d) {
            int iD = d(abstractC2717d.size());
            int i8 = t.f23194h[iD + 1];
            if (this.f23201a.isEmpty() || ((AbstractC2717d) this.f23201a.peek()).size() >= i8) {
                this.f23201a.push(abstractC2717d);
                return;
            }
            int i9 = t.f23194h[iD];
            AbstractC2717d tVar = (AbstractC2717d) this.f23201a.pop();
            while (true) {
                if (this.f23201a.isEmpty() || ((AbstractC2717d) this.f23201a.peek()).size() >= i9) {
                    break;
                } else {
                    tVar = new t((AbstractC2717d) this.f23201a.pop(), tVar);
                }
            }
            t tVar2 = new t(tVar, abstractC2717d);
            while (!this.f23201a.isEmpty()) {
                if (((AbstractC2717d) this.f23201a.peek()).size() >= t.f23194h[d(tVar2.size()) + 1]) {
                    break;
                } else {
                    tVar2 = new t((AbstractC2717d) this.f23201a.pop(), tVar2);
                }
            }
            this.f23201a.push(tVar2);
        }
    }

    public static class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack f23202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f23203b;

        public c(AbstractC2717d abstractC2717d) {
            this.f23202a = new Stack();
            this.f23203b = b(abstractC2717d);
        }

        public final o b(AbstractC2717d abstractC2717d) {
            while (abstractC2717d instanceof t) {
                t tVar = (t) abstractC2717d;
                this.f23202a.push(tVar);
                abstractC2717d = tVar.f23196c;
            }
            return (o) abstractC2717d;
        }

        public final o c() {
            while (!this.f23202a.isEmpty()) {
                o oVarB = b(((t) this.f23202a.pop()).f23197d);
                if (!oVarB.isEmpty()) {
                    return oVarB;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public o next() {
            o oVar = this.f23203b;
            if (oVar == null) {
                throw new NoSuchElementException();
            }
            this.f23203b = c();
            return oVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23203b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class d implements AbstractC2717d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f23204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC2717d.a f23205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f23206c;

        public d() {
            c cVar = new c(t.this);
            this.f23204a = cVar;
            this.f23205b = cVar.next().iterator();
            this.f23206c = t.this.size();
        }

        @Override // s6.AbstractC2717d.a
        public byte a() {
            if (!this.f23205b.hasNext()) {
                this.f23205b = this.f23204a.next().iterator();
            }
            this.f23206c--;
            return this.f23205b.a();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23206c > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i8 = 1;
        int i9 = 1;
        while (i8 > 0) {
            arrayList.add(Integer.valueOf(i8));
            int i10 = i9 + i8;
            i9 = i8;
            i8 = i10;
        }
        arrayList.add(Integer.MAX_VALUE);
        f23194h = new int[arrayList.size()];
        int i11 = 0;
        while (true) {
            int[] iArr = f23194h;
            if (i11 >= iArr.length) {
                return;
            }
            iArr[i11] = ((Integer) arrayList.get(i11)).intValue();
            i11++;
        }
    }

    public t(AbstractC2717d abstractC2717d, AbstractC2717d abstractC2717d2) {
        this.f23200g = 0;
        this.f23196c = abstractC2717d;
        this.f23197d = abstractC2717d2;
        int size = abstractC2717d.size();
        this.f23198e = size;
        this.f23195b = size + abstractC2717d2.size();
        this.f23199f = Math.max(abstractC2717d.H(), abstractC2717d2.H()) + 1;
    }

    public static AbstractC2717d W(AbstractC2717d abstractC2717d, AbstractC2717d abstractC2717d2) {
        t tVar = abstractC2717d instanceof t ? (t) abstractC2717d : null;
        if (abstractC2717d2.size() == 0) {
            return abstractC2717d;
        }
        if (abstractC2717d.size() != 0) {
            int size = abstractC2717d.size() + abstractC2717d2.size();
            if (size < 128) {
                return X(abstractC2717d, abstractC2717d2);
            }
            if (tVar != null && tVar.f23197d.size() + abstractC2717d2.size() < 128) {
                abstractC2717d2 = new t(tVar.f23196c, X(tVar.f23197d, abstractC2717d2));
            } else {
                if (tVar == null || tVar.f23196c.H() <= tVar.f23197d.H() || tVar.H() <= abstractC2717d2.H()) {
                    return size >= f23194h[Math.max(abstractC2717d.H(), abstractC2717d2.H()) + 1] ? new t(abstractC2717d, abstractC2717d2) : new b().b(abstractC2717d, abstractC2717d2);
                }
                abstractC2717d2 = new t(tVar.f23196c, new t(tVar.f23197d, abstractC2717d2));
            }
        }
        return abstractC2717d2;
    }

    public static o X(AbstractC2717d abstractC2717d, AbstractC2717d abstractC2717d2) {
        int size = abstractC2717d.size();
        int size2 = abstractC2717d2.size();
        byte[] bArr = new byte[size + size2];
        abstractC2717d.C(bArr, 0, 0, size);
        abstractC2717d2.C(bArr, 0, size, size2);
        return new o(bArr);
    }

    @Override // s6.AbstractC2717d
    public void F(byte[] bArr, int i8, int i9, int i10) {
        AbstractC2717d abstractC2717d;
        int i11 = i8 + i10;
        int i12 = this.f23198e;
        if (i11 <= i12) {
            abstractC2717d = this.f23196c;
        } else {
            if (i8 < i12) {
                int i13 = i12 - i8;
                this.f23196c.F(bArr, i8, i9, i13);
                this.f23197d.F(bArr, 0, i9 + i13, i10 - i13);
                return;
            }
            abstractC2717d = this.f23197d;
            i8 -= i12;
        }
        abstractC2717d.F(bArr, i8, i9, i10);
    }

    @Override // s6.AbstractC2717d
    public int H() {
        return this.f23199f;
    }

    @Override // s6.AbstractC2717d
    public boolean I() {
        return this.f23195b >= f23194h[this.f23199f];
    }

    @Override // s6.AbstractC2717d
    public boolean J() {
        int iM = this.f23196c.M(0, 0, this.f23198e);
        AbstractC2717d abstractC2717d = this.f23197d;
        return abstractC2717d.M(iM, 0, abstractC2717d.size()) == 0;
    }

    @Override // s6.AbstractC2717d
    public int L(int i8, int i9, int i10) {
        int i11 = i9 + i10;
        int i12 = this.f23198e;
        if (i11 <= i12) {
            return this.f23196c.L(i8, i9, i10);
        }
        if (i9 >= i12) {
            return this.f23197d.L(i8, i9 - i12, i10);
        }
        int i13 = i12 - i9;
        return this.f23197d.L(this.f23196c.L(i8, i9, i13), 0, i10 - i13);
    }

    @Override // s6.AbstractC2717d
    public int M(int i8, int i9, int i10) {
        int i11 = i9 + i10;
        int i12 = this.f23198e;
        if (i11 <= i12) {
            return this.f23196c.M(i8, i9, i10);
        }
        if (i9 >= i12) {
            return this.f23197d.M(i8, i9 - i12, i10);
        }
        int i13 = i12 - i9;
        return this.f23197d.M(this.f23196c.M(i8, i9, i13), 0, i10 - i13);
    }

    @Override // s6.AbstractC2717d
    public int N() {
        return this.f23200g;
    }

    @Override // s6.AbstractC2717d
    public String P(String str) {
        return new String(O(), str);
    }

    @Override // s6.AbstractC2717d
    public void S(OutputStream outputStream, int i8, int i9) {
        AbstractC2717d abstractC2717d;
        int i10 = i8 + i9;
        int i11 = this.f23198e;
        if (i10 <= i11) {
            abstractC2717d = this.f23196c;
        } else {
            if (i8 < i11) {
                int i12 = i11 - i8;
                this.f23196c.S(outputStream, i8, i12);
                this.f23197d.S(outputStream, 0, i9 - i12);
                return;
            }
            abstractC2717d = this.f23197d;
            i8 -= i11;
        }
        abstractC2717d.S(outputStream, i8, i9);
    }

    public final boolean Y(AbstractC2717d abstractC2717d) {
        c cVar = new c(this);
        o oVar = (o) cVar.next();
        c cVar2 = new c(abstractC2717d);
        o oVar2 = (o) cVar2.next();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int size = oVar.size() - i8;
            int size2 = oVar2.size() - i9;
            int iMin = Math.min(size, size2);
            if (!(i8 == 0 ? oVar.T(oVar2, i9, iMin) : oVar2.T(oVar, i8, iMin))) {
                return false;
            }
            i10 += iMin;
            int i11 = this.f23195b;
            if (i10 >= i11) {
                if (i10 == i11) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                oVar = (o) cVar.next();
                i8 = 0;
            } else {
                i8 += iMin;
            }
            if (iMin == size2) {
                oVar2 = (o) cVar2.next();
                i9 = 0;
            } else {
                i9 += iMin;
            }
        }
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public AbstractC2717d.a iterator() {
        return new d();
    }

    public boolean equals(Object obj) {
        int iN;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2717d)) {
            return false;
        }
        AbstractC2717d abstractC2717d = (AbstractC2717d) obj;
        if (this.f23195b != abstractC2717d.size()) {
            return false;
        }
        if (this.f23195b == 0) {
            return true;
        }
        if (this.f23200g == 0 || (iN = abstractC2717d.N()) == 0 || this.f23200g == iN) {
            return Y(abstractC2717d);
        }
        return false;
    }

    public int hashCode() {
        int iL = this.f23200g;
        if (iL == 0) {
            int i8 = this.f23195b;
            iL = L(i8, 0, i8);
            if (iL == 0) {
                iL = 1;
            }
            this.f23200g = iL;
        }
        return iL;
    }

    @Override // s6.AbstractC2717d
    public int size() {
        return this.f23195b;
    }
}
