package m2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import n2.AbstractC2411r;
import n2.C2412s;

/* JADX INFO: renamed from: m2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2356i extends AbstractC2411r {
    public C2356i(Context context) {
        super(new C2412s("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    @Override // n2.AbstractC2411r
    public final void a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.f21588a.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.f21588a.a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f21588a.a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        InstallState installStateF = InstallState.f(intent, this.f21588a);
        this.f21588a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", installStateF);
        d(installStateF);
    }
}
