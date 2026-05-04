package oc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends cc.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f17834b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final lc.a f17835d;

        public a(lc.a aVar, Object[] objArr) {
            super(objArr);
            this.f17835d = aVar;
        }

        @Override // oc.l.c
        public void a() {
            Object[] objArr = this.f17837a;
            int length = objArr.length;
            lc.a aVar = this.f17835d;
            for (int i10 = this.f17838b; i10 != length; i10++) {
                if (this.f17839c) {
                    return;
                }
                Object obj = objArr[i10];
                if (obj == null) {
                    aVar.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                aVar.d(obj);
            }
            if (this.f17839c) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        
            r10.f17838b = r2;
            r11 = addAndGet(-r6);
         */
        @Override // oc.l.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r11) {
            /*
                r10 = this;
                java.lang.Object[] r0 = r10.f17837a
                int r1 = r0.length
                int r2 = r10.f17838b
                lc.a r3 = r10.f17835d
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L44
                if (r2 == r1) goto L44
                boolean r8 = r10.f17839c
                if (r8 == 0) goto L15
                goto L61
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L38
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "The element at index "
                r12.append(r0)
                r12.append(r2)
                java.lang.String r0 = " is null"
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                r3.onError(r11)
                return
            L38:
                boolean r8 = r3.d(r8)
                if (r8 == 0) goto L41
                r8 = 1
                long r6 = r6 + r8
            L41:
                int r2 = r2 + 1
                goto La
            L44:
                if (r2 != r1) goto L4e
                boolean r11 = r10.f17839c
                if (r11 != 0) goto L61
                r3.onComplete()
                return
            L4e:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f17838b = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L61:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.l.a.b(long):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final kh.b f17836d;

        public b(kh.b bVar, Object[] objArr) {
            super(objArr);
            this.f17836d = bVar;
        }

        @Override // oc.l.c
        public void a() {
            Object[] objArr = this.f17837a;
            int length = objArr.length;
            kh.b bVar = this.f17836d;
            for (int i10 = this.f17838b; i10 != length; i10++) {
                if (this.f17839c) {
                    return;
                }
                Object obj = objArr[i10];
                if (obj == null) {
                    bVar.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                bVar.onNext(obj);
            }
            if (this.f17839c) {
                return;
            }
            bVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
        
            r10.f17838b = r2;
            r11 = addAndGet(-r6);
         */
        @Override // oc.l.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r11) {
            /*
                r10 = this;
                java.lang.Object[] r0 = r10.f17837a
                int r1 = r0.length
                int r2 = r10.f17838b
                kh.b r3 = r10.f17836d
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L41
                if (r2 == r1) goto L41
                boolean r8 = r10.f17839c
                if (r8 == 0) goto L15
                goto L5e
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L38
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "The element at index "
                r12.append(r0)
                r12.append(r2)
                java.lang.String r0 = " is null"
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                r3.onError(r11)
                return
            L38:
                r3.onNext(r8)
                r8 = 1
                long r6 = r6 + r8
                int r2 = r2 + 1
                goto La
            L41:
                if (r2 != r1) goto L4b
                boolean r11 = r10.f17839c
                if (r11 != 0) goto L5e
                r3.onComplete()
                return
            L4b:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f17838b = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.l.b.b(long):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c extends wc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f17837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f17839c;

        public c(Object[] objArr) {
            this.f17837a = objArr;
        }

        public abstract void a();

        public abstract void b(long j10);

        @Override // kh.c
        public final void cancel() {
            this.f17839c = true;
        }

        @Override // lc.i
        public final void clear() {
            this.f17838b = this.f17837a.length;
        }

        @Override // lc.e
        public final int h(int i10) {
            return i10 & 1;
        }

        @Override // lc.i
        public final boolean isEmpty() {
            return this.f17838b == this.f17837a.length;
        }

        @Override // lc.i
        public final Object poll() {
            int i10 = this.f17838b;
            Object[] objArr = this.f17837a;
            if (i10 == objArr.length) {
                return null;
            }
            this.f17838b = i10 + 1;
            return kc.b.d(objArr[i10], "array element is null");
        }

        @Override // kh.c
        public final void request(long j10) {
            if (wc.g.l(j10) && xc.d.a(this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j10);
                }
            }
        }
    }

    public l(Object[] objArr) {
        this.f17834b = objArr;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        if (bVar instanceof lc.a) {
            bVar.b(new a((lc.a) bVar, this.f17834b));
        } else {
            bVar.b(new b(bVar, this.f17834b));
        }
    }
}
