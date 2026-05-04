package v3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import androidx.fragment.app.u;
import p3.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f23109f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bumptech.glide.k f23110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f23111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w.a f23112c = new w.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f23113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f23114e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements b {
        @Override // v3.o.b
        public com.bumptech.glide.k a(com.bumptech.glide.b bVar, j jVar, p pVar, Context context) {
            return new com.bumptech.glide.k(bVar, jVar, pVar, context);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        com.bumptech.glide.k a(com.bumptech.glide.b bVar, j jVar, p pVar, Context context);
    }

    public o(b bVar) {
        bVar = bVar == null ? f23109f : bVar;
        this.f23111b = bVar;
        this.f23114e = new m(bVar);
        this.f23113d = b();
    }

    public static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static i b() {
        return (w.f18282f && w.f18281e) ? new h() : new f();
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
        if (c4.l.r() && !(context instanceof Application)) {
            if (context instanceof u) {
                return e((u) context);
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

    public com.bumptech.glide.k e(u uVar) {
        if (c4.l.q()) {
            return d(uVar.getApplicationContext());
        }
        a(uVar);
        this.f23113d.a(uVar);
        boolean zG = g(uVar);
        return this.f23114e.b(uVar, com.bumptech.glide.b.c(uVar.getApplicationContext()), uVar.getLifecycle(), uVar.getSupportFragmentManager(), zG);
    }

    public final com.bumptech.glide.k f(Context context) {
        if (this.f23110a == null) {
            synchronized (this) {
                try {
                    if (this.f23110a == null) {
                        this.f23110a = this.f23111b.a(com.bumptech.glide.b.c(context.getApplicationContext()), new v3.a(), new g(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f23110a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }
}
