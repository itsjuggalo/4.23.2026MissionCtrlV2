package a1;

import a1.n;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class t implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f9896b;

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9897a;

        public a(Context context) {
            this.f9897a = context;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new t(this.f9897a, rVar.d(Integer.class, AssetFileDescriptor.class));
        }
    }

    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9898a;

        public b(Context context) {
            this.f9898a = context;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new t(this.f9898a, rVar.d(Integer.class, InputStream.class));
        }
    }

    public t(Context context, n nVar) {
        this.f9895a = context.getApplicationContext();
        this.f9896b = nVar;
    }

    public static o e(Context context) {
        return new a(context);
    }

    public static o f(Context context) {
        return new b(context);
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Uri uri, int i8, int i9, U0.h hVar) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return g(uri, i8, i9, hVar);
        }
        if (pathSegments.size() == 2) {
            return h(uri, i8, i9, hVar);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
        return null;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.f9895a.getPackageName().equals(uri.getAuthority());
    }

    public final n.a g(Uri uri, int i8, int i9, U0.h hVar) {
        try {
            int i10 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i10 != 0) {
                return this.f9896b.a(Integer.valueOf(i10), i8, i9, hVar);
            }
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e8) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e8);
            }
            return null;
        }
    }

    public final n.a h(Uri uri, int i8, int i9, U0.h hVar) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.f9895a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.f9895a.getPackageName());
        if (identifier != 0) {
            return this.f9896b.a(Integer.valueOf(identifier), i8, i9, hVar);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
        return null;
    }
}
