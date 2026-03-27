package o0;

import android.media.MediaMuxer;
import java.io.FileDescriptor;

/* JADX INFO: renamed from: o0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC2286e {
    public static /* synthetic */ MediaMuxer a(FileDescriptor fileDescriptor, int i7) {
        return new MediaMuxer(fileDescriptor, i7);
    }
}
