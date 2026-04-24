package E0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* JADX INFO: loaded from: classes.dex */
public final class c extends kotlin.jvm.internal.k implements R4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f367a = new c(1);

    @Override // R4.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        kotlin.jvm.internal.j.e(require, "$this$require");
        return Boolean.valueOf((require.getRect().width() == 0 && require.getRect().height() == 0) ? false : true);
    }
}
