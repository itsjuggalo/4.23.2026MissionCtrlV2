package ea;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f8589b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f8591b;

        public g a() {
            if (TextUtils.isEmpty(this.f8590a)) {
                throw new IllegalArgumentException("ImageData model must have an imageUrl");
            }
            return new g(this.f8590a, this.f8591b);
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f8590a = str;
            }
            return this;
        }
    }

    public g(String str, Bitmap bitmap) {
        this.f8588a = str;
        this.f8589b = bitmap;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        return this.f8588a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return hashCode() == gVar.hashCode() && this.f8588a.equals(gVar.f8588a);
    }

    public int hashCode() {
        Bitmap bitmap = this.f8589b;
        return this.f8588a.hashCode() + (bitmap != null ? bitmap.hashCode() : 0);
    }
}
