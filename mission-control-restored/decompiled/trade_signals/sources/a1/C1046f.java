package a1;

import a1.n;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.data.d;
import f1.AbstractC1741i;
import java.io.IOException;
import java.io.InputStream;
import p1.C2543b;

/* JADX INFO: renamed from: a1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1046f implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f9823b;

    /* JADX INFO: renamed from: a1.f$a */
    public static final class a implements o, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9824a;

        public a(Context context) {
            this.f9824a = context;
        }

        @Override // a1.C1046f.e
        public Class a() {
            return AssetFileDescriptor.class;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1046f(this.f9824a, this);
        }

        @Override // a1.C1046f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // a1.C1046f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor c(Resources.Theme theme, Resources resources, int i8) {
            return resources.openRawResourceFd(i8);
        }
    }

    /* JADX INFO: renamed from: a1.f$c */
    public static final class c implements o, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9826a;

        public c(Context context) {
            this.f9826a = context;
        }

        @Override // a1.C1046f.e
        public Class a() {
            return InputStream.class;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1046f(this.f9826a, this);
        }

        @Override // a1.C1046f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // a1.C1046f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public InputStream c(Resources.Theme theme, Resources resources, int i8) {
            return resources.openRawResource(i8);
        }
    }

    /* JADX INFO: renamed from: a1.f$e */
    public interface e {
        Class a();

        void b(Object obj);

        Object c(Resources.Theme theme, Resources resources, int i8);
    }

    public C1046f(Context context, e eVar) {
        this.f9822a = context.getApplicationContext();
        this.f9823b = eVar;
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

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public n.a a(Integer num, int i8, int i9, U0.h hVar) {
        Resources.Theme theme = (Resources.Theme) hVar.c(f1.l.f17383b);
        return new n.a(new C2543b(num), new d(theme, theme != null ? theme.getResources() : this.f9822a.getResources(), this.f9823b, num.intValue()));
    }

    @Override // a1.n
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean b(Integer num) {
        return true;
    }

    /* JADX INFO: renamed from: a1.f$d */
    public static final class d implements com.bumptech.glide.load.data.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources.Theme f9827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources f9828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f9829c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9830d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f9831e;

        public d(Resources.Theme theme, Resources resources, e eVar, int i8) {
            this.f9827a = theme;
            this.f9828b = resources;
            this.f9829c = eVar;
            this.f9830d = i8;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class a() {
            return this.f9829c.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Object obj = this.f9831e;
            if (obj != null) {
                try {
                    this.f9829c.b(obj);
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
                Object objC = this.f9829c.c(this.f9827a, this.f9828b, this.f9830d);
                this.f9831e = objC;
                aVar.f(objC);
            } catch (Resources.NotFoundException e8) {
                aVar.c(e8);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* JADX INFO: renamed from: a1.f$b */
    public static final class b implements o, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9825a;

        public b(Context context) {
            this.f9825a = context;
        }

        @Override // a1.C1046f.e
        public Class a() {
            return Drawable.class;
        }

        @Override // a1.o
        public n d(r rVar) {
            return new C1046f(this.f9825a, this);
        }

        @Override // a1.C1046f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Drawable c(Resources.Theme theme, Resources resources, int i8) {
            return AbstractC1741i.a(this.f9825a, i8, theme);
        }

        @Override // a1.C1046f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(Drawable drawable) {
        }
    }
}
