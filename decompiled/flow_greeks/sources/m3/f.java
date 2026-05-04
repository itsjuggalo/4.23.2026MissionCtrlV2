package m3;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f15761b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements o, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f15762a;

        public a(Context context) {
            this.f15762a = context;
        }

        @Override // m3.f.e
        public Class a() {
            return AssetFileDescriptor.class;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new f(this.f15762a, this);
        }

        @Override // m3.f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // m3.f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor c(Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResourceFd(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements o, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f15764a;

        public c(Context context) {
            this.f15764a = context;
        }

        @Override // m3.f.e
        public Class a() {
            return InputStream.class;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new f(this.f15764a, this);
        }

        @Override // m3.f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // m3.f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public InputStream c(Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResource(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
        Class a();

        void b(Object obj);

        Object c(Resources.Theme theme, Resources resources, int i10);
    }

    public f(Context context, e eVar) {
        this.f15760a = context.getApplicationContext();
        this.f15761b = eVar;
    }

    public static o c(Context context) {
        return new a(context);
    }

    public static o e(Context context) {
        return new b(context);
    }

    public static o g(Context context) {
        return new c(context);
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public n.a b(Integer num, int i10, int i11, g3.h hVar) {
        Resources.Theme theme = (Resources.Theme) hVar.c(r3.g.f19293b);
        return new n.a(new b4.b(num), new d(theme, theme != null ? theme.getResources() : this.f15760a.getResources(), this.f15761b, num.intValue()));
    }

    @Override // m3.n
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources.Theme f15765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources f15766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f15767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f15768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f15769e;

        public d(Resources.Theme theme, Resources resources, e eVar, int i10) {
            this.f15765a = theme;
            this.f15766b = resources;
            this.f15767c = eVar;
            this.f15768d = i10;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f15767c.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Object obj = this.f15769e;
            if (obj != null) {
                try {
                    this.f15767c.b(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public g3.a d() {
            return g3.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(com.bumptech.glide.g gVar, d.a aVar) {
            try {
                Object objC = this.f15767c.c(this.f15765a, this.f15766b, this.f15768d);
                this.f15769e = objC;
                aVar.f(objC);
            } catch (Resources.NotFoundException e10) {
                aVar.c(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements o, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f15763a;

        public b(Context context) {
            this.f15763a = context;
        }

        @Override // m3.f.e
        public Class a() {
            return Drawable.class;
        }

        @Override // m3.o
        public n d(r rVar) {
            return new f(this.f15763a, this);
        }

        @Override // m3.f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Drawable c(Resources.Theme theme, Resources resources, int i10) {
            return r3.d.a(this.f15763a, i10, theme);
        }

        @Override // m3.f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(Drawable drawable) {
        }
    }
}
