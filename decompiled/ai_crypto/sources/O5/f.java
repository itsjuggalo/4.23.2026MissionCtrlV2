package O5;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public class f extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f4234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f4235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4236c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(File file, File file2, String str) {
        super(c.b(file, file2, str));
        r.f(file, "file");
        this.f4234a = file;
        this.f4235b = file2;
        this.f4236c = str;
    }
}
