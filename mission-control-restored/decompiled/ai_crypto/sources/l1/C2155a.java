package l1;

import android.content.Context;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: l1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2155a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2155a f18291a = new C2155a();

    public final File a(Context context) {
        r.f(context, "context");
        String string = UUID.randomUUID().toString();
        r.e(string, "toString(...)");
        return new File(context.getCacheDir(), string);
    }
}
