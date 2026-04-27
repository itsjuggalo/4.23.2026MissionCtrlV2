package C2;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f905a;

    public a(float f7) {
        this.f905a = f7;
    }

    @Override // C2.c
    public float a(RectF rectF) {
        return this.f905a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f905a == ((a) obj).f905a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f905a)});
    }
}
