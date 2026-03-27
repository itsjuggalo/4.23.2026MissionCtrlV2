package N3;

import F2.b;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import n5.InterfaceC2426a;
import r4.C2677b;
import r4.e;

/* JADX INFO: renamed from: N3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0712d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f5663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G2.f f5664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Application f5665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Q3.a f5666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final S0 f5667e;

    public C0712d(InterfaceC2426a interfaceC2426a, G2.f fVar, Application application, Q3.a aVar, S0 s02) {
        this.f5663a = interfaceC2426a;
        this.f5664b = fVar;
        this.f5665c = application;
        this.f5666d = aVar;
        this.f5667e = s02;
    }

    public final r4.c a(H0 h02) {
        return (r4.c) r4.c.V().z(this.f5664b.r().c()).x(h02.b()).y(h02.c().b()).o();
    }

    public final F2.b b() {
        b.a aVarA = F2.b.W().z(String.valueOf(Build.VERSION.SDK_INT)).y(Locale.getDefault().toString()).A(TimeZone.getDefault().getID());
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            aVarA.x(strD);
        }
        return (F2.b) aVarA.o();
    }

    public r4.e c(H0 h02, C2677b c2677b) {
        I0.c("Fetching campaigns from service.");
        this.f5667e.a();
        return e(((H) this.f5663a.get()).a((r4.d) r4.d.Z().z(this.f5664b.r().f()).x(c2677b.V()).y(b()).A(a(h02)).o()));
    }

    public final String d() {
        try {
            return this.f5665c.getPackageManager().getPackageInfo(this.f5665c.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e8) {
            I0.b("Error finding versionName : " + e8.getMessage());
            return null;
        }
    }

    public final r4.e e(r4.e eVar) {
        return (eVar.U() < this.f5666d.a() + TimeUnit.MINUTES.toMillis(1L) || eVar.U() > this.f5666d.a() + TimeUnit.DAYS.toMillis(3L)) ? (r4.e) ((e.b) eVar.Q()).x(this.f5666d.a() + TimeUnit.DAYS.toMillis(1L)).o() : eVar;
    }
}
