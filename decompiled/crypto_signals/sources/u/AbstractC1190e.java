package u;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: u.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1190e {
    public static Executor a(Context context) {
        return context.getMainExecutor();
    }
}
