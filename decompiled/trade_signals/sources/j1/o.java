package j1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import androidx.fragment.app.AbstractActivityC1143u;
import d1.v;
import q1.AbstractC2629l;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public class o implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f19960f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bumptech.glide.k f19961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f19962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2882a f19963c = new C2882a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f19964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f19965e;

    public class a implements b {
        @Override // j1.o.b
        public com.bumptech.glide.k a(com.bumptech.glide.b bVar, j jVar, p pVar, Context context) {
            return new com.bumptech.glide.k(bVar, jVar, pVar, context);
        }
    }

    public interface b {
        com.bumptech.glide.k a(com.bumptech.glide.b bVar, j jVar, p pVar, Context context);
    }

    public o(b bVar) {
        bVar = bVar == null ? f19960f : bVar;
        this.f19962b = bVar;
        this.f19965e = new m(bVar);
        this.f19964d = b();
    }

    public static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static i b() {
        return (v.f16819f && v.f16818e) ? new h() : new C2203f();
    }

    public static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean g(Context context) {
        Activity activityC = c(context);
        return activityC == null || !activityC.isFinishing();
    }

    public com.bumptech.glide.k d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (AbstractC2629l.r() && !(context instanceof Application)) {
            if (context instanceof AbstractActivityC1143u) {
                return e((AbstractActivityC1143u) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return d(contextWrapper.getBaseContext());
                }
            }
        }
        return f(context);
    }

    public com.bumptech.glide.k e(AbstractActivityC1143u abstractActivityC1143u) {
        if (AbstractC2629l.q()) {
            return d(abstractActivityC1143u.getApplicationContext());
        }
        a(abstractActivityC1143u);
        this.f19964d.a(abstractActivityC1143u);
        boolean zG = g(abstractActivityC1143u);
        return this.f19965e.b(abstractActivityC1143u, com.bumptech.glide.b.c(abstractActivityC1143u.getApplicationContext()), abstractActivityC1143u.getLifecycle(), abstractActivityC1143u.getSupportFragmentManager(), zG);
    }

    public final com.bumptech.glide.k f(Context context) {
        if (this.f19961a == null) {
            synchronized (this) {
                try {
                    if (this.f19961a == null) {
                        this.f19961a = this.f19962b.a(com.bumptech.glide.b.c(context.getApplicationContext()), new C2198a(), new g(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f19961a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }
}
