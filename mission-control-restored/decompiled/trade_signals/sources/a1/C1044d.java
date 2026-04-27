package a1;

import a1.n;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p1.C2543b;
import q1.AbstractC2618a;

/* JADX INFO: renamed from: a1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1044d implements n {

    /* JADX INFO: renamed from: a1.d$b */
    public static class b implements o {
        @Override // a1.o
        public n d(r rVar) {
            return new C1044d();
        }
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(File file, int i8, int i9, U0.h hVar) {
        return new n.a(new C2543b(file), new a(file));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(File file) {
        return true;
    }

    /* JADX INFO: renamed from: a1.d$a */
    public static final class a implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f9815a;

        public a(File file) {
            this.f9815a = file;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public U0.a d() {
            return U0.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            try {
                aVar.f(AbstractC2618a.a(this.f9815a));
            } catch (IOException e8) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e8);
                }
                aVar.c(e8);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
