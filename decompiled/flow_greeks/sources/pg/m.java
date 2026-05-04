package pg;

import java.util.concurrent.atomic.AtomicReferenceArray;
import sg.a0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f18673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f18674f;

    public m(long j10, m mVar, e eVar, int i10) {
        super(j10, mVar, i10);
        this.f18673e = eVar;
        this.f18674f = new AtomicReferenceArray(f.f18647b * 2);
    }

    public final Object A(int i10) {
        return z().get(i10 * 2);
    }

    public final Object B(int i10) {
        return z().get((i10 * 2) + 1);
    }

    public final void C(int i10, boolean z10) {
        if (z10) {
            y().b1((this.f20378c * ((long) f.f18647b)) + ((long) i10));
        }
        t();
    }

    public final Object D(int i10) {
        Object objA = A(i10);
        w(i10);
        return objA;
    }

    public final void E(int i10, Object obj) {
        z().set(i10 * 2, obj);
    }

    public final void F(int i10, Object obj) {
        z().set((i10 * 2) + 1, obj);
    }

    public final void G(int i10, Object obj) {
        E(i10, obj);
    }

    @Override // sg.a0
    public int r() {
        return f.f18647b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        w(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        r4 = y().f18641b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r4 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        sg.w.a(r4, r5, r6);
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
    @Override // sg.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r4, java.lang.Throwable r5, gd.i r6) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r3 = this;
            int r5 = pg.f.f18647b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.A(r4)
        Le:
            java.lang.Object r1 = r3.B(r4)
            boolean r2 = r1 instanceof ng.c3
            if (r2 != 0) goto L73
            boolean r2 = r1 instanceof pg.y
            if (r2 == 0) goto L1b
            goto L73
        L1b:
            sg.d0 r2 = pg.f.j()
            if (r1 == r2) goto L62
            sg.d0 r2 = pg.f.i()
            if (r1 != r2) goto L28
            goto L62
        L28:
            sg.d0 r2 = pg.f.p()
            if (r1 == r2) goto Le
            sg.d0 r2 = pg.f.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            sg.d0 r4 = pg.f.f()
            if (r1 == r4) goto L99
            sg.d0 r4 = pg.f.f18649d
            if (r1 != r4) goto L40
            goto L99
        L40:
            sg.d0 r4 = pg.f.z()
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
            r3.w(r4)
            if (r0 == 0) goto L99
            pg.e r4 = r3.y()
            pd.k r4 = r4.f18641b
            if (r4 == 0) goto L99
            sg.w.a(r4, r5, r6)
            return
        L73:
            if (r0 == 0) goto L7a
            sg.d0 r2 = pg.f.j()
            goto L7e
        L7a:
            sg.d0 r2 = pg.f.i()
        L7e:
            boolean r1 = r3.v(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.w(r4)
            r1 = r0 ^ 1
            r3.C(r4, r1)
            if (r0 == 0) goto L99
            pg.e r4 = r3.y()
            pd.k r4 = r4.f18641b
            if (r4 == 0) goto L99
            sg.w.a(r4, r5, r6)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.m.s(int, java.lang.Throwable, gd.i):void");
    }

    public final boolean v(int i10, Object obj, Object obj2) {
        return l.a(z(), (i10 * 2) + 1, obj, obj2);
    }

    public final void w(int i10) {
        E(i10, null);
    }

    public final Object x(int i10, Object obj) {
        return z().getAndSet((i10 * 2) + 1, obj);
    }

    public final e y() {
        e eVar = this.f18673e;
        kotlin.jvm.internal.t.c(eVar);
        return eVar;
    }

    public final /* synthetic */ AtomicReferenceArray z() {
        return this.f18674f;
    }
}
