package com.google.firebase.sessions;

import G1.p;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.x;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider INSTANCE = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    private final ProcessDetails buildProcessDetails(String str, int i4, int i5, boolean z4) {
        return new ProcessDetails(str, i4, i5, z4);
    }

    public static /* synthetic */ ProcessDetails buildProcessDetails$default(ProcessDetailsProvider processDetailsProvider, String str, int i4, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        if ((i6 & 8) != 0) {
            z4 = false;
        }
        return processDetailsProvider.buildProcessDetails(str, i4, i5, z4);
    }

    public final List<ProcessDetails> getAppProcessDetails(Context context) {
        r.f(context, "context");
        int i4 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = AbstractC0769p.g();
        }
        List listE = x.E(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listE) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i4) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            String str2 = runningAppProcessInfo.processName;
            r.e(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new ProcessDetails(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, r.b(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final ProcessDetails getCurrentProcessDetails(Context context) {
        Object next;
        r.f(context, "context");
        int iMyPid = Process.myPid();
        Iterator<T> it = getAppProcessDetails(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ProcessDetails) next).getPid() == iMyPid) {
                break;
            }
        }
        ProcessDetails processDetails = (ProcessDetails) next;
        return processDetails == null ? buildProcessDetails$default(this, getProcessName$com_google_firebase_firebase_sessions(), iMyPid, 0, false, 12, null) : processDetails;
    }

    public final String getProcessName$com_google_firebase_firebase_sessions() throws Throwable {
        String processName;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 33) {
            String strMyProcessName = Process.myProcessName();
            r.e(strMyProcessName, "myProcessName()");
            return strMyProcessName;
        }
        if (i4 >= 28 && (processName = Application.getProcessName()) != null) {
            return processName;
        }
        String strA = p.a();
        return strA != null ? strA : "";
    }
}
