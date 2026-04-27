package b1;

import U0.h;
import a1.n;
import a1.o;
import a1.r;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import p1.C2543b;

/* JADX INFO: renamed from: b1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1189d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f12864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f12865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class f12866d;

    /* JADX INFO: renamed from: b1.d$a */
    public static abstract class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f12867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f12868b;

        public a(Context context, Class cls) {
            this.f12867a = context;
            this.f12868b = cls;
        }

        @Override // a1.o
        public final n d(r rVar) {
            return new C1189d(this.f12867a, rVar.d(File.class, this.f12868b), rVar.d(Uri.class, this.f12868b), this.f12868b);
        }
    }

    /* JADX INFO: renamed from: b1.d$b */
    public static final class b extends a {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: renamed from: b1.d$c */
    public static final class c extends a {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: renamed from: b1.d$d, reason: collision with other inner class name */
    public static final class C0218d implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String[] f12869k = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f12870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f12871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n f12872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f12873d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12874e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f12875f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final h f12876g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f12877h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f12878i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public volatile com.bumptech.glide.load.data.d f12879j;

        public C0218d(Context context, n nVar, n nVar2, Uri uri, int i8, int i9, h hVar, Class cls) {
            this.f12870a = context.getApplicationContext();
            this.f12871b = nVar;
            this.f12872c = nVar2;
            this.f12873d = uri;
            this.f12874e = i8;
            this.f12875f = i9;
            this.f12876g = hVar;
            this.f12877h = cls;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f12877h;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d dVar = this.f12879j;
            if (dVar != null) {
                dVar.b();
            }
        }

        public final n.a c() {
            if (Environment.isExternalStorageLegacy()) {
                return this.f12871b.a(h(this.f12873d), this.f12874e, this.f12875f, this.f12876g);
            }
            if (V0.b.a(this.f12873d)) {
                return this.f12872c.a(this.f12873d, this.f12874e, this.f12875f, this.f12876g);
            }
            return this.f12872c.a(g() ? MediaStore.setRequireOriginal(this.f12873d) : this.f12873d, this.f12874e, this.f12875f, this.f12876g);
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f12878i = true;
            com.bumptech.glide.load.data.d dVar = this.f12879j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public U0.a d() {
            return U0.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            try {
                com.bumptech.glide.load.data.d dVarF = f();
                if (dVarF == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f12873d));
                    return;
                }
                this.f12879j = dVarF;
                if (this.f12878i) {
                    cancel();
                } else {
                    dVarF.e(gVar, aVar);
                }
            } catch (FileNotFoundException e8) {
                aVar.c(e8);
            }
        }

        public final com.bumptech.glide.load.data.d f() {
            n.a aVarC = c();
            if (aVarC != null) {
                return aVarC.f9867c;
            }
            return null;
        }

        public final boolean g() {
            return this.f12870a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        public final File h(Uri uri) {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.f12870a.getContentResolver().query(uri, f12869k, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursorQuery.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public C1189d(Context context, n nVar, n nVar2, Class cls) {
        this.f12863a = context.getApplicationContext();
        this.f12864b = nVar;
        this.f12865c = nVar2;
        this.f12866d = cls;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(Uri uri, int i8, int i9, h hVar) {
        return new n.a(new C2543b(uri), new C0218d(this.f12863a, this.f12864b, this.f12865c, uri, i8, i9, hVar, this.f12866d));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && V0.b.c(uri);
    }
}
