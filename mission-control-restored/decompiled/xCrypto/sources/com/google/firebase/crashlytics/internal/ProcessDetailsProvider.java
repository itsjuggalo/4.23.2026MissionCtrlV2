package com.google.firebase.crashlytics.internal;

import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.x;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider INSTANCE = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    public static /* synthetic */ CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails$default(ProcessDetailsProvider processDetailsProvider, String str, int i4, int i5, boolean z4, int i6, Object obj) {
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

    private final String getProcessName() {
        String processName;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 <= 33) {
            return (i4 < 28 || (processName = Application.getProcessName()) == null) ? "" : processName;
        }
        String strMyProcessName = Process.myProcessName();
        r.e(strMyProcessName, "{\n      Process.myProcessName()\n    }");
        return strMyProcessName;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName) {
        r.f(processName, "processName");
        return buildProcessDetails$default(this, processName, 0, 0, false, 14, null);
    }

    public final List<CrashlyticsReport.Session.Event.Application.ProcessDetails> getAppProcessDetails(Context context) {
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
            arrayList2.add(CrashlyticsReport.Session.Event.Application.ProcessDetails.builder().setProcessName(runningAppProcessInfo.processName).setPid(runningAppProcessInfo.pid).setImportance(runningAppProcessInfo.importance).setDefaultProcess(r.b(runningAppProcessInfo.processName, str)).build());
        }
        return arrayList2;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails getCurrentProcessDetails(Context context) {
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
            if (((CrashlyticsReport.Session.Event.Application.ProcessDetails) next).getPid() == iMyPid) {
                break;
            }
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) next;
        return processDetails == null ? buildProcessDetails$default(this, getProcessName(), iMyPid, 0, false, 12, null) : processDetails;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName, int i4) {
        r.f(processName, "processName");
        return buildProcessDetails$default(this, processName, i4, 0, false, 12, null);
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName, int i4, int i5) {
        r.f(processName, "processName");
        return buildProcessDetails$default(this, processName, i4, i5, false, 8, null);
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName, int i4, int i5, boolean z4) {
        r.f(processName, "processName");
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetailsBuild = CrashlyticsReport.Session.Event.Application.ProcessDetails.builder().setProcessName(processName).setPid(i4).setImportance(i5).setDefaultProcess(z4).build();
        r.e(processDetailsBuild, "builder()\n      .setProc…ltProcess)\n      .build()");
        return processDetailsBuild;
    }
}
