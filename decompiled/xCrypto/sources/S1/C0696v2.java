package S1;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: S1.v2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0696v2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f4993b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f4994c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference f4995d = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0688u2 f4996a;

    public C0696v2(InterfaceC0688u2 interfaceC0688u2) {
        this.f4996a = interfaceC0688u2;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        AbstractC0940s.k(strArr);
        AbstractC0940s.k(strArr2);
        AbstractC0940s.k(atomicReference);
        AbstractC0940s.a(strArr.length == strArr2.length);
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (Objects.equals(str, strArr[i4])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i4];
                        if (str2 == null) {
                            str2 = strArr2[i4] + "(" + strArr[i4] + ")";
                            strArr3[i4] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !this.f4996a.zza() ? str : g(str, AbstractC0539b4.f4352c, AbstractC0539b4.f4350a, f4993b);
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f4996a.zza() ? str : g(str, AbstractC0547c4.f4428b, AbstractC0547c4.f4427a, f4994c);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f4996a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, AbstractC0555d4.f4452b, AbstractC0555d4.f4451a, f4995d);
        }
        return "experiment_id(" + str + ")";
    }

    public final String d(J j4) {
        InterfaceC0688u2 interfaceC0688u2 = this.f4996a;
        if (!interfaceC0688u2.zza()) {
            return j4.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(j4.f4007c);
        sb.append(",name=");
        sb.append(a(j4.f4005a));
        sb.append(",params=");
        H h4 = j4.f4006b;
        sb.append(h4 == null ? null : !interfaceC0688u2.zza() ? h4.toString() : e(h4.o()));
        return sb.toString();
    }

    public final String e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f4996a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(b(str));
            sb.append(com.amazon.a.a.o.b.f.f8805b);
            Object obj = bundle.get(str);
            sb.append(obj instanceof Bundle ? f(new Object[]{obj}) : obj instanceof Object[] ? f((Object[]) obj) : obj instanceof ArrayList ? f(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb.append("}]");
        return sb.toString();
    }

    public final String f(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            String strE = obj instanceof Bundle ? e((Bundle) obj) : String.valueOf(obj);
            if (strE != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(strE);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
