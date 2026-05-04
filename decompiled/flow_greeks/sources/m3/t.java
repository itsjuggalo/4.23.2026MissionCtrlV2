package m3;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;
import java.util.List;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f15834b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f15835a;

        public a(Context context) {
            this.f15835a = context;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new t(this.f15835a, rVar.d(Integer.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f15836a;

        public b(Context context) {
            this.f15836a = context;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new t(this.f15836a, rVar.d(Integer.class, InputStream.class));
        }
    }

    public t(Context context, n nVar) {
        this.f15833a = context.getApplicationContext();
        this.f15834b = nVar;
    }

    public static o e(Context context) {
        return new a(context);
    }

    public static o f(Context context) {
        return new b(context);
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(Uri uri, int i10, int i11, g3.h hVar) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return g(uri, i10, i11, hVar);
        }
        if (pathSegments.size() == 2) {
            return h(uri, i10, i11, hVar);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
        return null;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.f15833a.getPackageName().equals(uri.getAuthority());
    }

    public final n.a g(Uri uri, int i10, int i11, g3.h hVar) {
        try {
            int i12 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i12 != 0) {
                return this.f15834b.b(Integer.valueOf(i12), i10, i11, hVar);
            }
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e10) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e10);
            }
            return null;
        }
    }

    public final n.a h(Uri uri, int i10, int i11, g3.h hVar) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.f15833a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.f15833a.getPackageName());
        if (identifier != 0) {
            return this.f15834b.b(Integer.valueOf(identifier), i10, i11, hVar);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
        return null;
    }
}
