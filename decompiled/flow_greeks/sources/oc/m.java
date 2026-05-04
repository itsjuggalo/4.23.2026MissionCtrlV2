package oc;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends cc.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable f17840b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a extends wc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator f17841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f17842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17843c;

        public a(Iterator it) {
            this.f17841a = it;
        }

        public abstract void a();

        public abstract void b(long j10);

        @Override // kh.c
        public final void cancel() {
            this.f17842b = true;
        }

        @Override // lc.i
        public final void clear() {
            this.f17841a = null;
        }

        @Override // lc.e
        public final int h(int i10) {
            return i10 & 1;
        }

        @Override // lc.i
        public final boolean isEmpty() {
            Iterator it = this.f17841a;
            return it == null || !it.hasNext();
        }

        @Override // lc.i
        public final Object poll() {
            Iterator it = this.f17841a;
            if (it == null) {
                return null;
            }
            if (!this.f17843c) {
                this.f17843c = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return kc.b.d(this.f17841a.next(), "Iterator.next() returned a null value");
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final lc.a f17844d;

        public b(lc.a aVar, Iterator it) {
            super(it);
            this.f17844d = aVar;
        }

        @Override // oc.m.a
        public void a() {
            Iterator it = this.f17841a;
            lc.a aVar = this.f17844d;
            while (!this.f17842b) {
                try {
                    Object next = it.next();
                    if (this.f17842b) {
                        return;
                    }
                    if (next == null) {
                        aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.d(next);
                    if (this.f17842b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f17842b) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        gc.b.b(th);
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    gc.b.b(th2);
                    aVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // oc.m.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r9) {
            /*
                r8 = this;
                java.util.Iterator r0 = r8.f17841a
                lc.a r1 = r8.f17844d
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L53
                boolean r6 = r8.f17842b
                if (r6 == 0) goto L10
                goto L64
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4b
                boolean r7 = r8.f17842b
                if (r7 == 0) goto L19
                goto L64
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                boolean r6 = r1.d(r6)
                boolean r7 = r8.f17842b
                if (r7 == 0) goto L2f
                goto L64
            L2f:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L43
                if (r7 != 0) goto L3d
                boolean r9 = r8.f17842b
                if (r9 != 0) goto L64
                r1.onComplete()
                return
            L3d:
                if (r6 == 0) goto L7
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L43:
                r9 = move-exception
                gc.b.b(r9)
                r1.onError(r9)
                return
            L4b:
                r9 = move-exception
                gc.b.b(r9)
                r1.onError(r9)
                return
            L53:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
            L64:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.m.b.b(long):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final kh.b f17845d;

        public c(kh.b bVar, Iterator it) {
            super(it);
            this.f17845d = bVar;
        }

        @Override // oc.m.a
        public void a() {
            Iterator it = this.f17841a;
            kh.b bVar = this.f17845d;
            while (!this.f17842b) {
                try {
                    Object next = it.next();
                    if (this.f17842b) {
                        return;
                    }
                    if (next == null) {
                        bVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    bVar.onNext(next);
                    if (this.f17842b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f17842b) {
                                return;
                            }
                            bVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        gc.b.b(th);
                        bVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    gc.b.b(th2);
                    bVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0058, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // oc.m.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r9) {
            /*
                r8 = this;
                java.util.Iterator r0 = r8.f17841a
                kh.b r1 = r8.f17845d
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L50
                boolean r6 = r8.f17842b
                if (r6 == 0) goto L10
                goto L61
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L48
                boolean r7 = r8.f17842b
                if (r7 == 0) goto L19
                goto L61
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                r1.onNext(r6)
                boolean r6 = r8.f17842b
                if (r6 == 0) goto L2e
                goto L61
            L2e:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L40
                if (r6 != 0) goto L3c
                boolean r9 = r8.f17842b
                if (r9 != 0) goto L61
                r1.onComplete()
                return
            L3c:
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L40:
                r9 = move-exception
                gc.b.b(r9)
                r1.onError(r9)
                return
            L48:
                r9 = move-exception
                gc.b.b(r9)
                r1.onError(r9)
                return
            L50:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
            L61:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.m.c.b(long):void");
        }
    }

    public m(Iterable iterable) {
        this.f17840b = iterable;
    }

    public static void K(kh.b bVar, Iterator it) {
        try {
            if (!it.hasNext()) {
                wc.d.a(bVar);
            } else if (bVar instanceof lc.a) {
                bVar.b(new b((lc.a) bVar, it));
            } else {
                bVar.b(new c(bVar, it));
            }
        } catch (Throwable th) {
            gc.b.b(th);
            wc.d.b(th, bVar);
        }
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        try {
            K(bVar, this.f17840b.iterator());
        } catch (Throwable th) {
            gc.b.b(th);
            wc.d.b(th, bVar);
        }
    }
}
