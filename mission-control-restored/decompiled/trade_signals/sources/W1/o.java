package W1;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f9266c;

    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (f9264a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                f9264a = Application.getProcessName();
            } else {
                int iMyPid = f9265b;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    f9265b = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        String str = "/proc/" + iMyPid + "/cmdline";
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str));
                            try {
                                String line = bufferedReader.readLine();
                                AbstractC1294n.j(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                k.a(bufferedReader2);
                                throw th;
                            }
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    k.a(bufferedReader);
                }
                f9264a = strTrim;
            }
        }
        return f9264a;
    }

    public static boolean b() {
        Boolean boolValueOf = f9266c;
        if (boolValueOf == null) {
            if (l.f()) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object objA = e2.j.a(Process.class, "isIsolated", new e2.h[0]);
                    Object[] objArr = new Object[0];
                    if (objA == null) {
                        throw new e2.c(e2.b.a("expected a non-null reference", objArr));
                    }
                    boolValueOf = (Boolean) objA;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = Boolean.FALSE;
                }
            }
            f9266c = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}
