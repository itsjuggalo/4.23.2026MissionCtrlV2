package f1;

import W0.v;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public class l implements U0.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final U0.g f17383b = U0.g.e("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17384a;

    public l(Context context) {
        this.f17384a = context.getApplicationContext();
    }

    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public v a(Uri uri, int i8, int i9, U0.h hVar) {
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            Context contextD = d(uri, authority);
            int iG = g(contextD, uri);
            Resources.Theme theme = ((String) AbstractC2628k.d(authority)).equals(this.f17384a.getPackageName()) ? (Resources.Theme) hVar.c(f17383b) : null;
            return k.f(theme == null ? AbstractC1741i.b(this.f17384a, contextD, iG) : AbstractC1741i.a(this.f17384a, iG, theme));
        }
        throw new IllegalStateException("Package name for " + uri + " is null or empty");
    }

    public final Context d(Uri uri, String str) {
        if (str.equals(this.f17384a.getPackageName())) {
            return this.f17384a;
        }
        try {
            return this.f17384a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e8) {
            if (str.contains(this.f17384a.getPackageName())) {
                return this.f17384a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e8);
        }
    }

    public final int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e8) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e8);
        }
    }

    public final int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    public final int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // U0.j
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri, U0.h hVar) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals("android.resource");
    }
}
