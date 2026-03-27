package S;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/* JADX INFO: renamed from: S.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0515a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0515a f3605a = new C0515a();

    public final boolean a(File srcFile, File dstFile) {
        kotlin.jvm.internal.r.f(srcFile, "srcFile");
        kotlin.jvm.internal.r.f(dstFile, "dstFile");
        try {
            Files.move(srcFile.toPath(), dstFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
