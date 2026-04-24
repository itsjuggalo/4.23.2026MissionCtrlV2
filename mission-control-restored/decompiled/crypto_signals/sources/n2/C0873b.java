package n2;

import H4.p;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import t2.C1137Z;
import t2.C1139a0;
import t2.D0;

/* JADX INFO: renamed from: n2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0873b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0873b f8554a = new C0873b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0873b f8555b = new C0873b();

    public static C1139a0 a(C0873b c0873b, String processName, int i, int i6, int i7) {
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        c0873b.getClass();
        j.e(processName, "processName");
        C1137Z c1137z = new C1137Z();
        c1137z.f10045a = processName;
        c1137z.f10046b = i;
        byte b3 = (byte) (c1137z.e | 1);
        c1137z.f10047c = i6;
        c1137z.f10048d = false;
        c1137z.e = (byte) (((byte) (b3 | 2)) | 4);
        return c1137z.a();
    }

    public static ArrayList d(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        j.e(context, "context");
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            runningAppProcesses = p.f577a;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : runningAppProcesses) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((ActivityManager.RunningAppProcessInfo) obj2).uid == i) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(H4.j.d0(arrayList2, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList2) {
            C1137Z c1137z = new C1137Z();
            String str2 = runningAppProcessInfo.processName;
            if (str2 == null) {
                throw new NullPointerException("Null processName");
            }
            c1137z.f10045a = str2;
            c1137z.f10046b = runningAppProcessInfo.pid;
            byte b3 = (byte) (c1137z.e | 1);
            c1137z.f10047c = runningAppProcessInfo.importance;
            c1137z.e = (byte) (b3 | 2);
            c1137z.f10048d = j.a(str2, str);
            c1137z.e = (byte) (c1137z.e | 4);
            arrayList3.add(c1137z.a());
        }
        return arrayList3;
    }

    public boolean b(int i) {
        return 4 <= i || Log.isLoggable("FirebaseCrashlytics", i);
    }

    public void c(String str) {
        if (b(3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public D0 e(Context context) {
        Object next;
        String processName;
        j.e(context, "context");
        int iMyPid = Process.myPid();
        Iterator it = d(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C1139a0) ((D0) next)).f10054b == iMyPid) {
                break;
            }
        }
        D0 d02 = (D0) next;
        if (d02 != null) {
            return d02;
        }
        int i = Build.VERSION.SDK_INT;
        if (i > 33) {
            processName = Process.myProcessName();
            j.b(processName);
        } else if (i < 28 || (processName = Application.getProcessName()) == null) {
            processName = "";
        }
        return a(this, processName, iMyPid, 0, 12);
    }

    public void f(String str) {
        if (b(2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
    }

    public void g(String str, Exception exc) {
        if (b(5)) {
            Log.w("FirebaseCrashlytics", str, exc);
        }
    }
}
