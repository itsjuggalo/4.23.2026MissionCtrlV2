package com.google.protobuf;

import com.google.protobuf.AbstractC1062i;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends AbstractC1062i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f11122j = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AbstractC1062i f11124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC1062i f11125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f11127i;

    public class a extends AbstractC1062i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f11128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC1062i.g f11129b = c();

        public a() {
            this.f11128a = new c(n0.this, null);
        }

        @Override // com.google.protobuf.AbstractC1062i.g
        public byte a() {
            AbstractC1062i.g gVar = this.f11129b;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            byte bA = gVar.a();
            if (!this.f11129b.hasNext()) {
                this.f11129b = c();
            }
            return bA;
        }

        public final AbstractC1062i.g c() {
            if (this.f11128a.hasNext()) {
                return this.f11128a.next().iterator();
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11129b != null;
        }
    }

    public static final class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque f11132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC1062i.AbstractC0160i f11133b;

        public /* synthetic */ c(AbstractC1062i abstractC1062i, a aVar) {
            this(abstractC1062i);
        }

        public final AbstractC1062i.AbstractC0160i b(AbstractC1062i abstractC1062i) {
            while (abstractC1062i instanceof n0) {
                n0 n0Var = (n0) abstractC1062i;
                this.f11132a.push(n0Var);
                abstractC1062i = n0Var.f11124f;
            }
            return (AbstractC1062i.AbstractC0160i) abstractC1062i;
        }

        public final AbstractC1062i.AbstractC0160i c() {
            AbstractC1062i.AbstractC0160i abstractC0160iB;
            do {
                ArrayDeque arrayDeque = this.f11132a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                abstractC0160iB = b(((n0) this.f11132a.pop()).f11125g);
            } while (abstractC0160iB.isEmpty());
            return abstractC0160iB;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public AbstractC1062i.AbstractC0160i next() {
            AbstractC1062i.AbstractC0160i abstractC0160i = this.f11133b;
            if (abstractC0160i == null) {
                throw new NoSuchElementException();
            }
            this.f11133b = c();
            return abstractC0160i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11133b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public c(AbstractC1062i abstractC1062i) {
            if (!(abstractC1062i instanceof n0)) {
                this.f11132a = null;
                this.f11133b = (AbstractC1062i.AbstractC0160i) abstractC1062i;
                return;
            }
            n0 n0Var = (n0) abstractC1062i;
            ArrayDeque arrayDeque = new ArrayDeque(n0Var.u());
            this.f11132a = arrayDeque;
            arrayDeque.push(n0Var);
            this.f11133b = b(n0Var.f11124f);
        }
    }

    public /* synthetic */ n0(AbstractC1062i abstractC1062i, AbstractC1062i abstractC1062i2, a aVar) {
        this(abstractC1062i, abstractC1062i2);
    }

    public static AbstractC1062i T(AbstractC1062i abstractC1062i, AbstractC1062i abstractC1062i2) {
        if (abstractC1062i2.size() == 0) {
            return abstractC1062i;
        }
        if (abstractC1062i.size() == 0) {
            return abstractC1062i2;
        }
        int size = abstractC1062i.size() + abstractC1062i2.size();
        if (size < 128) {
            return U(abstractC1062i, abstractC1062i2);
        }
        if (abstractC1062i instanceof n0) {
            n0 n0Var = (n0) abstractC1062i;
            if (n0Var.f11125g.size() + abstractC1062i2.size() < 128) {
                return new n0(n0Var.f11124f, U(n0Var.f11125g, abstractC1062i2));
            }
            if (n0Var.f11124f.u() > n0Var.f11125g.u() && n0Var.u() > abstractC1062i2.u()) {
                return new n0(n0Var.f11124f, new n0(n0Var.f11125g, abstractC1062i2));
            }
        }
        return size >= W(Math.max(abstractC1062i.u(), abstractC1062i2.u()) + 1) ? new n0(abstractC1062i, abstractC1062i2) : new b(null).b(abstractC1062i, abstractC1062i2);
    }

    public static AbstractC1062i U(AbstractC1062i abstractC1062i, AbstractC1062i abstractC1062i2) {
        int size = abstractC1062i.size();
        int size2 = abstractC1062i2.size();
        byte[] bArr = new byte[size + size2];
        abstractC1062i.s(bArr, 0, 0, size);
        abstractC1062i2.s(bArr, 0, size, size2);
        return AbstractC1062i.N(bArr);
    }

    public static int W(int i4) {
        int[] iArr = f11122j;
        if (i4 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i4];
    }

    @Override // com.google.protobuf.AbstractC1062i
    public AbstractC1063j A() {
        return AbstractC1063j.i(S(), true);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public int B(int i4, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.f11126h;
        if (i7 <= i8) {
            return this.f11124f.B(i4, i5, i6);
        }
        if (i5 >= i8) {
            return this.f11125g.B(i4, i5 - i8, i6);
        }
        int i9 = i8 - i5;
        return this.f11125g.B(this.f11124f.B(i4, i5, i9), 0, i6 - i9);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public int C(int i4, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.f11126h;
        if (i7 <= i8) {
            return this.f11124f.C(i4, i5, i6);
        }
        if (i5 >= i8) {
            return this.f11125g.C(i4, i5 - i8, i6);
        }
        int i9 = i8 - i5;
        return this.f11125g.C(this.f11124f.C(i4, i5, i9), 0, i6 - i9);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public AbstractC1062i F(int i4, int i5) {
        int iM = AbstractC1062i.m(i4, i5, this.f11123e);
        if (iM == 0) {
            return AbstractC1062i.f11025b;
        }
        if (iM == this.f11123e) {
            return this;
        }
        int i6 = this.f11126h;
        return i5 <= i6 ? this.f11124f.F(i4, i5) : i4 >= i6 ? this.f11125g.F(i4 - i6, i5 - i6) : new n0(this.f11124f.E(i4), this.f11125g.F(0, i5 - this.f11126h));
    }

    @Override // com.google.protobuf.AbstractC1062i
    public String J(Charset charset) {
        return new String(G(), charset);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public void P(AbstractC1061h abstractC1061h) {
        this.f11124f.P(abstractC1061h);
        this.f11125g.P(abstractC1061h);
    }

    public List S() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().f());
        }
        return arrayList;
    }

    public final boolean V(AbstractC1062i abstractC1062i) {
        a aVar = null;
        c cVar = new c(this, aVar);
        AbstractC1062i.AbstractC0160i abstractC0160i = (AbstractC1062i.AbstractC0160i) cVar.next();
        c cVar2 = new c(abstractC1062i, aVar);
        AbstractC1062i.AbstractC0160i abstractC0160i2 = (AbstractC1062i.AbstractC0160i) cVar2.next();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int size = abstractC0160i.size() - i4;
            int size2 = abstractC0160i2.size() - i5;
            int iMin = Math.min(size, size2);
            if (!(i4 == 0 ? abstractC0160i.Q(abstractC0160i2, i5, iMin) : abstractC0160i2.Q(abstractC0160i, i4, iMin))) {
                return false;
            }
            i6 += iMin;
            int i7 = this.f11123e;
            if (i6 >= i7) {
                if (i6 == i7) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                i4 = 0;
                abstractC0160i = (AbstractC1062i.AbstractC0160i) cVar.next();
            } else {
                i4 += iMin;
                abstractC0160i = abstractC0160i;
            }
            if (iMin == size2) {
                abstractC0160i2 = (AbstractC1062i.AbstractC0160i) cVar2.next();
                i5 = 0;
            } else {
                i5 += iMin;
            }
        }
    }

    @Override // com.google.protobuf.AbstractC1062i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1062i)) {
            return false;
        }
        AbstractC1062i abstractC1062i = (AbstractC1062i) obj;
        if (this.f11123e != abstractC1062i.size()) {
            return false;
        }
        if (this.f11123e == 0) {
            return true;
        }
        int iD = D();
        int iD2 = abstractC1062i.D();
        if (iD == 0 || iD2 == 0 || iD == iD2) {
            return V(abstractC1062i);
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractC1062i
    public ByteBuffer f() {
        return ByteBuffer.wrap(G()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.AbstractC1062i
    public byte k(int i4) {
        AbstractC1062i.l(i4, this.f11123e);
        return v(i4);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public int size() {
        return this.f11123e;
    }

    @Override // com.google.protobuf.AbstractC1062i
    public void t(byte[] bArr, int i4, int i5, int i6) {
        int i7 = i4 + i6;
        int i8 = this.f11126h;
        if (i7 <= i8) {
            this.f11124f.t(bArr, i4, i5, i6);
        } else {
            if (i4 >= i8) {
                this.f11125g.t(bArr, i4 - i8, i5, i6);
                return;
            }
            int i9 = i8 - i4;
            this.f11124f.t(bArr, i4, i5, i9);
            this.f11125g.t(bArr, 0, i5 + i9, i6 - i9);
        }
    }

    @Override // com.google.protobuf.AbstractC1062i
    public int u() {
        return this.f11127i;
    }

    @Override // com.google.protobuf.AbstractC1062i
    public byte v(int i4) {
        int i5 = this.f11126h;
        return i4 < i5 ? this.f11124f.v(i4) : this.f11125g.v(i4 - i5);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public boolean w() {
        return this.f11123e >= W(this.f11127i);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public boolean x() {
        int iC = this.f11124f.C(0, 0, this.f11126h);
        AbstractC1062i abstractC1062i = this.f11125g;
        return abstractC1062i.C(iC, 0, abstractC1062i.size()) == 0;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public AbstractC1062i.g iterator() {
        return new a();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque f11131a;

        public b() {
            this.f11131a = new ArrayDeque();
        }

        public final AbstractC1062i b(AbstractC1062i abstractC1062i, AbstractC1062i abstractC1062i2) {
            c(abstractC1062i);
            c(abstractC1062i2);
            AbstractC1062i n0Var = (AbstractC1062i) this.f11131a.pop();
            while (!this.f11131a.isEmpty()) {
                n0Var = new n0((AbstractC1062i) this.f11131a.pop(), n0Var, null);
            }
            return n0Var;
        }

        public final void c(AbstractC1062i abstractC1062i) {
            if (abstractC1062i.w()) {
                e(abstractC1062i);
                return;
            }
            if (abstractC1062i instanceof n0) {
                n0 n0Var = (n0) abstractC1062i;
                c(n0Var.f11124f);
                c(n0Var.f11125g);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + abstractC1062i.getClass());
            }
        }

        public final int d(int i4) {
            int iBinarySearch = Arrays.binarySearch(n0.f11122j, i4);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        public final void e(AbstractC1062i abstractC1062i) {
            a aVar;
            int iD = d(abstractC1062i.size());
            int iW = n0.W(iD + 1);
            if (this.f11131a.isEmpty() || ((AbstractC1062i) this.f11131a.peek()).size() >= iW) {
                this.f11131a.push(abstractC1062i);
                return;
            }
            int iW2 = n0.W(iD);
            AbstractC1062i n0Var = (AbstractC1062i) this.f11131a.pop();
            while (true) {
                aVar = null;
                if (this.f11131a.isEmpty() || ((AbstractC1062i) this.f11131a.peek()).size() >= iW2) {
                    break;
                } else {
                    n0Var = new n0((AbstractC1062i) this.f11131a.pop(), n0Var, aVar);
                }
            }
            n0 n0Var2 = new n0(n0Var, abstractC1062i, aVar);
            while (!this.f11131a.isEmpty()) {
                if (((AbstractC1062i) this.f11131a.peek()).size() >= n0.W(d(n0Var2.size()) + 1)) {
                    break;
                } else {
                    n0Var2 = new n0((AbstractC1062i) this.f11131a.pop(), n0Var2, aVar);
                }
            }
            this.f11131a.push(n0Var2);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public n0(AbstractC1062i abstractC1062i, AbstractC1062i abstractC1062i2) {
        this.f11124f = abstractC1062i;
        this.f11125g = abstractC1062i2;
        int size = abstractC1062i.size();
        this.f11126h = size;
        this.f11123e = size + abstractC1062i2.size();
        this.f11127i = Math.max(abstractC1062i.u(), abstractC1062i2.u()) + 1;
    }
}
