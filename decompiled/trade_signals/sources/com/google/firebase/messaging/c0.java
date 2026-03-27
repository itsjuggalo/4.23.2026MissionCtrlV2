package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f15700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15702c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f15704e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f15703d = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15705f = false;

    public c0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f15700a = sharedPreferences;
        this.f15701b = str;
        this.f15702c = str2;
        this.f15704e = executor;
    }

    public static c0 d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        c0 c0Var = new c0(sharedPreferences, str, str2, executor);
        c0Var.e();
        return c0Var;
    }

    public boolean b(String str) {
        boolean zC;
        if (TextUtils.isEmpty(str) || str.contains(this.f15702c)) {
            return false;
        }
        synchronized (this.f15703d) {
            zC = c(this.f15703d.add(str));
        }
        return zC;
    }

    public final boolean c(boolean z7) {
        if (z7 && !this.f15705f) {
            j();
        }
        return z7;
    }

    public final void e() {
        synchronized (this.f15703d) {
            try {
                this.f15703d.clear();
                String string = this.f15700a.getString(this.f15701b, "");
                if (!TextUtils.isEmpty(string) && string.contains(this.f15702c)) {
                    String[] strArrSplit = string.split(this.f15702c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f15703d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public String f() {
        String str;
        synchronized (this.f15703d) {
            str = (String) this.f15703d.peek();
        }
        return str;
    }

    public boolean g(Object obj) {
        boolean zC;
        synchronized (this.f15703d) {
            zC = c(this.f15703d.remove(obj));
        }
        return zC;
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f15703d.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(this.f15702c);
        }
        return sb.toString();
    }

    public final void i() {
        synchronized (this.f15703d) {
            this.f15700a.edit().putString(this.f15701b, h()).commit();
        }
    }

    public final void j() {
        this.f15704e.execute(new Runnable() { // from class: com.google.firebase.messaging.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f15699a.i();
            }
        });
    }
}
