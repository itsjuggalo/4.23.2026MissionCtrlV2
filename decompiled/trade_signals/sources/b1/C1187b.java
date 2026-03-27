package b1;

import U0.h;
import a1.n;
import a1.o;
import a1.r;
import android.content.Context;
import android.net.Uri;
import p1.C2543b;

/* JADX INFO: renamed from: b1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1187b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12859a;

    /* JADX INFO: renamed from: b1.b$a */
    public static class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f12860a;

        public a(Context context) {
            this.f12860a = context;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1187b(this.f12860a);
        }
    }

    public C1187b(Context context) {
        this.f12859a = context.getApplicationContext();
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Uri uri, int i8, int i9, h hVar) {
        if (V0.b.e(i8, i9)) {
            return new n.a(new C2543b(uri), V0.c.f(this.f12859a, uri));
        }
        return null;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return V0.b.b(uri);
    }
}
