package h3;

import e3.C1478g;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: h3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1698l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FilenameFilter f14841d = new FilenameFilter() { // from class: h3.j
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return C1698l.d(file, str);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Comparator f14842e = new Comparator() { // from class: h3.k
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C1698l.e((File) obj, (File) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3.g f14843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14844b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14845c = null;

    public C1698l(n3.g gVar) {
        this.f14843a = gVar;
    }

    public static /* synthetic */ boolean d(File file, String str) {
        return str.startsWith("aqs.");
    }

    public static /* synthetic */ int e(File file, File file2) {
        return Long.compare(file2.lastModified(), file.lastModified());
    }

    public static void f(n3.g gVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            gVar.q(str, "aqs." + str2).createNewFile();
        } catch (IOException e7) {
            C1478g.f().l("Failed to persist App Quality Sessions session id.", e7);
        }
    }

    public static String g(n3.g gVar, String str) {
        List listR = gVar.r(str, f14841d);
        if (!listR.isEmpty()) {
            return ((File) Collections.min(listR, f14842e)).getName().substring(4);
        }
        C1478g.f().k("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String c(String str) {
        if (Objects.equals(this.f14844b, str)) {
            return this.f14845c;
        }
        return g(this.f14843a, str);
    }

    public synchronized void h(String str) {
        if (!Objects.equals(this.f14845c, str)) {
            f(this.f14843a, this.f14844b, str);
            this.f14845c = str;
        }
    }

    public synchronized void i(String str) {
        if (!Objects.equals(this.f14844b, str)) {
            f(this.f14843a, str, this.f14845c);
            this.f14844b = str;
        }
    }
}
