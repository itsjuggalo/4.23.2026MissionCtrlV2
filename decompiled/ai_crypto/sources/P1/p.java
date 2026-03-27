package P1;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: loaded from: classes.dex */
public final class p extends zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0652f f4318b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(C0652f c0652f, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f4318b = c0652f;
        this.f4317a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i7 = message.what;
        if (i7 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i7);
            return;
        }
        C0652f c0652f = this.f4318b;
        int iG = c0652f.g(this.f4317a);
        if (c0652f.j(iG)) {
            this.f4318b.p(this.f4317a, iG);
        }
    }
}
