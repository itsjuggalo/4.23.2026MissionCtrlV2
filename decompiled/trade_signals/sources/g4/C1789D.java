package g4;

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

/* JADX INFO: renamed from: g4.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1789D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1789D f18019a = new C1789D();

    public final List a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> listI;
        AbstractC2304t.f(context, "context");
        int i8 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (listI = activityManager.getRunningAppProcesses()) == null) {
            listI = AbstractC2595q.i();
        }
        List listV = p5.z.V(listI);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listV) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i8) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(p5.r.s(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            String processName = runningAppProcessInfo.processName;
            AbstractC2304t.e(processName, "processName");
            arrayList2.add(new C1788C(processName, runningAppProcessInfo.pid, runningAppProcessInfo.importance, AbstractC2304t.b(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final C1788C b(Context context) {
        Object next;
        AbstractC2304t.f(context, "context");
        int iMyPid = Process.myPid();
        Iterator it = a(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C1788C) next).b() == iMyPid) {
                break;
            }
        }
        C1788C c1788c = (C1788C) next;
        return c1788c == null ? new C1788C(c(), iMyPid, 0, false) : c1788c;
    }

    public final String c() throws Throwable {
        String processName;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 > 33) {
            String strMyProcessName = Process.myProcessName();
            AbstractC2304t.e(strMyProcessName, "myProcessName(...)");
            return strMyProcessName;
        }
        if (i8 >= 28 && (processName = Application.getProcessName()) != null) {
            return processName;
        }
        String strA = W1.o.a();
        return strA != null ? strA : "";
    }
}
