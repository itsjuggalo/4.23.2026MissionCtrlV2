package w5;

import java.io.File;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f11446a = 0;

    static {
        char c6 = File.separatorChar;
        x5.a aVar = new x5.a();
        PrintWriter printWriter = new PrintWriter(aVar);
        try {
            printWriter.println();
            aVar.toString();
            printWriter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    printWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
