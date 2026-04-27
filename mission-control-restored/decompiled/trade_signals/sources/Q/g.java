package Q;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f6630b;

        public a(int i8, b[] bVarArr) {
            this.f6629a = i8;
            this.f6630b = bVarArr;
        }

        public static a a(int i8, b[] bVarArr) {
            return new a(i8, bVarArr);
        }

        public b[] b() {
            return this.f6630b;
        }

        public int c() {
            return this.f6629a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f6631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f6634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f6635e;

        public b(Uri uri, int i8, int i9, boolean z7, int i10) {
            this.f6631a = (Uri) S.g.d(uri);
            this.f6632b = i8;
            this.f6633c = i9;
            this.f6634d = z7;
            this.f6635e = i10;
        }

        public static b a(Uri uri, int i8, int i9, boolean z7, int i10) {
            return new b(uri, i8, i9, z7, i10);
        }

        public int b() {
            return this.f6635e;
        }

        public int c() {
            return this.f6632b;
        }

        public Uri d() {
            return this.f6631a;
        }

        public int e() {
            return this.f6633c;
        }

        public boolean f() {
            return this.f6634d;
        }
    }

    public static class c {
        public abstract void a(int i8);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return L.d.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, eVar, cancellationSignal);
    }

    public static Typeface c(Context context, e eVar, int i8, boolean z7, int i9, Handler handler, c cVar) {
        Q.a aVar = new Q.a(cVar, handler);
        return z7 ? f.e(context, eVar, aVar, i8, i9) : f.d(context, eVar, i8, null, aVar);
    }
}
