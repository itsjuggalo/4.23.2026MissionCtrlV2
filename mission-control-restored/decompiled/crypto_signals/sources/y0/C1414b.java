package y0;

import android.graphics.Rect;
import kotlin.jvm.internal.j;

/* JADX INFO: renamed from: y0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1414b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11617d;

    public C1414b(Rect rect) {
        int i = rect.left;
        int i6 = rect.top;
        int i7 = rect.right;
        int i8 = rect.bottom;
        this.f11614a = i;
        this.f11615b = i6;
        this.f11616c = i7;
        this.f11617d = i8;
        if (i > i7) {
            throw new IllegalArgumentException(a3.d.h("Left must be less than or equal to right, left: ", i, i7, ", right: ").toString());
        }
        if (i6 > i8) {
            throw new IllegalArgumentException(a3.d.h("top must be less than or equal to bottom, top: ", i6, i8, ", bottom: ").toString());
        }
    }

    public final Rect a() {
        return new Rect(this.f11614a, this.f11615b, this.f11616c, this.f11617d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!C1414b.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        j.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        C1414b c1414b = (C1414b) obj;
        return this.f11614a == c1414b.f11614a && this.f11615b == c1414b.f11615b && this.f11616c == c1414b.f11616c && this.f11617d == c1414b.f11617d;
    }

    public final int hashCode() {
        return (((((this.f11614a * 31) + this.f11615b) * 31) + this.f11616c) * 31) + this.f11617d;
    }

    public final String toString() {
        return C1414b.class.getSimpleName() + " { [" + this.f11614a + ',' + this.f11615b + ',' + this.f11616c + ',' + this.f11617d + "] }";
    }
}
