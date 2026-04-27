package S2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class N {
    public static void a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[8192];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i8 = inputStream.read(bArr);
                    if (i8 <= 0) {
                        gZIPOutputStream2.finish();
                        AbstractC0903j.g(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i8);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    AbstractC0903j.g(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(File file, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            M m8 = (M) it.next();
            InputStream inputStreamB = null;
            try {
                inputStreamB = m8.b();
                if (inputStreamB != null) {
                    a(inputStreamB, new File(file, m8.a()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                AbstractC0903j.g(null);
                throw th;
            }
            AbstractC0903j.g(inputStreamB);
        }
    }
}
