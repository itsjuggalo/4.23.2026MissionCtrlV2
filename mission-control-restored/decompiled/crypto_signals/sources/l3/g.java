package l3;

import android.net.Uri;
import i3.C0674a;
import i3.C0675b;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0675b f8119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final I4.i f8120b;

    public g(C0675b appInfo, I4.i blockingDispatcher) {
        kotlin.jvm.internal.j.e(appInfo, "appInfo");
        kotlin.jvm.internal.j.e(blockingDispatcher, "blockingDispatcher");
        this.f8119a = appInfo;
        this.f8120b = blockingDispatcher;
    }

    public static final URL a(g gVar) {
        gVar.getClass();
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp");
        C0675b c0675b = gVar.f8119a;
        Uri.Builder builderAppendPath2 = builderAppendPath.appendPath(c0675b.f6899a).appendPath("settings");
        C0674a c0674a = c0675b.f6900b;
        return new URL(builderAppendPath2.appendQueryParameter("build_version", c0674a.f6895c).appendQueryParameter("display_version", c0674a.f6894b).build().toString());
    }
}
