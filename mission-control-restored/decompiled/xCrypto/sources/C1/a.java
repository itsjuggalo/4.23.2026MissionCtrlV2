package C1;

import android.util.Log;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.common.internal.C0932j;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0932j f148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f149d;

    public a(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(f.f8804a);
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.f147b = string;
        this.f146a = str;
        this.f148c = new C0932j(str);
        int i4 = 2;
        while (i4 <= 7 && !Log.isLoggable(this.f146a, i4)) {
            i4++;
        }
        this.f149d = i4;
    }

    public void a(String str, Object... objArr) {
        if (f(3)) {
            Log.d(this.f146a, d(str, objArr));
        }
    }

    public void b(String str, Throwable th, Object... objArr) {
        Log.e(this.f146a, d(str, objArr), th);
    }

    public void c(String str, Object... objArr) {
        Log.e(this.f146a, d(str, objArr));
    }

    public String d(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f147b.concat(str);
    }

    public void e(String str, Object... objArr) {
        Log.i(this.f146a, d(str, objArr));
    }

    public boolean f(int i4) {
        return this.f149d <= i4;
    }

    public void g(String str, Object... objArr) {
        if (f(2)) {
            Log.v(this.f146a, d(str, objArr));
        }
    }

    public void h(String str, Object... objArr) {
        Log.w(this.f146a, d(str, objArr));
    }

    public void i(String str, Throwable th, Object... objArr) {
        Log.wtf(this.f146a, d(str, objArr), th);
    }

    public void j(Throwable th) {
        Log.wtf(this.f146a, th);
    }
}
