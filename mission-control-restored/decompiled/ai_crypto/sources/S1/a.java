package S1;

import android.util.Log;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.common.internal.C1199j;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1199j f4685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4686d;

    public a(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(f.f9989a);
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.f4684b = string;
        this.f4683a = str;
        this.f4685c = new C1199j(str);
        int i7 = 2;
        while (i7 <= 7 && !Log.isLoggable(this.f4683a, i7)) {
            i7++;
        }
        this.f4686d = i7;
    }

    public void a(String str, Object... objArr) {
        if (f(3)) {
            Log.d(this.f4683a, d(str, objArr));
        }
    }

    public void b(String str, Throwable th, Object... objArr) {
        Log.e(this.f4683a, d(str, objArr), th);
    }

    public void c(String str, Object... objArr) {
        Log.e(this.f4683a, d(str, objArr));
    }

    public String d(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f4684b.concat(str);
    }

    public void e(String str, Object... objArr) {
        Log.i(this.f4683a, d(str, objArr));
    }

    public boolean f(int i7) {
        return this.f4686d <= i7;
    }

    public void g(String str, Object... objArr) {
        if (f(2)) {
            Log.v(this.f4683a, d(str, objArr));
        }
    }

    public void h(String str, Object... objArr) {
        Log.w(this.f4683a, d(str, objArr));
    }

    public void i(String str, Throwable th, Object... objArr) {
        Log.wtf(this.f4683a, d(str, objArr), th);
    }

    public void j(Throwable th) {
        Log.wtf(this.f4683a, th);
    }
}
