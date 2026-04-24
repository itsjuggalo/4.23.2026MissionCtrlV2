package f0;

import android.content.Context;
import b0.AbstractC0975a;
import java.io.File;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: f0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1543b {
    public static final File a(Context context, String name) {
        r.f(context, "<this>");
        r.f(name, "name");
        return AbstractC0975a.a(context, name + ".preferences_pb");
    }
}
