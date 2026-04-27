package q0;

import Y3.i;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.j;

/* JADX INFO: renamed from: q0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0919a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f9143a;

    public C0919a(i registry) {
        j.e(registry, "registry");
        this.f9143a = new LinkedHashSet();
        registry.d("androidx.savedstate.Restarter", this);
    }

    @Override // q0.d
    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f9143a));
        return bundle;
    }
}
