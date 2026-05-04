package q0;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f18739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f18742d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18743e;

        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f18739a = (Uri) s0.f.d(uri);
            this.f18740b = i10;
            this.f18741c = i11;
            this.f18742d = z10;
            this.f18743e = i12;
        }

        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f18743e;
        }

        public int c() {
            return this.f18740b;
        }

        public Uri d() {
            return this.f18739a;
        }

        public int e() {
            return this.f18741c;
        }

        public boolean f() {
            return this.f18742d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
        public abstract void a(int i10);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return l0.g.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, l0.f.a(new Object[]{eVar}), cancellationSignal);
    }

    public static Typeface c(Context context, List list, int i10, boolean z10, int i11, Handler handler, c cVar) {
        q0.a aVar = new q0.a(cVar, h.b(handler));
        if (!z10) {
            return f.d(context, list, i10, null, aVar);
        }
        if (list.size() <= 1) {
            return f.e(context, (e) list.get(0), aVar, i10, i11);
        }
        throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f18738b;

        public a(int i10, b[] bVarArr) {
            this.f18737a = i10;
            this.f18738b = Collections.singletonList(bVarArr);
        }

        public static a a(int i10, List list) {
            return new a(i10, list);
        }

        public static a b(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] c() {
            return (b[]) this.f18738b.get(0);
        }

        public List d() {
            return this.f18738b;
        }

        public int e() {
            return this.f18737a;
        }

        public boolean f() {
            return this.f18738b.size() > 1;
        }

        public a(int i10, List list) {
            this.f18737a = i10;
            this.f18738b = list;
        }
    }
}
