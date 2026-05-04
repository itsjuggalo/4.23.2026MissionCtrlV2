package i3;

import com.bumptech.glide.load.data.d;
import i3.f;
import java.io.File;
import java.util.List;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements f, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f11581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.a f11582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g3.f f11584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f11585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile n.a f11587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f11588i;

    public c(g gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean a() {
        return this.f11586g < this.f11585f.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (a() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.f11585f;
        r3 = r7.f11586g;
        r7.f11586g = r3 + 1;
        r7.f11587h = ((m3.n) r0.get(r3)).b(r7.f11588i, r7.f11581b.t(), r7.f11581b.f(), r7.f11581b.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.f11587h == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.f11581b.u(r7.f11587h.f15805c.a()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.f11587h.f15805c.e(r7.f11581b.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.f11587h = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r2 != false) goto L40;
     */
    @Override // i3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            d4.b.a(r0)
        L5:
            java.util.List r0 = r7.f11585f     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L12
            goto L6e
        L12:
            r0 = 0
            r7.f11587h = r0     // Catch: java.lang.Throwable -> L68
        L15:
            if (r2 != 0) goto L6a
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L6a
            java.util.List r0 = r7.f11585f     // Catch: java.lang.Throwable -> L68
            int r3 = r7.f11586g     // Catch: java.lang.Throwable -> L68
            int r4 = r3 + 1
            r7.f11586g = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L68
            m3.n r0 = (m3.n) r0     // Catch: java.lang.Throwable -> L68
            java.io.File r3 = r7.f11588i     // Catch: java.lang.Throwable -> L68
            i3.g r4 = r7.f11581b     // Catch: java.lang.Throwable -> L68
            int r4 = r4.t()     // Catch: java.lang.Throwable -> L68
            i3.g r5 = r7.f11581b     // Catch: java.lang.Throwable -> L68
            int r5 = r5.f()     // Catch: java.lang.Throwable -> L68
            i3.g r6 = r7.f11581b     // Catch: java.lang.Throwable -> L68
            g3.h r6 = r6.k()     // Catch: java.lang.Throwable -> L68
            m3.n$a r0 = r0.b(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L68
            r7.f11587h = r0     // Catch: java.lang.Throwable -> L68
            m3.n$a r0 = r7.f11587h     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            i3.g r0 = r7.f11581b     // Catch: java.lang.Throwable -> L68
            m3.n$a r3 = r7.f11587h     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.d r3 = r3.f15805c     // Catch: java.lang.Throwable -> L68
            java.lang.Class r3 = r3.a()     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.u(r3)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            m3.n$a r0 = r7.f11587h     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.d r0 = r0.f15805c     // Catch: java.lang.Throwable -> L68
            i3.g r2 = r7.f11581b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.g r2 = r2.l()     // Catch: java.lang.Throwable -> L68
            r0.e(r2, r7)     // Catch: java.lang.Throwable -> L68
            r2 = r1
            goto L15
        L68:
            r0 = move-exception
            goto Lb0
        L6a:
            d4.b.e()
            return r2
        L6e:
            int r0 = r7.f11583d     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r1
            r7.f11583d = r0     // Catch: java.lang.Throwable -> L68
            java.util.List r1 = r7.f11580a     // Catch: java.lang.Throwable -> L68
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68
            if (r0 < r1) goto L7f
            d4.b.e()
            return r2
        L7f:
            java.util.List r0 = r7.f11580a     // Catch: java.lang.Throwable -> L68
            int r1 = r7.f11583d     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68
            g3.f r0 = (g3.f) r0     // Catch: java.lang.Throwable -> L68
            i3.d r1 = new i3.d     // Catch: java.lang.Throwable -> L68
            i3.g r3 = r7.f11581b     // Catch: java.lang.Throwable -> L68
            g3.f r3 = r3.p()     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L68
            i3.g r3 = r7.f11581b     // Catch: java.lang.Throwable -> L68
            k3.a r3 = r3.d()     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = r3.b(r1)     // Catch: java.lang.Throwable -> L68
            r7.f11588i = r1     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L5
            r7.f11584e = r0     // Catch: java.lang.Throwable -> L68
            i3.g r0 = r7.f11581b     // Catch: java.lang.Throwable -> L68
            java.util.List r0 = r0.j(r1)     // Catch: java.lang.Throwable -> L68
            r7.f11585f = r0     // Catch: java.lang.Throwable -> L68
            r7.f11586g = r2     // Catch: java.lang.Throwable -> L68
            goto L5
        Lb0:
            d4.b.e()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.c.b():boolean");
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(Exception exc) {
        this.f11582c.a(this.f11584e, exc, this.f11587h.f15805c, g3.a.DATA_DISK_CACHE);
    }

    @Override // i3.f
    public void cancel() {
        n.a aVar = this.f11587h;
        if (aVar != null) {
            aVar.f15805c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void f(Object obj) {
        this.f11582c.c(this.f11584e, obj, this.f11587h.f15805c, g3.a.DATA_DISK_CACHE, this.f11584e);
    }

    public c(List list, g gVar, f.a aVar) {
        this.f11583d = -1;
        this.f11580a = list;
        this.f11581b = gVar;
        this.f11582c = aVar;
    }
}
