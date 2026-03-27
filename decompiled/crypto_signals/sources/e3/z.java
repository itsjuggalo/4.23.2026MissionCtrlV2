package e3;

import android.util.Log;
import java.util.Arrays;
import java.util.regex.Pattern;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f6202d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6205c;

    public z(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in " + str + ".");
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !f6202d.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(AbstractC1024h.c("Invalid topic name: ", strSubstring, " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}."));
        }
        this.f6203a = strSubstring;
        this.f6204b = str;
        this.f6205c = a3.d.k(str, "!", str2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f6203a.equals(zVar.f6203a) && this.f6204b.equals(zVar.f6204b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6204b, this.f6203a});
    }
}
