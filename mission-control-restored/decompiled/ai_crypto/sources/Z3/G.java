package Z3;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.google.firebase.sessions.SessionLifecycleService;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public final class G implements F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5868b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5869a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public G(Context appContext) {
        kotlin.jvm.internal.r.f(appContext, "appContext");
        this.f5869a = appContext;
    }

    @Override // Z3.F
    public void a(Messenger callback, ServiceConnection serviceConnection) {
        boolean zBindService;
        kotlin.jvm.internal.r.f(callback, "callback");
        kotlin.jvm.internal.r.f(serviceConnection, "serviceConnection");
        Intent intent = new Intent(this.f5869a, (Class<?>) SessionLifecycleService.class);
        Log.d("LifecycleServiceBinder", "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra("ClientCallbackMessenger", callback);
        intent.setPackage(this.f5869a.getPackageName());
        try {
            zBindService = this.f5869a.bindService(intent, serviceConnection, 65);
        } catch (SecurityException e7) {
            Log.w("LifecycleServiceBinder", "Failed to bind session lifecycle service to application.", e7);
            zBindService = false;
        }
        if (zBindService) {
            return;
        }
        b(this.f5869a, serviceConnection);
        Log.i("LifecycleServiceBinder", "Session lifecycle service binding failed.");
    }

    public final Object b(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return E5.E.f1657a;
        } catch (IllegalArgumentException e7) {
            return Integer.valueOf(Log.w("LifecycleServiceBinder", "Session lifecycle service binding failed.", e7));
        }
    }
}
