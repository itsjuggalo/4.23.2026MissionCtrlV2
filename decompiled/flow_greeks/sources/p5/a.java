package p5;

import android.util.Log;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.common.internal.j;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f18303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18304d;

    public a(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(f.f4598a);
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            string = sb2.toString();
        }
        this.f18302b = string;
        this.f18301a = str;
        this.f18303c = new j(str);
        int i10 = 2;
        while (i10 <= 7 && !Log.isLoggable(this.f18301a, i10)) {
            i10++;
        }
        this.f18304d = i10;
    }

    public void a(String str, Object... objArr) {
        if (f(3)) {
            Log.d(this.f18301a, d(str, objArr));
        }
    }

    public void b(String str, Throwable th, Object... objArr) {
        Log.e(this.f18301a, d(str, objArr), th);
    }

    public void c(String str, Object... objArr) {
        Log.e(this.f18301a, d(str, objArr));
    }

    public String d(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f18302b.concat(str);
    }

    public void e(String str, Object... objArr) {
        Log.i(this.f18301a, d(str, objArr));
    }

    public boolean f(int i10) {
        return this.f18304d <= i10;
    }

    public void g(String str, Object... objArr) {
        if (f(2)) {
            Log.v(this.f18301a, d(str, objArr));
        }
    }

    public void h(String str, Object... objArr) {
        Log.w(this.f18301a, d(str, objArr));
    }

    public void i(String str, Throwable th, Object... objArr) {
        Log.wtf(this.f18301a, d(str, objArr), th);
    }

    public void j(Throwable th) {
        Log.wtf(this.f18301a, th);
    }
}
