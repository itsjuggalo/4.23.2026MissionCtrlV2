package V6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: V6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0978d implements U6.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f8962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final B5.o f8965d;

    /* JADX INFO: renamed from: V6.d$a */
    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8966a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public H5.d f8969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8970e;

        public a() {
            int iF = H5.i.f(C0978d.this.f8963b, 0, C0978d.this.f8962a.length());
            this.f8967b = iF;
            this.f8968c = iF;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void c() {
            /*
                r6 = this;
                int r0 = r6.f8968c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f8966a = r1
                r0 = 0
                r6.f8969d = r0
                goto L99
            Lc:
                V6.d r0 = V6.C0978d.this
                int r0 = V6.C0978d.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f8970e
                int r0 = r0 + r3
                r6.f8970e = r0
                V6.d r4 = V6.C0978d.this
                int r4 = V6.C0978d.e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f8968c
                V6.d r4 = V6.C0978d.this
                java.lang.CharSequence r4 = V6.C0978d.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                H5.d r0 = new H5.d
                int r1 = r6.f8967b
                V6.d r4 = V6.C0978d.this
                java.lang.CharSequence r4 = V6.C0978d.d(r4)
                int r4 = V6.C.S(r4)
                r0.<init>(r1, r4)
            L42:
                r6.f8969d = r0
            L44:
                r6.f8968c = r2
                goto L97
            L47:
                V6.d r0 = V6.C0978d.this
                B5.o r0 = V6.C0978d.c(r0)
                V6.d r4 = V6.C0978d.this
                java.lang.CharSequence r4 = V6.C0978d.d(r4)
                int r5 = r6.f8968c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                o5.q r0 = (o5.C2489q) r0
                if (r0 != 0) goto L73
                H5.d r0 = new H5.d
                int r1 = r6.f8967b
                V6.d r4 = V6.C0978d.this
                java.lang.CharSequence r4 = V6.C0978d.d(r4)
                int r4 = V6.C.S(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f8967b
                H5.d r4 = H5.i.l(r4, r2)
                r6.f8969d = r4
                int r2 = r2 + r0
                r6.f8967b = r2
                if (r0 != 0) goto L95
                r1 = r3
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f8966a = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: V6.C0978d.a.c():void");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public H5.d next() {
            if (this.f8966a == -1) {
                c();
            }
            if (this.f8966a == 0) {
                throw new NoSuchElementException();
            }
            H5.d dVar = this.f8969d;
            AbstractC2304t.d(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f8969d = null;
            this.f8966a = -1;
            return dVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8966a == -1) {
                c();
            }
            return this.f8966a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0978d(CharSequence input, int i8, int i9, B5.o getNextMatch) {
        AbstractC2304t.f(input, "input");
        AbstractC2304t.f(getNextMatch, "getNextMatch");
        this.f8962a = input;
        this.f8963b = i8;
        this.f8964c = i9;
        this.f8965d = getNextMatch;
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a();
    }
}
