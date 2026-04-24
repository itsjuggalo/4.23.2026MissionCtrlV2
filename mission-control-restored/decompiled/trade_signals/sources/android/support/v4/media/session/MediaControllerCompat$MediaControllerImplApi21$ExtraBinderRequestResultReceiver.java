package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f10266a;

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i8, Bundle bundle) {
        b.a(this.f10266a.get());
    }
}
