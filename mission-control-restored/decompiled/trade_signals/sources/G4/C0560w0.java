package G4;

import F4.C0489c;
import F4.P;
import com.google.firebase.analytics.FirebaseAnalytics;
import v2.AbstractC2844j;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0560w0 extends P.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0489c f3239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F4.X f3240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F4.Y f3241c;

    public C0560w0(F4.Y y7, F4.X x8, C0489c c0489c) {
        this.f3241c = (F4.Y) AbstractC2848n.o(y7, FirebaseAnalytics.Param.METHOD);
        this.f3240b = (F4.X) AbstractC2848n.o(x8, "headers");
        this.f3239a = (C0489c) AbstractC2848n.o(c0489c, "callOptions");
    }

    @Override // F4.P.g
    public C0489c a() {
        return this.f3239a;
    }

    @Override // F4.P.g
    public F4.X b() {
        return this.f3240b;
    }

    @Override // F4.P.g
    public F4.Y c() {
        return this.f3241c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0560w0.class != obj.getClass()) {
            return false;
        }
        C0560w0 c0560w0 = (C0560w0) obj;
        return AbstractC2844j.a(this.f3239a, c0560w0.f3239a) && AbstractC2844j.a(this.f3240b, c0560w0.f3240b) && AbstractC2844j.a(this.f3241c, c0560w0.f3241c);
    }

    public int hashCode() {
        return AbstractC2844j.b(this.f3239a, this.f3240b, this.f3241c);
    }

    public final String toString() {
        return "[method=" + this.f3241c + " headers=" + this.f3240b + " callOptions=" + this.f3239a + "]";
    }
}
