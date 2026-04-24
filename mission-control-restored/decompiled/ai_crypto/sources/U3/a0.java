package U3;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference f4863d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f4864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public X f4865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f4866c;

    public a0(SharedPreferences sharedPreferences, Executor executor) {
        this.f4866c = executor;
        this.f4864a = sharedPreferences;
    }

    public static synchronized a0 b(Context context, Executor executor) {
        a0 a0Var;
        try {
            WeakReference weakReference = f4863d;
            a0Var = weakReference != null ? (a0) weakReference.get() : null;
            if (a0Var == null) {
                a0Var = new a0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                a0Var.d();
                f4863d = new WeakReference(a0Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a0Var;
    }

    public synchronized boolean a(Z z7) {
        return this.f4865b.b(z7.e());
    }

    public synchronized Z c() {
        return Z.a(this.f4865b.f());
    }

    public final synchronized void d() {
        this.f4865b = X.d(this.f4864a, "topic_operation_queue", com.amazon.a.a.o.b.f.f9989a, this.f4866c);
    }

    public synchronized boolean e(Z z7) {
        return this.f4865b.g(z7.e());
    }
}
