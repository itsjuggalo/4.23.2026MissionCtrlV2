package g3;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends i {
    public static final File e(File file, File target, boolean z4, int i4) throws IllegalAccessException, IOException, InvocationTargetException {
        r.f(file, "<this>");
        r.f(target, "target");
        if (!file.exists()) {
            throw new l(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z4) {
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
                AbstractC1269a.a(fileInputStream, fileOutputStream, i4);
                b.a(fileOutputStream, null);
                b.a(fileInputStream, null);
                return target;
            } finally {
            }
        } finally {
        }
    }

    public static /* synthetic */ File f(File file, File file2, boolean z4, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = UserMetadata.MAX_INTERNAL_KEY_SIZE;
        }
        return e(file, file2, z4, i4);
    }

    public static String g(File file) {
        r.f(file, "<this>");
        String name = file.getName();
        r.e(name, "getName(...)");
        return AbstractC1753A.B0(name, com.amazon.a.a.o.c.a.b.f8816a, "");
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
            char c4 = File.separatorChar;
            if (!AbstractC1753A.K(string, c4, false, 2, null)) {
                return new File(string + c4 + relative);
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
