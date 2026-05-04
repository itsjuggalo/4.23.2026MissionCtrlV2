package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6454c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f6456e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f6455d = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6457f = false;

    public z0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f6452a = sharedPreferences;
        this.f6453b = str;
        this.f6454c = str2;
        this.f6456e = executor;
    }

    public static z0 d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        z0 z0Var = new z0(sharedPreferences, str, str2, executor);
        z0Var.e();
        return z0Var;
    }

    public boolean b(String str) {
        boolean zC;
        if (TextUtils.isEmpty(str) || str.contains(this.f6454c)) {
            return false;
        }
        synchronized (this.f6455d) {
            zC = c(this.f6455d.add(str));
        }
        return zC;
    }

    public final boolean c(boolean z10) {
        if (z10 && !this.f6457f) {
            j();
        }
        return z10;
    }

    public final void e() {
        synchronized (this.f6455d) {
            try {
                this.f6455d.clear();
                String string = this.f6452a.getString(this.f6453b, "");
                if (!TextUtils.isEmpty(string) && string.contains(this.f6454c)) {
                    String[] strArrSplit = string.split(this.f6454c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f6455d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public String f() {
        String str;
        synchronized (this.f6455d) {
            str = (String) this.f6455d.peek();
        }
        return str;
    }

    public boolean g(Object obj) {
        boolean zC;
        synchronized (this.f6455d) {
            zC = c(this.f6455d.remove(obj));
        }
        return zC;
    }

    public String h() {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.f6455d.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append(this.f6454c);
        }
        return sb2.toString();
    }

    public final void i() {
        synchronized (this.f6455d) {
            this.f6452a.edit().putString(this.f6453b, h()).commit();
        }
    }

    public final void j() {
        this.f6456e.execute(new Runnable() { // from class: com.google.firebase.messaging.y0
            @Override // java.lang.Runnable
            public final void run() {
                this.f6450a.i();
            }
        });
    }
}
