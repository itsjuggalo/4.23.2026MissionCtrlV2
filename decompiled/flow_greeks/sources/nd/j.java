package nd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import kg.c0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends i {
    public static final File e(File file, File target, boolean z10, int i10) throws IllegalAccessException, IOException, InvocationTargetException {
        t.f(file, "<this>");
        t.f(target, "target");
        if (!file.exists()) {
            throw new l(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z10) {
                throw new e(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new e(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (target.mkdirs()) {
                return target;
            }
            throw new f(file, target, "Failed to create target directory.");
        }
        File parentFile = target.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            try {
                a.a(fileInputStream, fileOutputStream, i10);
                b.a(fileOutputStream, null);
                b.a(fileInputStream, null);
                return target;
            } finally {
            }
        } finally {
        }
    }

    public static /* synthetic */ File f(File file, File file2, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 8192;
        }
        return e(file, file2, z10, i10);
    }

    public static String g(File file) {
        t.f(file, "<this>");
        String name = file.getName();
        t.e(name, "getName(...)");
        return c0.Q0(name, com.amazon.a.a.o.c.a.b.f4610a, "");
    }

    public static final File h(File file, File relative) {
        t.f(file, "<this>");
        t.f(relative, "relative");
        if (g.b(relative)) {
            return relative;
        }
        String string = file.toString();
        t.e(string, "toString(...)");
        if (string.length() != 0) {
            char c10 = File.separatorChar;
            if (!c0.S(string, c10, false, 2, null)) {
                return new File(string + c10 + relative);
            }
        }
        return new File(string + relative);
    }

    public static File i(File file, String relative) {
        t.f(file, "<this>");
        t.f(relative, "relative");
        return h(file, new File(relative));
    }
}
