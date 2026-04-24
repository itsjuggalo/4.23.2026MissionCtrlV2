package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f6223a;

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i4, Bundle bundle) {
        b.a(this.f6223a.get());
    }
}
