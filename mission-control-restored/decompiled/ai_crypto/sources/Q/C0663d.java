package Q;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* JADX INFO: renamed from: Q.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0663d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f4440a;

    /* JADX INFO: renamed from: Q.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f4441a;

        public a(ClipData clipData, int i7) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f4441a = new b(clipData, i7);
            } else {
                this.f4441a = new C0072d(clipData, i7);
            }
        }

        public C0663d a() {
            return this.f4441a.a();
        }

        public a b(Bundle bundle) {
            this.f4441a.b(bundle);
            return this;
        }

        public a c(int i7) {
            this.f4441a.d(i7);
            return this;
        }

        public a d(Uri uri) {
            this.f4441a.c(uri);
            return this;
        }
    }

    /* JADX INFO: renamed from: Q.d$b */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentInfo.Builder f4442a;

        public b(ClipData clipData, int i7) {
            this.f4442a = AbstractC0666g.a(clipData, i7);
        }

        @Override // Q.C0663d.c
        public C0663d a() {
            return new C0663d(new e(this.f4442a.build()));
        }

        @Override // Q.C0663d.c
        public void b(Bundle bundle) {
            this.f4442a.setExtras(bundle);
        }

        @Override // Q.C0663d.c
        public void c(Uri uri) {
            this.f4442a.setLinkUri(uri);
        }

        @Override // Q.C0663d.c
        public void d(int i7) {
            this.f4442a.setFlags(i7);
        }
    }

    /* JADX INFO: renamed from: Q.d$c */
    public interface c {
        C0663d a();

        void b(Bundle bundle);

        void c(Uri uri);

        void d(int i7);
    }

    /* JADX INFO: renamed from: Q.d$d, reason: collision with other inner class name */
    public static final class C0072d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ClipData f4443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Uri f4446d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bundle f4447e;

        public C0072d(ClipData clipData, int i7) {
            this.f4443a = clipData;
            this.f4444b = i7;
        }

        @Override // Q.C0663d.c
        public C0663d a() {
            return new C0663d(new g(this));
        }

        @Override // Q.C0663d.c
        public void b(Bundle bundle) {
            this.f4447e = bundle;
        }

        @Override // Q.C0663d.c
        public void c(Uri uri) {
            this.f4446d = uri;
        }

        @Override // Q.C0663d.c
        public void d(int i7) {
            this.f4445c = i7;
        }
    }

    /* JADX INFO: renamed from: Q.d$e */
    public static final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentInfo f4448a;

        public e(ContentInfo contentInfo) {
            this.f4448a = AbstractC0662c.a(P.f.g(contentInfo));
        }

        @Override // Q.C0663d.f
        public ClipData a() {
            return this.f4448a.getClip();
        }

        @Override // Q.C0663d.f
        public int b() {
            return this.f4448a.getFlags();
        }

        @Override // Q.C0663d.f
        public ContentInfo c() {
            return this.f4448a;
        }

        @Override // Q.C0663d.f
        public int d() {
            return this.f4448a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f4448a + "}";
        }
    }

    /* JADX INFO: renamed from: Q.d$f */
    public interface f {
        ClipData a();

        int b();

        ContentInfo c();

        int d();
    }

    /* JADX INFO: renamed from: Q.d$g */
    public static final class g implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClipData f4449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f4452d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f4453e;

        public g(C0072d c0072d) {
            this.f4449a = (ClipData) P.f.g(c0072d.f4443a);
            this.f4450b = P.f.c(c0072d.f4444b, 0, 5, "source");
            this.f4451c = P.f.f(c0072d.f4445c, 1);
            this.f4452d = c0072d.f4446d;
            this.f4453e = c0072d.f4447e;
        }

        @Override // Q.C0663d.f
        public ClipData a() {
            return this.f4449a;
        }

        @Override // Q.C0663d.f
        public int b() {
            return this.f4451c;
        }

        @Override // Q.C0663d.f
        public ContentInfo c() {
            return null;
        }

        @Override // Q.C0663d.f
        public int d() {
            return this.f4450b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f4449a.getDescription());
            sb.append(", source=");
            sb.append(C0663d.e(this.f4450b));
            sb.append(", flags=");
            sb.append(C0663d.a(this.f4451c));
            if (this.f4452d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f4452d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.f4453e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    public C0663d(f fVar) {
        this.f4440a = fVar;
    }

    public static String a(int i7) {
        return (i7 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i7);
    }

    public static String e(int i7) {
        return i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? i7 != 5 ? String.valueOf(i7) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static C0663d g(ContentInfo contentInfo) {
        return new C0663d(new e(contentInfo));
    }

    public ClipData b() {
        return this.f4440a.a();
    }

    public int c() {
        return this.f4440a.b();
    }

    public int d() {
        return this.f4440a.d();
    }

    public ContentInfo f() {
        ContentInfo contentInfoC = this.f4440a.c();
        Objects.requireNonNull(contentInfoC);
        return AbstractC0662c.a(contentInfoC);
    }

    public String toString() {
        return this.f4440a.toString();
    }
}
