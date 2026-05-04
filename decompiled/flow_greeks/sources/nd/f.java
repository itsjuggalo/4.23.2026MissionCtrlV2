package nd;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class f extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f17026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f17027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17028c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(File file, File file2, String str) {
        super(c.b(file, file2, str));
        t.f(file, "file");
        this.f17026a = file;
        this.f17027b = file2;
        this.f17028c = str;
    }
}
