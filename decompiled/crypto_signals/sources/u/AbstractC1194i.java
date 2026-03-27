package u;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: u.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1194i {
    public static File[] a(Context context) {
        return context.getExternalMediaDirs();
    }
}
