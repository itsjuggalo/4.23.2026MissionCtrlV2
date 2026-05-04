package aa;

import android.app.Application;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final da.a f495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ib.e f496d;

    public k(q2 q2Var, Application application, da.a aVar) {
        this.f493a = q2Var;
        this.f494b = application;
        this.f495c = aVar;
    }

    public cc.j f() {
        return cc.j.l(new Callable() { // from class: aa.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f442a.f496d;
            }
        }).x(this.f493a.c(ib.e.f0()).f(new ic.d() { // from class: aa.g
            @Override // ic.d
            public final void accept(Object obj) {
                this.f462a.f496d = (ib.e) obj;
            }
        })).h(new ic.g() { // from class: aa.h
            @Override // ic.g
            public final boolean test(Object obj) {
                return this.f471a.g((ib.e) obj);
            }
        }).e(new ic.d() { // from class: aa.i
            @Override // ic.d
            public final void accept(Object obj) {
                this.f476a.f496d = null;
            }
        });
    }

    public final boolean g(ib.e eVar) {
        long jC0 = eVar.c0();
        long jA = this.f495c.a();
        File file = new File(this.f494b.getApplicationContext().getFilesDir(), "fiam_eligible_campaigns_cache_file");
        return jC0 != 0 ? jA < jC0 : !file.exists() || jA < file.lastModified() + TimeUnit.DAYS.toMillis(1L);
    }

    public cc.b h(final ib.e eVar) {
        return this.f493a.d(eVar).d(new ic.a() { // from class: aa.j
            @Override // ic.a
            public final void run() {
                this.f484a.f496d = eVar;
            }
        });
    }
}
