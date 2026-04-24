package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f15710a;

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f15711d = TimeUnit.DAYS.toMillis(7);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f15714c;

        public a(String str, String str2, long j8) {
            this.f15712a = str;
            this.f15713b = str2;
            this.f15714c = j8;
        }

        public static String a(String str, String str2, long j8) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put(DiagnosticsEntry.TIMESTAMP_KEY, j8);
                return jSONObject.toString();
            } catch (JSONException e8) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e8);
                return null;
            }
        }

        public static a c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(DiagnosticsEntry.TIMESTAMP_KEY));
            } catch (JSONException e8) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + e8);
                return null;
            }
        }

        public boolean b(String str) {
            return System.currentTimeMillis() > this.f15714c + f15711d || !str.equals(this.f15713b);
        }
    }

    public d0(Context context) {
        this.f15710a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    public final void a(Context context, String str) {
        File file = new File(I.a.i(context), str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || f()) {
                return;
            }
            Log.i("FirebaseMessaging", "App restored, clearing state");
            c();
        } catch (IOException e8) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e8.getMessage());
            }
        }
    }

    public final String b(String str, String str2) {
        return str + "|T|" + str2 + com.amazon.a.a.o.b.f.f14102c + "*";
    }

    public synchronized void c() {
        this.f15710a.edit().clear().commit();
    }

    public synchronized void d(String str, String str2) {
        String strB = b(str, str2);
        SharedPreferences.Editor editorEdit = this.f15710a.edit();
        editorEdit.remove(strB);
        editorEdit.commit();
    }

    public synchronized a e(String str, String str2) {
        return a.c(this.f15710a.getString(b(str, str2), null));
    }

    public synchronized boolean f() {
        return this.f15710a.getAll().isEmpty();
    }

    public synchronized void g(String str, String str2, String str3, String str4) {
        String strA = a.a(str3, str4, System.currentTimeMillis());
        if (strA == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f15710a.edit();
        editorEdit.putString(b(str, str2), strA);
        editorEdit.commit();
    }
}
