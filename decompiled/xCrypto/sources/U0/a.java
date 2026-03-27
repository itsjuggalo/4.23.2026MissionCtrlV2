package U0;

import android.content.Context;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5248a = new a();

    public final File a(Context context) {
        r.f(context, "context");
        String string = UUID.randomUUID().toString();
        r.e(string, "toString(...)");
        return new File(context.getCacheDir(), string);
    }
}
