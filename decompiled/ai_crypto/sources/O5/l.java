package O5;

import java.io.File;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends f {
    public /* synthetic */ l(File file, File file2, String str, int i7, AbstractC2148j abstractC2148j) {
        this(file, (i7 & 2) != 0 ? null : file2, (i7 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(File file, File file2, String str) {
        super(file, file2, str);
        r.f(file, "file");
    }
}
