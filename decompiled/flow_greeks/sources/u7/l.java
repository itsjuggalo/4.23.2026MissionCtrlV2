package u7;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FilenameFilter f22298d = new FilenameFilter() { // from class: u7.j
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith("aqs.");
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Comparator f22299e = new Comparator() { // from class: u7.k
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a8.g f22300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22301b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22302c = null;

    public l(a8.g gVar) {
        this.f22300a = gVar;
    }

    public static void d(a8.g gVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            gVar.q(str, "aqs." + str2).createNewFile();
        } catch (IOException e10) {
            r7.g.f().l("Failed to persist App Quality Sessions session id.", e10);
        }
    }

    public static String e(a8.g gVar, String str) {
        List listR = gVar.r(str, f22298d);
        if (!listR.isEmpty()) {
            return ((File) Collections.min(listR, f22299e)).getName().substring(4);
        }
        r7.g.f().k("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String c(String str) {
        if (Objects.equals(this.f22301b, str)) {
            return this.f22302c;
        }
        return e(this.f22300a, str);
    }

    public synchronized void f(String str) {
        if (!Objects.equals(this.f22302c, str)) {
            d(this.f22300a, this.f22301b, str);
            this.f22302c = str;
        }
    }

    public synchronized void g(String str) {
        if (!Objects.equals(this.f22301b, str)) {
            d(this.f22300a, str, this.f22302c);
            this.f22301b = str;
        }
    }
}
