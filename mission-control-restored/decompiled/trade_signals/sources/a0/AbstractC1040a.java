package a0;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: a0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1040a {
    public static final File a(Context context, String fileName) {
        AbstractC2304t.f(context, "<this>");
        AbstractC2304t.f(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), "datastore/" + fileName);
    }
}
