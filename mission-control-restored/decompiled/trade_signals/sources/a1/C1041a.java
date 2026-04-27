package a1;

import a1.n;
import android.content.res.AssetManager;
import android.net.Uri;
import p1.C2543b;

/* JADX INFO: renamed from: a1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1041a implements n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9805c = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f9806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0164a f9807b;

    /* JADX INFO: renamed from: a1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0164a {
        com.bumptech.glide.load.data.d a(AssetManager assetManager, String str);
    }

    /* JADX INFO: renamed from: a1.a$b */
    public static class b implements o, InterfaceC0164a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f9808a;

        public b(AssetManager assetManager) {
            this.f9808a = assetManager;
        }

        @Override // a1.C1041a.InterfaceC0164a
        public com.bumptech.glide.load.data.d a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1041a(this.f9808a, this);
        }
    }

    /* JADX INFO: renamed from: a1.a$c */
    public static class c implements o, InterfaceC0164a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f9809a;

        public c(AssetManager assetManager) {
            this.f9809a = assetManager;
        }

        @Override // a1.C1041a.InterfaceC0164a
        public com.bumptech.glide.load.data.d a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1041a(this.f9809a, this);
        }
    }

    public C1041a(AssetManager assetManager, InterfaceC0164a interfaceC0164a) {
        this.f9806a = assetManager;
        this.f9807b = interfaceC0164a;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Uri uri, int i8, int i9, U0.h hVar) {
        return new n.a(new C2543b(uri), this.f9807b.a(this.f9806a, uri.toString().substring(f9805c)));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
