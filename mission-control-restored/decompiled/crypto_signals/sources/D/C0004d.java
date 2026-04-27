package D;

import android.view.DisplayCutout;
import java.util.Objects;

/* JADX INFO: renamed from: D.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0004d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f234a;

    public C0004d(DisplayCutout displayCutout) {
        this.f234a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0004d.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f234a, ((C0004d) obj).f234a);
    }

    public final int hashCode() {
        return this.f234a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f234a + "}";
    }
}
