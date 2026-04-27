package s2;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import l2.C2329m;

/* JADX INFO: renamed from: s2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ResultReceiverC2692g extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2329m f23070a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultReceiverC2692g(C2693h c2693h, Handler handler, C2329m c2329m) {
        super(handler);
        this.f23070a = c2329m;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i8, Bundle bundle) {
        this.f23070a.e(null);
    }
}
