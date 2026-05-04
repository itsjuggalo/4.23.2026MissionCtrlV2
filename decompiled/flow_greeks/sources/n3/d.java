package n3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.g;
import com.bumptech.glide.load.data.d;
import g3.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import m3.n;
import m3.o;
import m3.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f16617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f16618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class f16619d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f16620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f16621b;

        public a(Context context, Class cls) {
            this.f16620a = context;
            this.f16621b = cls;
        }

        @Override // m3.o
        public final n d(r rVar) {
            return new d(this.f16620a, rVar.d(File.class, this.f16621b), rVar.d(Uri.class, this.f16621b), this.f16621b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends a {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends a {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: renamed from: n3.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0298d implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String[] f16622k = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f16623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f16624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n f16625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f16626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f16627e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f16628f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final h f16629g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f16630h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f16631i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public volatile com.bumptech.glide.load.data.d f16632j;

        public C0298d(Context context, n nVar, n nVar2, Uri uri, int i10, int i11, h hVar, Class cls) {
            this.f16623a = context.getApplicationContext();
            this.f16624b = nVar;
            this.f16625c = nVar2;
            this.f16626d = uri;
            this.f16627e = i10;
            this.f16628f = i11;
            this.f16629g = hVar;
            this.f16630h = cls;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f16630h;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d dVar = this.f16632j;
            if (dVar != null) {
                dVar.b();
            }
        }

        public final n.a c() {
            if (Environment.isExternalStorageLegacy()) {
                return this.f16624b.b(h(this.f16626d), this.f16627e, this.f16628f, this.f16629g);
            }
            if (h3.b.a(this.f16626d)) {
                return this.f16625c.b(this.f16626d, this.f16627e, this.f16628f, this.f16629g);
            }
            return this.f16625c.b(g() ? MediaStore.setRequireOriginal(this.f16626d) : this.f16626d, this.f16627e, this.f16628f, this.f16629g);
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f16631i = true;
            com.bumptech.glide.load.data.d dVar = this.f16632j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public g3.a d() {
            return g3.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(g gVar, d.a aVar) {
            try {
                com.bumptech.glide.load.data.d dVarF = f();
                if (dVarF == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f16626d));
                    return;
                }
                this.f16632j = dVarF;
                if (this.f16631i) {
                    cancel();
                } else {
                    dVarF.e(gVar, aVar);
                }
            } catch (FileNotFoundException e10) {
                aVar.c(e10);
            }
        }

        public final com.bumptech.glide.load.data.d f() {
            n.a aVarC = c();
            if (aVarC != null) {
                return aVarC.f15805c;
            }
            return null;
        }

        public final boolean g() {
            return this.f16623a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        public final File h(Uri uri) {
            try {
                Cursor cursorQuery = this.f16623a.getContentResolver().query(uri, f16622k, null, null, null);
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
            } finally {
            }
        }
    }

    public d(Context context, n nVar, n nVar2, Class cls) {
        this.f16616a = context.getApplicationContext();
        this.f16617b = nVar;
        this.f16618c = nVar2;
        this.f16619d = cls;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(Uri uri, int i10, int i11, h hVar) {
        return new n.a(new b4.b(uri), new C0298d(this.f16616a, this.f16617b, this.f16618c, uri, i10, i11, hVar, this.f16619d));
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && h3.b.d(uri);
    }
}
