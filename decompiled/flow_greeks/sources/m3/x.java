package m3;

import android.content.ContentResolver;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f15842b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", FirebaseAnalytics.Param.CONTENT, "android.resource")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f15843a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements o, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f15844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f15845b;

        public a(ContentResolver contentResolver, boolean z10) {
            this.f15844a = contentResolver;
            this.f15845b = z10;
        }

        @Override // m3.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f15844a, uri, this.f15845b);
        }

        @Override // m3.o
        public n d(r rVar) {
            return new x(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements o, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f15846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f15847b;

        public b(ContentResolver contentResolver, boolean z10) {
            this.f15846a = contentResolver;
            this.f15847b = z10;
        }

        @Override // m3.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.f15846a, uri, this.f15847b);
        }

        @Override // m3.o
        public n d(r rVar) {
            return new x(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        com.bumptech.glide.load.data.d a(Uri uri);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d implements o, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f15848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f15849b;

        public d(ContentResolver contentResolver, boolean z10) {
            this.f15848a = contentResolver;
            this.f15849b = z10;
        }

        @Override // m3.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.n(this.f15848a, uri, this.f15849b);
        }

        @Override // m3.o
        public n d(r rVar) {
            return new x(this);
        }
    }

    public x(c cVar) {
        this.f15843a = cVar;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(Uri uri, int i10, int i11, g3.h hVar) {
        return new n.a(new b4.b(uri), this.f15843a.a(uri));
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return f15842b.contains(uri.getScheme());
    }
}
