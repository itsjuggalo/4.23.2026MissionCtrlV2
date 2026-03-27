package a3;

import android.util.Log;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzh;
import com.google.android.gms.internal.measurement.zzlm;
import com.google.android.recaptcha.internal.zzln;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import s3.B0;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static /* synthetic */ int a(int i) {
        int i6 = 1;
        if (i != 1) {
            i6 = 2;
            if (i != 2) {
                i6 = 3;
                if (i != 3) {
                    if (i == 4) {
                        return 4;
                    }
                    throw null;
                }
            }
        }
        return i6;
    }

    public static /* synthetic */ int b(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 16;
            case 6:
                return 32;
            case 7:
                return 64;
            case 8:
                return 128;
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return 256;
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return 512;
            case 11:
                return 1024;
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return 2048;
            case 13:
                return 4096;
            case 14:
                return 8192;
            case 15:
                return 16384;
            case 16:
                return 32768;
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return 65536;
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return 131072;
            case 19:
                return 262144;
            case 20:
                return 524288;
            case 21:
                return 1048576;
            case 22:
                return 2097152;
            case 23:
                return 4194304;
            case 24:
                return 8388608;
            case 25:
                return 16777216;
            case 26:
                return 33554432;
            case 27:
                return 67108864;
            case 28:
                return 134217728;
            case 29:
                return 268435456;
            case 30:
                return 536870912;
            case 31:
                return 1073741824;
            default:
                throw null;
        }
    }

    public static int c(int i, int i6, int i7) {
        return zzlm.zzz(i) + i6 + i7;
    }

    public static int d(int i, int i6, int i7, int i8) {
        return ((i * i6) / i7) + i8;
    }

    public static Object e(zzbk zzbkVar, int i, List list, int i6) {
        zzh.zza(zzbkVar.name(), i, list);
        return list.get(i6);
    }

    public static String f(int i, String str) {
        return str + i;
    }

    public static /* synthetic */ String g(Iterable iterable) {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) " ");
            }
        }
        return sb.toString();
    }

    public static String h(String str, int i, int i6, String str2) {
        return str + i + str2 + i6;
    }

    public static String i(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String j(String str, String str2) {
        return str + str2;
    }

    public static String k(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String l(String str, StringBuilder sb) {
        return str + ((Object) sb);
    }

    public static String m(String str, Throwable th, String str2, String str3) {
        return str + th + str2 + str3;
    }

    public static StringBuilder n(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder o(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder p(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static /* synthetic */ void q(int i, String str) {
        if (i == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = j.class.getName();
            int i6 = 0;
            while (!stackTrace[i6].getClassName().equals(name)) {
                i6++;
            }
            while (stackTrace[i6].getClassName().equals(name)) {
                i6++;
            }
            StackTraceElement stackTraceElement = stackTrace[i6];
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
            j.g(nullPointerException, j.class.getName());
            throw nullPointerException;
        }
    }

    public static /* synthetic */ void r(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void s(String str, String str2, String str3) {
        Log.e(str3, str + str2);
    }

    public static int t(int i, int i6, int i7) {
        return zzln.zzA(i) + i6 + i7;
    }
}
