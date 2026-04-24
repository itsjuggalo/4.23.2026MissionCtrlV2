package W1;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.common.zzab;
import com.google.android.gms.internal.common.zzac;
import com.google.android.gms.internal.common.zzj;
import com.google.android.gms.internal.common.zzl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f5372c;

    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (f5370a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                f5370a = Application.getProcessName();
            } else {
                int iMyPid = f5371b;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    f5371b = iMyPid;
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
                                AbstractC1207s.k(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                j.a(bufferedReader2);
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
                    j.a(bufferedReader);
                }
                f5370a = strTrim;
            }
        }
        return f5370a;
    }

    public static boolean b() {
        Boolean boolValueOf = f5372c;
        if (boolValueOf == null) {
            if (m.f()) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object objZza = zzl.zza(Process.class, "isIsolated", new zzj[0]);
                    Object[] objArr = new Object[0];
                    if (objZza == null) {
                        throw new zzac(zzab.zza("expected a non-null reference", objArr));
                    }
                    boolValueOf = (Boolean) objZza;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = Boolean.FALSE;
                }
            }
            f5372c = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}
