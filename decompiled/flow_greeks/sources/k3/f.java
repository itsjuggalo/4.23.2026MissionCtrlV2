package k3;

import android.content.Context;
import java.io.File;
import k3.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends d {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f14502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14503b;

        public a(Context context, String str) {
            this.f14502a = context;
            this.f14503b = str;
        }

        @Override // k3.d.a
        public File a() {
            File cacheDir = this.f14502a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f14503b != null ? new File(cacheDir, this.f14503b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
