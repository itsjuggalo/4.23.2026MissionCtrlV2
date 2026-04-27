package Z5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Y5.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f6024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Q5.o f6027d;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6028a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public W5.g f6031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6032e;

        public a() {
            int iF = W5.l.f(d.this.f6025b, 0, d.this.f6024a.length());
            this.f6029b = iF;
            this.f6030c = iF;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void c() {
            /*
                r6 = this;
                int r0 = r6.f6030c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f6028a = r1
                r0 = 0
                r6.f6031d = r0
                goto L9e
            Lc:
                Z5.d r0 = Z5.d.this
                int r0 = Z5.d.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f6032e
                int r0 = r0 + r3
                r6.f6032e = r0
                Z5.d r4 = Z5.d.this
                int r4 = Z5.d.e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f6030c
                Z5.d r4 = Z5.d.this
                java.lang.CharSequence r4 = Z5.d.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                W5.g r0 = new W5.g
                int r1 = r6.f6029b
                Z5.d r4 = Z5.d.this
                java.lang.CharSequence r4 = Z5.d.d(r4)
                int r4 = Z5.u.H(r4)
                r0.<init>(r1, r4)
                r6.f6031d = r0
                r6.f6030c = r2
                goto L9c
            L47:
                Z5.d r0 = Z5.d.this
                Q5.o r0 = Z5.d.c(r0)
                Z5.d r4 = Z5.d.this
                java.lang.CharSequence r4 = Z5.d.d(r4)
                int r5 = r6.f6030c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                E5.o r0 = (E5.o) r0
                if (r0 != 0) goto L77
                W5.g r0 = new W5.g
                int r1 = r6.f6029b
                Z5.d r4 = Z5.d.this
                java.lang.CharSequence r4 = Z5.d.d(r4)
                int r4 = Z5.u.H(r4)
                r0.<init>(r1, r4)
                r6.f6031d = r0
                r6.f6030c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f6029b
                W5.g r4 = W5.l.l(r4, r2)
                r6.f6031d = r4
                int r2 = r2 + r0
                r6.f6029b = r2
                if (r0 != 0) goto L99
                r1 = r3
            L99:
                int r2 = r2 + r1
                r6.f6030c = r2
            L9c:
                r6.f6028a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: Z5.d.a.c():void");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public W5.g next() {
            if (this.f6028a == -1) {
                c();
            }
            if (this.f6028a == 0) {
                throw new NoSuchElementException();
            }
            W5.g gVar = this.f6031d;
            kotlin.jvm.internal.r.d(gVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f6031d = null;
            this.f6028a = -1;
            return gVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6028a == -1) {
                c();
            }
            return this.f6028a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence input, int i7, int i8, Q5.o getNextMatch) {
        kotlin.jvm.internal.r.f(input, "input");
        kotlin.jvm.internal.r.f(getNextMatch, "getNextMatch");
        this.f6024a = input;
        this.f6025b = i7;
        this.f6026c = i8;
        this.f6027d = getNextMatch;
    }

    @Override // Y5.f
    public Iterator iterator() {
        return new a();
    }
}
