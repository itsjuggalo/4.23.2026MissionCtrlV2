package a1;

import a1.n;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileNotFoundException;
import p1.C2543b;

/* JADX INFO: renamed from: a1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1052l implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9854a;

    /* JADX INFO: renamed from: a1.l$a */
    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9855a;

        public a(Context context) {
            this.f9855a = context;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1052l(this.f9855a);
        }
    }

    public C1052l(Context context) {
        this.f9854a = context;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Uri uri, int i8, int i9, U0.h hVar) {
        return new n.a(new C2543b(uri), new b(this.f9854a, uri));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return V0.b.c(uri);
    }

    /* JADX INFO: renamed from: a1.l$b */
    public static class b implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f9856c = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f9858b;

        public b(Context context, Uri uri) {
            this.f9857a = context;
            this.f9858b = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public U0.a d() {
            return U0.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            Cursor cursorQuery = this.f9857a.getContentResolver().query(this.f9858b, f9856c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.f(new File(string));
                return;
            }
            aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f9858b));
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
