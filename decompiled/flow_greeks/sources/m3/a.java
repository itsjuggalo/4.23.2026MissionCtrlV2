package m3;

import android.content.res.AssetManager;
import android.net.Uri;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f15743c = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f15744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0284a f15745b;

    /* JADX INFO: renamed from: m3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0284a {
        com.bumptech.glide.load.data.d a(AssetManager assetManager, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements o, InterfaceC0284a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f15746a;

        public b(AssetManager assetManager) {
            this.f15746a = assetManager;
        }

        @Override // m3.a.InterfaceC0284a
        public com.bumptech.glide.load.data.d a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // m3.o
        public n d(r rVar) {
            return new a(this.f15746a, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements o, InterfaceC0284a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f15747a;

        public c(AssetManager assetManager) {
            this.f15747a = assetManager;
        }

        @Override // m3.a.InterfaceC0284a
        public com.bumptech.glide.load.data.d a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // m3.o
        public n d(r rVar) {
            return new a(this.f15747a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC0284a interfaceC0284a) {
        this.f15744a = assetManager;
        this.f15745b = interfaceC0284a;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(Uri uri, int i10, int i11, g3.h hVar) {
        return new n.a(new b4.b(uri), this.f15745b.a(this.f15744a, uri.toString().substring(f15743c)));
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
