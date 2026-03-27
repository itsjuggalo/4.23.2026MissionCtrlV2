package N3;

import android.app.Application;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: N3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0726k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f5697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f5698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Q3.a f5699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r4.e f5700d;

    public C0726k(R0 r02, Application application, Q3.a aVar) {
        this.f5697a = r02;
        this.f5698b = application;
        this.f5699c = aVar;
    }

    public P4.j f() {
        return P4.j.l(new Callable() { // from class: N3.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5676a.h();
            }
        }).x(this.f5697a.e(r4.e.X()).f(new V4.d() { // from class: N3.g
            @Override // V4.d
            public final void accept(Object obj) {
                this.f5679a.i((r4.e) obj);
            }
        })).h(new V4.g() { // from class: N3.h
            @Override // V4.g
            public final boolean test(Object obj) {
                return this.f5683a.g((r4.e) obj);
            }
        }).e(new V4.d() { // from class: N3.i
            @Override // V4.d
            public final void accept(Object obj) {
                this.f5687a.j((Throwable) obj);
            }
        });
    }

    public final boolean g(r4.e eVar) {
        long jU = eVar.U();
        long jA = this.f5699c.a();
        File file = new File(this.f5698b.getApplicationContext().getFilesDir(), "fiam_eligible_campaigns_cache_file");
        return jU != 0 ? jA < jU : !file.exists() || jA < file.lastModified() + TimeUnit.DAYS.toMillis(1L);
    }

    public final /* synthetic */ r4.e h() {
        return this.f5700d;
    }

    public final /* synthetic */ void i(r4.e eVar) {
        this.f5700d = eVar;
    }

    public final /* synthetic */ void j(Throwable th) {
        this.f5700d = null;
    }

    public final /* synthetic */ void k(r4.e eVar) {
        this.f5700d = eVar;
    }

    public P4.b l(final r4.e eVar) {
        return this.f5697a.f(eVar).g(new V4.a() { // from class: N3.j
            @Override // V4.a
            public final void run() {
                this.f5691a.k(eVar);
            }
        });
    }
}
