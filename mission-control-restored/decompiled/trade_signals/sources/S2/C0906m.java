package S2;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: S2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0906m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FilenameFilter f7563d = new FilenameFilter() { // from class: S2.k
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return C0906m.d(file, str);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Comparator f7564e = new Comparator() { // from class: S2.l
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C0906m.e((File) obj, (File) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y2.g f7565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7566b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7567c = null;

    public C0906m(Y2.g gVar) {
        this.f7565a = gVar;
    }

    public static /* synthetic */ boolean d(File file, String str) {
        return str.startsWith("aqs.");
    }

    public static /* synthetic */ int e(File file, File file2) {
        return Long.compare(file2.lastModified(), file.lastModified());
    }

    public static void f(Y2.g gVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            gVar.q(str, "aqs." + str2).createNewFile();
        } catch (IOException e8) {
            P2.g.f().l("Failed to persist App Quality Sessions session id.", e8);
        }
    }

    public static String g(Y2.g gVar, String str) {
        List listR = gVar.r(str, f7563d);
        if (!listR.isEmpty()) {
            return ((File) Collections.min(listR, f7564e)).getName().substring(4);
        }
        P2.g.f().k("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String c(String str) {
        if (Objects.equals(this.f7566b, str)) {
            return this.f7567c;
        }
        return g(this.f7565a, str);
    }

    public synchronized void h(String str) {
        if (!Objects.equals(this.f7567c, str)) {
            f(this.f7565a, this.f7566b, str);
            this.f7567c = str;
        }
    }

    public synchronized void i(String str) {
        if (!Objects.equals(this.f7566b, str)) {
            f(this.f7565a, str, this.f7567c);
            this.f7566b = str;
        }
    }
}
