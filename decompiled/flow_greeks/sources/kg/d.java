package kg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements jg.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f14864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pd.o f14867d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14868a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public vd.g f14871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14872e;

        public a() {
            int iF = vd.l.f(d.this.f14865b, 0, d.this.f14864a.length());
            this.f14869b = iF;
            this.f14870c = iF;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void c() {
            /*
                r6 = this;
                int r0 = r6.f14870c
                r1 = 0
                if (r0 >= 0) goto Lb
                r6.f14868a = r1
                r0 = 0
                r6.f14871d = r0
                return
            Lb:
                kg.d r0 = kg.d.this
                int r0 = kg.d.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L22
                int r0 = r6.f14872e
                int r0 = r0 + r3
                r6.f14872e = r0
                kg.d r4 = kg.d.this
                int r4 = kg.d.e(r4)
                if (r0 >= r4) goto L30
            L22:
                int r0 = r6.f14870c
                kg.d r4 = kg.d.this
                java.lang.CharSequence r4 = kg.d.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L46
            L30:
                vd.g r0 = new vd.g
                int r1 = r6.f14869b
                kg.d r4 = kg.d.this
                java.lang.CharSequence r4 = kg.d.d(r4)
                int r4 = kg.c0.W(r4)
                r0.<init>(r1, r4)
                r6.f14871d = r0
                r6.f14870c = r2
                goto L9b
            L46:
                kg.d r0 = kg.d.this
                pd.o r0 = kg.d.c(r0)
                kg.d r4 = kg.d.this
                java.lang.CharSequence r4 = kg.d.d(r4)
                int r5 = r6.f14870c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                cd.q r0 = (cd.q) r0
                if (r0 != 0) goto L76
                vd.g r0 = new vd.g
                int r1 = r6.f14869b
                kg.d r4 = kg.d.this
                java.lang.CharSequence r4 = kg.d.d(r4)
                int r4 = kg.c0.W(r4)
                r0.<init>(r1, r4)
                r6.f14871d = r0
                r6.f14870c = r2
                goto L9b
            L76:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f14869b
                vd.g r4 = vd.l.l(r4, r2)
                r6.f14871d = r4
                int r2 = r2 + r0
                r6.f14869b = r2
                if (r0 != 0) goto L98
                r1 = r3
            L98:
                int r2 = r2 + r1
                r6.f14870c = r2
            L9b:
                r6.f14868a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kg.d.a.c():void");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public vd.g next() {
            if (this.f14868a == -1) {
                c();
            }
            if (this.f14868a == 0) {
                throw new NoSuchElementException();
            }
            vd.g gVar = this.f14871d;
            kotlin.jvm.internal.t.d(gVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f14871d = null;
            this.f14868a = -1;
            return gVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14868a == -1) {
                c();
            }
            return this.f14868a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence input, int i10, int i11, pd.o getNextMatch) {
        kotlin.jvm.internal.t.f(input, "input");
        kotlin.jvm.internal.t.f(getNextMatch, "getNextMatch");
        this.f14864a = input;
        this.f14865b = i10;
        this.f14866c = i11;
        this.f14867d = getNextMatch;
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a();
    }
}
