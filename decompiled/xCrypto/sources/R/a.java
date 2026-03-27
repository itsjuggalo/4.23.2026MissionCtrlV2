package R;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final File a(Context context, String fileName) {
        r.f(context, "<this>");
        r.f(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), "datastore/" + fileName);
    }
}
