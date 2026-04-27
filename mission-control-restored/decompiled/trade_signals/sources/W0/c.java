package W0;

import W0.f;
import a1.n;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c implements f, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f9036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.a f9037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public U0.f f9039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f9040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile n.a f9042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f9043i;

    public c(g gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean b() {
        return this.f9041g < this.f9040f.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (b() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.f9040f;
        r3 = r7.f9041g;
        r7.f9041g = r3 + 1;
        r7.f9042h = ((a1.n) r0.get(r3)).a(r7.f9043i, r7.f9036b.t(), r7.f9036b.f(), r7.f9036b.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.f9042h == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.f9036b.u(r7.f9042h.f9867c.a()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.f9042h.f9867c.e(r7.f9036b.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.f9042h = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r2 != false) goto L40;
     */
    @Override // W0.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            r1.AbstractC2671b.a(r0)
        L5:
            java.util.List r0 = r7.f9040f     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            boolean r0 = r7.b()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L12
            goto L6e
        L12:
            r0 = 0
            r7.f9042h = r0     // Catch: java.lang.Throwable -> L68
        L15:
            if (r2 != 0) goto L6a
            boolean r0 = r7.b()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L6a
            java.util.List r0 = r7.f9040f     // Catch: java.lang.Throwable -> L68
            int r3 = r7.f9041g     // Catch: java.lang.Throwable -> L68
            int r4 = r3 + 1
            r7.f9041g = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L68
            a1.n r0 = (a1.n) r0     // Catch: java.lang.Throwable -> L68
            java.io.File r3 = r7.f9043i     // Catch: java.lang.Throwable -> L68
            W0.g r4 = r7.f9036b     // Catch: java.lang.Throwable -> L68
            int r4 = r4.t()     // Catch: java.lang.Throwable -> L68
            W0.g r5 = r7.f9036b     // Catch: java.lang.Throwable -> L68
            int r5 = r5.f()     // Catch: java.lang.Throwable -> L68
            W0.g r6 = r7.f9036b     // Catch: java.lang.Throwable -> L68
            U0.h r6 = r6.k()     // Catch: java.lang.Throwable -> L68
            a1.n$a r0 = r0.a(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L68
            r7.f9042h = r0     // Catch: java.lang.Throwable -> L68
            a1.n$a r0 = r7.f9042h     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            W0.g r0 = r7.f9036b     // Catch: java.lang.Throwable -> L68
            a1.n$a r3 = r7.f9042h     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.d r3 = r3.f9867c     // Catch: java.lang.Throwable -> L68
            java.lang.Class r3 = r3.a()     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.u(r3)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            a1.n$a r0 = r7.f9042h     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.d r0 = r0.f9867c     // Catch: java.lang.Throwable -> L68
            W0.g r2 = r7.f9036b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.g r2 = r2.l()     // Catch: java.lang.Throwable -> L68
            r0.e(r2, r7)     // Catch: java.lang.Throwable -> L68
            r2 = r1
            goto L15
        L68:
            r0 = move-exception
            goto Lb0
        L6a:
            r1.AbstractC2671b.e()
            return r2
        L6e:
            int r0 = r7.f9038d     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r1
            r7.f9038d = r0     // Catch: java.lang.Throwable -> L68
            java.util.List r1 = r7.f9035a     // Catch: java.lang.Throwable -> L68
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68
            if (r0 < r1) goto L7f
            r1.AbstractC2671b.e()
            return r2
        L7f:
            java.util.List r0 = r7.f9035a     // Catch: java.lang.Throwable -> L68
            int r1 = r7.f9038d     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68
            U0.f r0 = (U0.f) r0     // Catch: java.lang.Throwable -> L68
            W0.d r1 = new W0.d     // Catch: java.lang.Throwable -> L68
            W0.g r3 = r7.f9036b     // Catch: java.lang.Throwable -> L68
            U0.f r3 = r3.p()     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L68
            W0.g r3 = r7.f9036b     // Catch: java.lang.Throwable -> L68
            Y0.a r3 = r3.d()     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = r3.b(r1)     // Catch: java.lang.Throwable -> L68
            r7.f9043i = r1     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L5
            r7.f9039e = r0     // Catch: java.lang.Throwable -> L68
            W0.g r0 = r7.f9036b     // Catch: java.lang.Throwable -> L68
            java.util.List r0 = r0.j(r1)     // Catch: java.lang.Throwable -> L68
            r7.f9040f = r0     // Catch: java.lang.Throwable -> L68
            r7.f9041g = r2     // Catch: java.lang.Throwable -> L68
            goto L5
        Lb0:
            r1.AbstractC2671b.e()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.c.a():boolean");
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(Exception exc) {
        this.f9037c.i(this.f9039e, exc, this.f9042h.f9867c, U0.a.DATA_DISK_CACHE);
    }

    @Override // W0.f
    public void cancel() {
        n.a aVar = this.f9042h;
        if (aVar != null) {
            aVar.f9867c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void f(Object obj) {
        this.f9037c.g(this.f9039e, obj, this.f9042h.f9867c, U0.a.DATA_DISK_CACHE, this.f9039e);
    }

    public c(List list, g gVar, f.a aVar) {
        this.f9038d = -1;
        this.f9035a = list;
        this.f9036b = gVar;
        this.f9037c = aVar;
    }
}
