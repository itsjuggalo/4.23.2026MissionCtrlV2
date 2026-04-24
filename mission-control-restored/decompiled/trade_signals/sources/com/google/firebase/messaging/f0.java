package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1293m;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f15725d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15728c;

    public f0(String str, String str2) {
        this.f15726a = d(str2, str);
        this.f15727b = str;
        this.f15728c = str + "!" + str2;
    }

    public static f0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new f0(strArrSplit[0], strArrSplit[1]);
    }

    public static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !f15725d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public static f0 f(String str) {
        return new f0("S", str);
    }

    public static f0 g(String str) {
        return new f0("U", str);
    }

    public String b() {
        return this.f15727b;
    }

    public String c() {
        return this.f15726a;
    }

    public String e() {
        return this.f15728c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f15726a.equals(f0Var.f15726a) && this.f15727b.equals(f0Var.f15727b);
    }

    public int hashCode() {
        return AbstractC1293m.b(this.f15727b, this.f15726a);
    }
}
