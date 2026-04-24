package W0;

import W0.f;
import a1.n;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import q1.AbstractC2624g;

/* JADX INFO: loaded from: classes.dex */
public class z implements f, f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f9247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.a f9248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f9249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f9250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f9251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile n.a f9252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile d f9253g;

    public class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n.a f9254a;

        public a(n.a aVar) {
            this.f9254a = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(Exception exc) {
            if (z.this.e(this.f9254a)) {
                z.this.h(this.f9254a, exc);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void f(Object obj) {
            if (z.this.e(this.f9254a)) {
                z.this.f(this.f9254a, obj);
            }
        }
    }

    public z(g gVar, f.a aVar) {
        this.f9247a = gVar;
        this.f9248b = aVar;
    }

    @Override // W0.f
    public boolean a() {
        if (this.f9251e != null) {
            Object obj = this.f9251e;
            this.f9251e = null;
            try {
                if (!c(obj)) {
                    return true;
                }
            } catch (IOException e8) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e8);
                }
            }
        }
        if (this.f9250d != null && this.f9250d.a()) {
            return true;
        }
        this.f9250d = null;
        this.f9252f = null;
        boolean z7 = false;
        while (!z7 && d()) {
            List listG = this.f9247a.g();
            int i8 = this.f9249c;
            this.f9249c = i8 + 1;
            this.f9252f = (n.a) listG.get(i8);
            if (this.f9252f != null && (this.f9247a.e().c(this.f9252f.f9867c.d()) || this.f9247a.u(this.f9252f.f9867c.a()))) {
                j(this.f9252f);
                z7 = true;
            }
        }
        return z7;
    }

    @Override // W0.f.a
    public void b() {
        throw new UnsupportedOperationException();
    }

    public final boolean c(Object obj) throws Throwable {
        long jB = AbstractC2624g.b();
        boolean z7 = false;
        try {
            com.bumptech.glide.load.data.e eVarO = this.f9247a.o(obj);
            Object objA = eVarO.a();
            U0.d dVarQ = this.f9247a.q(objA);
            e eVar = new e(dVarQ, objA, this.f9247a.k());
            d dVar = new d(this.f9252f.f9865a, this.f9247a.p());
            Y0.a aVarD = this.f9247a.d();
            aVarD.a(dVar, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dVar + ", data: " + obj + ", encoder: " + dVarQ + ", duration: " + AbstractC2624g.a(jB));
            }
            if (aVarD.b(dVar) != null) {
                this.f9253g = dVar;
                this.f9250d = new c(Collections.singletonList(this.f9252f.f9865a), this.f9247a, this);
                this.f9252f.f9867c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f9253g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f9248b.g(this.f9252f.f9865a, eVarO.a(), this.f9252f.f9867c, this.f9252f.f9867c.d(), this.f9252f.f9865a);
                return false;
            } catch (Throwable th) {
                th = th;
                z7 = true;
                if (!z7) {
                    this.f9252f.f9867c.b();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // W0.f
    public void cancel() {
        n.a aVar = this.f9252f;
        if (aVar != null) {
            aVar.f9867c.cancel();
        }
    }

    public final boolean d() {
        return this.f9249c < this.f9247a.g().size();
    }

    public boolean e(n.a aVar) {
        n.a aVar2 = this.f9252f;
        return aVar2 != null && aVar2 == aVar;
    }

    public void f(n.a aVar, Object obj) {
        j jVarE = this.f9247a.e();
        if (obj != null && jVarE.c(aVar.f9867c.d())) {
            this.f9251e = obj;
            this.f9248b.b();
        } else {
            f.a aVar2 = this.f9248b;
            U0.f fVar = aVar.f9865a;
            com.bumptech.glide.load.data.d dVar = aVar.f9867c;
            aVar2.g(fVar, obj, dVar, dVar.d(), this.f9253g);
        }
    }

    @Override // W0.f.a
    public void g(U0.f fVar, Object obj, com.bumptech.glide.load.data.d dVar, U0.a aVar, U0.f fVar2) {
        this.f9248b.g(fVar, obj, dVar, this.f9252f.f9867c.d(), fVar);
    }

    public void h(n.a aVar, Exception exc) {
        f.a aVar2 = this.f9248b;
        d dVar = this.f9253g;
        com.bumptech.glide.load.data.d dVar2 = aVar.f9867c;
        aVar2.i(dVar, exc, dVar2, dVar2.d());
    }

    @Override // W0.f.a
    public void i(U0.f fVar, Exception exc, com.bumptech.glide.load.data.d dVar, U0.a aVar) {
        this.f9248b.i(fVar, exc, dVar, this.f9252f.f9867c.d());
    }

    public final void j(n.a aVar) {
        this.f9252f.f9867c.e(this.f9247a.l(), new a(aVar));
    }
}
