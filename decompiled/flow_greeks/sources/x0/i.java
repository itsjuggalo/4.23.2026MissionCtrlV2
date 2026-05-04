package x0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f24146e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f24147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f24149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f24150d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public i(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        this.f24147a = context;
    }

    public static /* synthetic */ h d(i iVar, Object obj, boolean z10, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return iVar.b(obj, z10);
    }

    public final List a(Context context) throws PackageManager.NameNotFoundException {
        String string;
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 132);
        ArrayList arrayList = new ArrayList();
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            kotlin.jvm.internal.t.c(serviceInfoArr);
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                Bundle bundle = serviceInfo.metaData;
                if (bundle != null && (string = bundle.getString("androidx.credentials.CREDENTIAL_PROVIDER_KEY")) != null) {
                    arrayList.add(string);
                }
            }
        }
        return dd.a0.I0(arrayList);
    }

    public final h b(Object request, boolean z10) {
        kotlin.jvm.internal.t.f(request, "request");
        if (kotlin.jvm.internal.t.b(request, "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL")) {
            return g();
        }
        if (request instanceof w) {
            for (g gVar : ((w) request).a()) {
            }
        }
        return c(z10);
    }

    public final h c(boolean z10) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            h hVarF = f();
            return (hVarF == null && z10) ? g() : hVarF;
        }
        if (i10 <= 33) {
            return g();
        }
        return null;
    }

    public final h e(List list, Context context) {
        Iterator it = list.iterator();
        h hVar = null;
        while (it.hasNext()) {
            try {
                Object objNewInstance = Class.forName((String) it.next()).getConstructor(Context.class).newInstance(context);
                kotlin.jvm.internal.t.d(objNewInstance, "null cannot be cast to non-null type androidx.credentials.CredentialProvider");
                h hVar2 = (h) objNewInstance;
                if (!hVar2.isAvailableOnDevice()) {
                    continue;
                } else {
                    if (hVar != null) {
                        Log.i("CredProviderFactory", "Only one active OEM CredentialProvider allowed");
                        return null;
                    }
                    hVar = hVar2;
                }
            } catch (Throwable unused) {
            }
        }
        return hVar;
    }

    public final h f() {
        if (!this.f24148b) {
            q qVar = new q(this.f24147a);
            if (qVar.isAvailableOnDevice()) {
                return qVar;
            }
            return null;
        }
        h hVar = this.f24149c;
        if (hVar == null) {
            return null;
        }
        kotlin.jvm.internal.t.c(hVar);
        if (hVar.isAvailableOnDevice()) {
            return this.f24149c;
        }
        return null;
    }

    public final h g() throws PackageManager.NameNotFoundException {
        if (!this.f24148b) {
            List listA = a(this.f24147a);
            if (listA.isEmpty()) {
                return null;
            }
            return e(listA, this.f24147a);
        }
        h hVar = this.f24150d;
        if (hVar == null) {
            return null;
        }
        kotlin.jvm.internal.t.c(hVar);
        if (hVar.isAvailableOnDevice()) {
            return this.f24150d;
        }
        return null;
    }
}
