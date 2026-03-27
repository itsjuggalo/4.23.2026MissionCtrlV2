package u;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: renamed from: u.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1195j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f10256b = new HashMap();

    public C1195j(String str) {
        this.f10255a = str;
    }

    public static boolean a(String str, String str2) {
        String strA = AbstractC1196k.a(str);
        String strA2 = AbstractC1196k.a(str2);
        if (strA.equals(strA2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strA2);
        sb.append('/');
        return strA.startsWith(sb.toString());
    }

    public final File b(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int iIndexOf = encodedPath.indexOf(47, 1);
        String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
        String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
        File file = (File) this.f10256b.get(strDecode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        File file2 = new File(file, strDecode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (a(canonicalFile.getPath(), file.getPath())) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
        }
    }
}
