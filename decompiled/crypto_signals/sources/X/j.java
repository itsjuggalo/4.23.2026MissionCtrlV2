package X;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
        mediaMetadataRetriever.setDataSource(mediaDataSource);
    }
}
