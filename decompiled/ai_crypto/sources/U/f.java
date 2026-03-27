package U;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4744a;

    public interface c {
        Uri a();

        void b();

        Uri c();

        Object d();

        ClipDescription getDescription();
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f4744a = new a(uri, clipDescription, uri2);
        } else {
            this.f4744a = new b(uri, clipDescription, uri2);
        }
    }

    public static f f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new f(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f4744a.a();
    }

    public ClipDescription b() {
        return this.f4744a.getDescription();
    }

    public Uri c() {
        return this.f4744a.c();
    }

    public void d() {
        this.f4744a.b();
    }

    public Object e() {
        return this.f4744a.d();
    }

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputContentInfo f4745a;

        public a(Object obj) {
            this.f4745a = (InputContentInfo) obj;
        }

        @Override // U.f.c
        public Uri a() {
            return this.f4745a.getContentUri();
        }

        @Override // U.f.c
        public void b() {
            this.f4745a.requestPermission();
        }

        @Override // U.f.c
        public Uri c() {
            return this.f4745a.getLinkUri();
        }

        @Override // U.f.c
        public Object d() {
            return this.f4745a;
        }

        @Override // U.f.c
        public ClipDescription getDescription() {
            return this.f4745a.getDescription();
        }

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f4745a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public f(c cVar) {
        this.f4744a = cVar;
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f4746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ClipDescription f4747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri f4748c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f4746a = uri;
            this.f4747b = clipDescription;
            this.f4748c = uri2;
        }

        @Override // U.f.c
        public Uri a() {
            return this.f4746a;
        }

        @Override // U.f.c
        public Uri c() {
            return this.f4748c;
        }

        @Override // U.f.c
        public Object d() {
            return null;
        }

        @Override // U.f.c
        public ClipDescription getDescription() {
            return this.f4747b;
        }

        @Override // U.f.c
        public void b() {
        }
    }
}
