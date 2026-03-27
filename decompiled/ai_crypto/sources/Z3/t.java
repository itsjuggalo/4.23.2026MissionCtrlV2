package Z3;

import F5.AbstractC0556n;
import F5.AbstractC0557o;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f5972a = new t();

    public static /* synthetic */ s b(t tVar, String str, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        if ((i9 & 8) != 0) {
            z7 = false;
        }
        return tVar.a(str, i7, i8, z7);
    }

    public final s a(String str, int i7, int i8, boolean z7) {
        return new s(str, i7, i8, z7);
    }

    public final List c(Context context) {
        kotlin.jvm.internal.r.f(context, "context");
        int i7 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = AbstractC0556n.g();
        }
        List listF = F5.v.F(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listF) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i7) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0557o.q(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            String str2 = runningAppProcessInfo.processName;
            kotlin.jvm.internal.r.e(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new s(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, kotlin.jvm.internal.r.b(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final s d(Context context) {
        Object next;
        kotlin.jvm.internal.r.f(context, "context");
        int iMyPid = Process.myPid();
        Iterator it = c(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((s) next).b() == iMyPid) {
                break;
            }
        }
        s sVar = (s) next;
        return sVar == null ? b(this, e(), iMyPid, 0, false, 12, null) : sVar;
    }

    public final String e() throws Throwable {
        String processName;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 > 33) {
            String strMyProcessName = Process.myProcessName();
            kotlin.jvm.internal.r.e(strMyProcessName, "myProcessName()");
            return strMyProcessName;
        }
        if (i7 >= 28 && (processName = Application.getProcessName()) != null) {
            return processName;
        }
        String strA = W1.p.a();
        return strA != null ? strA : "";
    }
}
