package f0;

import a0.AbstractC1040a;
import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: f0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1730b {
    public static final File a(Context context, String name) {
        AbstractC2304t.f(context, "<this>");
        AbstractC2304t.f(name, "name");
        return AbstractC1040a.a(context, name + ".preferences_pb");
    }
}
