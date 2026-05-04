package a8;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import r7.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final File f361g;

    public g(Context context) {
        String str;
        String strD = i.f19381a.e(context).d();
        this.f355a = strD;
        File filesDir = context.getFilesDir();
        this.f356b = filesDir;
        if (x()) {
            str = ".crashlytics.v3" + File.separator + w(strD);
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File fileS = s(new File(filesDir, str));
        this.f357c = fileS;
        this.f358d = s(new File(fileS, "open-sessions"));
        this.f359e = s(new File(fileS, "reports"));
        this.f360f = s(new File(fileS, "priority-reports"));
        this.f361g = s(new File(fileS, "native-reports"));
    }

    public static synchronized File s(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                r7.g.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (!file.mkdirs()) {
                r7.g.f().d("Could not create Crashlytics-specific directory: " + file);
            }
            return file;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static File t(File file) {
        file.mkdirs();
        return file;
    }

    public static boolean u(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                u(file2);
            }
        }
        return file.delete();
    }

    public static List v(Object[] objArr) {
        return objArr == null ? Collections.EMPTY_LIST : Arrays.asList(objArr);
    }

    public static String w(String str) {
        return str.length() > 40 ? u7.i.A(str) : str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    public final void b(String str) {
        File file = new File(this.f356b, str);
        if (file.exists() && u(file)) {
            r7.g.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    public final void c(final String str) {
        String[] list;
        if (!this.f356b.exists() || (list = this.f356b.list(new FilenameFilter() { // from class: a8.f
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return str2.startsWith(str);
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
        if (x()) {
            b(".com.google.firebase.crashlytics.files.v1");
            c(".com.google.firebase.crashlytics.files.v2" + File.pathSeparator);
        }
    }

    public boolean e(String str) {
        return u(new File(this.f358d, str));
    }

    public List f() {
        return v(this.f358d.list());
    }

    public File g(String str) {
        return new File(this.f357c, str);
    }

    public List h(FilenameFilter filenameFilter) {
        return v(this.f357c.listFiles(filenameFilter));
    }

    public File i(String str) {
        return new File(this.f361g, str);
    }

    public List j() {
        return v(this.f361g.listFiles());
    }

    public File k(String str) {
        return t(new File(p(str), "native"));
    }

    public File l(String str) {
        return new File(this.f360f, str);
    }

    public List m() {
        return v(this.f360f.listFiles());
    }

    public File n(String str) {
        return new File(this.f359e, str);
    }

    public List o() {
        return v(this.f359e.listFiles());
    }

    public final File p(String str) {
        return t(new File(this.f358d, str));
    }

    public File q(String str, String str2) {
        return new File(p(str), str2);
    }

    public List r(String str, FilenameFilter filenameFilter) {
        return v(p(str).listFiles(filenameFilter));
    }

    public final boolean x() {
        return !this.f355a.isEmpty();
    }
}
