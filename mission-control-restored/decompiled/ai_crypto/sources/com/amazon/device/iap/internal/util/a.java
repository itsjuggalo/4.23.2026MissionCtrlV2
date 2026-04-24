package com.amazon.device.iap.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.a.a.o.f;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10429a = a.class.getName() + "_PREFS";

    public static String a(String str) {
        f.a((Object) str, "userId");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        return contextB.getSharedPreferences(f10429a, 0).getString(str, null);
    }

    public static void a(String str, String str2) {
        f.a((Object) str, "userId");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        SharedPreferences.Editor editorEdit = contextB.getSharedPreferences(f10429a, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }
}
