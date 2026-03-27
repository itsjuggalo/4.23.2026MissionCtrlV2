package C2;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f959a;

    public i(float f7) {
        this.f959a = f7;
    }

    @Override // C2.c
    public float a(RectF rectF) {
        return this.f959a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f959a == ((i) obj).f959a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f959a)});
    }
}
