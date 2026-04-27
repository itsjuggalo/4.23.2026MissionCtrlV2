package E;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f361b;

        public a(int i4, b[] bVarArr) {
            this.f360a = i4;
            this.f361b = bVarArr;
        }

        public static a a(int i4, b[] bVarArr) {
            return new a(i4, bVarArr);
        }

        public b[] b() {
            return this.f361b;
        }

        public int c() {
            return this.f360a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f366e;

        public b(Uri uri, int i4, int i5, boolean z4, int i6) {
            this.f362a = (Uri) G.e.b(uri);
            this.f363b = i4;
            this.f364c = i5;
            this.f365d = z4;
            this.f366e = i6;
        }

        public static b a(Uri uri, int i4, int i5, boolean z4, int i6) {
            return new b(uri, i4, i5, z4, i6);
        }

        public int b() {
            return this.f366e;
        }

        public int c() {
            return this.f363b;
        }

        public Uri d() {
            return this.f362a;
        }

        public int e() {
            return this.f364c;
        }

        public boolean f() {
            return this.f365d;
        }
    }

    public static class c {
        public abstract void a(int i4);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, e eVar, int i4, boolean z4, int i5, Handler handler, c cVar) {
        E.a aVar = new E.a(cVar, handler);
        return z4 ? f.e(context, eVar, aVar, i4, i5) : f.d(context, eVar, i4, null, aVar);
    }
}
