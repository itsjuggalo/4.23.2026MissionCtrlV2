package W0;

import W0.f;
import a1.n;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.util.List;
import r1.AbstractC2671b;

/* JADX INFO: loaded from: classes.dex */
public class w implements f, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f.a f9226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f9227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9229d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public U0.f f9230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f9231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile n.a f9233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f9234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public x f9235j;

    public w(g gVar, f.a aVar) {
        this.f9227b = gVar;
        this.f9226a = aVar;
    }

    private boolean b() {
        return this.f9232g < this.f9231f.size();
    }

    @Override // W0.f
    public boolean a() {
        AbstractC2671b.a("ResourceCacheGenerator.startNext");
        try {
            List listC = this.f9227b.c();
            boolean z7 = false;
            if (listC.isEmpty()) {
                AbstractC2671b.e();
                return false;
            }
            List listM = this.f9227b.m();
            if (listM.isEmpty()) {
                if (File.class.equals(this.f9227b.r())) {
                    AbstractC2671b.e();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f9227b.i() + " to " + this.f9227b.r());
            }
            while (true) {
                if (this.f9231f != null && b()) {
                    this.f9233h = null;
                    while (!z7 && b()) {
                        List list = this.f9231f;
                        int i8 = this.f9232g;
                        this.f9232g = i8 + 1;
                        this.f9233h = ((a1.n) list.get(i8)).a(this.f9234i, this.f9227b.t(), this.f9227b.f(), this.f9227b.k());
                        if (this.f9233h != null && this.f9227b.u(this.f9233h.f9867c.a())) {
                            this.f9233h.f9867c.e(this.f9227b.l(), this);
                            z7 = true;
                        }
                    }
                    AbstractC2671b.e();
                    return z7;
                }
                int i9 = this.f9229d + 1;
                this.f9229d = i9;
                if (i9 >= listM.size()) {
                    int i10 = this.f9228c + 1;
                    this.f9228c = i10;
                    if (i10 >= listC.size()) {
                        AbstractC2671b.e();
                        return false;
                    }
                    this.f9229d = 0;
                }
                U0.f fVar = (U0.f) listC.get(this.f9228c);
                Class cls = (Class) listM.get(this.f9229d);
                this.f9235j = new x(this.f9227b.b(), fVar, this.f9227b.p(), this.f9227b.t(), this.f9227b.f(), this.f9227b.s(cls), cls, this.f9227b.k());
                File fileB = this.f9227b.d().b(this.f9235j);
                this.f9234i = fileB;
                if (fileB != null) {
                    this.f9230e = fVar;
                    this.f9231f = this.f9227b.j(fileB);
                    this.f9232g = 0;
                }
            }
        } catch (Throwable th) {
            AbstractC2671b.e();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(Exception exc) {
        this.f9226a.i(this.f9235j, exc, this.f9233h.f9867c, U0.a.RESOURCE_DISK_CACHE);
    }

    @Override // W0.f
    public void cancel() {
        n.a aVar = this.f9233h;
        if (aVar != null) {
            aVar.f9867c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void f(Object obj) {
        this.f9226a.g(this.f9230e, obj, this.f9233h.f9867c, U0.a.RESOURCE_DISK_CACHE, this.f9235j);
    }
}
