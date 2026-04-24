package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.AbstractC1240i;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class m0 extends AbstractC1240i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f12738j = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, a.e.API_PRIORITY_OTHER};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AbstractC1240i f12740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC1240i f12741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12743i;

    public class a extends AbstractC1240i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f12744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC1240i.g f12745b = c();

        public a() {
            this.f12744a = new c(m0.this, null);
        }

        @Override // com.google.protobuf.AbstractC1240i.g
        public byte a() {
            AbstractC1240i.g gVar = this.f12745b;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            byte bA = gVar.a();
            if (!this.f12745b.hasNext()) {
                this.f12745b = c();
            }
            return bA;
        }

        public final AbstractC1240i.g c() {
            if (this.f12744a.hasNext()) {
                return this.f12744a.next().iterator();
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12745b != null;
        }
    }

    public static final class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque f12748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC1240i.h f12749b;

        public /* synthetic */ c(AbstractC1240i abstractC1240i, a aVar) {
            this(abstractC1240i);
        }

        public final AbstractC1240i.h b(AbstractC1240i abstractC1240i) {
            while (abstractC1240i instanceof m0) {
                m0 m0Var = (m0) abstractC1240i;
                this.f12748a.push(m0Var);
                abstractC1240i = m0Var.f12740f;
            }
            return (AbstractC1240i.h) abstractC1240i;
        }

        public final AbstractC1240i.h c() {
            AbstractC1240i.h hVarB;
            do {
                ArrayDeque arrayDeque = this.f12748a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                hVarB = b(((m0) this.f12748a.pop()).f12741g);
            } while (hVarB.isEmpty());
            return hVarB;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public AbstractC1240i.h next() {
            AbstractC1240i.h hVar = this.f12749b;
            if (hVar == null) {
                throw new NoSuchElementException();
            }
            this.f12749b = c();
            return hVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12749b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public c(AbstractC1240i abstractC1240i) {
            if (!(abstractC1240i instanceof m0)) {
                this.f12748a = null;
                this.f12749b = (AbstractC1240i.h) abstractC1240i;
                return;
            }
            m0 m0Var = (m0) abstractC1240i;
            ArrayDeque arrayDeque = new ArrayDeque(m0Var.s());
            this.f12748a = arrayDeque;
            arrayDeque.push(m0Var);
            this.f12749b = b(m0Var.f12740f);
        }
    }

    public /* synthetic */ m0(AbstractC1240i abstractC1240i, AbstractC1240i abstractC1240i2, a aVar) {
        this(abstractC1240i, abstractC1240i2);
    }

    public static AbstractC1240i S(AbstractC1240i abstractC1240i, AbstractC1240i abstractC1240i2) {
        if (abstractC1240i2.size() == 0) {
            return abstractC1240i;
        }
        if (abstractC1240i.size() == 0) {
            return abstractC1240i2;
        }
        int size = abstractC1240i.size() + abstractC1240i2.size();
        if (size < 128) {
            return T(abstractC1240i, abstractC1240i2);
        }
        if (abstractC1240i instanceof m0) {
            m0 m0Var = (m0) abstractC1240i;
            if (m0Var.f12741g.size() + abstractC1240i2.size() < 128) {
                return new m0(m0Var.f12740f, T(m0Var.f12741g, abstractC1240i2));
            }
            if (m0Var.f12740f.s() > m0Var.f12741g.s() && m0Var.s() > abstractC1240i2.s()) {
                return new m0(m0Var.f12740f, new m0(m0Var.f12741g, abstractC1240i2));
            }
        }
        return size >= V(Math.max(abstractC1240i.s(), abstractC1240i2.s()) + 1) ? new m0(abstractC1240i, abstractC1240i2) : new b(null).b(abstractC1240i, abstractC1240i2);
    }

    public static AbstractC1240i T(AbstractC1240i abstractC1240i, AbstractC1240i abstractC1240i2) {
        int size = abstractC1240i.size();
        int size2 = abstractC1240i2.size();
        byte[] bArr = new byte[size + size2];
        abstractC1240i.q(bArr, 0, 0, size);
        abstractC1240i2.q(bArr, 0, size, size2);
        return AbstractC1240i.M(bArr);
    }

    public static int V(int i7) {
        int[] iArr = f12738j;
        return i7 >= iArr.length ? a.e.API_PRIORITY_OTHER : iArr[i7];
    }

    @Override // com.google.protobuf.AbstractC1240i
    public int A(int i7, int i8, int i9) {
        int i10 = i8 + i9;
        int i11 = this.f12742h;
        if (i10 <= i11) {
            return this.f12740f.A(i7, i8, i9);
        }
        if (i8 >= i11) {
            return this.f12741g.A(i7, i8 - i11, i9);
        }
        int i12 = i11 - i8;
        return this.f12741g.A(this.f12740f.A(i7, i8, i12), 0, i9 - i12);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public int B(int i7, int i8, int i9) {
        int i10 = i8 + i9;
        int i11 = this.f12742h;
        if (i10 <= i11) {
            return this.f12740f.B(i7, i8, i9);
        }
        if (i8 >= i11) {
            return this.f12741g.B(i7, i8 - i11, i9);
        }
        int i12 = i11 - i8;
        return this.f12741g.B(this.f12740f.B(i7, i8, i12), 0, i9 - i12);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public AbstractC1240i E(int i7, int i8) {
        int iJ = AbstractC1240i.j(i7, i8, this.f12739e);
        if (iJ == 0) {
            return AbstractC1240i.f12650b;
        }
        if (iJ == this.f12739e) {
            return this;
        }
        int i9 = this.f12742h;
        return i8 <= i9 ? this.f12740f.E(i7, i8) : i7 >= i9 ? this.f12741g.E(i7 - i9, i8 - i9) : new m0(this.f12740f.D(i7), this.f12741g.E(0, i8 - this.f12742h));
    }

    @Override // com.google.protobuf.AbstractC1240i
    public String I(Charset charset) {
        return new String(F(), charset);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public void O(AbstractC1239h abstractC1239h) {
        this.f12740f.O(abstractC1239h);
        this.f12741g.O(abstractC1239h);
    }

    public List R() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().b());
        }
        return arrayList;
    }

    public final boolean U(AbstractC1240i abstractC1240i) {
        a aVar = null;
        c cVar = new c(this, aVar);
        AbstractC1240i.h hVar = (AbstractC1240i.h) cVar.next();
        c cVar2 = new c(abstractC1240i, aVar);
        AbstractC1240i.h hVar2 = (AbstractC1240i.h) cVar2.next();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int size = hVar.size() - i7;
            int size2 = hVar2.size() - i8;
            int iMin = Math.min(size, size2);
            if (!(i7 == 0 ? hVar.P(hVar2, i8, iMin) : hVar2.P(hVar, i7, iMin))) {
                return false;
            }
            i9 += iMin;
            int i10 = this.f12739e;
            if (i9 >= i10) {
                if (i9 == i10) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                i7 = 0;
                hVar = (AbstractC1240i.h) cVar.next();
            } else {
                i7 += iMin;
                hVar = hVar;
            }
            if (iMin == size2) {
                hVar2 = (AbstractC1240i.h) cVar2.next();
                i8 = 0;
            } else {
                i8 += iMin;
            }
        }
    }

    @Override // com.google.protobuf.AbstractC1240i
    public ByteBuffer b() {
        return ByteBuffer.wrap(F()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.AbstractC1240i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1240i)) {
            return false;
        }
        AbstractC1240i abstractC1240i = (AbstractC1240i) obj;
        if (this.f12739e != abstractC1240i.size()) {
            return false;
        }
        if (this.f12739e == 0) {
            return true;
        }
        int iC = C();
        int iC2 = abstractC1240i.C();
        if (iC == 0 || iC2 == 0 || iC == iC2) {
            return U(abstractC1240i);
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractC1240i
    public byte g(int i7) {
        AbstractC1240i.h(i7, this.f12739e);
        return t(i7);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public void r(byte[] bArr, int i7, int i8, int i9) {
        int i10 = i7 + i9;
        int i11 = this.f12742h;
        if (i10 <= i11) {
            this.f12740f.r(bArr, i7, i8, i9);
        } else {
            if (i7 >= i11) {
                this.f12741g.r(bArr, i7 - i11, i8, i9);
                return;
            }
            int i12 = i11 - i7;
            this.f12740f.r(bArr, i7, i8, i12);
            this.f12741g.r(bArr, 0, i8 + i12, i9 - i12);
        }
    }

    @Override // com.google.protobuf.AbstractC1240i
    public int s() {
        return this.f12743i;
    }

    @Override // com.google.protobuf.AbstractC1240i
    public int size() {
        return this.f12739e;
    }

    @Override // com.google.protobuf.AbstractC1240i
    public byte t(int i7) {
        int i8 = this.f12742h;
        return i7 < i8 ? this.f12740f.t(i7) : this.f12741g.t(i7 - i8);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public boolean u() {
        return this.f12739e >= V(this.f12743i);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public boolean w() {
        int iB = this.f12740f.B(0, 0, this.f12742h);
        AbstractC1240i abstractC1240i = this.f12741g;
        return abstractC1240i.B(iB, 0, abstractC1240i.size()) == 0;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public AbstractC1240i.g iterator() {
        return new a();
    }

    @Override // com.google.protobuf.AbstractC1240i
    public AbstractC1241j y() {
        return AbstractC1241j.i(R(), true);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque f12747a;

        public b() {
            this.f12747a = new ArrayDeque();
        }

        public final AbstractC1240i b(AbstractC1240i abstractC1240i, AbstractC1240i abstractC1240i2) {
            c(abstractC1240i);
            c(abstractC1240i2);
            AbstractC1240i m0Var = (AbstractC1240i) this.f12747a.pop();
            while (!this.f12747a.isEmpty()) {
                m0Var = new m0((AbstractC1240i) this.f12747a.pop(), m0Var, null);
            }
            return m0Var;
        }

        public final void c(AbstractC1240i abstractC1240i) {
            if (abstractC1240i.u()) {
                e(abstractC1240i);
                return;
            }
            if (abstractC1240i instanceof m0) {
                m0 m0Var = (m0) abstractC1240i;
                c(m0Var.f12740f);
                c(m0Var.f12741g);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + abstractC1240i.getClass());
            }
        }

        public final int d(int i7) {
            int iBinarySearch = Arrays.binarySearch(m0.f12738j, i7);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        public final void e(AbstractC1240i abstractC1240i) {
            a aVar;
            int iD = d(abstractC1240i.size());
            int iV = m0.V(iD + 1);
            if (this.f12747a.isEmpty() || ((AbstractC1240i) this.f12747a.peek()).size() >= iV) {
                this.f12747a.push(abstractC1240i);
                return;
            }
            int iV2 = m0.V(iD);
            AbstractC1240i m0Var = (AbstractC1240i) this.f12747a.pop();
            while (true) {
                aVar = null;
                if (this.f12747a.isEmpty() || ((AbstractC1240i) this.f12747a.peek()).size() >= iV2) {
                    break;
                } else {
                    m0Var = new m0((AbstractC1240i) this.f12747a.pop(), m0Var, aVar);
                }
            }
            m0 m0Var2 = new m0(m0Var, abstractC1240i, aVar);
            while (!this.f12747a.isEmpty()) {
                if (((AbstractC1240i) this.f12747a.peek()).size() >= m0.V(d(m0Var2.size()) + 1)) {
                    break;
                } else {
                    m0Var2 = new m0((AbstractC1240i) this.f12747a.pop(), m0Var2, aVar);
                }
            }
            this.f12747a.push(m0Var2);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public m0(AbstractC1240i abstractC1240i, AbstractC1240i abstractC1240i2) {
        this.f12740f = abstractC1240i;
        this.f12741g = abstractC1240i2;
        int size = abstractC1240i.size();
        this.f12742h = size;
        this.f12739e = size + abstractC1240i2.size();
        this.f12743i = Math.max(abstractC1240i.s(), abstractC1240i2.s()) + 1;
    }
}
