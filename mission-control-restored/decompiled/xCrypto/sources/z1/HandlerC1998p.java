package z1;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: renamed from: z1.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC1998p extends zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1988f f16115b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1998p(C1988f c1988f, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f16115b = c1988f;
        this.f16114a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i4 = message.what;
        if (i4 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i4);
            return;
        }
        C1988f c1988f = this.f16115b;
        int iG = c1988f.g(this.f16114a);
        if (c1988f.j(iG)) {
            this.f16115b.p(this.f16114a, iG);
        }
    }
}
