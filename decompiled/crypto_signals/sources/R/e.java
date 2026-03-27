package R;

import android.content.SharedPreferences;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f2754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f2755b;

    public e(SharedPreferences prefs, LinkedHashSet linkedHashSet) {
        j.e(prefs, "prefs");
        this.f2754a = prefs;
        this.f2755b = linkedHashSet;
    }
}
