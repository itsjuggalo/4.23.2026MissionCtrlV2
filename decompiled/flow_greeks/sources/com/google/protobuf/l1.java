package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.i;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 extends i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f7089j = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, a.e.API_PRIORITY_OTHER};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f7091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f7092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f7094i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f7095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i.g f7096b = c();

        public a() {
            this.f7095a = new c(l1.this, null);
        }

        @Override // com.google.protobuf.i.g
        public byte a() {
            i.g gVar = this.f7096b;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            byte bA = gVar.a();
            if (!this.f7096b.hasNext()) {
                this.f7096b = c();
            }
            return bA;
        }

        public final i.g c() {
            if (this.f7095a.hasNext()) {
                return this.f7095a.next().iterator();
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7096b != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque f7099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i.AbstractC0115i f7100b;

        public /* synthetic */ c(i iVar, a aVar) {
            this(iVar);
        }

        public final i.AbstractC0115i b(i iVar) {
            while (iVar instanceof l1) {
                l1 l1Var = (l1) iVar;
                this.f7099a.push(l1Var);
                iVar = l1Var.f7091f;
            }
            return (i.AbstractC0115i) iVar;
        }

        public final i.AbstractC0115i c() {
            i.AbstractC0115i abstractC0115iB;
            do {
                ArrayDeque arrayDeque = this.f7099a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                abstractC0115iB = b(((l1) this.f7099a.pop()).f7092g);
            } while (abstractC0115iB.isEmpty());
            return abstractC0115iB;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public i.AbstractC0115i next() {
            i.AbstractC0115i abstractC0115i = this.f7100b;
            if (abstractC0115i == null) {
                throw new NoSuchElementException();
            }
            this.f7100b = c();
            return abstractC0115i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7100b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public c(i iVar) {
            if (!(iVar instanceof l1)) {
                this.f7099a = null;
                this.f7100b = (i.AbstractC0115i) iVar;
                return;
            }
            l1 l1Var = (l1) iVar;
            ArrayDeque arrayDeque = new ArrayDeque(l1Var.y());
            this.f7099a = arrayDeque;
            arrayDeque.push(l1Var);
            this.f7100b = b(l1Var.f7091f);
        }
    }

    public /* synthetic */ l1(i iVar, i iVar2, a aVar) {
        this(iVar, iVar2);
    }

    public static i l0(i iVar, i iVar2) {
        if (iVar2.size() == 0) {
            return iVar;
        }
        if (iVar.size() == 0) {
            return iVar2;
        }
        int size = iVar.size() + iVar2.size();
        if (size < 128) {
            return m0(iVar, iVar2);
        }
        if (iVar instanceof l1) {
            l1 l1Var = (l1) iVar;
            if (l1Var.f7092g.size() + iVar2.size() < 128) {
                return new l1(l1Var.f7091f, m0(l1Var.f7092g, iVar2));
            }
            if (l1Var.f7091f.y() > l1Var.f7092g.y() && l1Var.y() > iVar2.y()) {
                return new l1(l1Var.f7091f, new l1(l1Var.f7092g, iVar2));
            }
        }
        return size >= o0(Math.max(iVar.y(), iVar2.y()) + 1) ? new l1(iVar, iVar2) : new b(null).b(iVar, iVar2);
    }

    public static i m0(i iVar, i iVar2) {
        int size = iVar.size();
        int size2 = iVar2.size();
        byte[] bArr = new byte[size + size2];
        iVar.v(bArr, 0, 0, size);
        iVar2.v(bArr, 0, size, size2);
        return i.f0(bArr);
    }

    public static int o0(int i10) {
        int[] iArr = f7089j;
        return i10 >= iArr.length ? a.e.API_PRIORITY_OTHER : iArr[i10];
    }

    @Override // com.google.protobuf.i
    public byte A(int i10) {
        int i11 = this.f7093h;
        return i10 < i11 ? this.f7091f.A(i10) : this.f7092g.A(i10 - i11);
    }

    @Override // com.google.protobuf.i
    public boolean G() {
        return this.f7090e >= o0(this.f7094i);
    }

    @Override // com.google.protobuf.i
    public boolean K() {
        int iU = this.f7091f.U(0, 0, this.f7093h);
        i iVar = this.f7092g;
        return iVar.U(iU, 0, iVar.size()) == 0;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public i.g iterator() {
        return new a();
    }

    @Override // com.google.protobuf.i
    public j S() {
        return j.i(k0(), true);
    }

    @Override // com.google.protobuf.i
    public int T(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f7093h;
        if (i13 <= i14) {
            return this.f7091f.T(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f7092g.T(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f7092g.T(this.f7091f.T(i10, i11, i15), 0, i12 - i15);
    }

    @Override // com.google.protobuf.i
    public int U(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f7093h;
        if (i13 <= i14) {
            return this.f7091f.U(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f7092g.U(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f7092g.U(this.f7091f.U(i10, i11, i15), 0, i12 - i15);
    }

    @Override // com.google.protobuf.i
    public i X(int i10, int i11) {
        int iG = i.g(i10, i11, this.f7090e);
        if (iG == 0) {
            return i.f6998b;
        }
        if (iG == this.f7090e) {
            return this;
        }
        int i12 = this.f7093h;
        return i11 <= i12 ? this.f7091f.X(i10, i11) : i10 >= i12 ? this.f7092g.X(i10 - i12, i11 - i12) : new l1(this.f7091f.W(i10), this.f7092g.X(0, i11 - this.f7093h));
    }

    @Override // com.google.protobuf.i
    public String b0(Charset charset) {
        return new String(Y(), charset);
    }

    @Override // com.google.protobuf.i
    public ByteBuffer c() {
        return ByteBuffer.wrap(Y()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.i
    public byte e(int i10) {
        i.f(i10, this.f7090e);
        return A(i10);
    }

    @Override // com.google.protobuf.i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f7090e != iVar.size()) {
            return false;
        }
        if (this.f7090e == 0) {
            return true;
        }
        int iV = V();
        int iV2 = iVar.V();
        if (iV == 0 || iV2 == 0 || iV == iV2) {
            return n0(iVar);
        }
        return false;
    }

    @Override // com.google.protobuf.i
    public void h0(h hVar) {
        this.f7091f.h0(hVar);
        this.f7092g.h0(hVar);
    }

    public List k0() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().c());
        }
        return arrayList;
    }

    public final boolean n0(i iVar) {
        a aVar = null;
        c cVar = new c(this, aVar);
        i.AbstractC0115i abstractC0115i = (i.AbstractC0115i) cVar.next();
        c cVar2 = new c(iVar, aVar);
        i.AbstractC0115i abstractC0115i2 = (i.AbstractC0115i) cVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int size = abstractC0115i.size() - i10;
            int size2 = abstractC0115i2.size() - i11;
            int iMin = Math.min(size, size2);
            if (!(i10 == 0 ? abstractC0115i.i0(abstractC0115i2, i11, iMin) : abstractC0115i2.i0(abstractC0115i, i10, iMin))) {
                return false;
            }
            i12 += iMin;
            int i13 = this.f7090e;
            if (i12 >= i13) {
                if (i12 == i13) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                i10 = 0;
                abstractC0115i = (i.AbstractC0115i) cVar.next();
            } else {
                i10 += iMin;
                abstractC0115i = abstractC0115i;
            }
            if (iMin == size2) {
                abstractC0115i2 = (i.AbstractC0115i) cVar2.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
        }
    }

    @Override // com.google.protobuf.i
    public int size() {
        return this.f7090e;
    }

    @Override // com.google.protobuf.i
    public void w(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.f7093h;
        if (i13 <= i14) {
            this.f7091f.w(bArr, i10, i11, i12);
        } else {
            if (i10 >= i14) {
                this.f7092g.w(bArr, i10 - i14, i11, i12);
                return;
            }
            int i15 = i14 - i10;
            this.f7091f.w(bArr, i10, i11, i15);
            this.f7092g.w(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    @Override // com.google.protobuf.i
    public int y() {
        return this.f7094i;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque f7098a;

        public b() {
            this.f7098a = new ArrayDeque();
        }

        public final i b(i iVar, i iVar2) {
            c(iVar);
            c(iVar2);
            i l1Var = (i) this.f7098a.pop();
            while (!this.f7098a.isEmpty()) {
                l1Var = new l1((i) this.f7098a.pop(), l1Var, null);
            }
            return l1Var;
        }

        public final void c(i iVar) {
            if (iVar.G()) {
                e(iVar);
                return;
            }
            if (iVar instanceof l1) {
                l1 l1Var = (l1) iVar;
                c(l1Var.f7091f);
                c(l1Var.f7092g);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + iVar.getClass());
            }
        }

        public final int d(int i10) {
            int iBinarySearch = Arrays.binarySearch(l1.f7089j, i10);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        public final void e(i iVar) {
            a aVar;
            int iD = d(iVar.size());
            int iO0 = l1.o0(iD + 1);
            if (this.f7098a.isEmpty() || ((i) this.f7098a.peek()).size() >= iO0) {
                this.f7098a.push(iVar);
                return;
            }
            int iO02 = l1.o0(iD);
            i l1Var = (i) this.f7098a.pop();
            while (true) {
                aVar = null;
                if (this.f7098a.isEmpty() || ((i) this.f7098a.peek()).size() >= iO02) {
                    break;
                } else {
                    l1Var = new l1((i) this.f7098a.pop(), l1Var, aVar);
                }
            }
            l1 l1Var2 = new l1(l1Var, iVar, aVar);
            while (!this.f7098a.isEmpty()) {
                if (((i) this.f7098a.peek()).size() >= l1.o0(d(l1Var2.size()) + 1)) {
                    break;
                } else {
                    l1Var2 = new l1((i) this.f7098a.pop(), l1Var2, aVar);
                }
            }
            this.f7098a.push(l1Var2);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public l1(i iVar, i iVar2) {
        this.f7091f = iVar;
        this.f7092g = iVar2;
        int size = iVar.size();
        this.f7093h = size;
        this.f7090e = size + iVar2.size();
        this.f7094i = Math.max(iVar.y(), iVar2.y()) + 1;
    }
}
