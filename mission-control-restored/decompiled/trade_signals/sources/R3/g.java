package R3;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f7156b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f7158b;

        public g a() {
            if (TextUtils.isEmpty(this.f7157a)) {
                throw new IllegalArgumentException("ImageData model must have an imageUrl");
            }
            return new g(this.f7157a, this.f7158b);
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f7157a = str;
            }
            return this;
        }
    }

    public g(String str, Bitmap bitmap) {
        this.f7155a = str;
        this.f7156b = bitmap;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        return this.f7155a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return hashCode() == gVar.hashCode() && this.f7155a.equals(gVar.f7155a);
    }

    public int hashCode() {
        Bitmap bitmap = this.f7156b;
        return this.f7155a.hashCode() + (bitmap != null ? bitmap.hashCode() : 0);
    }
}
