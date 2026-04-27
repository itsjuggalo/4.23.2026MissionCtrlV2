package Z;

import android.media.MediaMuxer;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static /* synthetic */ MediaMuxer a(FileDescriptor fileDescriptor, int i4) {
        return new MediaMuxer(fileDescriptor, i4);
    }
}
