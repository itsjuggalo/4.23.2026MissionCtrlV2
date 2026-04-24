package a1;

import a1.n;
import android.content.ContentResolver;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p1.C2543b;

/* JADX INFO: loaded from: classes.dex */
public class x implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f9904b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", FirebaseAnalytics.Param.CONTENT, "android.resource")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9905a;

    public static final class a implements o, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f9906a;

        public a(ContentResolver contentResolver) {
            this.f9906a = contentResolver;
        }

        @Override // a1.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f9906a, uri);
        }

        @Override // a1.o
        public n d(r rVar) {
            return new x(this);
        }
    }

    public static class b implements o, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f9907a;

        public b(ContentResolver contentResolver) {
            this.f9907a = contentResolver;
        }

        @Override // a1.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.f9907a, uri);
        }

        @Override // a1.o
        public n d(r rVar) {
            return new x(this);
        }
    }

    public interface c {
        com.bumptech.glide.load.data.d a(Uri uri);
    }

    public static class d implements o, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f9908a;

        public d(ContentResolver contentResolver) {
            this.f9908a = contentResolver;
        }

        @Override // a1.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.n(this.f9908a, uri);
        }

        @Override // a1.o
        public n d(r rVar) {
            return new x(this);
        }
    }

    public x(c cVar) {
        this.f9905a = cVar;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Uri uri, int i8, int i9, U0.h hVar) {
        return new n.a(new C2543b(uri), this.f9905a.a(uri));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return f9904b.contains(uri.getScheme());
    }
}
