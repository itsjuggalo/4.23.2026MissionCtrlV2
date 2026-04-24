package Q1;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class p extends c2.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0794f f6712c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(C0794f c0794f, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f6712c = c0794f;
        this.f6711b = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i8 = message.what;
        if (i8 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i8);
            return;
        }
        C0794f c0794f = this.f6712c;
        int iG = c0794f.g(this.f6711b);
        if (c0794f.j(iG)) {
            this.f6712c.p(this.f6711b, iG);
        }
    }
}
