package e1;

import android.content.Context;
import c5.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import x0.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0152a f8300a = new C0152a(null);

    /* JADX INFO: renamed from: e1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0152a {
        public /* synthetic */ C0152a(k kVar) {
            this();
        }

        public final c5.c a(w request, Context context) {
            boolean z10;
            t.f(request, "request");
            t.f(context, "context");
            c.a aVar = new c.a();
            long jC = c(context);
            loop0: while (true) {
                z10 = false;
                for (x0.g gVar : request.a()) {
                    if (gVar instanceof j6.a) {
                        j6.a aVar2 = (j6.a) gVar;
                        aVar.c(b(aVar2));
                        if (z10 || aVar2.f()) {
                            z10 = true;
                        }
                    }
                }
            }
            if (jC > 241217000) {
                aVar.g(request.e());
            }
            c5.c cVarA = aVar.b(z10).a();
            t.e(cVarA, "build(...)");
            return cVarA;
        }

        public final c.b b(j6.a aVar) {
            c.b.a aVarG = c.b.R().c(aVar.g()).d(aVar.j()).e(aVar.k()).f(aVar.l()).g(true);
            t.e(aVarG, "setSupported(...)");
            if (aVar.i() != null) {
                String strI = aVar.i();
                t.c(strI);
                aVarG.a(strI, aVar.h());
            }
            c.b bVarB = aVarG.b();
            t.e(bVarB, "build(...)");
            return bVarB;
        }

        public final long c(Context context) {
            t.e(context.getPackageManager(), "getPackageManager(...)");
            return r3.getPackageInfo("com.google.android.gms", 0).versionCode;
        }

        public C0152a() {
        }
    }
}
