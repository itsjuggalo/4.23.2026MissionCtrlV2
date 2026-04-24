package N;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f3927b;

        public a(int i7, b[] bVarArr) {
            this.f3926a = i7;
            this.f3927b = bVarArr;
        }

        public static a a(int i7, b[] bVarArr) {
            return new a(i7, bVarArr);
        }

        public b[] b() {
            return this.f3927b;
        }

        public int c() {
            return this.f3926a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f3928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f3931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f3932e;

        public b(Uri uri, int i7, int i8, boolean z7, int i9) {
            this.f3928a = (Uri) P.f.g(uri);
            this.f3929b = i7;
            this.f3930c = i8;
            this.f3931d = z7;
            this.f3932e = i9;
        }

        public static b a(Uri uri, int i7, int i8, boolean z7, int i9) {
            return new b(uri, i7, i8, z7, i9);
        }

        public int b() {
            return this.f3932e;
        }

        public int c() {
            return this.f3929b;
        }

        public Uri d() {
            return this.f3928a;
        }

        public int e() {
            return this.f3930c;
        }

        public boolean f() {
            return this.f3931d;
        }
    }

    public static class c {
        public abstract void a(int i7);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return I.d.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, eVar, cancellationSignal);
    }

    public static Typeface c(Context context, e eVar, int i7, boolean z7, int i8, Handler handler, c cVar) {
        N.a aVar = new N.a(cVar, handler);
        return z7 ? f.e(context, eVar, aVar, i7, i8) : f.d(context, eVar, i7, null, aVar);
    }
}
