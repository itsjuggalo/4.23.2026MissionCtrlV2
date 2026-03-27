package Y2;

import P2.j;
import S2.AbstractC0903j;
import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f9544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f9545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f9546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f9547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f9548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final File f9549g;

    public g(Context context) {
        String str;
        String strD = j.f6363a.e(context).d();
        this.f9543a = strD;
        File filesDir = context.getFilesDir();
        this.f9544b = filesDir;
        if (y()) {
            str = ".crashlytics.v3" + File.separator + x(strD);
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File fileT = t(new File(filesDir, str));
        this.f9545c = fileT;
        this.f9546d = t(new File(fileT, "open-sessions"));
        this.f9547e = t(new File(fileT, "reports"));
        this.f9548f = t(new File(fileT, "priority-reports"));
        this.f9549g = t(new File(fileT, "native-reports"));
    }

    public static /* synthetic */ boolean s(String str, File file, String str2) {
        return str2.startsWith(str);
    }

    public static synchronized File t(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                P2.g.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (!file.mkdirs()) {
                P2.g.f().d("Could not create Crashlytics-specific directory: " + file);
            }
            return file;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static File u(File file) {
        file.mkdirs();
        return file;
    }

    public static boolean v(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                v(file2);
            }
        }
        return file.delete();
    }

    public static List w(Object[] objArr) {
        return objArr == null ? Collections.emptyList() : Arrays.asList(objArr);
    }

    public static String x(String str) {
        return str.length() > 40 ? AbstractC0903j.A(str) : str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    public final void b(String str) {
        File file = new File(this.f9544b, str);
        if (file.exists() && v(file)) {
            P2.g.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    public final void c(final String str) {
        String[] list;
        if (!this.f9544b.exists() || (list = this.f9544b.list(new FilenameFilter() { // from class: Y2.f
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return g.s(str, file, str2);
            }
        })) == null) {
            return;
        }
        for (String str2 : list) {
            b(str2);
        }
    }

    public void d() {
        b(".com.google.firebase.crashlytics");
        b(".com.google.firebase.crashlytics-ndk");
        if (y()) {
            b(".com.google.firebase.crashlytics.files.v1");
            c(".com.google.firebase.crashlytics.files.v2" + File.pathSeparator);
        }
    }

    public boolean e(String str) {
        return v(new File(this.f9546d, str));
    }

    public List f() {
        return w(this.f9546d.list());
    }

    public File g(String str) {
        return new File(this.f9545c, str);
    }

    public List h(FilenameFilter filenameFilter) {
        return w(this.f9545c.listFiles(filenameFilter));
    }

    public File i(String str) {
        return new File(this.f9549g, str);
    }

    public List j() {
        return w(this.f9549g.listFiles());
    }

    public File k(String str) {
        return u(new File(p(str), "native"));
    }

    public File l(String str) {
        return new File(this.f9548f, str);
    }

    public List m() {
        return w(this.f9548f.listFiles());
    }

    public File n(String str) {
        return new File(this.f9547e, str);
    }

    public List o() {
        return w(this.f9547e.listFiles());
    }

    public final File p(String str) {
        return u(new File(this.f9546d, str));
    }

    public File q(String str, String str2) {
        return new File(p(str), str2);
    }

    public List r(String str, FilenameFilter filenameFilter) {
        return w(p(str).listFiles(filenameFilter));
    }

    public final boolean y() {
        return !this.f9543a.isEmpty();
    }
}
