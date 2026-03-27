package i2;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: i2.v2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1937v2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f16152b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f16153c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference f16154d = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1929u2 f16155a;

    public C1937v2(InterfaceC1929u2 interfaceC1929u2) {
        this.f16155a = interfaceC1929u2;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        AbstractC1207s.k(strArr);
        AbstractC1207s.k(strArr2);
        AbstractC1207s.k(atomicReference);
        AbstractC1207s.a(strArr.length == strArr2.length);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            if (Objects.equals(str, strArr[i7])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i7];
                        if (str2 == null) {
                            str2 = strArr2[i7] + "(" + strArr[i7] + ")";
                            strArr3[i7] = str2;
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
        return !this.f16155a.zza() ? str : g(str, AbstractC1779b4.f15511c, AbstractC1779b4.f15509a, f16152b);
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f16155a.zza() ? str : g(str, AbstractC1787c4.f15587b, AbstractC1787c4.f15586a, f16153c);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f16155a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, AbstractC1795d4.f15611b, AbstractC1795d4.f15610a, f16154d);
        }
        return "experiment_id(" + str + ")";
    }

    public final String d(C1750J c1750j) {
        InterfaceC1929u2 interfaceC1929u2 = this.f16155a;
        if (!interfaceC1929u2.zza()) {
            return c1750j.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(c1750j.f15166c);
        sb.append(",name=");
        sb.append(a(c1750j.f15164a));
        sb.append(",params=");
        C1748H c1748h = c1750j.f15165b;
        sb.append(c1748h == null ? null : !interfaceC1929u2.zza() ? c1748h.toString() : e(c1748h.F()));
        return sb.toString();
    }

    public final String e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f16155a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(b(str));
            sb.append(com.amazon.a.a.o.b.f.f9990b);
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
