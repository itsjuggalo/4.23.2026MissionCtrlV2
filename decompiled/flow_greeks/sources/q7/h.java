package q7;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.List;
import java.util.concurrent.ExecutorService;
import r7.k;
import u7.c0;
import u7.h0;
import u7.m;
import u7.w;
import v7.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f18873a;

    public h(w wVar) {
        this.f18873a = wVar;
    }

    public static h b(a7.g gVar, ga.h hVar, fa.a aVar, fa.a aVar2, fa.a aVar3, ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3) {
        Context contextM = gVar.m();
        String packageName = contextM.getPackageName();
        r7.g.f().g("Initializing Firebase Crashlytics " + w.k() + " for " + packageName);
        i iVar = new i(executorService, executorService2);
        a8.g gVar2 = new a8.g(contextM);
        c0 c0Var = new c0(gVar);
        h0 h0Var = new h0(contextM, packageName, hVar, c0Var);
        r7.d dVar = new r7.d(aVar);
        d dVar2 = new d(aVar2);
        m mVar = new m(c0Var, gVar2);
        va.b.e(mVar);
        w wVar = new w(gVar, h0Var, dVar, c0Var, dVar2.e(), dVar2.d(), gVar2, mVar, new k(aVar3), iVar);
        String strC = gVar.r().c();
        String strM = u7.i.m(contextM);
        List<u7.f> listJ = u7.i.j(contextM);
        r7.g.f().b("Mapping file ID is: " + strM);
        for (u7.f fVar : listJ) {
            r7.g.f().b(String.format("Build id for %s on %s: %s", fVar.c(), fVar.a(), fVar.b()));
        }
        try {
            u7.a aVarA = u7.a.a(contextM, h0Var, strC, strM, listJ, new r7.f(contextM));
            r7.g.f().i("Installer package name is: " + aVarA.f22222d);
            c8.g gVarL = c8.g.l(contextM, strC, h0Var, new z7.b(), aVarA.f22224f, aVarA.f22225g, gVar2, c0Var);
            gVarL.p(iVar).addOnFailureListener(executorService3, new OnFailureListener() { // from class: q7.g
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    r7.g.f().e("Error fetching settings.", exc);
                }
            });
            if (wVar.p(aVarA, gVarL)) {
                wVar.i(gVarL);
            }
            return new h(wVar);
        } catch (PackageManager.NameNotFoundException e10) {
            r7.g.f().e("Error retrieving app package info.", e10);
            return null;
        }
    }
}
