package C2;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f907b;

    public b(float f7, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f906a;
            f7 += ((b) cVar).f907b;
        }
        this.f906a = cVar;
        this.f907b = f7;
    }

    @Override // C2.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f906a.a(rectF) + this.f907b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f906a.equals(bVar.f906a) && this.f907b == bVar.f907b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f906a, Float.valueOf(this.f907b)});
    }
}
