package e3;

import F5.AbstractC0556n;
import F5.AbstractC0557o;
import F5.v;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.AbstractC2074F;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13606a = new j();

    public static /* synthetic */ AbstractC2074F.e.d.a.c c(j jVar, String str, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        if ((i9 & 8) != 0) {
            z7 = false;
        }
        return jVar.b(str, i7, i8, z7);
    }

    public final AbstractC2074F.e.d.a.c a(String processName, int i7, int i8) {
        r.f(processName, "processName");
        return c(this, processName, i7, i8, false, 8, null);
    }

    public final AbstractC2074F.e.d.a.c b(String processName, int i7, int i8, boolean z7) {
        r.f(processName, "processName");
        AbstractC2074F.e.d.a.c cVarA = AbstractC2074F.e.d.a.c.a().e(processName).d(i7).c(i8).b(z7).a();
        r.e(cVarA, "builder()\n      .setProc…ltProcess)\n      .build()");
        return cVarA;
    }

    public final List d(Context context) {
        r.f(context, "context");
        int i7 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = AbstractC0556n.g();
        }
        List listF = v.F(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listF) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i7) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0557o.q(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            arrayList2.add(AbstractC2074F.e.d.a.c.a().e(runningAppProcessInfo.processName).d(runningAppProcessInfo.pid).c(runningAppProcessInfo.importance).b(r.b(runningAppProcessInfo.processName, str)).a());
        }
        return arrayList2;
    }

    public final AbstractC2074F.e.d.a.c e(Context context) {
        Object next;
        r.f(context, "context");
        int iMyPid = Process.myPid();
        Iterator it = d(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((AbstractC2074F.e.d.a.c) next).c() == iMyPid) {
                break;
            }
        }
        AbstractC2074F.e.d.a.c cVar = (AbstractC2074F.e.d.a.c) next;
        return cVar == null ? c(this, f(), iMyPid, 0, false, 12, null) : cVar;
    }

    public final String f() {
        String processName;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 <= 33) {
            return (i7 < 28 || (processName = Application.getProcessName()) == null) ? "" : processName;
        }
        String strMyProcessName = Process.myProcessName();
        r.e(strMyProcessName, "{\n      Process.myProcessName()\n    }");
        return strMyProcessName;
    }
}
