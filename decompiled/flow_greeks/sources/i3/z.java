package i3;

import android.util.Log;
import com.bumptech.glide.load.data.d;
import i3.f;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class z implements f, f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f11786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.a f11787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f11788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f11789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f11790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile n.a f11791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile d f11792g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n.a f11793a;

        public a(n.a aVar) {
            this.f11793a = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(Exception exc) {
            if (z.this.f(this.f11793a)) {
                z.this.i(this.f11793a, exc);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void f(Object obj) {
            if (z.this.f(this.f11793a)) {
                z.this.g(this.f11793a, obj);
            }
        }
    }

    public z(g gVar, f.a aVar) {
        this.f11786a = gVar;
        this.f11787b = aVar;
    }

    @Override // i3.f.a
    public void a(g3.f fVar, Exception exc, com.bumptech.glide.load.data.d dVar, g3.a aVar) {
        this.f11787b.a(fVar, exc, dVar, this.f11791f.f15805c.d());
    }

    @Override // i3.f
    public boolean b() {
        if (this.f11790e != null) {
            Object obj = this.f11790e;
            this.f11790e = null;
            try {
                if (!d(obj)) {
                    return true;
                }
            } catch (IOException e10) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e10);
                }
            }
        }
        if (this.f11789d != null && this.f11789d.b()) {
            return true;
        }
        this.f11789d = null;
        this.f11791f = null;
        boolean z10 = false;
        while (!z10 && e()) {
            List listG = this.f11786a.g();
            int i10 = this.f11788c;
            this.f11788c = i10 + 1;
            this.f11791f = (n.a) listG.get(i10);
            if (this.f11791f != null && (this.f11786a.e().c(this.f11791f.f15805c.d()) || this.f11786a.u(this.f11791f.f15805c.a()))) {
                j(this.f11791f);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // i3.f.a
    public void c(g3.f fVar, Object obj, com.bumptech.glide.load.data.d dVar, g3.a aVar, g3.f fVar2) {
        this.f11787b.c(fVar, obj, dVar, this.f11791f.f15805c.d(), fVar);
    }

    @Override // i3.f
    public void cancel() {
        n.a aVar = this.f11791f;
        if (aVar != null) {
            aVar.f15805c.cancel();
        }
    }

    public final boolean d(Object obj) throws Throwable {
        Throwable th;
        long jB = c4.g.b();
        boolean z10 = false;
        try {
            com.bumptech.glide.load.data.e eVarO = this.f11786a.o(obj);
            Object objA = eVarO.a();
            g3.d dVarQ = this.f11786a.q(objA);
            e eVar = new e(dVarQ, objA, this.f11786a.k());
            d dVar = new d(this.f11791f.f15803a, this.f11786a.p());
            k3.a aVarD = this.f11786a.d();
            aVarD.a(dVar, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dVar + ", data: " + obj + ", encoder: " + dVarQ + ", duration: " + c4.g.a(jB));
            }
            if (aVarD.b(dVar) != null) {
                this.f11792g = dVar;
                this.f11789d = new c(Collections.singletonList(this.f11791f.f15803a), this.f11786a, this);
                this.f11791f.f15805c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f11792g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f11787b.c(this.f11791f.f15803a, eVarO.a(), this.f11791f.f15805c, this.f11791f.f15805c.d(), this.f11791f.f15803a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                if (z10) {
                    throw th;
                }
                this.f11791f.f15805c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean e() {
        return this.f11788c < this.f11786a.g().size();
    }

    public boolean f(n.a aVar) {
        n.a aVar2 = this.f11791f;
        return aVar2 != null && aVar2 == aVar;
    }

    public void g(n.a aVar, Object obj) {
        j jVarE = this.f11786a.e();
        if (obj != null && jVarE.c(aVar.f15805c.d())) {
            this.f11790e = obj;
            this.f11787b.h();
        } else {
            f.a aVar2 = this.f11787b;
            g3.f fVar = aVar.f15803a;
            com.bumptech.glide.load.data.d dVar = aVar.f15805c;
            aVar2.c(fVar, obj, dVar, dVar.d(), this.f11792g);
        }
    }

    @Override // i3.f.a
    public void h() {
        throw new UnsupportedOperationException();
    }

    public void i(n.a aVar, Exception exc) {
        f.a aVar2 = this.f11787b;
        d dVar = this.f11792g;
        com.bumptech.glide.load.data.d dVar2 = aVar.f15805c;
        aVar2.a(dVar, exc, dVar2, dVar2.d());
    }

    public final void j(n.a aVar) {
        this.f11791f.f15805c.e(this.f11786a.l(), new a(aVar));
    }
}
