package m3;

import android.util.Base64;
import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f15754a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        Class a();

        void b(Object obj);

        Object decode(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f15758a = new a();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements a {
            public a() {
            }

            @Override // m3.e.a
            public Class a() {
                return InputStream.class;
            }

            @Override // m3.e.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // m3.e.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public InputStream decode(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // m3.o
        public n d(r rVar) {
            return new e(this.f15758a);
        }
    }

    public e(a aVar) {
        this.f15754a = aVar;
    }

    @Override // m3.n
    public boolean a(Object obj) {
        return obj.toString().startsWith("data:image");
    }

    @Override // m3.n
    public n.a b(Object obj, int i10, int i11, g3.h hVar) {
        return new n.a(new b4.b(obj), new b(obj.toString(), this.f15754a));
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f15756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f15757c;

        public b(String str, a aVar) {
            this.f15755a = str;
            this.f15756b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f15756b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f15756b.b(this.f15757c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public g3.a d() {
            return g3.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            try {
                Object objDecode = this.f15756b.decode(this.f15755a);
                this.f15757c = objDecode;
                aVar.f(objDecode);
            } catch (IllegalArgumentException e10) {
                aVar.c(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
