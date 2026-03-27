package z5;

import V6.C;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends i {
    public static final File d(File file, File target, boolean z7, int i8) throws IllegalAccessException, IOException, InvocationTargetException {
        AbstractC2304t.f(file, "<this>");
        AbstractC2304t.f(target, "target");
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
                    AbstractC3013a.a(fileInputStream, fileOutputStream, i8);
                    AbstractC3014b.a(fileOutputStream, null);
                    AbstractC3014b.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!target.mkdirs()) {
            throw new f(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File e(File file, File file2, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z7 = false;
        }
        if ((i9 & 4) != 0) {
            i8 = 8192;
        }
        return d(file, file2, z7, i8);
    }

    public static String f(File file) {
        AbstractC2304t.f(file, "<this>");
        String name = file.getName();
        AbstractC2304t.e(name, "getName(...)");
        return C.D0(name, com.amazon.a.a.o.c.a.b.f14112a, "");
    }

    public static final File g(File file, File relative) {
        AbstractC2304t.f(file, "<this>");
        AbstractC2304t.f(relative, "relative");
        if (g.b(relative)) {
            return relative;
        }
        String string = file.toString();
        AbstractC2304t.e(string, "toString(...)");
        if (string.length() != 0) {
            char c8 = File.separatorChar;
            if (!C.O(string, c8, false, 2, null)) {
                return new File(string + c8 + relative);
            }
        }
        return new File(string + relative);
    }

    public static File h(File file, String relative) {
        AbstractC2304t.f(file, "<this>");
        AbstractC2304t.f(relative, "relative");
        return g(file, new File(relative));
    }
}
