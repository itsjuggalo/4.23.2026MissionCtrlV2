package b5;

import i5.AbstractC1928b;
import i5.EnumC1933g;

/* JADX INFO: renamed from: b5.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1214l extends P4.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f13084b;

    /* JADX INFO: renamed from: b5.l$a */
    public static final class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Y4.a f13085d;

        public a(Y4.a aVar, Object[] objArr) {
            super(objArr);
            this.f13085d = aVar;
        }

        @Override // b5.C1214l.c
        public void a() {
            Object[] objArr = this.f13087a;
            int length = objArr.length;
            Y4.a aVar = this.f13085d;
            for (int i8 = this.f13088b; i8 != length; i8++) {
                if (this.f13089c) {
                    return;
                }
                Object obj = objArr[i8];
                if (obj == null) {
                    aVar.onError(new NullPointerException("array element is null"));
                    return;
                }
                aVar.e(obj);
            }
            if (this.f13089c) {
                return;
            }
            aVar.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        
            r10.f13088b = r2;
            r11 = addAndGet(-r6);
         */
        @Override // b5.C1214l.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r11) {
            /*
                r10 = this;
                java.lang.Object[] r0 = r10.f13087a
                int r1 = r0.length
                int r2 = r10.f13088b
                Y4.a r3 = r10.f13085d
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L30
                if (r2 == r1) goto L30
                boolean r8 = r10.f13089c
                if (r8 == 0) goto L15
                return
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L24
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L24:
                boolean r8 = r3.e(r8)
                if (r8 == 0) goto L2d
                r8 = 1
                long r6 = r6 + r8
            L2d:
                int r2 = r2 + 1
                goto La
            L30:
                if (r2 != r1) goto L3a
                boolean r11 = r10.f13089c
                if (r11 != 0) goto L39
                r3.a()
            L39:
                return
            L3a:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f13088b = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b5.C1214l.a.b(long):void");
        }
    }

    /* JADX INFO: renamed from: b5.l$b */
    public static final class b extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final x7.b f13086d;

        public b(x7.b bVar, Object[] objArr) {
            super(objArr);
            this.f13086d = bVar;
        }

        @Override // b5.C1214l.c
        public void a() {
            Object[] objArr = this.f13087a;
            int length = objArr.length;
            x7.b bVar = this.f13086d;
            for (int i8 = this.f13088b; i8 != length; i8++) {
                if (this.f13089c) {
                    return;
                }
                Object obj = objArr[i8];
                if (obj == null) {
                    bVar.onError(new NullPointerException("array element is null"));
                    return;
                }
                bVar.c(obj);
            }
            if (this.f13089c) {
                return;
            }
            bVar.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        
            r10.f13088b = r2;
            r11 = addAndGet(-r6);
         */
        @Override // b5.C1214l.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r11) {
            /*
                r10 = this;
                java.lang.Object[] r0 = r10.f13087a
                int r1 = r0.length
                int r2 = r10.f13088b
                x7.b r3 = r10.f13086d
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L2d
                if (r2 == r1) goto L2d
                boolean r8 = r10.f13089c
                if (r8 == 0) goto L15
                return
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L24
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L24:
                r3.c(r8)
                r8 = 1
                long r6 = r6 + r8
                int r2 = r2 + 1
                goto La
            L2d:
                if (r2 != r1) goto L37
                boolean r11 = r10.f13089c
                if (r11 != 0) goto L36
                r3.a()
            L36:
                return
            L37:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f13088b = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b5.C1214l.b.b(long):void");
        }
    }

    /* JADX INFO: renamed from: b5.l$c */
    public static abstract class c extends AbstractC1928b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f13087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f13089c;

        public c(Object[] objArr) {
            this.f13087a = objArr;
        }

        public abstract void a();

        public abstract void b(long j8);

        @Override // x7.c
        public final void cancel() {
            this.f13089c = true;
        }

        @Override // Y4.j
        public final void clear() {
            this.f13088b = this.f13087a.length;
        }

        @Override // x7.c
        public final void i(long j8) {
            if (EnumC1933g.n(j8) && j5.d.a(this, j8) == 0) {
                if (j8 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j8);
                }
            }
        }

        @Override // Y4.j
        public final boolean isEmpty() {
            return this.f13088b == this.f13087a.length;
        }

        @Override // Y4.f
        public final int k(int i8) {
            return i8 & 1;
        }

        @Override // Y4.j
        public final Object poll() {
            int i8 = this.f13088b;
            Object[] objArr = this.f13087a;
            if (i8 == objArr.length) {
                return null;
            }
            this.f13088b = i8 + 1;
            return X4.b.d(objArr[i8], "array element is null");
        }
    }

    public C1214l(Object[] objArr) {
        this.f13084b = objArr;
    }

    @Override // P4.f
    public void I(x7.b bVar) {
        bVar.d(bVar instanceof Y4.a ? new a((Y4.a) bVar, this.f13084b) : new b(bVar, this.f13084b));
    }
}
