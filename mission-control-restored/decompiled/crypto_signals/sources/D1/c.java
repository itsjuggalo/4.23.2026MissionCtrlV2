package D1;

import android.app.Service;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.internal.I;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f276a;

    public c(Context context) {
        this.f276a = context;
    }

    public ApplicationInfo a(int i, String str) {
        return this.f276a.getPackageManager().getApplicationInfo(str, i);
    }

    public PackageInfo b(int i, String str) {
        return this.f276a.getPackageManager().getPackageInfo(str, i);
    }

    public boolean c() {
        String nameForUid;
        int callingUid = Binder.getCallingUid();
        int iMyUid = Process.myUid();
        Context context = this.f276a;
        if (callingUid == iMyUid) {
            return b.z(context);
        }
        if (!B1.c.d() || (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return context.getPackageManager().isInstantApp(nameForUid);
    }

    public c(Service service) {
        I.g(service);
        Context applicationContext = service.getApplicationContext();
        I.g(applicationContext);
        this.f276a = applicationContext;
    }
}
