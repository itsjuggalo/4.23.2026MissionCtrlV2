package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import c.b;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompat$ItemReceiver extends b {
    @Override // c.b
    public void a(int i4, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i4 != 0 || bundle == null || !bundle.containsKey("media_item")) {
            throw null;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
            throw null;
        }
        throw null;
    }
}
