package a1;

import a1.n;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class v implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f9900a;

    public static final class a implements o {
        @Override // a1.o
        public n d(r rVar) {
            return new v(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o {
        @Override // a1.o
        public n d(r rVar) {
            return new v(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o {
        @Override // a1.o
        public n d(r rVar) {
            return new v(rVar.d(Uri.class, InputStream.class));
        }
    }

    public v(n nVar) {
        this.f9900a = nVar;
    }

    public static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) != '/') {
            Uri uri = Uri.parse(str);
            if (uri.getScheme() != null) {
                return uri;
            }
        }
        return f(str);
    }

    public static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(String str, int i8, int i9, U0.h hVar) {
        Uri uriE = e(str);
        if (uriE == null || !this.f9900a.b(uriE)) {
            return null;
        }
        return this.f9900a.a(uriE, i8, i9, hVar);
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(String str) {
        return true;
    }
}
