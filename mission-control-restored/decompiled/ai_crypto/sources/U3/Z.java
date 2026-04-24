package U3;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1206q;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class Z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f4838d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4841c;

    public Z(String str, String str2) {
        this.f4839a = d(str2, str);
        this.f4840b = str;
        this.f4841c = str + "!" + str2;
    }

    public static Z a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new Z(strArrSplit[0], strArrSplit[1]);
    }

    public static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !f4838d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public static Z f(String str) {
        return new Z("S", str);
    }

    public static Z g(String str) {
        return new Z("U", str);
    }

    public String b() {
        return this.f4840b;
    }

    public String c() {
        return this.f4839a;
    }

    public String e() {
        return this.f4841c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Z)) {
            return false;
        }
        Z z7 = (Z) obj;
        return this.f4839a.equals(z7.f4839a) && this.f4840b.equals(z7.f4840b);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f4840b, this.f4839a);
    }
}
