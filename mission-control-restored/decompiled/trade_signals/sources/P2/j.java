package P2;

import V2.F;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import p5.r;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f6363a = new j();

    public static /* synthetic */ F.e.d.a.c c(j jVar, String str, int i8, int i9, boolean z7, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = 0;
        }
        if ((i10 & 8) != 0) {
            z7 = false;
        }
        return jVar.b(str, i8, i9, z7);
    }

    public final F.e.d.a.c a(String processName, int i8, int i9) {
        AbstractC2304t.f(processName, "processName");
        return c(this, processName, i8, i9, false, 8, null);
    }

    public final F.e.d.a.c b(String processName, int i8, int i9, boolean z7) {
        AbstractC2304t.f(processName, "processName");
        F.e.d.a.c cVarA = F.e.d.a.c.a().e(processName).d(i8).c(i9).b(z7).a();
        AbstractC2304t.e(cVarA, "build(...)");
        return cVarA;
    }

    public final List d(Context context) {
        List<ActivityManager.RunningAppProcessInfo> listI;
        AbstractC2304t.f(context, "context");
        int i8 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (listI = activityManager.getRunningAppProcesses()) == null) {
            listI = AbstractC2595q.i();
        }
        List listV = z.V(listI);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listV) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i8) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(r.s(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            arrayList2.add(F.e.d.a.c.a().e(runningAppProcessInfo.processName).d(runningAppProcessInfo.pid).c(runningAppProcessInfo.importance).b(AbstractC2304t.b(runningAppProcessInfo.processName, str)).a());
        }
        return arrayList2;
    }

    public final F.e.d.a.c e(Context context) {
        Object next;
        AbstractC2304t.f(context, "context");
        int iMyPid = Process.myPid();
        Iterator it = d(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((F.e.d.a.c) next).c() == iMyPid) {
                break;
            }
        }
        F.e.d.a.c cVar = (F.e.d.a.c) next;
        return cVar == null ? c(this, f(), iMyPid, 0, false, 12, null) : cVar;
    }

    public final String f() {
        String processName;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 <= 33) {
            return (i8 < 28 || (processName = Application.getProcessName()) == null) ? "" : processName;
        }
        String strMyProcessName = Process.myProcessName();
        AbstractC2304t.c(strMyProcessName);
        return strMyProcessName;
    }
}
