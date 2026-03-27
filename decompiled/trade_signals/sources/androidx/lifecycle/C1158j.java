package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: androidx.lifecycle.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1158j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1158j f11980a = new C1158j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f11981b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: androidx.lifecycle.j$a */
    public static final class a extends AbstractC1153e {
        @Override // androidx.lifecycle.AbstractC1153e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            AbstractC2304t.f(activity, "activity");
            x.f12021b.c(activity);
        }
    }

    public static final void a(Context context) {
        AbstractC2304t.f(context, "context");
        if (f11981b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        AbstractC2304t.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
