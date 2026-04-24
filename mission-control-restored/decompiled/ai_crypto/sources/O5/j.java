package O5;

import Z5.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends i {
    public static final File e(File file, File target, boolean z7, int i7) throws IllegalAccessException, IOException, InvocationTargetException {
        r.f(file, "<this>");
        r.f(target, "target");
        if (!file.exists()) {
            throw new l(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z7) {
                throw new e(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new e(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    a.a(fileInputStream, fileOutputStream, i7);
                    b.a(fileOutputStream, null);
                    b.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!target.mkdirs()) {
            throw new f(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File f(File file, File file2, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 8192;
        }
        return e(file, file2, z7, i7);
    }

    public static String g(File file) {
        r.f(file, "<this>");
        String name = file.getName();
        r.e(name, "getName(...)");
        return u.w0(name, com.amazon.a.a.o.c.a.b.f10001a, "");
    }

    public static final File h(File file, File relative) {
        r.f(file, "<this>");
        r.f(relative, "relative");
        if (g.b(relative)) {
            return relative;
        }
        String string = file.toString();
        r.e(string, "toString(...)");
        if (string.length() != 0) {
            char c7 = File.separatorChar;
            if (!u.F(string, c7, false, 2, null)) {
                return new File(string + c7 + relative);
            }
        }
        return new File(string + relative);
    }

    public static File i(File file, String relative) {
        r.f(file, "<this>");
        r.f(relative, "relative");
        return h(file, new File(relative));
    }
}
