package Y0;

import Y0.d;
import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {

    public class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f9506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9507b;

        public a(Context context, String str) {
            this.f9506a = context;
            this.f9507b = str;
        }

        @Override // Y0.d.a
        public File a() {
            File cacheDir = this.f9506a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f9507b != null ? new File(cacheDir, this.f9507b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j8) {
        super(new a(context, str), j8);
    }
}
