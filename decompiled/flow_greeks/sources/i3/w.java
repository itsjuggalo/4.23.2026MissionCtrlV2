package i3;

import com.bumptech.glide.load.data.d;
import i3.f;
import java.io.File;
import java.util.List;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w implements f, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f.a f11765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f11766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11768d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g3.f f11769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f11770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile n.a f11772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f11773i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public x f11774j;

    public w(g gVar, f.a aVar) {
        this.f11766b = gVar;
        this.f11765a = aVar;
    }

    private boolean a() {
        return this.f11771g < this.f11770f.size();
    }

    @Override // i3.f
    public boolean b() {
        d4.b.a("ResourceCacheGenerator.startNext");
        try {
            List listC = this.f11766b.c();
            boolean z10 = false;
            if (listC.isEmpty()) {
                d4.b.e();
                return false;
            }
            List listM = this.f11766b.m();
            if (listM.isEmpty()) {
                if (File.class.equals(this.f11766b.r())) {
                    d4.b.e();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f11766b.i() + " to " + this.f11766b.r());
            }
            while (true) {
                if (this.f11770f != null && a()) {
                    this.f11772h = null;
                    while (!z10 && a()) {
                        List list = this.f11770f;
                        int i10 = this.f11771g;
                        this.f11771g = i10 + 1;
                        this.f11772h = ((m3.n) list.get(i10)).b(this.f11773i, this.f11766b.t(), this.f11766b.f(), this.f11766b.k());
                        if (this.f11772h != null && this.f11766b.u(this.f11772h.f15805c.a())) {
                            this.f11772h.f15805c.e(this.f11766b.l(), this);
                            z10 = true;
                        }
                    }
                    d4.b.e();
                    return z10;
                }
                int i11 = this.f11768d + 1;
                this.f11768d = i11;
                if (i11 >= listM.size()) {
                    int i12 = this.f11767c + 1;
                    this.f11767c = i12;
                    if (i12 >= listC.size()) {
                        d4.b.e();
                        return false;
                    }
                    this.f11768d = 0;
                }
                g3.f fVar = (g3.f) listC.get(this.f11767c);
                Class cls = (Class) listM.get(this.f11768d);
                this.f11774j = new x(this.f11766b.b(), fVar, this.f11766b.p(), this.f11766b.t(), this.f11766b.f(), this.f11766b.s(cls), cls, this.f11766b.k());
                File fileB = this.f11766b.d().b(this.f11774j);
                this.f11773i = fileB;
                if (fileB != null) {
                    this.f11769e = fVar;
                    this.f11770f = this.f11766b.j(fileB);
                    this.f11771g = 0;
                }
            }
        } catch (Throwable th) {
            d4.b.e();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(Exception exc) {
        this.f11765a.a(this.f11774j, exc, this.f11772h.f15805c, g3.a.RESOURCE_DISK_CACHE);
    }

    @Override // i3.f
    public void cancel() {
        n.a aVar = this.f11772h;
        if (aVar != null) {
            aVar.f15805c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void f(Object obj) {
        this.f11765a.c(this.f11769e, obj, this.f11772h.f15805c, g3.a.RESOURCE_DISK_CACHE, this.f11774j);
    }
}
