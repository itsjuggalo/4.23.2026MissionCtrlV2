package io.flutter.embedding.engine;

import android.app.ApplicationExitInfo;
import android.content.res.loader.ResourcesLoader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.ImageReader;
import android.view.autofill.AutofillManager;
import java.nio.file.attribute.AclEntryPermission;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FlutterJNI$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ApplicationExitInfo m(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ ResourcesLoader m833m() {
        return new ResourcesLoader();
    }

    public static /* synthetic */ ImageReader.Builder m(int i, int i2) {
        return new ImageReader.Builder(i, i2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AutofillManager m836m(Object obj) {
        return (AutofillManager) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m838m() {
        return AutofillManager.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m847m() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m850m(Object obj) {
        return obj instanceof AdaptiveIconDrawable;
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return AclEntryPermission.class;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m855m$1() {
    }

    public static /* synthetic */ void m$2() {
    }
}
