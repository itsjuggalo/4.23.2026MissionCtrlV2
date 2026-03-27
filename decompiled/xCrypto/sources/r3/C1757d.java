package r3;

import j3.InterfaceC1564a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import o3.AbstractC1681l;
import o3.C1676g;

/* JADX INFO: renamed from: r3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1757d implements q3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f14569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i3.o f14572d;

    /* JADX INFO: renamed from: r3.d$a */
    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14573a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C1676g f14576d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14577e;

        public a() {
            int iF = AbstractC1681l.f(C1757d.this.f14570b, 0, C1757d.this.f14569a.length());
            this.f14574b = iF;
            this.f14575c = iF;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b() {
            /*
                r6 = this;
                int r0 = r6.f14575c
                r1 = 0
                if (r0 >= 0) goto Lb
                r6.f14573a = r1
                r0 = 0
                r6.f14576d = r0
                return
            Lb:
                r3.d r0 = r3.C1757d.this
                int r0 = r3.C1757d.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L22
                int r0 = r6.f14577e
                int r0 = r0 + r3
                r6.f14577e = r0
                r3.d r4 = r3.C1757d.this
                int r4 = r3.C1757d.e(r4)
                if (r0 >= r4) goto L30
            L22:
                int r0 = r6.f14575c
                r3.d r4 = r3.C1757d.this
                java.lang.CharSequence r4 = r3.C1757d.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L46
            L30:
                o3.g r0 = new o3.g
                int r1 = r6.f14574b
                r3.d r4 = r3.C1757d.this
                java.lang.CharSequence r4 = r3.C1757d.d(r4)
                int r4 = r3.AbstractC1753A.M(r4)
                r0.<init>(r1, r4)
                r6.f14576d = r0
                r6.f14575c = r2
                goto L9b
            L46:
                r3.d r0 = r3.C1757d.this
                i3.o r0 = r3.C1757d.c(r0)
                r3.d r4 = r3.C1757d.this
                java.lang.CharSequence r4 = r3.C1757d.d(r4)
                int r5 = r6.f14575c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                W2.o r0 = (W2.o) r0
                if (r0 != 0) goto L76
                o3.g r0 = new o3.g
                int r1 = r6.f14574b
                r3.d r4 = r3.C1757d.this
                java.lang.CharSequence r4 = r3.C1757d.d(r4)
                int r4 = r3.AbstractC1753A.M(r4)
                r0.<init>(r1, r4)
                r6.f14576d = r0
                r6.f14575c = r2
                goto L9b
            L76:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f14574b
                o3.g r4 = o3.AbstractC1681l.l(r4, r2)
                r6.f14576d = r4
                int r2 = r2 + r0
                r6.f14574b = r2
                if (r0 != 0) goto L98
                r1 = r3
            L98:
                int r2 = r2 + r1
                r6.f14575c = r2
            L9b:
                r6.f14573a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.C1757d.a.b():void");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public C1676g next() {
            if (this.f14573a == -1) {
                b();
            }
            if (this.f14573a == 0) {
                throw new NoSuchElementException();
            }
            C1676g c1676g = this.f14576d;
            kotlin.jvm.internal.r.d(c1676g, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f14576d = null;
            this.f14573a = -1;
            return c1676g;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14573a == -1) {
                b();
            }
            return this.f14573a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C1757d(CharSequence input, int i4, int i5, i3.o getNextMatch) {
        kotlin.jvm.internal.r.f(input, "input");
        kotlin.jvm.internal.r.f(getNextMatch, "getNextMatch");
        this.f14569a = input;
        this.f14570b = i4;
        this.f14571c = i5;
        this.f14572d = getNextMatch;
    }

    @Override // q3.e
    public Iterator iterator() {
        return new a();
    }
}
