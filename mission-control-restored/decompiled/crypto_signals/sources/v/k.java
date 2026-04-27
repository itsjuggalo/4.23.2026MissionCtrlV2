package v;

import android.content.res.Resources;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f10587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f10588b;

    public k(Resources resources, Resources.Theme theme) {
        this.f10587a = resources;
        this.f10588b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (this.f10587a.equals(kVar.f10587a) && Objects.equals(this.f10588b, kVar.f10588b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f10587a, this.f10588b);
    }
}
