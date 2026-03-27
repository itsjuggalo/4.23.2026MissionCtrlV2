package a1;

import a1.n;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class s implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f9890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f9891b;

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f9892a;

        public a(Resources resources) {
            this.f9892a = resources;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new s(this.f9892a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f9893a;

        public b(Resources resources) {
            this.f9893a = resources;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new s(this.f9893a, rVar.d(Uri.class, InputStream.class));
        }
    }

    public static class c implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f9894a;

        public c(Resources resources) {
            this.f9894a = resources;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new s(this.f9894a, w.c());
        }
    }

    public s(Resources resources, n nVar) {
        this.f9891b = resources;
        this.f9890a = nVar;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Integer num, int i8, int i9, U0.h hVar) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.f9890a.a(uriD, i8, i9, hVar);
    }

    public final Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f9891b.getResourcePackageName(num.intValue()) + '/' + this.f9891b.getResourceTypeName(num.intValue()) + '/' + this.f9891b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e8) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e8);
            return null;
        }
    }

    @Override // a1.n
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(Integer num) {
        return true;
    }
}
