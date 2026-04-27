package h3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class S {
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
                    int i7 = inputStream.read(bArr);
                    if (i7 <= 0) {
                        gZIPOutputStream2.finish();
                        AbstractC1695i.g(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i7);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    AbstractC1695i.g(gZIPOutputStream);
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
            InterfaceC1686Q interfaceC1686Q = (InterfaceC1686Q) it.next();
            InputStream inputStreamB = null;
            try {
                inputStreamB = interfaceC1686Q.b();
                if (inputStreamB != null) {
                    a(inputStreamB, new File(file, interfaceC1686Q.a()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                AbstractC1695i.g(null);
                throw th;
            }
            AbstractC1695i.g(inputStreamB);
        }
    }
}
