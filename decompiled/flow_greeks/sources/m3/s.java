package m3;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f15828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f15829b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f15830a;

        public a(Resources resources) {
            this.f15830a = resources;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new s(this.f15830a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f15831a;

        public b(Resources resources) {
            this.f15831a = resources;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new s(this.f15831a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f15832a;

        public c(Resources resources) {
            this.f15832a = resources;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new s(this.f15832a, w.c());
        }
    }

    public s(Resources resources, n nVar) {
        this.f15829b = resources;
        this.f15828a = nVar;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(Integer num, int i10, int i11, g3.h hVar) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.f15828a.b(uriD, i10, i11, hVar);
    }

    public final Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f15829b.getResourcePackageName(num.intValue()) + '/' + num);
        } catch (Resources.NotFoundException e10) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e10);
            return null;
        }
    }

    @Override // m3.n
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }
}
