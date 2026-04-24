package g3;

import java.io.File;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends f {
    public /* synthetic */ l(File file, File file2, String str, int i4, AbstractC1585j abstractC1585j) {
        this(file, (i4 & 2) != 0 ? null : file2, (i4 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(File file, File file2, String str) {
        super(file, file2, str);
        r.f(file, "file");
    }
}
