package a1;

import a1.n;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p1.C2543b;

/* JADX INFO: renamed from: a1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1047g implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f9832a;

    /* JADX INFO: renamed from: a1.g$a */
    public static class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f9833a;

        public a(d dVar) {
            this.f9833a = dVar;
        }

        @Override // a1.o
        public final n d(r rVar) {
            return new C1047g(this.f9833a);
        }
    }

    /* JADX INFO: renamed from: a1.g$b */
    public static class b extends a {

        /* JADX INFO: renamed from: a1.g$b$a */
        public class a implements d {
            @Override // a1.C1047g.d
            public Class a() {
                return ParcelFileDescriptor.class;
            }

            @Override // a1.C1047g.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // a1.C1047g.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* JADX INFO: renamed from: a1.g$d */
    public interface d {
        Class a();

        void b(Object obj);

        Object c(File file);
    }

    /* JADX INFO: renamed from: a1.g$e */
    public static class e extends a {

        /* JADX INFO: renamed from: a1.g$e$a */
        public class a implements d {
            @Override // a1.C1047g.d
            public Class a() {
                return InputStream.class;
            }

            @Override // a1.C1047g.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // a1.C1047g.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public C1047g(d dVar) {
        this.f9832a = dVar;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(File file, int i8, int i9, U0.h hVar) {
        return new n.a(new C2543b(file), new c(file, this.f9832a));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(File file) {
        return true;
    }

    /* JADX INFO: renamed from: a1.g$c */
    public static final class c implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f9834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f9835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f9836c;

        public c(File file, d dVar) {
            this.f9834a = file;
            this.f9835b = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f9835b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Object obj = this.f9836c;
            if (obj != null) {
                try {
                    this.f9835b.b(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public U0.a d() {
            return U0.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            try {
                Object objC = this.f9835b.c(this.f9834a);
                this.f9836c = objC;
                aVar.f(objC);
            } catch (FileNotFoundException e8) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e8);
                }
                aVar.c(e8);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
