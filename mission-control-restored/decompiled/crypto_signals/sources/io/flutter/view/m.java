package io.flutter.view;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7349b;

    public m(View view, int i) {
        this.f7348a = view;
        this.f7349b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f7349b == mVar.f7349b && this.f7348a.equals(mVar.f7348a);
    }

    public final int hashCode() {
        return ((this.f7348a.hashCode() + 31) * 31) + this.f7349b;
    }
}
