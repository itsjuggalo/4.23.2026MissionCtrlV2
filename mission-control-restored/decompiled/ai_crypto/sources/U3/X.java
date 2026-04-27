package U3;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f4826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4828c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f4830e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f4829d = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4831f = false;

    public X(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f4826a = sharedPreferences;
        this.f4827b = str;
        this.f4828c = str2;
        this.f4830e = executor;
    }

    public static X d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        X x7 = new X(sharedPreferences, str, str2, executor);
        x7.e();
        return x7;
    }

    public boolean b(String str) {
        boolean zC;
        if (TextUtils.isEmpty(str) || str.contains(this.f4828c)) {
            return false;
        }
        synchronized (this.f4829d) {
            zC = c(this.f4829d.add(str));
        }
        return zC;
    }

    public final boolean c(boolean z7) {
        if (z7 && !this.f4831f) {
            j();
        }
        return z7;
    }

    public final void e() {
        synchronized (this.f4829d) {
            try {
                this.f4829d.clear();
                String string = this.f4826a.getString(this.f4827b, "");
                if (!TextUtils.isEmpty(string) && string.contains(this.f4828c)) {
                    String[] strArrSplit = string.split(this.f4828c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f4829d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public String f() {
        String str;
        synchronized (this.f4829d) {
            str = (String) this.f4829d.peek();
        }
        return str;
    }

    public boolean g(Object obj) {
        boolean zC;
        synchronized (this.f4829d) {
            zC = c(this.f4829d.remove(obj));
        }
        return zC;
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f4829d.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(this.f4828c);
        }
        return sb.toString();
    }

    public final void i() {
        synchronized (this.f4829d) {
            this.f4826a.edit().putString(this.f4827b, h()).commit();
        }
    }

    public final void j() {
        this.f4830e.execute(new Runnable() { // from class: U3.W
            @Override // java.lang.Runnable
            public final void run() {
                this.f4825a.i();
            }
        });
    }
}
