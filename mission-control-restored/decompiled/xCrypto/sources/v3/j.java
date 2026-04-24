package v3;

import java.util.concurrent.atomic.AtomicReferenceArray;
import y3.C;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends C {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f15368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReferenceArray f15369f;

    public j(long j4, j jVar, b bVar, int i4) {
        super(j4, jVar, i4);
        this.f15368e = bVar;
        this.f15369f = new AtomicReferenceArray(c.f15341b * 2);
    }

    public final void A(int i4, Object obj) {
        this.f15369f.set((i4 * 2) + 1, obj);
    }

    public final void B(int i4, Object obj) {
        z(i4, obj);
    }

    @Override // y3.C
    public int n() {
        return c.f15341b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        s(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        r4 = u().f15332b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r4 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        y3.x.b(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    @Override // y3.C
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(int r4, java.lang.Throwable r5, Z2.i r6) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r3 = this;
            int r5 = v3.c.f15341b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.v(r4)
        Le:
            java.lang.Object r1 = r3.w(r4)
            boolean r2 = r1 instanceof t3.b1
            if (r2 != 0) goto L73
            boolean r2 = r1 instanceof v3.v
            if (r2 == 0) goto L1b
            goto L73
        L1b:
            y3.F r2 = v3.c.j()
            if (r1 == r2) goto L62
            y3.F r2 = v3.c.i()
            if (r1 != r2) goto L28
            goto L62
        L28:
            y3.F r2 = v3.c.p()
            if (r1 == r2) goto Le
            y3.F r2 = v3.c.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            y3.F r4 = v3.c.f()
            if (r1 == r4) goto L99
            y3.F r4 = v3.c.f15343d
            if (r1 != r4) goto L40
            goto L99
        L40:
            y3.F r4 = v3.c.z()
            if (r1 != r4) goto L47
            goto L99
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            r3.s(r4)
            if (r0 == 0) goto L99
            v3.b r4 = r3.u()
            i3.k r4 = r4.f15332b
            if (r4 == 0) goto L99
            y3.x.b(r4, r5, r6)
            return
        L73:
            if (r0 == 0) goto L7a
            y3.F r2 = v3.c.j()
            goto L7e
        L7a:
            y3.F r2 = v3.c.i()
        L7e:
            boolean r1 = r3.r(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.s(r4)
            r1 = r0 ^ 1
            r3.x(r4, r1)
            if (r0 == 0) goto L99
            v3.b r4 = r3.u()
            i3.k r4 = r4.f15332b
            if (r4 == 0) goto L99
            y3.x.b(r4, r5, r6)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.j.o(int, java.lang.Throwable, Z2.i):void");
    }

    public final boolean r(int i4, Object obj, Object obj2) {
        return i.a(this.f15369f, (i4 * 2) + 1, obj, obj2);
    }

    public final void s(int i4) {
        z(i4, null);
    }

    public final Object t(int i4, Object obj) {
        return this.f15369f.getAndSet((i4 * 2) + 1, obj);
    }

    public final b u() {
        b bVar = this.f15368e;
        kotlin.jvm.internal.r.c(bVar);
        return bVar;
    }

    public final Object v(int i4) {
        return this.f15369f.get(i4 * 2);
    }

    public final Object w(int i4) {
        return this.f15369f.get((i4 * 2) + 1);
    }

    public final void x(int i4, boolean z4) {
        if (z4) {
            u().F0((this.f15955c * ((long) c.f15341b)) + ((long) i4));
        }
        p();
    }

    public final Object y(int i4) {
        Object objV = v(i4);
        s(i4);
        return objV;
    }

    public final void z(int i4, Object obj) {
        this.f15369f.lazySet(i4 * 2, obj);
    }
}
