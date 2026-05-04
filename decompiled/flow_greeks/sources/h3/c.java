package h3;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f10973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f10974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f10975c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f10976b = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f10977a;

        public a(ContentResolver contentResolver) {
            this.f10977a = contentResolver;
        }

        @Override // h3.d
        public Cursor a(Uri uri) {
            return this.f10977a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f10976b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f10978b = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f10979a;

        public b(ContentResolver contentResolver) {
            this.f10979a = contentResolver;
        }

        @Override // h3.d
        public Cursor a(Uri uri) {
            return this.f10979a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f10978b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public c(Uri uri, e eVar) {
        this.f10973a = uri;
        this.f10974b = eVar;
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
        InputStream inputStream = this.f10975c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public g3.a d() {
        return g3.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void e(g gVar, d.a aVar) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.f10975c = inputStreamH;
            aVar.f(inputStreamH);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e10);
            }
            aVar.c(e10);
        }
    }

    public final InputStream h() throws Throwable {
        InputStream inputStreamD = this.f10974b.d(this.f10973a);
        int iA = inputStreamD != null ? this.f10974b.a(this.f10973a) : -1;
        return iA != -1 ? new com.bumptech.glide.load.data.g(inputStreamD, iA) : inputStreamD;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
