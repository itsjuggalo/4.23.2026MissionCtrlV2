package a1;

import a1.n;
import android.util.Base64;
import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import p1.C2543b;

/* JADX INFO: renamed from: a1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1045e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9816a;

    /* JADX INFO: renamed from: a1.e$a */
    public interface a {
        Class a();

        void b(Object obj);

        Object decode(String str);
    }

    /* JADX INFO: renamed from: a1.e$c */
    public static final class c implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f9820a = new a();

        /* JADX INFO: renamed from: a1.e$c$a */
        public class a implements a {
            public a() {
            }

            @Override // a1.C1045e.a
            public Class a() {
                return InputStream.class;
            }

            @Override // a1.C1045e.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // a1.C1045e.a
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

        @Override // a1.o
        public n d(r rVar) {
            return new C1045e(this.f9820a);
        }
    }

    public C1045e(a aVar) {
        this.f9816a = aVar;
    }

    @Override // a1.n
    public n.a a(Object obj, int i8, int i9, U0.h hVar) {
        return new n.a(new C2543b(obj), new b(obj.toString(), this.f9816a));
    }

    @Override // a1.n
    public boolean b(Object obj) {
        return obj.toString().startsWith("data:image");
    }

    /* JADX INFO: renamed from: a1.e$b */
    public static final class b implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f9818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f9819c;

        public b(String str, a aVar) {
            this.f9817a = str;
            this.f9818b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f9818b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f9818b.b(this.f9819c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public U0.a d() {
            return U0.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            try {
                Object objDecode = this.f9818b.decode(this.f9817a);
                this.f9819c = objDecode;
                aVar.f(objDecode);
            } catch (IllegalArgumentException e8) {
                aVar.c(e8);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
