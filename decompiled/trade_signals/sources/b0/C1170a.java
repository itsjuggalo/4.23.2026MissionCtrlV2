package b0;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: b0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1170a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1170a f12595a = new C1170a();

    public final boolean a(File srcFile, File dstFile) {
        AbstractC2304t.f(srcFile, "srcFile");
        AbstractC2304t.f(dstFile, "dstFile");
        try {
            Files.move(srcFile.toPath(), dstFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
