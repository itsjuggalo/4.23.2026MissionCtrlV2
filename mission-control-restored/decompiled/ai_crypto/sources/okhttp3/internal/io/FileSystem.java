package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import w6.L;
import w6.X;
import w6.Z;

/* JADX INFO: loaded from: classes2.dex */
public interface FileSystem {

    /* JADX INFO: renamed from: okhttp3.internal.io.FileSystem$1, reason: invalid class name */
    public class AnonymousClass1 implements FileSystem {
        @Override // okhttp3.internal.io.FileSystem
        public Z a(File file) {
            return L.k(file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public X b(File file) {
            try {
                return L.f(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return L.f(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public void c(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    c(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public boolean d(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.io.FileSystem
        public void e(File file, File file2) throws IOException {
            f(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.io.FileSystem
        public void f(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public X g(File file) {
            try {
                return L.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return L.a(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public long h(File file) {
            return file.length();
        }
    }

    Z a(File file);

    X b(File file);

    void c(File file);

    boolean d(File file);

    void e(File file, File file2);

    void f(File file);

    X g(File file);

    long h(File file);
}
