package z5;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public class f extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f24797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f24798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24799c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(File file, File file2, String str) {
        super(AbstractC3015c.b(file, file2, str));
        AbstractC2304t.f(file, "file");
        this.f24797a = file;
        this.f24798b = file2;
        this.f24799c = str;
    }
}
