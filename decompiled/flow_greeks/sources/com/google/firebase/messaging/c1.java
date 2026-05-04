package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f6296d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6299c;

    public c1(String str, String str2) {
        this.f6297a = d(str2, str);
        this.f6298b = str;
        this.f6299c = str + "!" + str2;
    }

    public static c1 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new c1(strArrSplit[0], strArrSplit[1]);
    }

    public static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !f6296d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public static c1 f(String str) {
        return new c1("S", str);
    }

    public static c1 g(String str) {
        return new c1("U", str);
    }

    public String b() {
        return this.f6298b;
    }

    public String c() {
        return this.f6297a;
    }

    public String e() {
        return this.f6299c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return this.f6297a.equals(c1Var.f6297a) && this.f6298b.equals(c1Var.f6298b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f6298b, this.f6297a);
    }
}
