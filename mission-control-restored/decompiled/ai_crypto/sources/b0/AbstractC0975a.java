package b0;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: b0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0975a {
    public static final File a(Context context, String fileName) {
        r.f(context, "<this>");
        r.f(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), "datastore/" + fileName);
    }
}
