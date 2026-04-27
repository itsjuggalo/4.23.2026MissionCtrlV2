package V0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f8479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f8480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f8481c;

    public static class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f8482b = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f8483a;

        public a(ContentResolver contentResolver) {
            this.f8483a = contentResolver;
        }

        @Override // V0.d
        public Cursor a(Uri uri) {
            return this.f8483a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f8482b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public static class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f8484b = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f8485a;

        public b(ContentResolver contentResolver) {
            this.f8485a = contentResolver;
        }

        @Override // V0.d
        public Cursor a(Uri uri) {
            return this.f8485a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f8484b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public c(Uri uri, e eVar) {
        this.f8479a = uri;
        this.f8480b = eVar;
    }

    public static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.c(context).j().g(), dVar, com.bumptech.glide.b.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.d
    public Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f8481c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public U0.a d() {
        return U0.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void e(g gVar, d.a aVar) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.f8481c = inputStreamH;
            aVar.f(inputStreamH);
        } catch (FileNotFoundException e8) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e8);
            }
            aVar.c(e8);
        }
    }

    public final InputStream h() throws Throwable {
        InputStream inputStreamD = this.f8480b.d(this.f8479a);
        int iA = inputStreamD != null ? this.f8480b.a(this.f8479a) : -1;
        return iA != -1 ? new com.bumptech.glide.load.data.g(inputStreamD, iA) : inputStreamD;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
