package n3;

import android.content.Context;
import e3.C1478g;
import e3.j;
import h3.AbstractC1695i;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f19629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f19630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f19631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f19632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f19633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final File f19634g;

    public g(Context context) {
        String str;
        String strD = j.f13606a.e(context).d();
        this.f19628a = strD;
        File filesDir = context.getFilesDir();
        this.f19629b = filesDir;
        if (y()) {
            str = ".crashlytics.v3" + File.separator + x(strD);
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File fileT = t(new File(filesDir, str));
        this.f19630c = fileT;
        this.f19631d = t(new File(fileT, "open-sessions"));
        this.f19632e = t(new File(fileT, "reports"));
        this.f19633f = t(new File(fileT, "priority-reports"));
        this.f19634g = t(new File(fileT, "native-reports"));
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
                C1478g.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (!file.mkdirs()) {
                C1478g.f().d("Could not create Crashlytics-specific directory: " + file);
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
        return str.length() > 40 ? AbstractC1695i.A(str) : str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    public final void b(String str) {
        File file = new File(this.f19629b, str);
        if (file.exists() && v(file)) {
            C1478g.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    public final void c(final String str) {
        String[] list;
        if (!this.f19629b.exists() || (list = this.f19629b.list(new FilenameFilter() { // from class: n3.f
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
        return v(new File(this.f19631d, str));
    }

    public List f() {
        return w(this.f19631d.list());
    }

    public File g(String str) {
        return new File(this.f19630c, str);
    }

    public List h(FilenameFilter filenameFilter) {
        return w(this.f19630c.listFiles(filenameFilter));
    }

    public File i(String str) {
        return new File(this.f19634g, str);
    }

    public List j() {
        return w(this.f19634g.listFiles());
    }

    public File k(String str) {
        return u(new File(p(str), "native"));
    }

    public File l(String str) {
        return new File(this.f19633f, str);
    }

    public List m() {
        return w(this.f19633f.listFiles());
    }

    public File n(String str) {
        return new File(this.f19632e, str);
    }

    public List o() {
        return w(this.f19632e.listFiles());
    }

    public final File p(String str) {
        return u(new File(this.f19631d, str));
    }

    public File q(String str, String str2) {
        return new File(p(str), str2);
    }

    public List r(String str, FilenameFilter filenameFilter) {
        return w(p(str).listFiles(filenameFilter));
    }

    public final boolean y() {
        return !this.f19628a.isEmpty();
    }
}
