package x1;

import android.util.Log;
import java.util.Locale;

/* JADX INFO: renamed from: x1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1402a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11452c;

    public C1402a(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.f11451b = string;
        this.f11450a = str;
        int length = str.length();
        Object[] objArr = {str, 23};
        if (length > 23) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.f11450a, i)) {
            i++;
        }
        this.f11452c = i;
    }

    public final void a(String str, Object... objArr) {
        if (this.f11452c <= 3) {
            Log.d(this.f11450a, d(str, objArr));
        }
    }

    public final void b(String str, Exception exc, Object... objArr) {
        Log.e(this.f11450a, d(str, objArr), exc);
    }

    public final void c(String str, Object... objArr) {
        Log.e(this.f11450a, d(str, objArr));
    }

    public final String d(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f11451b.concat(str);
    }

    public final void e(String str, Object... objArr) {
        if (this.f11452c <= 2) {
            Log.v(this.f11450a, d(str, objArr));
        }
    }

    public final void f(String str, Object... objArr) {
        Log.w(this.f11450a, d(str, objArr));
    }
}
