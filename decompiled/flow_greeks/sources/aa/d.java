package aa;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import ib.e;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import z6.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.g f404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Application f405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final da.a f406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r2 f407e;

    public d(bd.a aVar, a7.g gVar, Application application, da.a aVar2, r2 r2Var) {
        this.f403a = aVar;
        this.f404b = gVar;
        this.f405c = application;
        this.f406d = aVar2;
        this.f407e = r2Var;
    }

    public final ib.c a(g2 g2Var) {
        return (ib.c) ib.c.d0().z(this.f404b.r().c()).x(g2Var.b()).y(g2Var.c().b()).n();
    }

    public final z6.b b() {
        b.a aVarA = z6.b.e0().z(String.valueOf(Build.VERSION.SDK_INT)).y(Locale.getDefault().toString()).A(TimeZone.getDefault().getID());
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            aVarA.x(strD);
        }
        return (z6.b) aVarA.n();
    }

    public ib.e c(g2 g2Var, ib.b bVar) {
        h2.c("Fetching campaigns from service.");
        this.f407e.a();
        return e(((h0) this.f403a.get()).a((ib.d) ib.d.h0().z(this.f404b.r().f()).x(bVar.d0()).y(b()).A(a(g2Var)).n()));
    }

    public final String d() {
        try {
            return this.f405c.getPackageManager().getPackageInfo(this.f405c.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            h2.b("Error finding versionName : " + e10.getMessage());
            return null;
        }
    }

    public final ib.e e(ib.e eVar) {
        return (eVar.c0() < this.f406d.a() + TimeUnit.MINUTES.toMillis(1L) || eVar.c0() > this.f406d.a() + TimeUnit.DAYS.toMillis(3L)) ? (ib.e) ((e.b) eVar.Y()).x(this.f406d.a() + TimeUnit.DAYS.toMillis(1L)).n() : eVar;
    }
}
